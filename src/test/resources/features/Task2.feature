Feature: Testing list of people with jobs

  @addPerson
  Scenario Outline: Adding a person
    Given I am on people with jobs page
    When I click on add person button
    And I enter name: <name>, and job: <job>
    And I click on add button
    Then I see a new person <name> with job <job>
    And I click on reset list button

    Examples:
    | name   | job               |
    | John   | Engineer          |
    | Paul   | Preschool Teacher |
    | George | Bank Clerk        |

  @editPerson
  Scenario: Editing a person
    Given I am on people with jobs page
    When I click on first edit icon
    And I change name to "Peter" and job to "Manager"
    And I click on edit button
    Then I see first person with name "Peter" and job "Manager"
    And I click on reset list button

  @removePerson
  Scenario Outline: Removing a person
    Given I am on people with jobs page
    When I click on remove person icon <person>
    Then I don't see removed person <person>
    And I click on reset list button

    Examples:
    | person  |
    | person0 |
    | person1 |
    | person2 |

  @checkClearButton
  Scenario: Check if clear button works
    Given I am on people with jobs page
    When I click on add person button
    And I enter name: John, and job: Engineer
    And I click on clear all fields button
    Then I see that all fields are clear

