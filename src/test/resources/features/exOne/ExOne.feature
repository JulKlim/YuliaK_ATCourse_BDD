Feature: Exercise 1: Log rows for selected elements are displayed

  Scenario: Log rows are displayed for checkboxes, radio button and dropdown
    Given I open home page
    And The homepage title is correct
    When I perform login
    And The logged username is correct
    And I open different elements page
    And I select checkboxes Water and Wind
    And I select radio button Selen
    And I select Yellow color from dropdown
    Then The log rows for Water and Wind are displayed and its value corresponds to the checkbox status
    Then The log row for Selen is displayed and its value corresponds to the radio status
    Then The log row for Yellow color from dropdown is displayed  and its value corresponds to the dropdown status