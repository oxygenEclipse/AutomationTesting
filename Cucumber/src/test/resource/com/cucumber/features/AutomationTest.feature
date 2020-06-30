Feature: Automation Practice Application Order Process Validation

  Scenario Outline: Verify the Login Functionality
    Given User launches the browser and hit the Automation Practice application
    When User clicks on the Sign In in the Home Page
    Then User verifies whether the SignIn Page is displayed
    And User enters the "<emailAddress>" to create an account
    And User clicks on create an account button
    Then User verifies User Registration Page is displayed
    When User enters the user details as "<title>","<firstName>","<lastName>","<eMail>","<password>" and "<dob>"
    And User enters the address details as "<company>","<address>","<city>","<state>","<postalCode>" and "<country>"
    And User enters the contact details as "<homePhone>","<mobilePhone>" and "<addrAlias>"
    And User clicks on register button
    Then User verifies the user name is displayed on header on successful registration
    When User clicks on logout button
    Then User verifies if the user is logout of the application
    When User closes the browser
    
     Examples: 
      | emailAddress     | title | firstName | lastName | eMail            | password | dob        | company     | address           | city    | state   | postalCode | country       | homePhone | mobilePhone | addrAlias  |
      | test@test154.com | Mrs.  | TestABC   | Abc      | test@test154.com | test@123 | 29/03/2000 | ABC Company | 745, Apple Avenue | Phoenix | Arizona |      54786 | United States |   2547865 |  9784512346 | My Address |
    
