## Example UI Data Load JSON
```
{
  "Environment": "qaauto",
  "User": "qaauto_super",
  "UserPass": "pass",
  "Contracts": [
    {
      "ContractName": "Test Contract 1",
      "Carrier": "EGLV",
      "LCL": true,
      "TradeLane": "U.S. to Europe",
      "CommodityGroup": {
        "CommodityGroupName": "Ski Equipment",
        "Commodities": [
          "Ski Boots",
          "Ski Poles"
        ],
        "FAK": false,
        "HazardousIndicator": "n",
        "CommodityGroupType": "global"
      },
      "ContainerTypes": [
        "10000 Lbs", "40 Cubic Ft. 2000 Lbs"
      ],
      "ServiceType": "Break Bulk",
      "ServiceString": "Test Service String 1",
      "Vessel": "Test Vessel 1",
      "RateType": "Test Rate Type 1",
      "NamedAccountGroup": {
        "NamedAccountGroupName": "Test Named Account Group 1",
        "NamedAccounts": [
          "Test Named Account 1",
          "Test Named Account 2"
        ]
      },
      "RateTypeTwo": "Test Rate Type Two 1",
      "AddOn": "Origins and Destinations Allowed",
      "Origins": [
        {
          "Origin": "Charleston",
          "Routing": "Panama City"
        },
        {
          "Origin": "Jacksonville"
        }
      ],
      "Destinations": [
        {
          "Destination": "Antwerp",
          "Routing": "London"
        },
        {
          "Destination": "Antwerp"
        }
      ],
      "Rates": [
        "1200",
        "620",
        "1400",
        "600"
      ]
    }
  ]
}    
```
### Explanation of fields' behaviors:
- `Environment` - The environment used to log in to the system, passwords are defined in `BaseStepDefinitions.java`
- `Contracts` - An array of the contract .json structure used to define contracts loaded into the system.  The automation
will iterate over this array and return to the Carrier Select page after loading each contract, ready to start the next.
  - `ContractName` - The contract name, this field is used to check if the contract already exists in the database before
  performing an unnecessary data load.
  - `Carrier` - The carrier selected at the Carrier Select page to load the contract.  If that carrier doesn't exist it will
  be added through the UI by this exact SCAC, so this value must be an exact SCAC in the database.
  - `LCL` - Optional field. If true the contract add will be performed on the LCL Contract Add page, otherwise it will be performed
  on the FCL Contract Add page.
  - `TradeLane` - If this exact trade lane exists in the ContractAddManager it will be used.  Otherwise, it will be added
  through the UI.
  - `CommodityGroup` - Contains information about the commodity group associated with the contract.  The fields of this
  substructure are self-explanatory.  However, if a commodity group with the exact `CommodityGroupName` is found, it will
  be selected and the remaining `CommodityGroup` fields will be ignored.
  - `ContainerTypes` - Can contain multiple strings and all of those container types will be selected.  The provided values
  must correspond to the container types exactly as they appear in the ContractAddManager UI.
  - `ServiceType` - Optional field, a provided value must correspond to the service type exactly as it appears in the
  ContractAddManager UI.
  - `ServiceString`, `RateType`, `Vessel`, and `RateTypeTwo` - These optional fields all behave identically.  If the provided
  value exists it is selected, if not the provided value is added through the UI.
  - `NamedAccountGroup` - Optional field. Behaves similarly to `CommodityGroup`.  Subfields are ignored if the account group already exists.
  Otherwise, the subfields are included as the NamedAccountGroup details.
  - `AddOn` - Optional field. Behaves like `ServiceType`.
  - `Origins` - An array of Origin / Routing pair objects.  The routing pair in each is optional.  They are added in the order
  they are provided through the UI.
  - `Destinations` - Behaves similarly to `Origins`.  That means you must provide the same number of Destinations as Origins.
  - `Rates` - An array of integers that are entered into the available rate inputs row by row in the order they are provided.  
  That means you must provide `Origins.size * ContainerTypes.size` values in this field.
