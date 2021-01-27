Feature: Contract management Console

Background:
	        Given that scac is active for "MAEU" 
@CreateFCLContract1
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract1oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Boat" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|	
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract1oneContainerLocation"
						
@CreateFCLContract2			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract2oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Glass" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|	
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract2oneContainerLocation"
						
@CreateFCLContract3			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract3oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Auto" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract3oneContainerLocation"
						
@CreateFCLContract4			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract4oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Cotton" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract4oneContainerLocation"
					
@CreateFCLContract5			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract5oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "car" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract5oneContainerLocation"	
					
@CreateFCLContract6			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract6oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "PEAS" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract6oneContainerLocation"	
						
@CreateFCLContract7			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract7oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "BRUSH" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract7oneContainerLocation"	
					
@CreateFCLContract8			
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract8oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "PAINT" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract8oneContainerLocation"
		
@CreateFCLContract9		
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract9oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "BRACELET" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract9oneContainerLocation"	
					
@CreateFCLContract10		
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract10oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "HAIR" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract10oneContainerLocation"	
					
@CreateFCLContract11		
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract11oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Gel" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract11oneContainerLocation"	
					
@CreateFCLContract12		
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract12oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "COSMETICS" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 		
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract12oneContainerLocation"	
					
@CreateMulticontainerFCLContract13
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract13oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Transformer" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			|Cntr. 40 ft|
			|Cntr. 40 ft HC|
			|Cntr. 45 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			|Charleston||Shanghai|
			|Baltimore||Paris|
			|Norfolk||Yantian|
			|Tacoma||Hong Kong|
			Then user adds amount for "4" Container Types for "5" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100| 
			|Cntr. 40 ft| |200|
			|Cntr. 40 ft HC| |300|
			|Cntr. 45 ft| |400|
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract13oneContainerLocation"	
			
@CreateFCLContract14
Scenario:   Customer creates a contract in console for single container type and location
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "Contract14oneContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "treadmill" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Atlanta||Yantian|
			Then user adds amount for "1" Container Types for "1" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|	
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "Contract14oneContainerLocation"
			
@CreateMulticontainerFCLContract15		
Scenario:   Customer creates a contract in console for multiple container type
	   		Given that user "qaauto_super" is logged into "qaauto" environment
	   		#Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "MultiContainerLocation" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Tofu" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			|Cntr. 40 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Charleston||Shanghai|
			|Atlanta||Yantian|
			Then user adds amount for "2" Container Types for "2" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|
			|Cntr. 40 ft| |200|
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "MultiContainerLocation"
									
@ApplyConsoleFilters
Scenario: 	Customer applies filters in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "MultiContainerLocation"
 	   	    Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|TOFU (FAK, Non-hazardous)|
						
@ClearConsoleFilters
Scenario: 	Customer clears filters individually in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "MultiContainerLocation"
 	   	    Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|TOFU (FAK, Non-hazardous)|
			Then user clears container type filter
			Then user clears origin location filter
			Then user clears destination location filter
			Then user clears commodity group filter
					
@ClearAllFilters
Scenario: 	Customer clears  all filters in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "MultiContainerLocation"
 	   	    Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|TOFU (FAK, Non-hazardous)|
			Then user clears all filters		
									
