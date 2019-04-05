Feature: task2

  @Person
  Scenario Outline: addNewPerson
    Given I am on pageObject
    When I click on addPersonButton
    And I enter name: <name>
    And I enter job: <job>
    And I click addButton
    Then I see theResult: <name>, <job>

    Examples:
    |name |      job       |
    |Smith|AutomotionTester|
    |Tim  |DevOP           |

    Scenario Outline: Edit a person
      Given I am on pageObject
      When I click edit button
      And I change name and job: <name>, <job>
      And I click on edit button again
      Then I see first person with name and job: <name>, <job>

      Examples:
      |name |     job    |
      |Chris|  SDET      |

  Scenario Outline: Deleting a person
    Given I am on pageObject
    When I click on deleting person button
    Then I do not see deleted person: <person>

    Examples:
      | person  |
      | person0 |

    Scenario Outline: Clear Button
      Given I am on pageObject
      When I click on addPersonButton
      And I enter name: <name>
      And I enter job: <job>
      And I click clear all fields button
      Then I see empty fields

      Examples:
        |name |      job       |
        |Smith|AutomotionTester|



