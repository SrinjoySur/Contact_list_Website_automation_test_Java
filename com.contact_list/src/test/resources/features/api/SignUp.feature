@allure.label.epic:API
Feature: Sign Up Features for API
  Background:
    Given User has request specifications for Sign Up
  @allure.label.suite:Sign_Up
  @allure.label.subSuite:Valid_Sign_Up
    Scenario Template: Valid Sign Up
      When User sends a post request with First Name "<firstName>", Last Name "<lastName>", Email "<email>" and Password "<password>"
      Then User receives Success Response
      And User Validates response for Correct Json Schema
#      Given User has token for Authentication of user with credentials "<email>" and "<password>"
#      When User sends a delete request
#      Then User should receive OK response
      Examples:
      |firstName|lastName|email|password|
      | Example        |   User     |   johnson300@email.com  |  #John123      |
  @allure.label.subSuite:Invalid_Sign_Up
    Scenario Template: Invalid Sign Up
    When User sends a post request with First Name "<firstName>", Last Name "<lastName>", Email "<email>" and Password "<password>"
    Then User receives Error Response
    And User receives "<message>" in response
    Examples:
      |firstName|lastName|email|password|message|
      |         |    User    |   johnson300@email.com  |  #John123      |    User validation failed: firstName: Path `firstName` is required.   |
    |    User     |            |          johnson300@email.com               |        #John123        |                        User validation failed: lastName: Path `lastName` is required.                                               |
    |      User       |     User       |                                             |           John123             |                                             User validation failed: email: Email is invalid                                                                                        |
    |        User     |        User    |                johnson300@email.com                             |                        |                                                           User validation failed: password: Path `password` is required.                                                                          |