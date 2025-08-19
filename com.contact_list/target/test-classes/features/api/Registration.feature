Feature: Registration Features for API
  Background:
    Given User has endpoint for Registration
    Scenario Template: Valid Registration
      When User sends a request with First Name "<firstName>", Last Name "<lastName>", Email "<email>" and Password "<password>"
      Then User receives Success Response
      Examples:
      |firstName|lastName|email|password|
      | Example        |   User     |   johnson90@email.com  |  #John123      |