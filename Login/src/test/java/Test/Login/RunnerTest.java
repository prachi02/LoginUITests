package Test.Login;
import org.junit.runner.*;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
				features={"src/test/java/LoginTest.feature"})
public class RunnerTest {

}
