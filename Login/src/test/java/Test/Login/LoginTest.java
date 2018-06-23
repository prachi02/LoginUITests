package Test.Login;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.containsString;

import static io.restassured.RestAssured.given;

public class LoginTest {
	public WebDriver driver;

	@Given("^user open a web page$")
	public void user_open_a_web_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","//Users//prachisingh//eclipse-workspace//Login//driver//chromedriver");
		driver  = new ChromeDriver();
		driver.get("http://testing-ground.scraping.pro/login");

	}

	@Given("^user open a web page and deletes the session cookie$")
	public void user_open_a_web_page_and_deletes_the_session_cookie() throws Throwable {

		ChromeOptions options = new ChromeOptions();  
		Map prefs = new HashMap();  
		prefs.put("profile.default_content_setting_values.cookies", 2);  
		prefs.put("profile.block_third_party_cookies", true);  
		options.setExperimentalOption("prefs", prefs); driver = new ChromeDriver(options);

		driver.get("http://testing-ground.scraping.pro/login");

	}

	
	@Given("^user enters the UserName as \"(.*?)\"$")
	public void user_enters_the_UserName_as(String arg1) throws Throwable {			
		
	WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usr")));
		
	    WebElement userNameField = driver.findElement(By.id("usr"));
	
	    userNameField.sendKeys(arg1);
	}

	@Given("^enters the password \"(.*?)\"$")
	public void enters_the_password(String arg1) throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwd")));

		WebElement passwordField = driver.findElement(By.id("pwd"));
		passwordField.sendKeys(arg1);
	}

	@When("^user login$")
	public void user_login() throws Throwable {

		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^user goes back to home page$")
	public void user_goes_back_to_home_page() throws Throwable {

		driver.findElement(By.xpath("//a[@href='login']")).click();
		//driver.quit();

	}
	
	@Then("^closes the browser$")
	public void closes_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

	@Given("^user login with username and passowrd and due to server issue http redirection was not processed$")
	public void user_login_with_username_and_passowrdand_due_to_server_issue_http_redirection_was_not_processed() throws Throwable {
		
		given().
		  redirects().follow(false).
		  formParam("usr", "admin").
		  formParam("pwd", "12345").
		
		when().
		  post("http://testing-ground.scraping.pro/login?mode=login").
		   
		then().
		  assertThat().
		  statusCode(302).
		  body(containsString("h3 class")).
		  body(containsString("success")).
		  body(containsString("REDIRECTING...")).
		  log().body();
		   
	}

	@Then("^user sees the message \"(.*?)\"$")
	public void user_sees_the_message(String arg1) throws Throwable {
		
		WebElement alertMessage = driver.findElement(By.tagName("h3"));
		System.out.println(alertMessage.getText());
		Assert.assertEquals(alertMessage.getText() , arg1);  
	}

}
