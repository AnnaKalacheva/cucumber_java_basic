Feature: Introduction to cucumber Task1

  Scenario Outline: a new scenario outline
    Given I am on Enter a number page
    When I enter number: "<number>"
    And I click Submit
    Then I see error message "<errorMessage>"

    Examples:
    | number | errorMessage           |
    | 20     | Number is too small    |
    | 120    | Number is too big      |
    | qwerty | Please enter a number  |

  Scenario: a new scenario 2 with regex
    Given I am on Enter a number page
    When I enter number 64 in the field
    And I click Submit
    Then I see Alert with text "Square root of 64 is 8.00"