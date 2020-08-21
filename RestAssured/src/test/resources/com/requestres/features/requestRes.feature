Feature: Requestres API Http Methods Functionality Validation

  Scenario: GET Method verification for Single User
    Given User mentions the endpoint "https://reqres.in/api/users/2"
    When User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "data.id" in response body is equal to "2"
    And User verifies whether the response key "data.email" in response body is equal to "janet.weaver@reqres.in"
    And User verifies whether the response key "data.first_name" in response body is equal to "Janet"
    And User verifies whether the response key "data.last_name" in response body is equal to "Weaver"
    And User verifies whether the response key "data.avatar" in response body is equal to "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
    And User verifies whether the response key "ad.company" in response body is equal to "StatusCode Weekly"
    And User verifies whether the response key "ad.url" in response body is equal to "http://statuscode.org/"
    And User verifies whether the response key "ad.text" in response body contains "A weekly newsletter"

  Scenario: GET Method verification for List of User
    Given User mentions the endpoint "https://reqres.in/api/users?page=2"
    When User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "page" in response body is equal to "2"
    And User verifies whether the response key "per_page" in response body is equal to "6"
    And User verifies whether the response key "total" in response body is equal to "12"
    And User verifies whether the response key "total_pages" in response body is equal to "2"
    And User verifies whether the response key "data[0].id" in response body is equal to "7"
    And User verifies whether the response key "data[0].email" in response body is equal to "michael.lawson@reqres.in"
    And User verifies whether the response key "data[0].first_name" in response body is equal to "Michael"
    And User verifies whether the response key "data[0].last_name" in response body is equal to "Lawson"
    And User verifies whether the response key "data[0].avatar" in response body is equal to "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"

  @SingleUserNotFound
  Scenario: GET Method verification for Single User Not Found
    Given User mentions the endpoint "https://reqres.in/api/users/23"
    When User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "404"

  @ListOfResources
  Scenario: GET Method verification for List of Resources
    Given User mentions the endpoint "https://reqres.in/api/unknown"
    When User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "page" in response body is equal to "1"
    And User verifies whether the response key "per_page" in response body is equal to "6"
    And User verifies whether the response key "total" in response body is equal to "12"
    And User verifies whether the response key "total_pages" in response body is equal to "2"
    And User verifies whether the response key "data[0].id" in response body is equal to "1"
    And User verifies whether the response key "data[0].name" in response body is equal to "cerulean"
    And User verifies whether the response key "data[0].year" in response body is equal to "2000"
    And User verifies whether the response key "data[0].color" in response body is equal to "#98B2D1"
    And User verifies whether the response key "data[0].pantone_value" in response body is equal to "15-4020"

  @SingleResource
  Scenario: GET Method verification for Single Resource
    Given User mentions the endpoint "https://reqres.in/api/unknown/2"
    When User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "data.id" in response body is equal to "2"
    And User verifies whether the response key "data.name" in response body is equal to "fuchsia rose"
    And User verifies whether the response key "data.year" in response body is equal to "2001"
    And User verifies whether the response key "data.color" in response body is equal to "#C74375"
    And User verifies whether the response key "data.pantone_value" in response body is equal to "17-2031"
    And User verifies whether the response key "ad.company" in response body is equal to "StatusCode Weekly"
    And User verifies whether the response key "ad.url" in response body is equal to "http://statuscode.org/"
    And User verifies whether the response key "ad.text" in response body contains "A weekly newsletter"

  @SingleResourceNotFound
  Scenario: GET Method verification for Single Resource Not Found
    Given User mentions the endpoint "https://reqres.in/api/unknown/23"
    When User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "404"

  @CreateUser
  Scenario: POST Method verification for Create User
    Given User mentions the endpoint "https://reqres.in/api/users"
    When User mentions the request body
      """
      {
      "name": "morpheus",
      "job": "leader"
      }
      """
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response status code is "201"
    And User verifies whether the response key "id" in response body is present
    And User verifies whether the response key "createdAt" in response body is present

  @CreateRegisterSuccess
  Scenario: POST Method verification for Register Successful
    Given User mentions the endpoint "https://reqres.in/api/register"
    When User mentions the request body
      """
      {
      "email": "eve.holt@reqres.in",
      "password": "pistol"
      }
      """
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "id" in response body is present
    And User verifies whether the response key "token" in response body is present

  @CreateRegisterUnsuccessful
  Scenario: POST Method verification for Register Unsuccessful
    Given User mentions the endpoint "https://reqres.in/api/register"
    When User mentions the request body
      """
      {
      "email": "sydney@fife"
      }
      """
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response status code is "400"
    And User verifies whether the response key "error" in response body is equal to "Missing password"

  @CreateLoginSuccess
  Scenario: POST Method verification for Login Successful
    Given User mentions the endpoint "https://reqres.in/api/login"
    When User mentions the request body
      """
      {
      "email": "eve.holt@reqres.in",
      "password": "cityslicka"
      }
      """
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "token" in response body is present

  @CreateLoginUnsuccess
  Scenario: POST Method verification for Login Unsuccessful
    Given User mentions the endpoint "https://reqres.in/api/login"
    When User mentions the request body
      """
      {
      "email": "peter@klaven"
      }
      """
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response status code is "400"
    And User verifies whether the response key "error" in response body is equal to "Missing password"

  @UpdateUser
  Scenario: PUT Method verification for Update User
    Given User mentions the endpoint "https://reqres.in/api/users/2"
    When User mentions the request body
      """
      {
      "name": "morpheus",
      "job": "zion resident"
      }
      """
    And User sends the PUT Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "name" in response body is equal to "morpheus"
    And User verifies whether the response key "job" in response body is equal to "zion resident"
    And User verifies whether the response key "updatedAt" in response body is present

  @DeleteUser
  Scenario: DELETE Method verification for a Single User
    Given User mentions the endpoint "https://reqres.in/api/users/2"
    When User sends the DELETE Request
    Then User verifies whether the response status code is "204"
