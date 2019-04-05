Feature: Task 2
  Testing List of people page

  Background:
    Given I open List of people page

  Scenario Outline: Add a new person
    When I remember current list of people
    And I click on Add person button
    And I enter values for the person:
      | name      | <name>      |
      | surname   | <surname>   |
      | job       | <job>       |
      | birthDate | <birthDate> |
    And I select languages: <languages>
    And I select a gender: <gender>
    And I select an employee status: <status>
    And I click Add button
    Then I see a new person with:
      | name      | <name>      |
      | surname   | <surname>   |
      | job       | <job>       |
      | birthDate | <birthDate> |
      | languages | <languages> |
      | gender    | <gender>    |
      | status    | <status>    |
    And I see that other people did not change after add
    Examples:
      | name  | surname | job      | birthDate  | languages | gender | status     |
      | Name  | Surname | Some job | 11/01/1990 |           | male   | Intern     |
      | Name1 | Name2   | Cool job | 11/01/2006 |           | female | Contractor |
      |       |         |          |            |           |        | Employee   |
  @bug
    Examples:
      | name | surname | job | birthDate  | languages                | gender | status   |
      |      |         |     |            | English                  |        | Employee |
      |      |         |     |            | English, French          |        | Employee |
      |      |         |     |            | French, Spanish          |        | Employee |
      |      |         |     |            | English, French, Spanish |        | Employee |
      |      |         |     | 01/01/2030 |                          |        | Employee |

  # place start from 0
  Scenario Outline: Edit a person
    When I remember current list of people
    And I click Edit button for a person at: <place>
    And I enter values for the person:
      | name      | <name>      |
      | surname   | <surname>   |
      | job       | <job>       |
      | birthDate | <birthDate> |
    And I select languages: <languages>
    And I select a gender: <gender>
    And I select an employee status: <status>
    And I click Edit button
    Then I see the values for a person at: <place>
      | name      | <name>      |
      | surname   | <surname>   |
      | job       | <job>       |
      | birthDate | <birthDate> |
      | languages | <languages> |
      | gender    | <gender>    |
      | status    | <status>    |
    And I see that other people did not change after editing a person at: <place>
    Examples:
      | place | name  | surname | job      | birthDate  | languages                | gender | status     |
      | 0     | Name  | Surname | Some job | 11/01/1990 |                          | male   | Intern     |
      | 1     | Name1 | Name2   | Cool job | 11/01/2006 |                          | female | Contractor |
      | 2     |       |         |          |            |                          | male   | Employee   |
      | 1     |       |         |          |            | English                  | male   | Employee   |
      | 1     |       |         |          |            | English, French          | male   | Employee   |
      | 1     |       |         |          |            | English, French, Spanish | male   | Employee   |
  @bug
    Examples:
      | place | name | surname | job | birthDate  | languages       | gender | status   |
      | 1     |      |         |     |            | French          | male   | Employee |
      | 1     |      |         |     |            | Spanish         | male   | Employee |
      | 1     |      |         |     |            | French, Spanish | male   | Employee |
      | 1     |      |         |     | 01/01/2030 |                 | male   | Employee |

  Scenario Outline: Delete a person
    When I remember current list of people
    And I click Delete button for a person at: <place>
    Then I see that a person at <place> was deleted and others did not change
    Examples:
      | place |
      | 0     |
      | 1     |
      | 2     |

  Scenario: Resetting a list after add
    When I remember current list of people
    And I click on Add person button
    And I click Add button
    And I click Reset List button
    Then I see the original list

  Scenario: Resetting a list after edit
    When I remember current list of people
    And I click Edit button for a person at: 0
    And I enter values for the person:
      | name      | new name    |
      | surname   | new surname |
      | job       | new job     |
      | birthDate | 01/01/2000  |
    And I select languages: French, Spanish
    And I select a gender: female
    And I select an employee status: Intern
    And I click Edit button
    And I click Reset List button
    Then I see the original list

  Scenario: Resetting a list after delete
    When I remember current list of people
    And I click Delete button for a person at: 0
    And I click Reset List button
    Then I see the original list

  Scenario Outline: Adding a new person clear button
    When I click on Add person button
    And I enter values for the person:
      | name      | <name>      |
      | surname   | <surname>   |
      | job       | <job>       |
      | birthDate | <birthDate> |
    And I select languages: <languages>
    And I select a gender: <gender>
    And I select an employee status: <status>
    And I click Clear all fields button
    Then I see that all of the fields are cleared
    Examples:
      | name  | surname | job      | birthDate  | languages       | gender | status     |
      | Name  | Surname | Some job | 11/01/1990 | English         | male   | Intern     |
      | Name1 | Name2   | Cool job | 11/01/2006 | French, Spanish | female | Contractor |
      |       |         |          |            |                 |        | Employee   |