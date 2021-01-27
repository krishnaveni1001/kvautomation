Feature: test scenario
 Scenario: The user has all rate management permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
   Then click on "rateMgmtPermission" and tab "rateMgmt_tab" and enable "rateMgmtEnableAll"
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
    
  Then the user logs in with login id "Lathaqa" and "test@1234"
	Then checks the following navigations
	| Rate Search  | Rate Management | Quoting |
	 Then user clicks on "Rate Management"
   Then user clicks on "chooseCarrierLink"
 	 Then select a carrier "zim"
 	 Then user clicks on rate management submenu
 	 Then user logout from the environment
 	 
 Scenario: The user can manage selected contracts only
 	Given that user "qaauto_super" is logged into "qaauto" environment	
 	Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
   Then click on "rateMgmtPermission" and tab "rateMgmt_tab" and enable "rateMgmtEnableAll"
	Then user give permisson to manage few contracts
 	Then user clicks on "register"
  Then user sees "userAddedDialog" popup 
  
    
  Then the user logs in with login id "Lathaqa" and "test@1234"
	Then checks the following navigations
	| Rate Search  | Rate Management | Quoting |
	 Then user clicks on "Rate Management"
   Then user clicks on "chooseCarrierLink"
 	 Then select a carrier "zim"
 	 Then user find the number of contracts
 	 Then user logout from the environment
 	 
 	Scenario: The user has Limit by contract attribute permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "rateMgmtPermission" and tab "rateMgmt_tab" and enable "rateMgmtEnableAll"
  
  Then user give permission to limit by contract attributes
  		| attribute | value |
		  | rateMgmtCarrierData |ZIM|
		  | rateMgmtCountryData | India|
		  | rateMgmtLoadTypeData | FCL|
   		| rateMgmtMngScopesData | Buy |
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup 
 	 
	   
  Then the user logs in with login id "Lathaqa" and "test@1234"
	Then checks the following navigations
	| Rate Search  | Rate Management | Quoting |
	 Then user clicks on "Rate Management"
   Then user clicks on "chooseCarrierLink"
 	 Then select a carrier "zim"
 	
 	 Then user open a contract
 	 Then user can check internal contract owner permission
 	 Then user logout from the environment
	
Scenario: The user has Account admin permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "accountAdminPermission" and tab "accountAdmin_tab" and enable "mngAccEnableAll"
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
  
    
  Then the user logs in with login id "Lathaqa" and "test@1234"
	 Then user clicks on "Admin"
	 Then user check customers and external agents link
	 Then user clicks on "Admin"
	 Then user check manage tariff organization record
	 Then user clicks on "Admin"
	 Then user clicks on "carriersListLink"
	
	 Then user check fmc tariff users permission
	 
	Scenario: The user check selected business unit permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "accountAdminPermission" and tab "accountAdmin_tab" and enable "mngAccEnableAll"
   Then user click on selected "mngAccSelUsers" and "mngAccSelBU" and "Chicago" 
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
  
   
   		
  Scenario: The user check ratemesh permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on ratemesh permission
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
  Then the user logs in with login id "Lathaqa" and "test@1234"
	 
	 Then user clicks on "Rate Mesh"
	 Then user check ratemesh submenu
 
	Scenario: The user check report and dash board permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "reportsPermission" and tab "reports_tab" and enable "mngRepEnableAll"
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup

  Then the user logs in with login id "Lathaqa" and "test@1234"
  Then user clicks on "Reports"
	Then user check report submenu
	
	 Scenario: The user checks selected reports permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "reportsPermission" and tab "reports_tab" and enable "mngRepEnableAll"
  Then user click on selected "mngRepSelRep" and "mngRepSelRepData" and "GRI"
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
 
    
  Then the user logs in with login id "Lathaqa" and "test@1234"
	 Then user clicks on "Reports"
	 Then user check on report menu "GRI"
	 
 Scenario: The user checks selected dashboard permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "reportsPermission" and tab "reports_tab" and enable "mngRepEnableAll"
  Then user click on selected "mngRepSelDash" and "mngRepSelDashData" and "SUDS"
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
 
    
  Then the user logs in with login id "Lathaqa" and "test@1234"
	Then user clicks on "Reports"
	Then user check on report menu "SUDS"
	
	Scenario: The user check system admin permission
 	Given that user "qaauto_super" is logged into "qaauto" environment
  Then user clicks on "User Profile"
	Then user is a "Owner" 
  Then should be able to see all the menus
  Then user clicks on "Admin"
  Then user clicks on "usersLink"
  Then user click on searchbox
  Then user can edit the permission
  Then click on "systemAdminPermission" and tab "systemAdmin_tab" and enable "mngSysEnableAll"
 
  Then user clicks on "register"
  Then user sees "userAddedDialog" popup
 
    
  Then the user logs in with login id "Lathaqa" and "test@1234"
	Then user clicks on adminsubmenu
	 
	 
	 