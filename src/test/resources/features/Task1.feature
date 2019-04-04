Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  @wowNumbersAreTooSmall
Scenario Outline:  error cases (too small numbers)
    When I open Enter a number page
    And I enter a number <numbera>
    And Press submit button
    Then Error message is shown: <message>


  @tooSmallNumbers
    Examples:
      | numbera  | message            |
      | -50      |Number is too small |
      | 1        |Number is too small |
      | 49       |Number is too small |
      | 48       |Number is too small |

@tooBigNumbers
     Examples:
        | numbera  | message           |
        | 170      |Number is too big  |
        | 999      |Number is too big  |
        | 101      |Number is too big  |
        | 909090   |Number is too big  |


@notEvenNumbers
    Examples:
      | numbera  | message              |
      | 17a      |Please enter a number |
      | cake     |Please enter a number |
      | @        |Please enter a number |
      | 1 1      |Please enter a number |


@successfulTest
Scenario Outline:
  When I open Enter a number page
  And I enter a number <numbera>
  Then A message is shown: "Square root of <numbera> is <messageSuccessful>"



   @successfulNumbers
   Examples:
   | numbera  | messageSuccessful         |
   | 64       |8.00                       |


