Feature: Individual Task2 scenario

  Background:
    Given I am on enter a people with job page

  @AddNewPerson
  Scenario Outline: Individual Task2 Addnew Person
    When I click on add new person
    Then I see add new person page
    And  I enter people name: "<names>"
    And  I enter people job: "<jobs>"
    And  I click add button

    Examples:
      | names |  | jobs            |
      | Muthu |  | Test Automation |

  @EditPerson
  Scenario Outline: Individual Task2 Edit a person
    When I click on edit person
    Then I see edit person page
    And  I enter people name: "<names>"
    And  I enter people job: "<jobs>"
    And  I click on edit button
    Then I see edited names and job: "<names>" "<jobs>"

    Examples:
      | names   |  | jobs      |
      | Anandan |  | Developer |

  @RemovePerson
  Scenario: Individual Task2 remove a person
    When I click on delete person
    Then I see person is removed from list


  @ResetOriginalList
  Scenario Outline: Individual Task2 Reset Original List
    When I click on add new person
    Then I see add new person page
    And  I enter people name: "<names>"
    And  I enter people job: "<jobs>"
    And  I click add button
    When I click on edit person
    Then I see edit person page
    And  I edit people name: "<names>"
    And  I edit people job: "<jobs>"
    And  I click on edit button
    Then I see edited names and job: "<names>" "<jobs>"
    When I click on delete person
    Then I see person is removed from list after added
    And  I click on reset list
    Then I see list names and job title reset: "<defaultnames>" "<defaultjobs>"



    Examples:
      | names |  | jobs            |  | defaultnames |  | defaultjobs  |
      | Muthu |  | Test Automation |  | Mike         |  | Web Designer |


  @ClearButtonAddingPage
  Scenario Outline: Individual Task2 Clear Button On Adding Page
    When I click on add new person
    Then I see add new person page
    And  I enter people name: "<names>"
    And  I enter people job: "<jobs>"
    Then I click on clear all fields

    Examples:
      | names |  | jobs            |
      | Muthu |  | Test Automation |

