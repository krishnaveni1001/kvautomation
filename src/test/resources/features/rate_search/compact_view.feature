Feature: Rate search

  Background:
    Given test data has been loaded for "compact_view_filters"
    And a user is on the login page for the "qaauto" environment
    When the user logs in as "qaauto_super"

 # Check for correct initial state of columns for this user / rate
  @CompactViewColumnOrder1 @CompactViewColumnOrder @CompactView
  Scenario: Check initial rate search grid column order is in the default order
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    Then the grid column order is "Carrier, Origin, Destination, Owner, Expiration, Cntr. 20 ft, Cntr. 40 ft, Cntr. 40 ft HC, BOL, Commodity Group, Commodity Group Type, Named Account, Origin Routing, Destination Routing, Rate Type, Rate Type 2, Service String, Service Type, Contract Number"

 # The "Owner" column is moved again after saving the order in this test to ensure
 # the column order is actually changing back from an altered order after clicking search
  @CompactViewColumnOrder2 @CompactViewColumnOrder @CompactView
  Scenario: Check rate search grid column order preference saves and is honored
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user moves the "Owner" column to position 0
    And the user saves the column order preference
    And the user moves the "Owner" column to position 4
    And the user clicks search on the results page
    Then the grid column order is "Owner, Carrier, Origin, Destination, Expiration, Cntr. 20 ft, Cntr. 40 ft, Cntr. 40 ft HC, BOL, Commodity Group, Commodity Group Type, Named Account, Origin Routing, Destination Routing, Rate Type, Rate Type 2, Service String, Service Type, Contract Number"

  @CompactViewColumnOrder3 @CompactViewColumnOrder @CompactView
  Scenario: Check that resetting the compact view grid order preference works
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user moves the "Owner" column to position 0
    And the user resets the column order preference
    Then the grid column order is "Carrier, Origin, Destination, Owner, Expiration, Cntr. 20 ft, Cntr. 40 ft, Cntr. 40 ft HC, BOL, Commodity Group, Commodity Group Type, Named Account, Origin Routing, Destination Routing, Rate Type, Rate Type 2, Service String, Service Type, Contract Number"

  @CompactViewDropdown1 @CompactViewDropdown @CompactView
  Scenario: Check that the clearing the filter through the drop down menu button works
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the service providers filter popup
    And the user applies the service providers filter for "EVERGREEN LINE"
    And the user clears their filters through the dropdown
    Then there are no filters applied

  @CompactViewDropdown2 @CompactViewDropdown @CompactView
  Scenario: Check that the hide filters button in the drop down menu works
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user toggles the filter visibility through the dropdown
    Then the filters are hidden

  @CompactViewDropdown3 @CompactViewDropdown @CompactView
  Scenario: The hide filters button in the drop down menu changes to show filters once they are hidden
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user toggles the filter visibility through the dropdown
    Then the toggle filter visibility button's text is now "Show filters"
    And the user toggles the filter visibility through the dropdown
    And the filters are visible
    
   @logosAssertion 
   Scenario: The hide filters button in the drop down menu changes to show filters once they are hidden
    When the user performs a compact view rate search for "MAAGA" to "AEAUH" 
    And the user resets the column order preference
  	Then the user should see the Carrier logo 
  	And the user moves the "Owner" column to position 0
  	Then the user should see Owner logo
    
