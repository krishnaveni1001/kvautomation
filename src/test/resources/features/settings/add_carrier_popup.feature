Feature: Add carriers 


  @CS-7208 @CS-17732
  Scenario: Add a carrier with all information
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "carriersListLink"
   And user clicks on add carrier button
   And user enter scac code "MAEU"
   And user enter contact name "TestQA1"
   And user enter emailid "donotuse@cargosphere.com"
   And user click on save carrier button
   
   
    
  Scenario: Check duplicate carrier allows in system
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "carriersListLink"
   And user clicks on add carrier button
   And user enter scac code "MAEU"
   And user enter contact name "TestQA1"
   And user enter emailid "donotuse@cargosphere.com"
   And user click on save carrier button
   And user catch the duplicate carrier warning message
   
    
  Scenario: Check the Cancel button
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "carriersListLink"
   And user clicks on add carrier button
   And user enter scac code "MAEU"
   And user enter contact name "TestQA1"
   And user clicks on cancel button
   
   
  Scenario: Add carrier without the mandatory field Carrier name
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "carriersListLink"
   And user clicks on add carrier button
   And user enter contact name "TestQA1"
   And user enter emailid "donotuse@cargosphere.com"
   And user click on save carrier button
   And user get the warning message
   
  Scenario: Add carrier with mandatory field Carrier name
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "carriersListLink"
   And user clicks on add carrier button
   And user enter company name "TestQACarrier01"
   And user click on save carrier button with a popup
  
  Scenario: Add carrier with a wrong email format
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "carriersListLink"
   And user clicks on add carrier button
   And user enter company name "TestQACarrier02"
   And user enter emailid "donotuse"
   And user click on save carrier button
   And user catch the wrong email format error
  