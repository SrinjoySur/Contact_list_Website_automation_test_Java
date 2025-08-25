@allure.label.epic:API
  Feature: Sign In feature Scenarios
    Background:
      Given User has request specifications ready for Sign
    @allure.label.suite:Sign_In
    @allure.label.subSuite:Valid_Sign_In
      Scenario Template: Valid Sign In Scenarios
      When User sends a post request to Sign In endpoint with credentials "<email>" and "<password>"
      Then User receives OK response
      And User receives a token in response body
      Examples:
      |email|password|
      | demobro@email.com      |  #Demo123       |
      | demo_tester@email.com  |  #Demo123       |
      | demo2tester@email.org  |  @Demo123       |
      | jona@email.com         |  @Jona123       |
      | daily@email.org        | @Daily123       |