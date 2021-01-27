Feature: Reset Password
  	Users should be able to log into CargoSphere from the login page.
  @smoke
	Scenario: A user clicks on forgot password and gets reset email
		Given a user is on the login page for the "qaauto" environment
		Given user clicks on forgot password and lands on Forgot password page
		When the user enters email "dontuse@cargosphere.com" for reset password
		Then reset email sent successfully
		And user gets the reset password email for "dontuse@cargosphere.com"
	
	@deleteUserCreated	
  Scenario Outline:A Super user created tries to reset the password
    Given that a Super user with login id <loginId> and email <email> created with report permission
    Given that user with email <email> forgots password and lands on reset password page through the email link
    When the user tries to reset the password as <resetPwd> 
		Then the user resets and lands on login page
		Then the user <loginId> logins with given password <givenPwd> results <result>
		Examples: 
      | loginId  | email | resetPwd | givenPwd |result  |
      | "name1" |     "name1@test.com"  | "test@1234" | "test@12345" | "false" |
      | "name2" |     "name2@test.com"  | "test@1234" | "test@1234" | "true" | 
      | "name3" |     "name3@test.com"  | "test@1234" | "test@1234" | "true" |  