@allure.label.epic:API
Feature: Scenarios for deleting users
  Background:
    Given User has request specifications for Deleting Users
    @allure.label.suite:Delete_User
      @allure.label.subSuite:Delete_Existing_User
    Scenario Template: Deleting existing User
      When User sends a delete request for the user with credentials "<email>" and "<password>"
      Then User should receive OK response
      Examples:
      |email|password|
      |   johnson100@email.com  |  #John123      |