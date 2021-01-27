Feature: Account admin permission
  
  Scenario: Check available permission on the account admin tab
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "accountAdmin_tab"
   And user click on enable all button
   And user check available permission on the tab
   And user clicks on Save user
  
  Scenario: Enable manage users permission and check all users selected by default
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "accountAdmin_tab"
   And user clicks on disableall button
   And user enable manage users permission 
   And user clicks on Save user
   
   Scenario: Select business unit permission without a value
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "accountAdmin_tab"
   And user click on enable all button
   And user select business unit and no value selected from dropdown
   And user clicks on Save user
  
  Scenario: Disable all account admin permission
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "accountAdmin_tab"
   And user clicks on disableall button
   And user clicks on Save user
   
   Scenario: Enable all account admin permission
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "accountAdmin_tab"
   And user click on enable all button
   And user clicks on Save user