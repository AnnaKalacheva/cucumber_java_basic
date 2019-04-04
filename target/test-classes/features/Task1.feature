Feature: Task1
  As a test engineer
  I want to be able to write and execute a scenario with parameters
Background:
Given I am on Enter a number page

  Scenario Outline: for error cases:


  When  I enter <number>
  And   I click submit
  Then  Then I see message: "<message>"


  Examples:
    | number  | message                   |
    | 33      | Number is too small       |
    | 166     | Number is too big         |
    | word    | Please enter a number     |

Scenario Outline: for correct number

  When  I enter <number>
  And   I click submit
  Then  I see message answer : "Square root of <number> is <answer>"

  Examples:
    | number  | answer                    |
    | 55      |    7.42                   |
    | 99      |    9.95                   |