@CompareRatetotal			
Scenario: 	Customer compares a rate total amount in the console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "MultiContainerLocation"
 	   	    Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|TOFU (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
								
@AddApplicableSurchargePerContainer_1
Scenario: 	Customer adds an 'Applicable' surcharge with Price-by 'Per container, Exclusion 'No' Currency 'Euro'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "MultiContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|   |EffDate|     |ExpDate|   
			  |BAF|            |Applicable|           |Origin|   		|Per Container|   |20|     |EUR Euro|       |No|            |11/01/2019|  |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|TOFU (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "122.40"
			Then user checks surcharge "EBAF[Orig]" is "Applicable" with total surcharge amount "22.40"
		
@AddApplicableSurchargePerContainer_2
Scenario: 	Customer adds an 'Applicable' surcharge with Price-by 'Per container, Exclusion 'Yes' Currency 'Euro'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract1oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|   |EffDate|     |ExpDate|   
			  |BAF|            |Applicable|         |Destination|   	|Per Container|   |20|     |EUR Euro|       |Yes|           |11/01/2019|  |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|Boat (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF[Dest]" is "Applicable" with total surcharge amount "0.00"
					
@AddApplicableSurchargePercent_3
Scenario: 	Customer adds an 'Applicable' surcharge with Price-by 'Percent, Exclusion 'No' 
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract2oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|   |EffDate|     |ExpDate|   
			  |BAF|            |Applicable|          |Unspecified|   	|Percent|   	|20|     	|EUR Euro|         |No|         |11/01/2019|  |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|GLASS (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "120.00"
			Then user checks surcharge "EBAF: $20.00  (20.00 %)" is "Applicable" with total surcharge amount "20.00"
		
@AddApplicableSurchargePercent_3
Scenario: 	Customer adds an 'Applicable' surcharge with Price-by 'Percent, Exclusion 'Yes'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract3oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|   |EffDate|     |ExpDate|   
			  |BAF|            |Applicable|           |Origin|   		|Percent|   	|20|        |EUR Euro|       |Yes|          |11/01/2019|  |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|Auto (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF: $20.00  (20.00 %)" is "Applicable" with total surcharge amount "0.00"	
					
@AddApplicableSurchargeBOL_4
Scenario: 	Customer adds an 'Applicable' surcharge with Price-by 'Per BOL, Exclusion 'No' Currency 'Euro'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract4oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|            |Applicable|          |Unspecified|   	|Per BOL|   	|20|        |EUR Euro|       |No|            |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|COTTON (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF: $22.40  (20.00 EUR)" is "B/L surcharges" with total surcharge amount "20.00"	
						
@AddApplicableSurchargeBOL_5
Scenario: 	Customer adds an 'Applicable' surcharge with Price-by 'Per BOL, Exclusion 'Yes' Currency 'Euro'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract5oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|            |Applicable|          |Destination|   	|Per BOL|  		 |20|       |EUR Euro|       |Yes|            |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|car (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF[Dest]: $22.40  (20.00 EUR) " is "B/L surcharges" with total surcharge amount "0.00"
					
@AddIncludedSurcharge_1
Scenario: 	Customer adds an 'Included' surcharge with Exclusion 'No'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract6oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|            |Included|            |Origin|   		|Per Container|  |0|       |EUR Euro|       |No|              |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|PEAS (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF[Orig]" is "Included" with total surcharge amount "0.00"
					
@AddIncludedSurcharge_2
Scenario: 	Customer adds an 'Included' surcharge with Exclusion 'Yes'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract7oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|            |Included|          |Destination|   		|Per Container|  |0|       |EUR Euro|       |yes|             |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|BRUSH (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF[Dest]" is "Included" with total surcharge amount "0.00"
						
@AddSubjectToSurcharge_1
Scenario: 	Customer adds an 'SubjectTo' surcharge with surcharge with Exclusion 'No'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract8oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|            |Subject To|          |Unspecified|   	|Per Container|  |0|       |EUR Euro|       |No|              |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|PAINT (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF" is "Subject To" with total surcharge amount "0.00"
					
@AddSubjectToSurcharge_2
Scenario: 	Customer adds an 'SubjectTo' surcharge with Exclusion 'Yes'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract9oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|            |Subject To|          |Origin|   	|Per Container|  	|0|       |EUR Euro|       |yes|             |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|BRACELET (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF[Orig]" is "Subject To" with total surcharge amount "0.00"
					
@AddNot-ApplicableSurcharge_1
Scenario: 	Customer adds an 'Not-Applicable' surcharge with Exclusion 'No'
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract10oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|           |Not-Applicable|       |Destination|   	|Per Container|  |0|       |EUR Euro|       |No|              |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|HAIR (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF[Dest]" is "Not-Applicable" with total surcharge amount "0.00"	
						
@AddNot-ApplicableSurcharge_2
Scenario: 	Customer adds an 'Not-Applicable' surcharge with Exclusion 'Yes' 
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
	   	   	Then user selects an Ocean Contract with name "Contract11oneContainerLocation"
	   	   	Then user opens Pricing Info drop down in console
			Then user chooses Level 1 Surcharge editor in console
			Then user adds Level 1 surcharges to the rates in "Amd1"
			|Surcharge Term|  |Applicability|        |Category|   		|PriceBy|       |Amount|   |Currency|  |ExcludeFromTotal|     |EffDate|     	|ExpDate|   
			  |BAF|           |Not-Applicable|       |Unspecified|   	|Per Container|  |0|       |EUR Euro|       |yes|             |11/01/2019|      |12/31/2020| 
			Then user filters on origin location by UNLOC code
			|USATL|
			Then user filters on destination location by UNLOC code
			|CNYTN|
			Then user filters on container type
			|Cntr. 20 ft|
			Then user filters on commodity
			|Gel (FAK, Non-hazardous)|
			Then user opens rate detail
			Then user compares total rate amount in the console summary with expected amount "100.00"
			Then user checks surcharge "EBAF" is "Not-Applicable" with total surcharge amount "0.00"
			Then user clears cache for Chrome Browser								
			
@CreateRateMeshContract1		
Scenario:   Customer creates a contract in console
	   		Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "RatemeshContract1" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "cotton" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			|Cntr. 40 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Charleston||Shanghai|
			|Atlanta||Yantian|
			Then user adds amount for "2" Container Types for "2" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|
			|Cntr. 40 ft| |200|
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "RatemeshContract1"
			Then user selects share button for rate sharing to "QAAUTO"
						
@CreateRateMeshContract2		
Scenario:  Customer creates a contract in console
	   		Given that user "e-maeu_super" is logged into "e-maeu" environment
   	   	    And that user enters console in SCAC "MAEU" with carrierID "137804"
            Then user adds an Ocean contract name "RatemeshContract2" 
            Then user adds tradeLane "Asia to USA"
            Then user adds commodity "Auto" and commodity group name "test" and commodity ID "1624"
            Then user adds dates from "11/01/2019" to "12/31/2020"
            Then user adds Container types 
			|Cntr. 20 ft|
			|Cntr. 40 ft|
			Then user adds rates as 'Through rates'
			Then user adds Locations to add rates
			|Origin||Destination|
			|Charleston||Shanghai|
			|Atlanta||Yantian|
			Then user adds amount for "2" Container Types for "2" set of locations
			|CntrType| |Amount|
			|Cntr. 20 ft| |100|
			|Cntr. 40 ft| |200|
			Then user Submits rates
			Then user confirms creation of rates
			Then user views created rates for the contract "RatemeshContract2"
			Then user selects share button for rate sharing to "QAAUTO"
			Then user clears cache for Chrome Browser
			
@OpenRateMeshContract
Scenario: 	Customer opens a RateMesh contract in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
  	   		And user opens a Rate mesh contract
    		And user selects an Ocean Contract with name "RatemeshContract1"
    		Then user clears cache for Chrome Browser	
    		
@esudsAmendmentApproveButton
Scenario: 	Customer opens a RateMesh contract in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
  	   		And user opens a Rate mesh contract
    		And user selects an Ocean Contract with name "RatemeshContract1"
    		And user clicks on Audit page button
    		And user clicks on Amendment Approve button and sends email to contact name "Ammu" with email "ammu.francis@cargosphere.com"    	
    		And user clicks on Return to console button
    		    		
@esudsAmendmentRejectButton
Scenario: 	Customer opens a RateMesh contract in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
  	   		And user opens a Rate mesh contract
    		And user selects an Ocean Contract with name "RatemeshContract2"
    		And user clicks on Audit page button
    		And user clicks on Amendment Reject button and sends email to contact name "Gisha" with email "gisha.george@cargosphere.com" 	
    		And user clicks on Return to console button
    		Then user clears cache for Chrome Browser		
    		
@DeleteContract
Scenario: 	Customer opens a contract in console
			Given that user "qaauto_super" is logged into "qaauto" environment
  	   		And that user enters console in SCAC "MAEU" with carrierID "137804"
  	   		Then user selects an Ocean Contract with name "Contract14oneContainerLocation"
    		Then user filters on Effective Date "11/01/2019" and Expiration Date "12/31/2020"
    		Then user deletes rates
    		Then user confirms deletion of rates for the contract "Contract14oneContainerLocation"
																							
			