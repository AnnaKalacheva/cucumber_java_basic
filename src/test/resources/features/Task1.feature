#Individual Tasks: In Task1.feature create 1 scenario outline and 1 scenario for page with url: https://kristinek.github.io/site/tasks/enter_a_number
Feature: Task 1
  As a test engineer


  Background:
    Given I am on age pageNumber

  Scenario Outline: outline number too small cases:
    When enter "<number>"
    And I click submit
    Then I see message: "<message>"

    Examples:
      | number | message             |
      | 1      | Number is too small |
      | 2      | Number is too small |
      | 3      | Number is too small |

  Scenario Outline: outline number too big cases:
    When enter "<number>"
    And I click submit
    Then I see message: "<message>"
    Examples:
      | number | message           |
      | 111    | Number is too big |
      | 222    | Number is too big |
      | 322    | Number is too big |

  Scenario Outline: outline text cases:
    When enter "<string>"
    And I click submit
    Then I see message: "<message>"
    Examples:
      | string   | message               |
      | 1qweqw11 | Please enter a number |
      | 2wqe22   | Please enter a number |
      | 3weq22   | Please enter a number |


  Scenario Outline: outline number  cases:
    When enter "<number>"
    And I click submit
    Then I see Alert of "<number>"

    Examples:
      | number |
      | 55     |
      | 81     |
      | 90     |


