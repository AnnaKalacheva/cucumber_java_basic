Feature: errorCase


  Scenario Outline: errorCase
    Given I am on number page
    When I enter number: <number>
     And I click submit
    Then I see error: <message>

    Examples:
    | number | message             |
    | 10     | Number is too small |
    | 105    | Number is too big   |
    | *      | Please enter a number   |

    Scenario Outline: happyCase
      Given I am on num page
      When I enter num: <number>
      And I click submitButton
      Then I see alertMessage: <message>

      Examples:
        | number | message             |
        | 55     | Square root of 55 is 7.42   |

