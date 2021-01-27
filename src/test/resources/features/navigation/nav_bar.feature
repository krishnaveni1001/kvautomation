Feature: Navigation Bar

@NavigationBar1 @NavigationBar
Scenario: All navigation menu options should be visible to the Owner and user type indicator displays "Owner"
	Given a user is on the login page for the "qaauto" environment
	And the user logs in as "qaauto_super"
	Then the user type indicator displays "Owner"
	And all the navigation menu options should be visible

@NavigationBar2 @NavigationBar
Scenario: All navigation options should be visible for super user
	Given a user is on the login page for the "demo" environment
	Given the user logs in as "Super User"
	Then all the navigation menu options should be visible