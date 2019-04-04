Feature: Task 1
  Testing Enter number page answers

  Background:
    Given I open Enter a number page

  Scenario Outline: Enter wrong input
    When I enter number: <number>
    And I click Submit
    Then I see an error message: "<message>"
    Examples:
      | number | message                      |
      | 48     | Number is too small          |
      | 101    | Number is too big            |
      | word   | Please enter a number        |
      |        | You haven't entered anything |

  Scenario Outline: Enter a valid number
    When I enter number: <number>
    And I click Submit
    Then I get an alert with message: "Square root of <number> is <answer>"
    And I press OK
    Examples:
      | number | answer |
      | 64     | 8.00   |
      | 70     | 8.37   |
    @bug
    Examples:
      | number | answer |
      | 49     | 7.00   |

  @easterEgg
  Scenario: Enter 42
    When I enter number: 42
    And I click Submit
    Then I get an alert with message: "Sorry you have asked the wrong answer"
    And I press OK
