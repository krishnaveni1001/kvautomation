Feature: Compact view filters

  Background:
    Given test data has been loaded for "compact_view_filters"
    When a user is on the login page for the "qaauto" environment
    And the user logs in as "qaauto_super"
    And the user changes the View Toggle from Classic View to Compact View

  @CompactViewContractFilterPopup1 @CompactViewFilterPopups @CompactView
    Scenario: The contract filter popup search bar contains the contracts in the rate search results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the contracts filter popup
    Then the contract filter available contract names are
      | Test Contract 3 | Test Contract 1 | Test Contract 2 |
    And the contract filter available carriers names are
      | ANL Container Line Pty Ltd. | EVERGREEN LINE | MAERSK LINE|
    And the contract filter available source systems are
      | QAAUTO | QAAUTO | QAAUTO |

  @CompactViewContractFilterPopup2 @CompactViewFilterPopups @CompactView
    Scenario: Applying a filter in the contract filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the contracts filter popup
    And the user applies the contract filter for "Test Contract 1"
    Then the contracts present in the grid view result are
    | Test Contract 1 |

  @CompactViewContractFilterPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Clearing the filters in the contracts filter popup clears the contract filters
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the contracts filter popup
    And the user applies the contract filter for "Test Contract 1"
    And the user clears the contract filters through the popup
    Then there are no filters applied

  @CompactViewServiceProvidersFilterPopup1 @CompactViewFilterPopups @CompactView
  Scenario: The service providers filter popup search bar contains the carriers in the rate search results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the service providers filter popup
    Then the available service provider filter carrier names are
      | ANLC | EGLV | MAEU |
    And the available service provider filter source system names are
      | ANL Container Line Pty Ltd. | EVERGREEN LINE | MAERSK LINE |

  @CompactViewServiceProvidersFilterPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Applying a filter in the service providers filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the service providers filter popup
    And the user applies the service providers filter for "EVERGREEN LINE"
    Then the service providers present in the grid view result are
      | EVERGREEN LINE |

  @CompactViewServiceProvidersFilterPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Clearing the filters in the service provider filter popup clears the filters
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the service providers filter popup
    And the user applies the service providers filter for "EVERGREEN LINE"
    And the user clears the service providers filters through the popup
    Then there are no filters applied

  @CompactViewCommGroupFilterPopup1 @CompactViewFilterPopups @CompactView
  Scenario: The commodity group filter popup search bar contains the commodity groups in the rate search results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the commodity groups filter popup
    Then the available commodity groups are
      | FAK Commodity Groups | Archery Equipment | Bicycle Equipment | Ski Equipment |

  @CompactViewCommGroupFilterPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Applying a filter in the commodity groups filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the commodity groups filter popup
    And the user applies the commodity group filter for "Ski Equipment"
    Then the commodity groups present in the grid view result are
      | Ski Equipment |

  # Need to add test for Industry Commodity group once relevant data is loaded

  @CompactViewCommGroupFilterPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Clearing the filters in the commodity groups filter popup clears the filters
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the commodity groups filter popup
    And the user applies the commodity group filter for "Ski Equipment"
    And the user clears the commodity group filters through the popup
    Then there are no filters applied

  @CompactViewCommoditiesFilterPopup1 @CompactViewFilterPopups @CompactView
  Scenario: The commodities filter popup search bar contains the commodities in the rate search results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the commodities filter popup
    Then the available commodities are
      | Archery targets | BICYCLE FRAMES | BICYCLE HELMETS | Bow and Arrow | Ski Boots| SKI POLES |

  @CompactViewCommoditiesFilterPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Applying a filter in the commodities filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the commodities filter popup
    And the user applies the commodities filter for "Archery targets"
    Then all grid view results have the commodities
      | Archery targets |

  @CompactViewCommoditiesFilterPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Clearing the filters in the commodities filter popup clears the filters
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the commodities filter popup
    And the user applies the commodities filter for "Archery targets"
    And the user clears the commodities filters through the popup
    Then there are no filters applied

  @CompactViewNamedAccountsFilterPopup1 @CompactViewFilterPopups @CompactView
  Scenario: The named accounts filter popup search bar contains the named accounts in the rate search results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the named accounts filter popup
    Then the available named accounts are
      | Exclude NA Rates | Test Named Account 1 | Test Named Account 2 |

  @CompactViewNamedAccountsFilterPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Applying a filter in the named accounts filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the named accounts filter popup
    And the user applies the named account filter for "Test Named Account 1"
    Then the named accounts present in the grid view result are
      | Test Named Account 1 | Test Named Account 2 |
    And the named account groups present in the grid view result are
      | Test Named Account Group 1 |

  @CompactViewNamedAccountsFilterPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Applying the Exclude NA Rates filter removes rates with named accounts from the compact view results
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user opens the named accounts filter popup
    And the user applies the named account filter for "Exclude NA Rates"
    Then there are no rates with named accounts in the results

  @CompactViewLocationsFilterPopup1 @CompactViewFilterPopups @CompactView
  Scenario: The locations in the locations filter popup match the locations in the rate search results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the locations filter popup
    Then the available origin filters are
      | Charleston, U.S.A. | Jacksonville, U.S.A. |
    And the available destination filters are
      | Antwerp, Belgium | Zeebrugge, Belgium |

  @CompactViewLocationsFilterPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Applying an origin filter in the locations filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the locations filter popup
    And the user applies the origin filter for "Charleston, U.S.A."
    Then the origins present in the grid view result are
      | USCHS - Charleston, SC, U.S.A. [Port] |

  @CompactViewLocationsFilterPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Applying a destination filter in the locations filter popup filters the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the locations filter popup
    And the user applies the destination filter for "Antwerp, Belgium"
    Then the destinations present in the grid view result are
      | BEANR - Antwerp, Belgium [Port]|

  @CompactViewLocationsFilterPopup4 @CompactViewFilterPopups @CompactView
  Scenario: Clearing the location filters through the location filter popup resets the filters
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the locations filter popup
    And the user applies the destination filter for "Antwerp, Belgium"
    And the user clears the location filters through the popup
    Then there are no filters applied

  @CompactViewRoutingsFiltersPopup1 @CompactViewFilterPopups @CompactView
  Scenario: The routings filter popup contains the routings available in the compact view search results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the routings filters popup
    Then the available origin routings filters are
      | Panama City, U.S.A. | No Routing |
    And the available destination routings filters are
      | London, United Kingdom | No Routing |

  @CompactViewRoutingsFiltersPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on origin routing filters the origin routings in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the routings filters popup
    And the user applies the routing filters for origin "Panama City" and destination "London"
    Then all rates in the results have routing for origin "Panama City" and destination "London Seaport"

  @CompactViewMoreFiltersPopup1 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on container type filters the container type in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the 40 ft HC container filter
    And the user applies the More Filters filters
    Then all rates in the results have prices for container type "Cntr. 40 ft HC"

  @CompactViewMoreFiltersPopup2 @CompactViewFilterPopups @CompactView
  Scenario: Clearing the "More Filters" filters through the More Filters popup resets the filters
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the 20 ft container filter
    And the user applies the More Filters filters
    And the user clears the filters through the more filters popup
    Then there are no filters applied

  @CompactViewMoreFiltersPopup3 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on Rate Type filters the Rate Types in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the the Rate Type filter for "Test Rate Type 2"
    And the user applies the More Filters filters
    Then all rates in the results have rate type "Test Rate Type 2"

  @CompactViewMoreFiltersPopup4 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on Rate Type Twos filters the Rate Type Twos in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the the Rate Type Two filter for "Test Rate Type Two 1"
    And the user applies the More Filters filters
    Then all rates in the results have rate type two "Test Rate Type Two 1"

  @CompactViewMoreFiltersPopup5 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on Service String filters the Service Strings in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the the Service String filter for "Test Service String 1"
    And the user applies the More Filters filters
    Then all rates in the results have service string "Test Service String 1"

  @CompactViewMoreFiltersPopup6 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on Service Type filters the Service Types in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the the Service Type filter for "Break Bulk"
    And the user applies the More Filters filters
    Then all rates in the results have service type "Break Bulk"

  @CompactViewMoreFiltersPopup7 @CompactViewFilterPopups @CompactView
  Scenario: Filtering on Vessel filters the Vessels in the compact view results
    When the user performs a compact view rate search for "USCHS, USJAX" to "BEANR, BEZEE"
    And the user opens the more filters popup
    And the user selects the the Vessel filter for "Test Vessel 1"
    And the user applies the More Filters filters
    Then all rates in the results have vessel "Test Vessel 1"
