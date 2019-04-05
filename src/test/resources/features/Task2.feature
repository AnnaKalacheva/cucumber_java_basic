Feature: Task2
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  Scenario Outline:  add a new people
    Given I am on People with jobs page
    When I press Add person
    When Input name "<name>"
    And  Input job "<job>"
    And  Press Add button
    Then The new  Person with "<name>"and "<job>" is created

    Examples:
      | name     | job               |
      | Alina    | Director          |


  Scenario Outline: edit a person
    Given I am on People with jobs page
    When Press edit Button Pencil
    And Input name "<name>"
    And Input job "<job>"
    And Press edit Button
    Then The Person is edited with "<name>" and "<job>"
    Examples:
      | name     | job              |
      | John     | Director         |


    Scenario: remove a person
      Given I am on People with jobs page
      When Press cross icon
      Then Person is removed from list


    Scenario Outline: reset original list after adding a person
      Given I am on People with jobs page
      When Press edit Button Pencil
      And Input name "<name>"
      And Input job "<job>"
      And Press Add button
      And Press Reset List
      Then Original list of People left

      Examples:
        | name     | job              |
        | John     | Director         |


   Scenario Outline: reset original list after editing a person
     Given I am on People with jobs page
     When Press edit Button Pencil
     And Input name "<name>"
     And Input job "<job>"
     And Press edit Button
     Then The Person is edited with "<name>" and "<job>"
     And Press Reset List
     Then Original list of People left

     Examples:
       | name     | job              |
       | John     | Director         |


  Scenario: reset original list after removing a person
      Given I am on People with jobs page
      When Press cross icon
      And Person is removed from list
      And Press Reset List
      Then Original list of People left

