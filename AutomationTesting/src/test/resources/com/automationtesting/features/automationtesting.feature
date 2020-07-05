Feature: Automation Testing HomePage Functionality

  Background: User opens the automation testing website
    Given User open the browser and enters the automation testing URL

  @HomePageSliders
  Scenario: HomePage with three Silders only
    When User clicks on Shop Menu
    And User clicks on Home menu button
    Then Check whether it is navigated to the Home page
    And User verifies whether the Home page has only 3 sliders

  @HomePageArrivals
  Scenario: HomePage with three Arrivals only
    When User clicks on Shop Menu
    And User clicks on Home menu button
    Then Check whether it is navigated to the Home page
    And User verifies whether the Home page has only 3 arrivals

  @HomePageSliders
  Scenario: HomePage - images in Arrivals should navigate
    When User clicks on Shop Menu
    And User clicks on Home menu button
    Then Check whether it is navigated to the Home page
    And User verifies whether the Home page has only 3 arrivals
    When User clicks on the image in Arrivals
    Then User should navigate to the page where user can Add to his basket

  @HomePageArrivals
  Scenario: HomePage - images in Arrivals should navigate and display description
    When User clicks on Shop Menu
    And User clicks on Home menu button
    Then Check whether it is navigated to the Home page
    And User verifies whether the Home page has only 3 arrivals
    When User clicks on the image in Arrivals
    Then User should navigate to the page where user can Add to his basket
    When User clicks on Description tab
    Then User verifies the description displayed is same as the book clicked

  @HomePageArrivalsAddToBasket
  Scenario: HomePage - images in Arrivals should navigate and click on Add To Basket
    When User clicks on Shop Menu
    And User clicks on Home menu button
    Then Check whether it is navigated to the Home page
    And User verifies whether the Home page has only 3 arrivals
    When User clicks on the image in Arrivals
    Then User should navigate to the page where user can Add to his basket
    When User clicks on Add to Basket button
    Then User verify the product is added to the Basket
    And User can view that Book in the Menu item with price
