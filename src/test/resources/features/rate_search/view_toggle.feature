Feature: The user is able to toggle between classic and compact views.

  Background:
    Given a user is on the login page for the "qaauto" environment
    When the user logs in as "qaauto_super"

  # CS-14777 AC 1.b
  @ViewToggle1
  Scenario: There is appropriate hover text for the rate search view switch
    When the user performs a classic view rate search for "MAAGA" to "AEAUH"
    Then the user is redirected to the rate search results page
    And the hover text of the classic view button says "Classic View"
    And the hover text of the compact view button says "Compact View"

  # CS-14777 AC 2, 2.a
  @ViewToggle2
  Scenario: Changing the toggle on the Start page and clicking Search returns the results in the selected format.
    Given the user is on the rate search Start page
    When the user changes the View Toggle from Classic View to Compact View
    And the user performs a rate search for "MAAGA" to "AEAUH"
    Then the rate search results are shown in Compact View
    And the View Toggle in the Results page is set to Compact View

  # CS-14777 AC 2, 2.a
  @ViewToggle3
  Scenario: Changing the toggle on the Start page and clicking Search returns the results in the selected format.
    Given the user is on the rate search Start page
    When the user changes the View Toggle from Compact View to Classic View
    And the user performs a rate search for "MAAGA" to "AEAUH"
    Then the rate search results are shown in Classic View
    And the View Toggle in the Results page is set to Classic View

  # CS-14777
  @ViewToggle4
  Scenario: There is a functional View Toggle on the Results page
    Given the user is on the rate search Start page
    When the user changes the View Toggle from Classic View to Compact View
    And the user performs a rate search for "MAAGA" to "AEAUH"
    And the user changes the results View Toggle from Compact View to Classic View
    Then the rate search results are shown in Classic View
    When the user changes the results View Toggle from Classic View to Compact View
    Then the rate search results are shown in Compact View
