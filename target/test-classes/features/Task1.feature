Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  Scenario Outline: Scenario for wrong input
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
