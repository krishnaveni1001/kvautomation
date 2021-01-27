Feature: Compact view LCL pieces, dimensions and weight

  Background:
    Given test data has been loaded for "compact_view_lcl"
    When a user is on the login page for the "qaauto" environment
    And the user logs in as "qaauto_super"
    And the user changes the View Toggle from Classic View to Compact View
    And the user changes the rate type to LCL Buy

  @CompactViewLCL1 @CompactViewLCL @CompactView
  Scenario: Shipment info is hidden when LCL Rate is selected
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to LCL Rate
    Then the shipment info field is hidden

  @CompactViewLCL2 @CompactViewLCL @CompactView
  Scenario: Shipment info is visible and empty when Shipment Total is selected with no info loaded
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    Then the shipment info field is visible
    And the shipment info popup is empty

  @CompactViewLCL3 @CompactViewLCL @CompactView
  Scenario: The user cancels the shipping info popup and the LCL toggle switches to LCL Rate
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Inch(es)  |20    |24   |16    |            |Cubic Feet  |100        |            | Lbs       |
    And the user clicks cancel on the shipment info popup
    Then the LCL toggle is set to LCL Rate

  @CompactViewLCL4 @CompactViewLCL @CompactView
  Scenario: Shipment info is visible and populated when shipment info saved
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Inch(es)  |20    |24   |16    |            |Cubic Feet  |100        |            | Lbs       |
    And the user saves the shipment info
    Then the shipment info for row 0 is
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Inch(es)  |20.00 |24.00|16.00 |            |Cubic Feet  |100.00     |            | Lbs       |

  @CompactViewLCL5 @CompactViewLCL @CompactView
  Scenario: Shipment info is popup is empty after clearing shipment info
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Inch(es)  |20    |24   |16    |            |Cubic Feet  |100        |            | Lbs       |
    And the user saves the shipment info
    And the user clears the shipment info
    Then the shipment info popup is empty

  @CompactViewLCL6 @CompactViewLCL @CompactView
  Scenario: The total volume (inches) and total weight values (lbs) are correct in the shipping info popup
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Inch(es)  |20    |24   |16    |            |Cubic Feet  |100        |            | Lbs       |
    Then the total volume is "1.26 CBM / 44.44 CBFT"
    And the total weight is "453.60 KGS / 1,000.00 LBS"

  @CompactViewLCL7 @CompactViewLCL @CompactView
  Scenario: The total volume (feet) and total weight values (lbs) are correct in the shipping info popup
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Foot/feet |2     |1.5  |2     |            |Cubic Feet  |100        |            | Lbs       |
    Then the total volume is "1.70 CBM / 60.00 CBFT"
    And the total weight is "453.60 KGS / 1,000.00 LBS"

  @CompactViewLCL8 @CompactViewLCL @CompactView
  Scenario: The total volume (cms) and total weight values (kgs) are correct in the shipping info popup
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Cm(s)     |50    |25   |50    |            |Cubic Meters|100        |            | Kgs       |
    Then the total volume is "0.63 CBM / 22.25 CBFT"
    And the total weight is "1,000.00 KGS / 2,204.62 LBS"

  @CompactViewLCL9 @CompactViewLCL @CompactView
  Scenario: The total volume (meters) and total weight values (kgs) are correct in the shipping info popup
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Meter(s)  |.5    |.5   |.5    |            |Cubic Meters|100        |            | Kgs       |
    Then the total volume is "1.25 CBM / 44.14 CBFT"
    And the total weight is "1,000.00 KGS / 2,204.62 LBS"

  @CompactViewLCL10 @CompactViewLCL @CompactView
  Scenario: The shipment info will not save if the unit weight field is missing
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Meter(s)  |.5    |.5   |.5    |            |Cubic Meters|           |            | Kgs       |
    And the user saves the shipment info
    Then the shipment info missing weight error message is visible

  @CompactViewLCL11 @CompactViewLCL @CompactView
  Scenario: The mismatched unit error will be displayed if the dimension type and measurement are mismatched
    When the user performs a compact view rate search for "USCHS" to "BEANR"
    And the user sets the LCL Toggle to Shipment Total
    And the user clears the shipment info
    And the user enters the shipment info for row 0
      |Quantity|Piece Type|Dimen Type|Length|Width|Height|Total Volume|Measure Type|Unit Weight|Total Weight|Weight Type|
      |10      | Box(es)  |Foot/feet |.5    |.5   |.5    |            |Cubic Meters|100        |            | Kgs       |
    Then the shipment info mismatched units error message is visible