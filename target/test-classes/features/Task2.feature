Feature: individual task 2 create 1 scenario outline and create scenario or scenario outlines for page
  As a test engineer

  Background:
    Given I am on People with jobs page

  Scenario: add a new person
    When I click Add new person button
    And I see Enter a new person page
    And I enter a new name and job:
      | name | Valentina     |
      | job  | Test Engineer |
    And I click add button
    And I am redirected on People with jobs page
    Then new person is added

  Scenario: edit a person
    When I click Edit
    Then I see editing page
    And I editing name and job
      | name | Valentina     |
      | job  | Test Engineer |
    And I click Edit button
    Then I am redirected on People with jobs page
    And person is changed

  Scenario: remove a person
    When I click remove first person
    Then First person is removed

  Scenario: reset original list after adding a person
    When I click Add new person button
    And I see Enter a new person page
    And I enter a new name and job:
      | name | Valentina     |
      | job  | Test Engineer |
    And I click add button
    And I am redirected on People with jobs page
    Then new person is added
    And I click Reset list button
    Then I see original list size

  Scenario: reset original list after editing a person
    When I click Edit
    Then I see editing page
    And I editing name and job
      | name | Valentina     |
      | job  | Test Engineer |
    And I click Edit button
    Then I am redirected on People with jobs page
    And person is changed
    And I click Reset list button
    Then I see original list size

  Scenario: reset original list after removing a person
    When I click remove first person
    Then First person is removed
    And I click Reset list button
    Then I see original list size

  Scenario: check that clear button on adding a user works correctly
    When I click Add new person button
    And I see Enter a new person page
    And I enter a new name and job:
      | name | Valentina     |
      | job  | Test Engineer |
    And I click clear all fields button
    Then I see all fields are cleared