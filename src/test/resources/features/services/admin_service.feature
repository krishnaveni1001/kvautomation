Feature: To get users using admin service 
Scenario: User calls admin to get users 
	Given I want to execute service /api/auth/ 
	When I read the json data file "json/auth-login.json" 
	Then I send the json post request to endpoint "login" 
	When I validate status code 
	Then I verify the result message param "accessToken" 
	And get the access token 
	When I hit the service with token /api/admin/ 
	When I read the json data file "json/admin-get-users.json" 
	Then I send the json post request to endpoint "users" 
	When I validate status code 
	Then it is success 
	
Scenario: User calls environment add to create environment 
	When I hit the service with "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoic2VydmljZSIsInVzZXJJZCI6LTEsInVzZXJUeXBlSWQiOjQsImFkbWluSWQiOjAsImNsaWVudFZpZXdJZCI6MCwicGVybWlzc2lvbnMiOnt9LCJpc3MiOiJDYXJnb1NwaGVyZSIsImlhdCI6MTU2MjAwODI3Nn0.TLHzyTocgPQk-UrSUDdCgoYUq3bcHX1AfDKhSpq0BySuIpIu4kO2RidCsp5-De0fIlfpnUjYXStoRQ7i_VByEu0HQCfhvS54BIWXd_eO5IMBoPk0kuw-xfHK23--K_XM1kmBrL7Mk4Cn330KRFsCigMIm9BPTxsQbjzPaQbC1_Y5gVNlHw4fttQf0qVMidO01VK2OehMQckiOgEuALVWT_C4fpHXkaMSjF-aMjo0IElweykX3-TA2CENHMIOn-Wy0HEedFhrs07PcY6ATZYVhqd8Jet8JWWE4Hp1nN8xFmWhmG1Z1ddHj8dbhZ1-4Xapu6z6DCPfiNpB2g_aUrXczQ" token /api/admin/ 
	And I read the json data file "json/create-env.json" 
	And I send the json post request to endpoint "/environment/add" 
	Then I validate status code 
	Then it is success 
	
Scenario: User calls environment add to create environment with incorrect token 
	When I hit the service with "hbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoic2VydmljZSIsInVzZXJJZCI6LTEsInVzZXJUeXBlSWQiOjQsImFkbWluSWQiOjIsImNsaWVudFZpZXdJZCI6MTAyLCJwZXJtaXNzaW9ucyI6e30sImlzcyI6IkNhcmdvU3BoZXJlIiwiaWF0IjoxNTYyMDA4Mjc2fQ.pq2TdBOvOaSlvwuMfuxAty17ggtp8lKXJqSOGaiISJs2y5f_HDlCbJ4H3FAPNNYh41XPQNxUwjIYq2fIX3G7jfmu8UrhdryMGRmgnWBiM5MM1AA1VKTN0ZyI6q33Goh0N-Sz7uRfovUnG2n5wzHt3RZIC2ADzjlTUdZoBMcMgV8QWz1IroN0pTaomqjk3I_Web6ZwuTXoZdZ8dAsqvXEDnOL00xGKZjPavTQ8elBVKVhpunW0-b7wE4jTU54gIIE-IKamxYXDgLi88mOn0VgnydMuDwsH68emfyOj6Ei6lWlE_DmtUTEoCnL-nywiAcBMwlhYnbwj1SSBV8-XR2XcA" token /api/admin/ 
	And I read the json data file "json/create-env.json" 
	And I send the json post request to endpoint "/environment/add" 
	Then I validate status code 
	Then it is not success 
	
