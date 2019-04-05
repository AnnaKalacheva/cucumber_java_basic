@regression
Feature: task2 scenarios of adding a person with job


@addingAPerson
  Scenario Outline: adding a new person
    Given I am on page of persons with a job
    When I press Add Person using PO
    And I enter name: <name> using PO
    And I enter surname: <surname> using PO
    And I enter job: <job> using PO
    And I enter birth date: <date> using PO
    And I choose languages:  using PO
    And I choose gender: <gender> using PO
    And I choose Employee Status: <status> using PO
    And I perform the action of adding the person using PO
    And I press edit person
    And I change persons name to <newName> using PO
    And I perform the action of adding the person using PO
    And I delete the person
    And I reset the person list using PO
    And I press Add new person using PO
    And I input the name using PO <name1>
    And I clear the data by button using PO
    Then I check if input is empty





  @aNewPerson
  Examples:
    | name   | surname       | job        |date              | gender | status     |newName| name1  |
    | Josh   | Cakeman       | President  |11/07/1976        |Male    | Employee   |Billy  | Clara  |
