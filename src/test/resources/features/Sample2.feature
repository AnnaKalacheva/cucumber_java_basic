Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Background:
    //it is easier like step before, you can write in each scenario at the beginning
    Given I am on age page

  Scenario: a new scenario 1 with regex
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  Scenario: My 2nd scenario
    Given  I open action page
    And I enter number: 5
    And I click Result
    Then I see Text: You entered number: "5"




