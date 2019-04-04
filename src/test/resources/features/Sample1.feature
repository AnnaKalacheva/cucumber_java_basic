Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

@testA
  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And I should see menu
    And I should see some text

@test8
    Scenario: My scenario
    When I open styles page
    Then correct header is seen


@testA   @test8
Scenario: the new one
      Given  I open action page
      And I enter number 5 in number field
      And I click Result
      Then I see text: "You entered number: "5""



