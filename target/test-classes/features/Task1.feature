Feature: Task 1


  Background:
    Given I am on number page

    Scenario: scenario with correct number
      When I enter a number: 81
      And I click on Submit
      Then I see result message: Square root of 81 is 9.00
      Then I click OK on result message

    Scenario Outline: scenario with invalid input
      When I enter a number: <input>
      And I click on Submit
      Then I see error message: <message>

      Examples:
        | input | message |
        |abc    |Please enter a number|
        |12     |Number is too small  |
        |101    |Number is too big    |
