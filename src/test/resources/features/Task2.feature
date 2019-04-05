Feature: Task2 People with jobs PO

  Background:
    Given I am on People with jobs page

  Scenario: 1. add a new person
    When I click Add person button:
    Then I'm redirected to a new person registration page
    And I enter values in fields:
      | Name          | TestName    |
      | Surname       | TestSurname |
      | Job           | TestJob     |
      | Date of birth | 01/04/2000  |
    And I click on language checkboxes:
      | English |
      | French  |
      | Spanish |
    And I click on gender: Male
    And I select Employee status: Contractor
    Then I click Add button

  Scenario: 2. edit person
    When I click pencil to edit person for person: 1
    And I enter a new date of birth: 01/01/1900
    Then I click Edit button

  Scenario: 3. remove a person
    When I click cross to remove person: 1
 #   And I enter a new date of birth: 01/01/1900
  #  Then I click Edit button

#  Examples:
#  | Number | Name | Surname |
#  | 1      | Mike | Kid     |
#  | 2      | Jill | Watson  |
#  | 3      | Jane | Doe     |





#  Scenario Outline: a new scenario outline 2
#    When I enter values using PO:
#      | name | <name> |
#      | age  | <age>  |
#    And I click submit age using PO
#    Then I see message: "<message>" using PO
#    Examples:
#      | name | age | message                      |
#      | Ann  | 5   | Hello, Ann, you are a kid    |
#      | Bob  | 61  | Hello, Bob, you are an adult |

