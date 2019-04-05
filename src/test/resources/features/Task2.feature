Feature: Task 2

  Background:
  Given I am on People with Jobs page

  Scenario: a new scenario add a new person using PO
    When I click Add person button
    And I enter Name "Test"
    And I enter Job Title: "Tester"
    Then I click Add button
    Then I am on People with Jobs page and I see new line in list of people is added

  Scenario: a new scenario edit a person using PO
    When I click Edit button
    And I enter Name "Test2"
    And I enter Job Title: "Tester2"
    Then I click Add button
    Then I am on People with Jobs page I see person info is edited

