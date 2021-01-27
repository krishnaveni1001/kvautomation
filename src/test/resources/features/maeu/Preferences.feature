Feature: Preference

  @Preferences1
  Scenario: Customer search with origin and destination with default values
	Given that user "qaauto_super" is logged into "qaauto" environment
    And user clicks on navigation menu
    And user clicks on "Activity Menu"
    And user clicks on Account info link
    And user clicks on Application settings link
    Then the user should land on the Preference page
    