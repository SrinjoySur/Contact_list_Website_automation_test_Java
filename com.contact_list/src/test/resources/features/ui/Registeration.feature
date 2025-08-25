@allure.label.epic:UI
Feature: Registration Feature for UI
  Background:
    Given User is at Registration Page
  @allure.label.suite:Registration
    @allure.label.subSuite:Valid_Registration
    Scenario Template: Valid Registrations
      When User enters First Name "<firstName>" and Last Name "<lastName>"
      And User enters Email "<email>" and Password "<password>"
      And User clicks on Submit button
      Then User is redirected to Contact List page
      Given User has token for Authentication of user with credentials "<email>" and "<password>"
      When User sends a delete request
      Then User should receive OK response
      Examples:
      |firstName|lastName|email|password|
      | Example        |   User     |   johnson100@email.com  |  #John123      |
  @allure.label.subSuite:Invalid_Registration
  Scenario Template: Invalid Registration
    When User enters First Name "<firstName>" and Last Name "<lastName>"
    And User enters Email "<email>" and Password "<password>"
    And User clicks on Submit button
    Then User should get Error "<error>"
    Examples:
      |firstName|lastName|email|password|error|
      |         |   User     |   johnson100@email.com  |  #John123      |User validation failed: firstName: Path `firstName` is required.|
      |   User      |        |   johnson100@email.com  |  #John123      |User validation failed: lastName: Path `lastName` is required.|
    |      hi       |    hi    |                         |        Hii#123        |             User validation failed: email: Email is invalid                                                 |
    |       hi        |    hi      |      hi@email.com                   |                       |                               User validation failed: password: Path `password` is required.                                                                              |
    @allure.label.subSuite:Cancel
    Scenario: Cancel Registration
    When User clicks on Cancel Button
    Then User is redirected to login page