Feature: Create FMC user
  
   
  
  Scenario: Create FMC user and login as a FMC user
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "manageFMCUsersLink"
   And user click on add fmcuser button
   And user enter fmc user name "testQaFmc1"
   And user enter login id "qaFmc1"
   And user enter email id "dontuse@cargosphere.com"
   And user click on save button
   
   
   
   
   
 