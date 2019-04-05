#Feature: First Practice Task
#  As a test engineer
#  I want to be able to write and execute a simple scenario
#
#  Scenario: Simple Scenario
#    When I am on style page
#    Then I should see style page header

#Feature: Second Practice Task
#  As a test engineer
#  I want to be able to write and execute a scenario with parameters
#
#  Background:
#    Given I am on action page
#
#  Scenario: Simple Scenario
#    When I enter number: "5"
#    And I click result
#    Then I see text: "You entered number: "5""

Feature: Task 1
  As a test engineer
  I want to be sure that numbers are being validated correctly

  Background:
    Given I am on Enter a number page

  Scenario: Correct Numbers (less than 101 and more than 49)
    When I enter correct number: 100
    And I click Submit
    Then I see alert message
    And I press Ok
    When I enter correct number: 50
    And I click Submit
    Then I see alert message

  Scenario Outline: Incorrect Numbers (less than 101 and more than 49)
    When I enter correct number: <number>
    And I click Submit
    Then I see error message: <message>

    Examples:
      | number | message               |
      | 45     | Number is too small   |
      | 105    | Number is too big     |
      | abc    | Please enter a number |

  @bug
    Examples:
      | number | message             |
      | 49     | Number is too small |





