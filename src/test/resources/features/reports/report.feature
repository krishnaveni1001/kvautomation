 Feature: Report
 
 Users should be able to log into CargoSphere from the login page.
 
  Background: 
   Given that a Super user with login id "name1" and email "name1@test.com" created with report permission
   Given that user with email "name1@test.com" forgots password and lands on reset password page through the email link
   When the user tries to reset the password as "test@1234" 
	 When the user resets and lands on login page
	 Then the user "name1" logins with given password "test@1234" results "true"
    
    @reportPermissions @deleteUserCreated
    Scenario: A Super user created tries to check all report permission
    When that the user click on report menu
    Then that user check all report links