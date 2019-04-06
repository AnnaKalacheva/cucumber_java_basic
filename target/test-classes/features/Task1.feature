Feature: Introduction to cucumber part 3
#  Scenario outline for error cases:
#     enter number too small
#     enter number too big
#     enter text instead of the number
#  Scenario for correct number

  Scenario Outline: Scenario outline for error cases
    Given I am on enter number page
    When I enter number: <number>
    And I click Submit
    Then I see message: <error_message>
    Examples:
      | number  | error_message             |
      | 30      | Number is too small       |
      | 1000    | Number is too big         |
      | aaa     | Please enter a number     |


  Scenario Outline: Scenario for correct input
    Given I am on enter number page
    When I enter number: <number>
    And I click Submit
    Then I see alert message "Square root of <number> is <sqr_result>"
    Examples:
      | number  | sqr_result  |
      | 60      | 7.75        |
