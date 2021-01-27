Feature: Create Quote

  Scenario: The user selects carrier and creates a FCL single Routing quote
    Given that user selects the "qaauto" environment
    When the user logs in with login id "qaauto_super" and "pass"
    And user clicks on "Quoting"
    And user clicks on "newQuoteLink"
    And user clicks on "Create QP"
    And user clicks on "Single Routing"
    And user clicks on "Ocean-FCL"
    And user clicks on "Create New"
    And user adds Locations to create quote
      | Origin  |  | Destination |
      | Atlanta |  | Yantian     |
    And user adds dates from "11/01/2019" to "12/31/2020" for quote
    And user adds commodity "C HOOK"
    And user adds Container types for quote
      | Cntr. 20 ft |
    And I enter buyrate
      | Buy Rate |
      |       23 |
    And I add an agent "kvtest"
    #And I select "by contact person"
    And I assign a agent "kvt"
    And I select the Agent
    And I create a quote
    Then Quote is created
