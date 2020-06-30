Feature: Open Cart Application User Creation and Login Functionality

  Scenario: Verify successful login with valid email and valid password
    Given User launches the Open Cart Application
    Then Verify the application launches successfully
    When User clicks on My Account Login link
    Then User verifies whether Login Page is displayed
    When User enters "test94@abc.com" and "test904" and clicks login button
    Then User verifies whether the user is logged in successfully
    When User clicks on logout link in the account page
    Then Verify user successfully logs out of the application
    And User quits the application

  Scenario: Verify successful login with invalid email and password
    Given User launches the Open Cart Application
    Then Verify the application launches successfully
    When User clicks on My Account Login link
    Then User verifies whether Login Page is displayed
    When User enters "test904@abc.com" and "test904" and clicks login button
    Then User verifies whether login error message is displayed in the header
    And User quits the application
    
    Scenario: Verify User Registration form
    Given User launches the Open Cart Application
    Then Verify the application launches successfully
    When User clicks on My Account Register link
    Then User verifies User Creation page is displayed
    When User enters "<firstName>", "<lastName>","<email>","<telephone>","<fax>"
    And User enters "<company>","<address1>","<address2">,"<city>","<postcode>","<country>","<state>"
    And User enters "<password>","<confirmPassword>"
    And User checks News Letter and Agree
    And User clicks on Continue button to continue registeration
    Then User verifies whether registration is success
    When User clicks on continue to Account Page
    And User clicks on Logout button
    Then User verifies User Logout message is displayed
    When User clicks on continue button to Logout the application
    Then User verifies whether user is logout and home page is displayed
    And User quits the application
    
    
