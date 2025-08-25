@allure.label.epic:UI
Feature: Login Feature for UI
  Background:
    Given User is at Login Page
  @allure.label.suite:Login
  @allure.label.subSuite:Valid_Login
    Scenario Template:Valid Login Credentials
    When User enters credentials "<email>" and "<password>"
    And User clicks on Login button
    Then User is redirected to Contact List Dashboard page
    Examples:
    | email | password|
    | demobro@email.com      |  #Demo123       |
    | demo_tester@email.com  |  #Demo123       |
    | demo2tester@email.org  |  @Demo123       |
    | jona@email.com         |  @Jona123       |
    | daily@email.org        | @Daily123       |