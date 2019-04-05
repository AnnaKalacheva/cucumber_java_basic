Feature: Task 1 - test execution

  Background:
    Given I am on people with jobs page

    Scenario Outline: Add a new person complete process
      When I click on add new person button
      And I enter persons values:
        |name|<name>|
        |job |<job>|
      And I click on Add
      Then I see new person in list
      |name|<nameinlist>|
      |job |<jobinlist>|

      Examples:
        |name|job|nameinlist|jobinlist|
      |Ann |programmer|Ann|programmer|
      |John|          |John|         |
      |    |programmer|    |programmer|
      |    |          |    |          |



  Scenario: Edit a person
    When I click on edit person button
    And I change persons values
      |name|John|
      |job |developer|
    And click on Edit button
    Then I see edited values in list
      |name|John|
      |job |developer|



    Scenario: Remove particular person from list
      When I click on Remove button for person with index:  1
      Then I see that the person is removed



    Scenario: Reset list after adding person
      When I click on add new person button
      And I enter persons values:
        |name|Ann|
        |job |analyst|
      And I click on Add
      And I see new person in list
        |name|Ann|
        |job |analyst|
      And I click on Reset button
      Then I see original list


  Scenario: Reset list after editing a person
    When I click on edit person button
    And I change persons values
      |name|John|
      |job |developer|
    And click on Edit button
    Then I see edited values in list
      |name|John|
      |job |developer|
    And I click on Reset button
    Then I see original list



  Scenario: Reset list after removing a person
    When I click on Remove button for person with index:  1
    And I see that person is removed from the list
    And I click on Reset button
    Then I see original list



    Scenario: clear button on add person page
      When I click on add new person button
      And I enter persons values:
        |name|<name>|
        |job |<job>|
      And I click on Clear All
      Then I see no text in input fields



