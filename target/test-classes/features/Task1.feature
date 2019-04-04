Feature: Entering a number in given page

  @firstScenario
Scenario Outline: number input error cases
  Given I open enter a number page
  When I enter invalid input <input> in the number field
  And I click on submit button
  Then I see error message <input>

  Examples:
    | input |
    |   3   |
    |  443  |
    |  afg  |

Scenario: number input is correct
  Given I open enter a number page
  When I enter 64 in the number field
  And I click on submit button
  Then I see a message: "Square root of 64 is 8.00"