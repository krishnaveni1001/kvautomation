Feature: Date range selector

Background:
	Given a user is on the login page for the "qaauto" environment
	And the user logs in as "qaauto_super"
	When user clicks on "Rate Management"
	When user clicks on "FreeTime" under Ratemanagement submenu
	And I choose below carrier
	 |Maersk|
	And user clicks on freetime link
	 
	 
@18783
Scenario: Below test fields are seen on the UI 
		Then user should see
   |Carrier|Contract|Date Range|
   
Scenario: Two date fields are seen
	 And I click on the Date Range text field
   Then Two date fields are available. 
   And The currently selected dates "17-Nov-2020" are displayed by default

Scenario: Two checkboxes are available
	      And I click on the Date Range text field
	      Then Two date fields are available
        Then an Open start checkbox is available.
       And an Open end checkbox is also available.

Scenario: Open checkbox displays Open text
	      And I click on the Date Range text field
	      Then Two date fields are available
	      Then Checking an Open box clears the associated date 
        And displays the text 'Open' in the date field

Scenario: Unchecking open check box
	      And I click on the Date Range text field
	      Then Two date fields are available
	      Then Checking an Open box clears the associated date 
        And displays the text 'Open' in the date field
        Then Unchecking an 'Open' box clears the 'Open' text

Scenario: Two checkboxes are available with dates
	      And I click on the Date Range text field
	      Then Two date fields are available
	       Then end date can be selected "1-31-2021" if the start date is Open
         Then Start date can also be selected "1-17-2021" if the end date is open

Scenario: Start date error text
	      And I click on the Date Range text field
	      Then Two date fields are available
	      And I uncheck open start checkbox
        And I click Apply button
        Then the text is displayed "Please choose a start date"

Scenario: Start date error text
	      And I click on the Date Range text field
	      Then Two date fields are available
	      And I uncheck open end checkbox
        And I click Apply button
        Then the text is displayed "Please choose an end date"

Scenario: Start date error text
	      And I click on the Date Range text field
	      Then Two date fields are available
	      And I enter the start date as "31-JAN-2021"
	      And I enter the end date as "1-JAN-2021"
	      And I click Apply button
        Then the text is displayed "The start date cannot be later than the end date"

Scenario: Start date error text
	      And I click on the Date Range text field
	      And I click Cancel button
        Then the date range pop up is not displayed

