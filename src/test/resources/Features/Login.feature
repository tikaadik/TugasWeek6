 Feature: Login
   Scenario: User can login with valid credential
     Given User open link website
     Then User input registered username
     And User input registered password
     Then User tap login button
     Then User in on dashboard page

   Scenario: User login with wrong username
     Given User open link website
     Then User input wrong username
     And User input registered password
     Then User tap login button
     Then User get error message

   Scenario: User login with wrong password
     Given User open link website
     Then User input registered username
     And User input wrong password
     Then User tap login button
     Then User get error message

   Scenario: User login with wrong username and password
     Given User open link website
     Then User input wrong username
     And User input wrong password
     Then User tap login button
     Then User get error message