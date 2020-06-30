Feature: Amazon Search Product Test Cases

  Scenario: Search for a Product: Good Product
    Given User launches the Amazon website
    Then User successfully launches the website
    When User enter product name as "Dove Soap"
    And User hit Enter or click submit button
    Then System should responed back with list of Dove Soaps
    When User quits the application

  Scenario: Search for a Product: Empty Search
    Given User launches the Amazon website
    Then User successfully launches the website
    When User enter no product name
    And User hit Enter or click submit button
    Then System should responed back with the text "No search term was entered. Please enter product name."
    When User quits the application

  Scenario: Search for a Product: Wrong Search
    Given User launches the Amazon website
    Then User successfully launches the website
    When User enter product name as "10 tola gold bar"
    And User hit Enter or click submit button
    Then System should responed back with the text "No matches found."
    When User quits the application
