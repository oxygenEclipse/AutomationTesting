Feature: JIRA API Issue Automation Functionality

  @CreateIssue
  Scenario: Create an Issue in JIRA using POST Method
    Given User mentions the endpoint "https://greenstechnologyan1.atlassian.net/rest/api/2/issue/"
    When User specify the header key as "Content-Type" and value as "application/json"
    And User pass the authentication credentials
    And User specify the input body from the file "src/test/resources/createIssue.json"
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response key "id" in response body is present
    And User verifies whether the response status code is "201"
    And User verifies whether the response key "key" in response body is present

  @UpdateIssueAndRetrieve
  Scenario: Update an Issue in JIRA using PUT Method and verify using GET Method
    Given User mentions the endpoint "https://greenstechnologyan1.atlassian.net/rest/api/2/issue/RESTAPI-2"
    When User specify the header key as "Content-Type" and value as "application/json"
    And User pass the authentication credentials
    And User specify the input body from the file "src/test/resources/updateIssue.json"
    And User sends the PUT Request
    Then User prints the response
    And User verifies whether the response status code is "204"
    When User mentions the endpoint "https://greenstechnologyan1.atlassian.net/rest/api/2/issue/RESTAPI-2"
    And User specify the header key as "Content-Type" and value as "application/json"
    And User pass the authentication credentials
    And User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "fields.project.key" in response body is equal to "RESTAPI"
    And User verifies whether the response key "key" in response body is equal to "RESTAPI-2"
    And User verifies whether the response key "fields.issuetype.name" in response body is equal to "Bug"
    And User verifies whether the response key "fields.priority.name" in response body is equal to "Medium"
    And User verifies whether the response key "fields.summary" in response body contains "summary"
    And User verifies whether the response key "fields.description" in response body contains "description"

  @CreateIssueAndRetrieve
  Scenario: Create an Issue in JIRA using POST Method and verify using GET Method
Given User mentions the endpoint "https://greenstechnologyan1.atlassian.net/rest/api/2/issue/"
    When User specify the header key as "Content-Type" and value as "application/json"
    And User pass the authentication credentials
    And User specify the input body from the file "src/test/resources/createIssue.json"
    And User sends the POST Request
    Then User prints the response
    And User verifies whether the response key "id" in response body is present
    And User verifies whether the response status code is "201"
    And User verifies whether the response key "key" in response body is present
    When User mentions the endpoint "https://greenstechnologyan1.atlassian.net/rest/api/2/issue/"
    And User specify the header key as "Content-Type" and value as "application/json"
    And User pass the authentication credentials
    And User sends the GET Request
    Then User prints the response
    And User verifies whether the response status code is "200"
    And User verifies whether the response key "fields.project.key" in response body is equal to "RESTAPI"
    And User verifies whether the response key "fields.issuetype.name" in response body is equal to "Bug"
    And User verifies whether the response key "fields.priority.name" in response body is equal to "Medium"
    And User verifies whether the response key "fields.summary" in response body contains "Automation"
    And User verifies whether the response key "fields.description" in response body contains "project keys"