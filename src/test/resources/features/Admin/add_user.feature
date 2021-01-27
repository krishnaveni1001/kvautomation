Feature: Add Users

 Background:
	 Given a user is on the login page for the "qaauto" environment

@AddUser1 @UserAdmin
Scenario: Super users added through the UI has proper permissions
	Given the user logs in as "qaauto_super"
	And the user navigates to the user management page
	And the user populates the add user form with this data
		|     Name 		 |            Email 		   | Login ID | Country | User Type | Business Unit  | Rate Search | Rate Management | Quoting |  FMC  | Reports | Account Admin| User Status |
		| Latha QA Auto	 | lathaqaauto@cargosphere.com | Lathaqa  | Algeria | Super User| Atlanta 		 |    true     |      true 		 |   true  | false |  false  |     false    |    Active   |
	And the user submits the user management form
	And the user refreshes the page
	Then the user table contains this data
|     Name 		 |            Email 		   | Login ID     | Country | User Type     | Business Unit  | Rate Search | Rate Management | Quoting |  FMC  | Reports | Account Admin| User Status |
		| Latha QA Auto	 | lathaqaauto@cargosphere.com | Lathaqa      | Algeria | Super User    | Atlanta 		 |    true     |      true 		 |   true  | false |  false  |     false    |    Active   |
		| Super User        | dontuse@cargosphere.com     | qaauto_super | U.S.A.  | Owner         |                |    true     |      true       |   true  | true  |  true   |     true     |    true   |
	
	
						@AddUser2 @UserAdmin
Scenario: Super users added through the UI has proper permissions
	Given the user logs in as "qaauto_super"
	And the user navigates to the user management page
	And the user populates the add user form with this data
		|     Name 		 |            Email 		   | Login ID | Country | User Type | Business Unit  | Rate Search | Rate Management | Quoting |  FMC  | Reports | Account Admin| User Status |
		| Latha QA Auto1	 | lathaqaauto1@cargosphere.com | Lathaqa  | Algeria | Super User| Atlanta 		 |    true     |      true 		 |   true  | false |  false  |     false    |    Active   |
	And the user enables all rate search permissions
	And the user enables all rate management permissions
	And the user enables all quote permissions
	And the user submits the user management form
	And the password is reset to "test@1234" through the email link
	And the user is on the login page for the "qaauto" environment
	And the user logs in with login id "Lathaqa" and password "test@1234"
	Then the following navigations are visible
		| Rate Search  | Rate Management | Quoting |
		


		
