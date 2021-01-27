Feature: Users can view a Contract Tab that shows contract and amendment info.

Background:
  Given a user is on the login page for the "qaauto" environment
  When the user logs in as "qaauto_super"
  And the user changes the View Toggle from Classic View to Compact View
  And the user performs a rate search for "MAAGA" to "AEAUH"
  Then the user is redirected to the rate search results page
  And 1 rate search results are shown in the compact view
  When the user clicks the 20 ft container rate price on row 1 of the compact view
  Then the Level 2 details are shown for row 1 of the compact view

@CompactViewCommoditiesTab @CompactViewCommoditiesTab1
Scenario: The commodities info section is shown when a user opens the Level 2 details and clicks the Commodities Tab.
  When the user clicks the tab header button "Commodities" in the level 2 details of row 1
  Then the Commodities tab is active in the Level 2 details for row 1 of the compact view

@CompactViewCommoditiesTab @CompactViewCommoditiesTab2
Scenario: The commodities tab lists the included commodities
  When the user clicks the tab header button "Commodities" in the level 2 details of row 1
  Then the Commodities tab of the level2 details of row 1 shows the following included commodities:
    |FAK|

@CompactViewCommoditiesTab @CompactViewCommoditiesTab3
Scenario: The commodities tab does not show the excluded commodities section if there are not any
  When the user clicks the tab header button "Commodities" in the level 2 details of row 1
  Then the Commodities tab of the level2 details of row 1 does not have any excluded commodities

@CompactViewCommoditiesTab @CompactViewCommoditiesTab4
Scenario: The commodities tab shows the commoditiy group name and type in the section header
  When the user clicks the tab header button "Commodities" in the level 2 details of row 1
  Then the Commodities tab of the level2 details of row 1 shows the following text for Commodity Group: "FAK(FAK,Unspecified)"


