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

@CompactViewContractTab @CompactViewContractTab1
Scenario: The contract info is shown when a user opens the Level 2 details and clicks the Contract Tab.
  When the user clicks the tab header button "Contract" in the level 2 details of row 1
  Then the Contract tab is active in the Level 2 details for row 1 of the compact view

@CompactViewContractTab @CompactViewContractTab2
Scenario: The contract tab shows the contract number for the rate that was selected
  When the user clicks the tab header button "Contract" in the level 2 details of row 1
  Then the Contract tab of the level2 details of row 1 shows the contract number "7910172_E4E_FAK"

@CompactViewContractTab @CompactViewContractTab3
Scenario: The contract tab shows the correct carrier and trade lane
  When the user clicks the tab header button "Contract" in the level 2 details of row 1
  Then the Contract tab of the level2 details of row 1 shows the following text in the info section:
    |carrier|contractScope|tradeLane|internalOwners|externalOwners|
    |MAEU eSUDS|- -|E4E|- -|- -|

@CompactViewContractTab @CompactViewContractTab4
Scenario: The contract tab shows the correct amendment info
  When the user clicks the tab header button "Contract" in the level 2 details of row 1
  Then the Contract tab of the level2 details of row 1 shows the following amendment information:
    |number|administrator|receivedDate|notes|
    |63-14Aug2019(Initial Load)|MAEU-SFTP|27-Mar-2020||
