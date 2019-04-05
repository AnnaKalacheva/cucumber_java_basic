Feature: Task 2

  Background:
  Given I am on People with Jobs page
  @test
  Scenario: a new scenario add a new person using PO
    When I click Add person button
    And I enter Name "Test"
    And I enter Job Title: "Tester"
    Then I click Add button
    Then I am on People with Jobs page and I see new line in list of people is added
  @test
  Scenario: a new scenario edit a person using PO
    When I click Edit button
    And I enter Name "Test2"
    And I enter Job Title: "Tester2"
    Then I click Add button
    Then I am on People with Jobs page I see person info is edited
  @test
  Scenario: a new scenario remove a person using PO
    When I click delete Person button
    Then I see person is removed
  @test
  Scenario: a new scenario reset original list using PO
    When I click Add person button
    And I enter Name "Test"
    And I enter Job Title: "Tester"
    Then I click Add button
    Then I am on People with Jobs page and I see new line in list of people is added
    Then I click Reset button and I see original list
    And I click Edit button
    And I enter Name "Test2"
    And I enter Job Title: "Tester2"
    Then I click Add button
    Then I am on People with Jobs page I see person info is edited
    Then I click Reset button and I see original list
    When I click delete Person button
    Then I see person is removed
    Then I click Reset button and I see original list
  @test
  Scenario: a new scenario clear button on adding a user works correctly using PO
    When I click Add person button
    And I enter Name "Test"
    And I enter Job Title: "Tester"
    Then I click Clear all button and I see all lines are empty


