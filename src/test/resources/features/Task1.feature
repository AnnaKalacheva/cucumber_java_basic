Feature: Task 1
  A first try to write something


  Background:
    Given I am on age page to number

  Scenario: Small number scenario
    When I enter to number field number: 99
    And I click Submit
    Then I see alert message


  Scenario Outline: Number scenario outline
    When I enter to number field number: <number>
    And I click Submit
    Then I see error message: "<message>"

    Examples:
      | number | message               |
      | 25     | Number is too small   |
      | 101    | Number is too big     |
      | abc    | Please enter a number |

  @bug
    Examples:
      | number | message             |
      | 49     | Number is too small |
      | 666    | Number is too big   |
