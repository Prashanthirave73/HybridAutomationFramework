Feature: Login Functionality

  Background:
    Given User launches application

  @ignore @smoke
  Scenario: Successful Login
    When User enters valid credentials
    Then User should login successfully

  @ignore @regression
  Scenario: Logout
    When User logs in
    And User clicks logout
    Then User should be redirected to login page

  Scenario Outline: Login Validation
    # Given User launches application
    When User enters "<username>" and "<password>"
    Then Login should be "<result>"

    Examples:
      | username                   | password | result  |
      | prashanthirave96@gmail.com | Test@123 | success |
      | user2@test.com             | pass2    | failure |
      | wrong@test.com             | wrong    | failure |

  @ignore
  Scenario: Multiple User Login
    When User enters following credentials
      | username       | password |
      | user1@test.com | pass1    |
      | user2@test.com | pass2    |
