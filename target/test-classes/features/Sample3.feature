@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<Name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | Name  | age | message                        |
      | Ann   | 5   | Hello, Ann, you are a kid      |
      | Marry | 50  | Hello, Marry, you are an adult |
      | Bob   | 61  | Hello, Bob, you are an adult   |


  @not_working
    Examples:
      | Name | age | message                   |
      | Tom  | 15  | Hello, Tom, you are a kid |

  @myTag
  Scenario outline for error cases:
    And enter number too small
    And enter number too big
    And enter text instead of the number

  Scenario for correct number:



