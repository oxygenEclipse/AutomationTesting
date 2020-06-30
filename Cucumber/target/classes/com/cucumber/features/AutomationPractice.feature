Feature: Automation Practice Product Selection and Product Order functionality validation

  Scenario: Verify Login Functionality of the Automation Practice Application
    Given User launches the browser and hit the Automation Practice application
    When User clicks on the Sign In in the Home Page
    Then User verifies whether the SignIn Page is displayed
    When User enters the "automation@abc.com" as username and "1234abc" as password
    And User clicks on the Sign in button in the Sign In Page
    Then User verifies whether Sign In is successful

  Scenario Outline: Verify Search Box Product Selection and Product Order funtionality
    When User enters the "<Product>" in search box
    And User clicks on the Search button in the Search Page
    Then User verifies whether the products are displayed
    When User clicks on any one of the listed product
    Then User verifies whether the product detail page is displayed
    When User selects the quantity, size and color
    And User clicks on the Add to cart button
    Then User verifies whether the Proceed to cart popup is displayed
    When User clicks on the Proceed to checkout button
    Then User verifies whether Summary Page is displayed
    And User verifies whether expected Product Name, Unit Price and Total Price are displayed
    When User clicks on the Proceed to checkout button in Summary Page
    Then User verifies whether the Address Page is displayed
    And User verifies whether Your Deilvery Address and Your Billing Address are same
    When User clicks on the Proceed to checkout button in Address Page
    Then User verifies whether the Shipping Page is displayed
    When User clicks the Agree checkbox
    And User clicks on the Proceed to Checkout button in Shipping Page
    Then User verifies whether Payment Page is displayed
    When User clicks on the Pay by bank wire from the Payment options
    Then User verifies whether the Bank-Wire Payment Details are displayed
    When User clicks on the I confirm my order button
    Then User verifies whether the order is complete

    Examples: 
      | Product |
      | Blouse  |
      | T-Shirt |
      | Tops    |

  Scenario: Verify Log out functionality of the Automation Practice Application
    When User clicks logout button in the application
    Then User verifies if the user is logged out of the application
    And User quits the browser
