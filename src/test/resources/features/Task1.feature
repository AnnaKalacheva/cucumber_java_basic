Feature: Individual Task1 scenario

  Background:
    Given I am on enter a number page

    @Scenario
    Scenario Outline: Individual Task1 scenario1
    When I enter number: <number>
    And  I click submit number
    Then I see error text: "Number is too small"

    @smallnumber
  Examples:
  | number  |
  | 10  |

  @Scenario2
    Scenario Outline: Individual Task1 scenario2
    When I enter number: <number>
    And  I click submit number
    Then I see error text: "Number is too big"

    @bignumber
      Examples:
        | number  |
        | 220  |

  @Scenario3
  Scenario Outline: Individual Task1 scenario3
    When I enter text: <text>
    And  I click submit number
    Then I see error text: "Please enter a number"

  @text
    Examples:
      | text  |
      | muthu  |

  @Scenario4
  Scenario Outline: Individual Task1 scenario4
    When I enter number: <number>
    And  I click submit number
    Then I see result in alert message: "Square root of 60 is 7.75"
  @bignumber
    Examples:
      | number  |
      | 60  |