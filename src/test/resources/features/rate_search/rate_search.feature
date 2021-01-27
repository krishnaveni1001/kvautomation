Feature: Rate Search
  Users should be able to log into CargoSphere from the login page, land on 
  the rate search start page, and do a rate search.

  Background:
    Given test data has been loaded for "rate_search"

  @RateSearch1
  Scenario: A user does a rate search from the rate search start page.
    Then the user is redirected to the rate search results page

  @RateSearchResults1
  Scenario: Contract owner search with origin and destination and check the number of rates in the result
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And the user performs a classic view rate search for "MLBKO" to "JPMAI"
    Then there should be 1 total classic view rate search results

  @RateSearchResults2
  Scenario: Customer search with origin and destination with default values
    Given that user "qaauto_super" is logged into "qaauto" environment
    And the user performs a classic view rate search for "MAAGA" to "AEAUH"
    Then there should be 1 total classic view rate search results

  @RateSearchResults3
  Scenario: Contract owner search with origin and destination with default values
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "MAAGA" origin and destination "AEAUH"
    Then there should be 2 total classic view rate search results
    And first summary total should match with the detail total

  @RateSearchResults4
  Scenario: Contract owner search with inland origin and destination with default values
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "CAMTR" origin and destination "DEHAM"
    Then there should be 1 total classic view rate search results
    And first summary total should match with the detail total
    And inland location need to check

  @RateSearchResults5
  Scenario: Contract owner search with inland origin and base destination with default values
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "CAMTR" origin and destination "SNDKR"
    Then there should be 1 total classic view rate search results
    And first summary total should match with the detail total

  @Level2Results1
  Scenario: Check rate search surcharge preference and add origin & destination preference as default
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then show level2 result
    Then check surcharge preference

  @Level2Results2
  Scenario: Compare base rate and other details
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then show level2 result
    Then compare baserate
      | charge | rate | priceBy | type |
      | BASE RATE | $2,400.00 | Per Container| Applicable |

  @Level2Results3
  Scenario: Compare different surcharge and details
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then check surcharge preference
    Then show level2 result
    Then enter surcharge data
      | charge | rate | priceBy | type | category | index | pattern |
      | AAF| $50.00 | Per Container | Applicable | Freight | 0 | ocean_base |
      | CAA|   |  | Included | Freight | 2 | ocean_base |
      | BAF|   |  |Subject To | Freight | 4 | ocean_base |
      | DAD|   |  | Not Applicable | Destination | 3 | ocean_base |
      | EA| $25.00 | Per Document | Applicable | Freight | 0 | Bol |
      | FA| $30.00 | Per Container | Applicable | Freight | 1 | addchr_base |

  @Level2Results4
  Scenario: Contract owner search with origin and destination and compare the summary total and level2 total
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "MLBKO" origin and destination "JPMAI"
    Then show level2 result
    And first summary total should match with the detail total