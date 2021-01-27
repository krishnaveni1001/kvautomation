Feature: Users can view a Service Info Tab that shows service details about a rate.

Background:
  Given a user is on the login page for the "qaauto" environment
  When the user logs in as "qaauto_super"
  And the user changes the View Toggle from Classic View to Compact View
  And the user performs a rate search for "MAAGA" to "AEAUH"
  Then the user is redirected to the rate search results page
  And 1 rate search results are shown in the compact view
  When the user clicks the 20 ft container rate price on row 1 of the compact view
  Then the Level 2 details are shown for row 1 of the compact view

@CompactViewServiceInfoTab @CompactViewServiceInfoTab1
Scenario: The Service Info is shown when a user opens the Level 2 details and clicks the Service Info Tab.
  When the user clicks the tab header button "Service Info" in the level 2 details of row 1
  Then the Service Info tab is active in the Level 2 details for row 1 of the compact view

@CompactViewServiceInfoTab @CompactViewServiceInfoTab2
Scenario: The Service Info Tab shows the information as expected for the base to base leg of the trip.
  When the user clicks the tab header button "Service Info" in the level 2 details of row 1
  Then the Service Info tab of the level2 details of row 1 shows the "base" section
  And the Service Info tab of the level2 details of row 1 shows the following text in the "base" section:
    |header | itemNumber | serviceType | rateType | rateType2 | serviceString | vessel | transitTime | frequency | addOnAssignment |
    |MAAGA - Agadir, Morocco ( Port ) AEAUH - Abu Dhabi, United Arab Emirates ( Port )|11|- -|- -|- -|- -|- -|- -|- -|- -|

@CompactViewServiceInfoTab @CompactViewServiceInfoTab3
Scenario: The inland to base section does not appear if there is no data
  When the user clicks the tab header button "Service Info" in the level 2 details of row 1
  Then the Service Info tab of the level2 details of row 1 does not show the "inland" section

@CompactViewServiceInfoTab @CompactViewServiceInfoTab4
Scenario: The base to outland section does not appear if there is no data
  When the user clicks the tab header button "Service Info" in the level 2 details of row 1
  Then the Service Info tab of the level2 details of row 1 does not show the "outland" section

@CompactViewServiceInfoTab @CompactViewServiceInfoTab5
Scenario: The Maersk Spot section does not appear if there is no data
  When the user clicks the tab header button "Service Info" in the level 2 details of row 1
  Then the Service Info tab of the level2 details of row 1 does not show the "Maersk Spot" section
