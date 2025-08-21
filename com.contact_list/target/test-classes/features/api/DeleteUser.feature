@allure.label.epic:API
Feature: Scenarios for deleting users
#  Background:
#    Given User has token for Authentication of user with credentials "<email>" and "<password>"
    @allure.label.suite:Delete_User
      @allure.label.subSuite:Delete_Existing_User
    Scenario Template: Deleting existing User
      Given User has token for Authentication of user with credentials "<email>" and "<password>"
      When User sends a delete request
      Then User should receive OK response
      Examples:
      |email|password|
#      |   johnson300@email.com  |  #John123      |