Scenario Outline: User calls environment add to create multiple environments 
	When I hit the service with "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoic2VydmljZSIsInVzZXJJZCI6LTEsInVzZXJUeXBlSWQiOjQsImFkbWluSWQiOjAsImNsaWVudFZpZXdJZCI6MCwicGVybWlzc2lvbnMiOnt9LCJpc3MiOiJDYXJnb1NwaGVyZSIsImlhdCI6MTU2MjAwODI3Nn0.TLHzyTocgPQk-UrSUDdCgoYUq3bcHX1AfDKhSpq0BySuIpIu4kO2RidCsp5-De0fIlfpnUjYXStoRQ7i_VByEu0HQCfhvS54BIWXd_eO5IMBoPk0kuw-xfHK23--K_XM1kmBrL7Mk4Cn330KRFsCigMIm9BPTxsQbjzPaQbC1_Y5gVNlHw4fttQf0qVMidO01VK2OehMQckiOgEuALVWT_C4fpHXkaMSjF-aMjo0IElweykX3-TA2CENHMIOn-Wy0HEedFhrs07PcY6ATZYVhqd8Jet8JWWE4Hp1nN8xFmWhmG1Z1ddHj8dbhZ1-4Xapu6z6DCPfiNpB2g_aUrXczQ" token /api/admin/ 
	And I read the json data file "json/create-env-parameters.json" 
	And I assert on the environments with "<environment>" details to endpoint "/environment/add" 
	Then I validate status code 
	Then it is success 
	Then I verify the result message param "message" 
	Then I verify the result message param "result" 
	Then I verify the result message param "resultCode" value 
	
	
	Examples: 
		|environment|
		|KVTEST10   |                          
		
		
Scenario Outline: 
	User calls environment add to create environment based on parameters with empty environment type 
	When I hit the service with "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoic2VydmljZSIsInVzZXJJZCI6LTEsInVzZXJUeXBlSWQiOjQsImFkbWluSWQiOjAsImNsaWVudFZpZXdJZCI6MCwicGVybWlzc2lvbnMiOnt9LCJpc3MiOiJDYXJnb1NwaGVyZSIsImlhdCI6MTU2MjAwODI3Nn0.TLHzyTocgPQk-UrSUDdCgoYUq3bcHX1AfDKhSpq0BySuIpIu4kO2RidCsp5-De0fIlfpnUjYXStoRQ7i_VByEu0HQCfhvS54BIWXd_eO5IMBoPk0kuw-xfHK23--K_XM1kmBrL7Mk4Cn330KRFsCigMIm9BPTxsQbjzPaQbC1_Y5gVNlHw4fttQf0qVMidO01VK2OehMQckiOgEuALVWT_C4fpHXkaMSjF-aMjo0IElweykX3-TA2CENHMIOn-Wy0HEedFhrs07PcY6ATZYVhqd8Jet8JWWE4Hp1nN8xFmWhmG1Z1ddHj8dbhZ1-4Xapu6z6DCPfiNpB2g_aUrXczQ" token /api/admin/ 
	And I read the json data file "json/create-env-parameters.json" 
	And I assert on the environments with "<environment>" details and "<deploymentType>" and "<companyName>" and "<emailAddress>" and "<loginId>" and "<userName>" and "<masterEmailAddress>" and "<masterLoginId>" and "<masterUserName>" and "<message>" and "<result>" and "<resultCode>" and "<statusCode>" to endpoint "/environment/add" 
	When I validate status code 
	
	Examples: 
		|environment| deploymentType |companyName|      emailAddress                 | loginId   |    userName         |  masterEmailAddress             |   masterLoginId    |   masterUserName     |  message                                     | result             | resultCode      |  statusCode |
		| KVTEST_6  |     S         |nvo inc     |    kristt@cargopshere.com        |  nvo      |     krishna1        |    krishtt@cargosphere.com      |      dmaster       |    dmaster           |Duplicate environment                         | Action failed      |   1001          |   200      |
		|           |     S         |nvo         |    kv1@cargosphere.com           |  kv1      |     User name       |   kv11@cargosphere.com          |      dmaster       |    dmaster           |Issues with creating environment and users    | Action failed      |   1001          |   200     |     
		| KVTEST10  |     S         |nvo         |    kvtest10@cargosphere.com      |  kv1      |     User name       |                                 |      dmaster       |    dmaster           |Internal Exception                            | Action failed      |   1001          |   400       |     
		| KVTEST11  |     S         |nvo         |   kvtest11@cargosphere.com       |  kv1      |     User name       |    mkvtest11@cargosphere.com    |                    |    dmaster           |Internal Exception                            | Action failed      |   1001          |   400       |      
		| KVTEST11  |     S         |nvo         |   kvtest11@cargosphere.com       |  kv1      |     User name       |    mkvtest11@cargosphere.com    |      dmaster       |                      |Internal Exception                            | Action failed      |   1001          |   400       |        
		| KVTEST10  |               |nvo         |   kvtest10@cargosphere.com       |  kv1      |     User name       |    mkvtest10@cargosphere.com    |      dmaster       |                      |Internal Exception                            | Action failed      |   1001          |   400       |                      
		
		
		
		