Feature: Test login

Scenario: Successful login

 Given user open a web page
 Given user enters the UserName as "admin"
 And enters the password "12345"
 When user login
 Then user sees the message "WELCOME :)"
 And user goes back to home page
 And closes the browser
 
 Scenario: Unsuccessful login due to wrong credential

 Given user open a web page
 Given user enters the UserName as "admin"
 And enters the password "123"
 When user login
 Then user sees the message "ACCESS DENIED!"
 And user goes back to home page
 And closes the browser
 
 Scenario: Unsuccessful login due to wrong session cookie

 Given user open a web page and deletes the session cookie
 Then user enters the UserName as "admin"
 And enters the password "12345"
 When user login
 Then user sees the message "THE SESSION COOKIE IS MISSING OR HAS A WRONG VALUE!"
 And user goes back to home page
 And closes the browser
 
 Scenario: Unsuccessful login due to http redirection not be processed

 Given user login with username and passowrd and due to server issue http redirection was not processed
 
 
 
 
 