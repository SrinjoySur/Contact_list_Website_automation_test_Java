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
      Examples:
      |firstName|lastName|email|password|
      | Example        |   User     |   johnson20@email.com  |  #John123      |