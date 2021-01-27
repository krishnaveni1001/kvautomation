Feature: FMC permission 
 
   Scenario: Check available permissions in FMC tab
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
   And user clicks on enable button on fmc tab
   And user check available permissions on FMC tab
  
  
  Scenario: Check view tariff permission validation with review and release tariff permission
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
   And user clicks on disable all button on fmc tab
   And user check view tariff permission validation with review and release tariff permission
   And user clicks on Save user 
   And user get the error message
 
 Scenario: Enable Create and manage tariff and check require approval for release is enabled
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
   And user clicks on disable all button on fmc tab
   And user enable Create and manage tariff and check require approval for release is enabled
   And user clicks on Save user
  
  Scenario: If Create and manage tariff is enabled then view tariff must be enabled
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
   And user clicks on disable all button on fmc tab
   And user check view tariff permission
   And user clicks on Save user
   
  
  
  Scenario: Disable all FMC permission and save
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
   And user clicks on disable all button on fmc tab
   And user clicks on Save user
   
   Scenario: Enable all FMC permission and save
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
   And user clicks on enable button on fmc tab
   And user clicks on Save user
   
   Scenario: Check view tariff permission validation with create tariff permission
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "fmc_tab"
  
   And user check view tariff permission validation with create tariff permission
   And user clicks on Save user 
   And user get the error message
   