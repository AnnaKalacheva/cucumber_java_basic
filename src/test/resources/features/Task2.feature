Feature: List of persons using PO

  Background:
    Given I am on ListPage

  Scenario Outline: add a new person scenario
    When I click Add person button
    And I enter user data: "<name>" "<surname>"
    And I enter date of birth: "<dateOfBirth>"
    And I enter user gender: "<gender>"
    And I enter user information: "<jobTitle>" "<status>"
    And I enter languages: "<languages>"
    Then I click Add button
    Then I check if person added

    Examples:
      | name | surname | jobTitle | dateOfBirth | languages              | gender | status   |
      | Kate | Hudson  | Designer | 10/11/1984  | English,French,Spanish | female | Intern   |
      | Jack | Jackson | Director | 07/25/1978  | English,Spanish        | male   | Employee |


  Scenario: edit a person scenario
    When I click edit person button
    And I enter user data: "Jane" "Larsson"
    And I enter date of birth: "11/11/1990"
    And I enter user gender: "Female"
    And I enter user information: "Secretary" "Employee"
    And I enter languages: "French"
    Then I click Edit button
    Then I check person name changed to: "Jane" "Larsson"


  Scenario: remove a person scenario
    And I click remove person button
    Then I check if person removed


  Scenario: reset after adding person
    When I click Add person button
    And I enter user data: "Paul" "Jansons"
    And I enter date of birth: "10/26/1989"
    And I enter user gender: "male"
    And I enter user information: "Trainer" "Contractor"
    And I enter languages: "Spanish"
    And I click Add button
    And I check if person added
    Then I click reset button
    Then I check if person removed


  Scenario: reset after editing person
    When I click edit person button
    And I enter user data: "Lee" "Doe"
    And I enter date of birth: "10/26/1989"
    And I enter user gender: "male"
    And I enter user information: "Developer" "Employee"
    And I enter languages: "English,Spanish"
    And I click Edit button
    And I check person name changed to: "Lee" "Doe"
    Then I click reset button
    Then I check person "Lee" "Doe" removed


  Scenario: reset after removing person
    When I click remove person button
    And I check if person removed
    Then I click reset button


  Scenario: clear button on adding person
    When I click Add person button
    And I enter user data: "Ludwig" "Fourteenth"
    And I enter date of birth: "11/27/1985"
    And I enter user gender: "male"
    And I enter user information: "Junior tester" "Intern"
    And I enter languages: "English"
    And I click clear fields button
    Then I check fields cleared

