
Feature: Omission Bunk Report
  
  Scenario: The user create and send report to selected email
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Reports"
   And user clicks on "bunkerOmissionLink"
   And user select "Super User" to send report
   And user click on the move button
   And user enter emailid "dontuse@cargosphere.com" to send report
   Then user click on generate report button
   
   
   
   
   
   
   
   