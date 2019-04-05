Feature: First Individual task in cucumber

  Background:
    Given I am on number page


    @negative1
  Scenario Outline: a negative scenario outline1
  When I enter  number: "<number>"
  And I click submit button
  Then I see message:"<message>"

   @negativeExemple1
    Examples:
      | number | message              |
      | 1      | Number is too small  |

  @negative2
    Scenario Outline: a negative scenario outline2
    When I enter  number: "<number>"
    And I click submit button
    Then I see message:"<message>"

  @negativeExemple2
    Examples:
      | number | message                   |
      | abc     | Please enter a number    |

  @negative3
  Scenario Outline: a negative scenario outline3
    When I enter  number: "<number>"
    And I click submit button
    Then I see message:"<message>"

  @negativeExemple3
    Examples:
      | number | message                  |
      | 101    | Number is too big    |


  @positivescenario
Scenario Outline: a positive scenario
    When I enter  number: "<number>"
    And I click submit button
    Then I see alert:"<alert>"

    Examples:
      | number | alert                        |
      | 56     | Square root of 56 is 7.48    |