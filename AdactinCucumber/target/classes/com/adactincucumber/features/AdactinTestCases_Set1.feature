Feature: Adactin Hotel Booking Application verification and validation

  Scenario: Verify the login functionality of the Adactin Application
    Given User launches the browser and hit the Adactin application
    Then User verifies whether the Home Page is displayed
    When User enters the "banusathish23" as username and "1234abc" as password
    And User clicks on the Login button in the Home Page
    Then User verifies whether Login is successful

  Scenario Outline: Verify whether the check-out date field accepts a later date than checkin date
    When User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" later than "<checkout date>"
    And User clicks on the search button
    Then User verifies that system gives an error saying check-in-date should not be later than check-out-date

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today + 7    | today + 5     |

  Scenario Outline: Verify whether error is reported if check-out date field is in the past
    When User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" with before date and "<checkout date>" with before date
    And User clicks on the search button
    Then User verifies that system that application throws error message

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today - 5    | today - 3     |

  Scenario Outline: Verify whether location in Select Hotel page and Search Hotel are displayed same
    When User clicks on search hotel link
    And User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" and "<checkout date>"
    And User clicks on the search button
    Then User verifies Location displayed in Select Hotel Page should be the same as location selected in Search Hotel Page

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today        | today + 1     |

  Scenario Outline: Verify whether Check-In Date and Check Out Date in Select Hotel page and Search Hotel page are displayed same
    When User clicks on search hotel link
    And User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" and "<checkout date>"
    And User clicks on the search button
    Then User verifies that check-in date and check-out date are the same as selected in Search Hotel

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today        | today + 1     |

  Scenario Outline: Verify whether no. of rooms entry in Select Hotel page and Search Hotel page are displayed same
    When User clicks on search hotel link
    And User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" and "<checkout date>"
    And User clicks on the search button
    Then User verifies No-of-rooms should be displayed and match with number of rooms in Search Hotel page

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today        | today + 1     |

  Scenario Outline: Verify whether room type entry in Select Hotel page and Search Hotel page are displayed same
    When User clicks on search hotel link
    And User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" and "<checkout date>"
    And User clicks on the search button
    Then User verifies room type should be displayed and match with room type in Search Hotel page

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today        | today + 1     |

  Scenario Outline: To verify whether the total price (excl.GST) is calculated as “price per night * no. of nights* no of rooms”
    When User clicks on search hotel link
    And User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" and "<checkout date>"
    And User clicks on the search button
    And User selects the "<hotel>" displayed in Select Page
    And User clicks on the continue button in Select Page
    Then User verifies whether total-price (excl. GST) is calculated as per formula

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today        | today + 1     |

  Scenario Outline: Verify total price is being calculated as “price per night*no of days*no of rooms in Book a hotel page
    When User clicks on search hotel link
    And User selects location as "<location>"
    And User selects hotel as "<hotel>"
    And User selects room type as "<room type>"
    And User selects no-of-rooms as "<no of rooms>"
    And User enters "<checkin date>" and "<checkout date>"
    And User clicks on the search button
    And User selects the "<hotel>" displayed in Select Page
    And User clicks on the continue button in Select Page
    Then User verifies whether total-price is calculated as (price-pernight* no-ofrooms* no-of-days + 10% GST”)

    Examples: 
      | location | hotel       | room type | no of rooms | checkin date | checkout date |
      | Sydney   | Hotel Creek | Standard  |           1 | today        | today + 1     |
