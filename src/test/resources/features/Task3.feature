#Write tests for the page https://kristinek.github.io/site/examples/age.html
#1) Check that the field name is required (check that an error message is correct)
#2) Check that the field age is required (check that an error message is correct)
#3) Check the final page after entering a correct name and a correct age (Check that text on the final page is correct, and the title of the final page is correct)
#4) Check that the button “back” on the final page works correctly

Feature: Introduction to Test 3
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  Scenario: Check that the field name is required
    Given I am on the age page
    When I enter age: "34"
    Then I click on the submit button
    Then I can see the message "You haven't entered anything in name field"

  Scenario: Check that the field age is required
    Given I am on the age page
    When I fill the name field: "Eld"
    Then I click on the submit button
    Then I can see the message "You haven't entered anything in age field"

  Scenario: Check the final page after entering a correct name and a correct age
    Given I am on the age page
    When I enter age: "34"
    And I fill the name field: "Eld"
    Then I click on the submit button
    Then I can see message "Hello, Eld, you are an adult"

  Scenario: Check that the button “back” on the final page works correctly
    Given I am on the age page
    When I enter age: "34"
    And I fill the name field: "Eld"
    Then I click on the submit button
    Then I click on the back button
    Then I returned to the age page

  Scenario: Check that you cannot enter a literal value in the age field
    Given I am on the age page
    When I fill the name field: "Sara"
    Then I enter age: "Sara"
    Then I click on the submit button
    Then I can see the message "You haven't entered anything in age field"










