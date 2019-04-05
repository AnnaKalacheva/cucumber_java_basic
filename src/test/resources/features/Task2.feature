Feature: Second Individual task in cucumber

  Background:
    Given I am on job page

  @newPerson
  Scenario Outline: add a new person
    When I click add a person
    And I enter person name: "<name>"
    And I enter job title: "<title>"
    And I click add button
    Then I see person's <name> and job's <title> name

    Examples:
      | name     | title     |
      | Kristine | tester    |
      | Edgards  | developer |

  @editPerson
  Scenario Outline: edit person
    When I click edit person
    And I edit person name: "<name>"
    And I edit job title: "<title>"
    And I click edit button
    Then I see person's edit: "<name>" and "<title>"

    Examples:
      | name  | title  |
      | Ralfs | singer |


  @removePerson
  Scenario: remove person
    When I click remove icon
    And I see person is removed

  @AddAndResetPerson
  Scenario Outline: reset original list after adding
    When I click add a person
    And I enter person name: "<name>"
    And I enter job title: "<title>"
    Then I click add button
    Then I see person's <name> and job's <title> name
    Then I reset original list
    Then I check that list is reset

    Examples:
      | name     | title     |
      | Kristine | tester    |
      | Edgards  | developer |

  @editAndResetPerson
  Scenario Outline: edit and reset person
    When I click edit person
    And I edit person name: "<name>"
    And I edit job title: "<title>"
    And I click edit button
    Then I see person's edit: "<name>" and "<title>"
    Then I reset original list
    Then I check that list is reset

    Examples:
      | name  | title  |
      | Ralfs | singer |
      | Rita  | dancer |

  @removeAndReset
  Scenario: remove person and reset original list later
    When I click remove icon
    And I see person is removed
    Then I reset original list
    Then I check that list is reset

  @addAndClearPerson
  Scenario Outline: add a new person
    When I click add a person
    And I enter person name: "<name>"
    And I enter job title: "<title>"
    And I clear all input fields
    Then I see input fields empty

    Examples:
      | name     | title     |
      | Kristine | tester    |
      | Edgards  | developer |