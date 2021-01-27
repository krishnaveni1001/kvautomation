Feature: Users can view a Pricing Tab that shows pricing details about a rate.

Background:
  Given a user is on the login page for the "qaauto" environment
  When the user logs in as "qaauto_super"
  And the user changes the View Toggle from Classic View to Compact View
  And the user performs a rate search for "MAAGA" to "AEAUH"
  Then the user is redirected to the rate search results page
  And 1 rate search results are shown in the compact view

@CompactViewPricingTab @CompactViewPricingTab1
Scenario: The Pricing Tab is shown by default when a user opens the Level 2 details
  When the user clicks the 20 ft container rate price on row 1 of the compact view
  Then the Level 2 details are shown for row 1 of the compact view
  And the Pricing tab is active in the Level 2 details for row 1 of the compact view

@CompactViewPricingTab @CompactViewPricingTab2
Scenario: Clicking the price a second time closes the Level 2 details for that row
  When the user clicks the 20 ft container rate price on row 1 of the compact view
  Then the Level 2 details are shown for row 1 of the compact view
  When the user clicks the 40 ft container rate price on row 1 of the compact view
  Then the Level 2 details are shown for row 1 of the compact view
  When the user clicks the 40 ft container rate price on row 1 of the compact view
  Then the Level 2 details are not shown for row 1 of the compact view

@CompactViewPricingTab @CompactViewPricingTab3
Scenario: The container name and price are shown in the Level 2 Details header
  When the user clicks the 20 ft container rate price on row 1 of the compact view
  Then the Level 2 detail header of row 1 says "Cntr. 20 ft: 455.00 USD"
  When the user clicks the 40 ft container rate price on row 1 of the compact view
  Then the Level 2 detail header of row 1 says "Cntr. 40 ft: 690.00 USD"

@CompactViewPricingTab @CompactViewPricingTab4
Scenario: The Pricing Tab shows the information as expected.
  When the user clicks the 20 ft container rate price on row 1 of the compact view
  Then the level2 details of row 1 pricing tab shows the following "base" surcharge text:
    | term | description | rate | priceBy | info | min | max | paymentType |
    |EBS | EMERGENCY BUNKER SURCHARGE ||Per Container|||||
    |PSS | Peak Season Surcharge ||Per Container|||||
    |BAF | BAF || Included|||||
    |DPA | Transport Arbitrary - Destination|| Included|||||
    |ERS | Emergency Risk Surcharge|| Included|||||
    |OPA | Origin Transport Arbitrary|| Included|||||
    |SBF | Standard Bunker Adjustment Factor|| Included|||||
  And the level2 details of row 1 pricing tab shows the following "base" Base Rate text:
    | term | description | rate | priceBy | info | min | max | paymentType |
    ||Base Rate| 455.00 USD| Per Container| Rate takes effect Rate changes or expires||||
  And the level2 details of row 1 pricing tab shows the following "base" header text:
    |MAAGA - Agadir, Morocco ( Port ) AEAUH - Abu Dhabi, United Arab Emirates ( Port )|
