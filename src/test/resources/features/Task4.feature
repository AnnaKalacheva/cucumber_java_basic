#The task for today: https://kristinek.github.io/site/tasks/provide_feedback
#1) Enter all options and send feedback (check that next page contains correct options which you have chosed)
#2) Check that you can send feedback without entering fields (next page will contain empty value or NULL)
#3) Check NO button and when you click NO button and check that all values have not disappeared
#4) Check YES button with entered name and without name (final page has to contain correct message)

Feature: Task one
  As a test engineer
  I want to be able to write and execute a scenario outline

  Scenario Outline: Enter all options and send feedback
    Given I am on the Give us your feedback page
    When I enter name field : "<name>"
    Then I enter age field : "<age>"
    Then I select Language: "<language>"
    Then I select Genre: "<genre>"
    Then I choose my opinion : "<how do you like us>"
    Then I write some comment: "<comment>"
    Then I click send button
    Then I can check the message "Is this the feedback you want to give us?"
    Then I can see correct options which i filled: "<name>", "<age>", "<language>", "<genre>", "<how do you like us>", "<comment>"


    Examples:
      | name    | age | language | genre  | how do you like us | comment |
      | Rosa    | 36  | English  | female | Why me?            |         |
      | Michael | 21  | Spanish  | male   | Good               | ahaha   |

  Scenario: Check that you can send feedback without entering fields
    Given I am on the Give us your feedback page
    Then I click send button
    Then I can check the message "Is this the feedback you want to give us?"
    Then I can see correct options which i filled: "", "", "", "null", "null", ""

  Scenario: Check NO button
    Given I am on the Give us your feedback page
    When I enter name field : "Rosa"
    Then I enter age field : "36"
    Then I select Language: "Spanish"
    Then I select Genre: "female"
    Then I choose my opinion : "Good"
    Then I write some comment: "qwerty"
    Then I click send button
    Then I click no button
    Then I can see what i entered previously: "Rosa", "36", "Spanish", "female", "Good", "qwerty"

  Scenario Outline: Check YES button with entered name and without name
    Given I am on the Give us your feedback page
    When I enter name field : "<name>"
    Then I click send button
    Then I click yes button
    Then I can see message with correct name: "<final message>"


    Examples:
      | name | final message                       |
      | Rosa | Thank you, Rosa, for your feedback! |
      |      | Thank you for your feedback!        |
