Feature: Individual Tasks: In Task1.feature create 1 scenario outline and 1 scenario for page with url: https://kristinek.github.io/site/tasks/enter_a_number
  @debugs
Scenario Outline: outline for error cases:
    Given I opened Enter number page
    When I enter number <number>
    And I click submit
    Then I see error message: <message>

    Examples:
      | number | message                  |
      |  5   | Number is too small        |
      | 107  | Number is too big          |
      |qwerty| Please enter a number      |
      |      |You haven't entered anything|


  Scenario Outline: for correct number:

    Given I opened Enter number page
    When I enter number <number>
    And I click submit
    Then I see alert message: <Text>

  Examples:
  |number|    Text                    |
  | 81   | Square root of 81 is 9.00  |



