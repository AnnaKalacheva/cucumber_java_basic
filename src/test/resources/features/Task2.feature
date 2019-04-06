Feature: Task2 Test scenarios for List of people PO (P2)
  In Task2.feature create 1 scenario outline and create scenario or scenario outlines for page
  P1 = https://kristinek.github.io/site/tasks/list_of_people_with_jobs
  P2 = https://kristinek.github.io/site/tasks/list_of_people
  in order to test that user can:

  /1* add a new person
  /2* edit a person
  /3* remove a person
  /4* reset original list after:
  /4.1* adding a person
  /4.2* editing a person
  /4.3* removing a person
  /5* check that clear button on adding a user works correctly

#  Default persons:
#  Mike Kid
#  Jill Watson
#  Jane Doe

  Background:
    Given I am on People with jobs page

  Scenario Outline: 1. add a new person + 4.1 reset original list after adding a person
    When I click Add person button:
    Then I'm redirected to a new person registration page
    And I enter values in fields:
      | name    | <name>    |
      | surname | <surname> |
      | job     | <job>     |
      | dob     | <dob>     |
    And I click on language checkboxes:
      | English |
      | French  |
      | Spanish |
    And I click on gender: Male
    And I select Employee status: Contractor
    And I click Add button
    Then I click Reset list button
    Examples:
      | name     | surname     | job     | dob        |
      | TestName | TestSurname | TestJob | 01/04/2000 |


  Scenario: 2. edit person + 4.2 reset original list after editing a person
    When I click pencil to edit person: Mike Kid
    And I enter a new date of birth: 01/01/1900
    And I click Edit button
    Then I click Reset list button

  Scenario: 3. remove a person + 4.2 reset original list after removing a person
    When I click cross to remove person: Jill Watson
    And I see person is removed
    Then I click Reset list button

  Scenario Outline: 5. check that clear button on adding a user works correctly
    When I click Add person button:
    Then I'm redirected to a new person registration page
    And I enter values in fields:
      | name    | <name>    |
      | surname | <surname> |
      | job     | <job>     |
      | dob     | <dob>     |
    And I click Clear all fields button
    Then I see that registration form was reset to default
    Examples:
      | name     | surname     | job     | dob        |
      | TestName | TestSurname | TestJob | 01/04/2000 |

