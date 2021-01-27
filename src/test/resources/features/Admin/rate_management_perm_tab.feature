Feature: rate management

 Scenario: Check rate management and enable all permissions
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "rateMgmt_tab"
   And user clicks on enable all button on ratemanagement tab
   Then user clicks on Save user
	
	
 Scenario: Check rate management and disable all permissions
   Given a user is on the login page for the "qaauto" environment
   When the user logs in with login id "qaauto_super" and password "pass"
   And user clicks on "Admin"
   And user clicks on "usersLink"
   And user clicks on search box and enter "test"
   And user clicks on "rateMgmt_tab"
   And user clicks on disable all button on ratemanageent tab
   Then user clicks on Save user
   
   