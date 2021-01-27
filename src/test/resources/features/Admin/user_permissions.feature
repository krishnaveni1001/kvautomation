Feature: User permissions

  Background: 
    Given a user is on the login page for the "qaauto" environment

  @12373
  Scenario: Super users added through the UI has proper permissions
    Given the user logs in as "qaauto_super"
    And user clicks on "User Profile"
    And user is a "Owner"
    And the user navigates to the user management page
    And the user clicks on the "Owner" row
    Then the following permission categories are checked
      | Rate Search | Rate Management | Quoting | FMC | Reports | Account Admin |
    When the Rate Search permission is clicked
    Then all the below rate search permissions are enabled for Rate search
      | Scope | Named Accounts | FCL Buy rates | LCL Buy rates | FCL Sell rates | LCL Sell rates | View markup on Sell rates | VIP 1 discount | VIP 2 discounts |
    And I click on Quote
    Then all the Quote permissions are enabled for Quote
      | Rate Requests | Customer Quotes | Update Customer Quotes | View Customer Quotes |
      
   Scenario: Super users added through the UI has proper permissions for Standard user
    Given the user logs in as "qaauto_super"
    And user clicks on "User Profile"
    And user is a "Standard"
    And the user navigates to the user management page
    And the user clicks on the "Standard" row
    Then the following permission categories are checked
      | Rate Search |
    When the Rate Search permission is clicked
    Then all the below rate search permissions are enabled for Rate search
      | FCL Buy rates | LCL Buy rates |
   
    Scenario: Super users added through the UI has proper permissions for Rate Manager user
    Given the user logs in as "qaauto_super"
    And user clicks on "User Profile"
    And user is a "Rate Manager"
    And the user navigates to the user management page
    And the user clicks on the "Rate Manager" row
    Then the following permission categories are checked
      | Rate Search | Rate Management |
    When the Rate Search permission is clicked
    Then all the below rate search permissions are enabled for Rate search
      | Scope | Named Accounts | FCL Buy rates | LCL Buy rates |
      

  
