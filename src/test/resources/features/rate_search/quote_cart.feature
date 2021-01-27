Feature: Quote Cart

  Background:
    Given that user "e-maeu_super" is logged into "e-maeu" environment

  @QuoteCart1
  Scenario: Contract owner checking if any rates is added in quote cart then clear quote cart
    Given the user performs a rate search for "MLBKO" to "JPMAI"
    Then there should be 1 total classic view rate search results
    Then clear cart in rate search page
    Then add first rate to quote cart
    Then goto quote cart page
    And clear cart
    Then return to rate search page
    Then clear cart in rate search page

  @QuoteCart2
  Scenario: Contract owner checking if any rates is added in quote cart then clear quote cart
    Given that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then add first rate to quote cart
    Then goto quote cart page
    And clear cart
    Then return to rate search page
    Then clear cart in rate search page

  @QuoteCart3
  Scenario: Contract owner add first rate to quote cart and clear quote cart
    Given that user "e-maeu_super" is logged into "e-maeu" environment
    And that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then add first rate to quote cart
    Then goto quote cart page
    And clear cart
    Then return to rate search page

  @QuoteCart4
  Scenario: Contract owner add first rate to quote cart and check the quote cart date is same as rate search date
    Given that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then add first rate to quote cart
    Then the default quote cart date should be rate search date
    And clear cart
    Then return to rate search page

  @QuoteCart5
  Scenario: Contract owner add first rate to quote cart and check the number of rates in the quote cart is same as rate search page
    Given that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    Then add first rate to quote cart
    And number of rates in the cart
    And clear cart
    Then return to rate search page

  @QuoteCart6
  Scenario: Add all the rates in the rate search page in to quote cart
    Given that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    And add page to quote cart
    Then goto quote cart page
    And clear cart
    Then return to rate search page

  @QuoteCart7
  Scenario: Add all the rates in the selected row in to quote cart
    Given that user search with "MLBKO" origin and destination "JPMAI"
    Then there should be 1 total classic view rate search results
    And add all rates to quote cart
    Then goto quote cart page
    And clear cart
    Then return to rate search page

  @QuoteCart8
  Scenario: Contract owner search with base origin and ouland destination with default values
    Given that user search with "AWAUA" origin and destination "DEHAM"
    Then there should be 1 total classic view rate search results
    And first summary total should match with the detail total
    And check the rates in quote cart
    And clear quote cart filters