# LoginUITests

Set up & run

There are two ways to run this project

First way:
Clone or download the project, navigate to the path of project like in my case the path is: “/Users/prachisingh/DownloadsLoginUITests-master/Login” and run command: “mvn test”
Make sure you are inside project "Login"
 
Second way:
Import the project in environment
Make sure the path for Java is set
Run the runner class as JUnit test
You can have cucumber plugin in environment but not mandatory

# Note:
Change the path of chrome driver file as per one own system.
I have used Mac for test execution and creation. If one is running on windows , make sure to have chromedriver.exe and change the driver path accordingly

# Description
All tests and feature file are located in src/test/java/Login/Test

I grouped tests into 4 different scenarios

Success login
Unsuccessful login due to wrong credential
Unsuccessful login due of wrong session cookie
Unsuccessful login due of stopped redirection


# Decisions:

Selenium Webdriver

I really like Selenium web driver for UI testing. As its quite powerful. It is open source and I used it in past.

Junit

With Junit, you can manage user sessions and assert expectations and conditions, which together allow you to run UI tests with Selenium. I also choose it as its easy and does not take much effort to integrate it with Selenium. I would have preferred TestNG, for broader usage, but since my requirement was very limited and so I avoided it.

Java

I used Java, as I have been working with Java for automation tasks I did in past.
Rest Assured

I choose it, as the last test case was difficult to produce at UI level. It is quite easy to do such cases using rest assured. Selenium is not meant for such cases. 

Cucumber

I like cucumber, because it gives an overview of entire test flow. It also helps reviewer to understand the test and related code.

# Challenges

The biggest challenge was the last test case, where I was struggling to do with selenium, as I wanted to stick to a single tool and then I realized there are better tools to do such task and selenium is not meant for that. The solution will also be more clean and logical.

# Improvements:

The last case assertions can be definitely improved, as I am just matching it like strings, also we can divide it like earlier scenarios for better readability and consistency. But I wanted to keep it together, as rest assured itself contains given, when and then

# Assumptions and notes:

I have implemented these tests just for chrome browser, all these tests can be easily run on all the major browser using the drivers provided by Selenium

I have found a dirty solution, using cucumber which allows me to run on all browser without using solution like grid

I am executing each scenario on a new browser instance

I have some print statement for each error code, we need to remove it in case the code is checked in source control

I am logging the body, just to make reviewer aware of the body, which contains the error message “REDIRECTING…” 

Not included: security, penetration, load, performance testing
