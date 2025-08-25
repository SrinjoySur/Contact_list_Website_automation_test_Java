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
      And User validates that the response received is of valid json format
      And User receives details of account in response "<firstName>", "<lastName>" and "<email>"
      Examples:
      |email|password|firstName|lastName|
      | demobro@email.com      |  #Demo123       |Demo |Tester|
      | demo_tester@email.com  |  #Demo123       |Demo |Tester|
      | demo2tester@email.org  |  @Demo123       |Demo |Tester|
      | jona@email.com         |  @Jona123       |John |Doe   |
      | daily@email.org        |  @Daily123      |Daily|News  |