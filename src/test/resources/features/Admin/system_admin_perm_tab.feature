Feature: System admin permission
  
   @CS-8120 @CS-17620 
  Scenario: Enable Quote settings and currency bump check box is checked
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "systemAdmin_Tab"
   And user clicks on disable all button
   And user clicks on quote settings
   And user enable currency bump checkbox
   Then user clicks on Save user
   
   Scenario: Enable VIP permission and check warning message
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "systemAdmin_Tab"
   And user clicks on disable all button
   And user enable VIP button and disable the checkboxes
   And user clicks on Save user
   Then user get an alert
   
  
  Scenario: Enable Quote settings and no cheboxes are checked
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "systemAdmin_Tab"
   And user clicks on disable all button
   And user clicks on quote settings
   And user clicks on Save user
   Then user gets awarning message
   
  Scenario: Check system admin enable all permissions
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "systemAdmin_Tab"
   And user clicks on enable all button
   Then user clicks on Save user
 
  Scenario: Check system admin disable all permissions
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "systemAdmin_Tab"
   And user clicks on disable all button
   Then user clicks on Save user
 
   
   
  