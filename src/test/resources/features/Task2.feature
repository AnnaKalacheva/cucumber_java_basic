Feature: Task2
  As a test engineer

  Background:
    Given Entering People with jobs

  Scenario Outline: a new scenario add new person
    When add new person
    And enter fields info "<name>""<surname>"
    And enter fields "<job>""<date>"
    And enter fields "<language>""<gender>""<employee>"
    And add person
    Then check that person was add
    Examples:
      | name | surname | job | date       | language               | gender | employee |
      | Name | Surname | Job | 01/01/2000 | English,French,Spanish | Female | Employee |


  Scenario Outline: a new scenario edit person
    When edit person
    And enter fields info "<name>""<surname>"
    And enter fields "<job>""<date>"
    And enter fields "<language>""<gender>""<employee>"

    Then add edited person
    Examples:
      | name | surname | job | date       | language | gender | employee   |
      | Name | Surname | Job | 01/01/2000 | French   | Female | contractor |

  Scenario: a new scenario delete person
    When delete person
    Then check that person was delete


  Scenario Outline: a new scenario add new person and reset list
    When add new person
    And enter fields info "<name>""<surname>"
    And enter fields "<job>""<date>"
    And enter fields "<language>""<gender>""<employee>"
    And add person
    Then reset list
    Examples:
      | name | surname | job | date | language | gender | employee |
      | Name | Surname | Job | Date | French   | Male   | Employee |

  Scenario Outline: a new scenario edit person and reset list
    When edit person
    And enter fields info "<name>""<surname>"
    And enter fields "<job>""<date>"
    And enter fields "<language>""<gender>""<employee>"
    And add edited person
    Then reset list
    Examples:
      | name | surname | job | date       | language | gender | employee |
      | Name | Surname | Job | 01/01/2000 | French   | Female | Employee |

  Scenario: a new scenario delete person and reset list
    When delete person
    Then reset list

  Scenario Outline: a new scenario add new person and clear all field
    When add new person
    And enter fields info "<name>""<surname>"
    And enter fields "<job>""<date>"
    And enter fields "<language>""<gender>""<employee>"
    And clear fields
    Then check empty fields
    Examples:
      | name | surname | job | date       | language | gender | employee |
      | Name | Surname | Job | 01/01/2000 | French   | Female | Employee |