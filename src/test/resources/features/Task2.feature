Feature: Task two
  As a test engineer
  I want to be able to add new person, edit and remove person, execute a scenario outline

  Scenario Outline: people with jobs
    Given I am on People with jobs page
    When I click on Add person button
    And I enter person name: "<name>"
    And I enter job: "<job>"
    Then I click on Add button
    Then check that person with "<name>" and "<job>" exists

    Examples:
      | name           | job    |
      | Tom Hanks      | actor  |
      | Britney Spears | singer |


  Scenario: edit person
    Given I am on People with jobs page
    When I click on edit person button
    And I can edit name: "Donald"
    And I can edit job: "president"
    Then I click on save changes
    Then check that person "Donald" is exists


  Scenario Outline: remove a person
    Given I am on People with jobs page
    When I click on remove person button with "<id>"
    Then I can see that person with "<id>" disappeared
    Examples:
      | id |
      | 0  |
      | 1  |


  Scenario Outline: reset original list after: adding a person
    Given I am on People with jobs page
    When I click on Add person button
    Then I enter person name: "David"
    Then I enter job: "engineer"
    Then I click on Add button
    Then check that person "David" is exists
    Then I click on reset list button
    Then check that person with "<name>" and "<job>" exists

    Examples:
      | name | job          |
      | Mike | Web Designer |
      | Jill | Support      |
      | Jane | Accountant   |


  Scenario Outline: reset original list after: editing a person
    Given I am on People with jobs page
    When I click on edit person button
    And I can edit name: "Donald"
    And I can edit job: "president"
    Then I click on save changes
    Then check that person "Donald" is exists
    Then I click on reset list button
    Then check that person with "<name>" and "<job>" exists

    Examples:
      | name | job          |
      | Mike | Web Designer |
      | Jill | Support      |
      | Jane | Accountant   |

  Scenario Outline: reset original list after: removing a person
    Given I am on People with jobs page
    When I click on remove person button with "<id>"
    Then I can see that person with "<id>" disappeared
    Then I click on reset list button
    Then check that person with "<name>" and "<job>" exists

    Examples:
      | name | job          | id |
      | Mike | Web Designer | 0  |
      | Jill | Support      | 1  |
      | Jane | Accountant   | 2  |


  Scenario: check that clear button on adding a user works correctly
    Given I am on People with jobs page
    When I click on Add person button
    Then I enter person name: "David"
    Then I enter job: "engineer"
    And I click on clear all fields
    Then I check all fields are cleared