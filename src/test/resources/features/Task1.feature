Feature: Task one
  As a test engineer
  I want to be able to write and execute a scenario outline

  Background:
    Given I am on Enter a number page

  Scenario Outline: Number scenario errors
    When I enter number field : "<number>"
    And I click Submit
    Then I should see message: "<message>"

    Examples:
      | number | message               |
      | 20     | Number is too small   |
      | 110    | Number is too big     |
      | Anna   | Please enter a number |

  Scenario Outline: correct numbers
    When I enter number field : "<number>"
    And I click Submit
    Then I should see answer message: "Square root of <number> is <message>"

    Examples:
      | number | message |
      | 81     | 9.00    |















