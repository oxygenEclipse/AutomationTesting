$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/com/cucumber/features/AutomationPracticeLoginRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "Automation Practice Login Registration",
  "description": "",
  "id": "automation-practice-login-registration",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 28,
  "name": "Verify Automation Practice product selection is range specified",
  "description": "",
  "id": "automation-practice-login-registration;verify-automation-practice-product-selection-is-range-specified",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 27,
      "name": "@ProductRange"
    }
  ]
});
formatter.step({
  "line": 29,
  "name": "User launches the browser and hit the Automation Practice application",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "User clicks on the Sign In in the Home Page",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "User verifies whether the SignIn Page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "User enters the \"automation@abc.com\" as username and \"1234abc\" as password",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "User clicks on the Sign in button in the Sign In Page",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "User verifies whether Sign In is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "User clicks on Women Blouses from the menu",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "User verifies whether the displayed product is in range mentioned in the page",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "User clicks on logout button",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "User verifies if the user is logout of the application",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "User closes the browser",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_launches_the_browser_and_hit_the_Automation_Practice_application()"
});
formatter.result({
  "duration": 288897052535,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_the_Sign_In_in_the_Home_Page()"
});
formatter.result({
  "duration": 11810368946,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_verifies_whether_the_SignIn_Page_is_displayed()"
});
formatter.result({
  "duration": 1096161025,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automation@abc.com",
      "offset": 17
    },
    {
      "val": "1234abc",
      "offset": 54
    }
  ],
  "location": "StepDefinition.user_enters_the_as_username_and_as_password(String,String)"
});
formatter.result({
  "duration": 2181841574,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_the_Sign_in_button_in_the_Sign_In_Page()"
});
formatter.result({
  "duration": 8201846271,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_verifies_whether_Sign_In_is_successful()"
});
formatter.result({
  "duration": 402097218,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_Women_Blouses_from_the_menu()"
});
formatter.result({
  "duration": 17741243267,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_verifies_whether_the_displayed_product_is_in_range_mentioned_in_the_page()"
});
formatter.result({
  "duration": 574248959,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_logout_button()"
});
formatter.result({
  "duration": 15453894226,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_verifies_if_the_user_is_logout_of_the_application()"
});
formatter.result({
  "duration": 154780964,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_closes_the_browser()"
});
formatter.result({
  "duration": 1227975886,
  "status": "passed"
});
});