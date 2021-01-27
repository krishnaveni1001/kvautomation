Feature: Add Carrier

 Scenario: The user logins and add carrier
 	 Given that user "qaauto_super" is logged into "qaauto" environment
 	 Then user clicks on "Admin"
 	 Then user clicks on "carriersListLink"
 	 Then select a new carrier by selecting the Carrier following data:
 | ScacId |
 |HLCU|
 |APLU|
 |CMDU|
 |ZIMU|