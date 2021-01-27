package us.cargosphere.automation.dataload;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import org.openqa.selenium.InvalidArgumentException;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.CucumberRunner;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.domain.UIContractDataLoad;
import us.cargosphere.automation.domain.UIContractDataLoad.*;
import us.cargosphere.automation.domain.UIContractDataLoad.Contract.SurchargeData;
import us.cargosphere.automation.domain.UIContractDataLoad.Contract.SurchargeData.LevelOneSurcharge;
import us.cargosphere.automation.pages.LoginPage;
import us.cargosphere.automation.pages.contractmanagement.CarrierSelectPage;
import us.cargosphere.automation.pages.contractmanagement.console.ContractMgmtConsolePage;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.ContractAddManagerPage;
import us.cargosphere.automation.pages.common.DatePicker;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.ThroughRatesInput;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups.*;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups.*;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;
import us.cargosphere.automation.pages.ratesearch.startpage.RateSearchStartPage;
import us.cargosphere.automation.util.Flags;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SetupSteps extends BaseStepDefinitions {

    // The names of feature data loads that have run are inserted into hasRun
    private static final Map<String, Boolean> hasRun = new HashMap<>();
    private CarrierSelectPage carrierSelectPage;
    private ContractAddManagerPage contractAddPage;

    public SetupSteps(TestContext context) {
        super(context);
    }

    @When("^test data has been loaded for \"([^\"]*)\"$")
    public void testDataHasBeenLoadedFor(String featureName) throws IOException, SQLException, InterruptedException {

        if(hasRun.get(featureName) == null){

            String path = CucumberRunner.cmd.getOptionValue(Flags.Long.UI_DATA_LOAD_PATH);
            if(path == null || path.isEmpty()) {
                path = "./contracts/ui_load_json/";
                System.out.println("No argument for UI Data Load JSON path, using default " + path);
            }
            File file = new File(path + featureName + ".json");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            UIContractDataLoad dataLoad = objectMapper.readValue(file, UIContractDataLoad.class);
            System.out.println("Contract data load JSON mapped successfully.");

            List<Contract> unloadedContracts = new ArrayList<>();

            for(UIContractDataLoad.Contract contract : dataLoad.getContracts()) {
                if (!hasContractBeenLoaded(contract.getContractName())) {
                    unloadedContracts.add(contract);
                }
            }

            // Don't perform any UI operations unless there are contracts to load.
            if (unloadedContracts.size() > 0) {
                navigateToContractAddManager(dataLoad);
                // Load unloaded contracts
                for(Contract contract : unloadedContracts) {
                    doContractDataLoad(contract);
                    doSurchargeLoad(contract);
                }
            }

            hasRun.put(featureName, true);
        }
    }

    /**
     * Connects to the test database to see if a contract has already been loaded by name.
     * @param contractName name of the contract to search for in the database.
     * @return true if contract is found in the database.
     * @throws IOException
     * @throws SQLException
     */
    public boolean hasContractBeenLoaded(String contractName) throws IOException, SQLException {

        String query = "SELECT count(*) from cs_ocean_contract_group where contract_number = '" + contractName + "'";
        Connection conn = getConn();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            if(rs.getInt("count") == 1) {
                System.out.println("Data has for contract " + contractName + " already been loaded");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error querying for initial data load: " + e);
        }

        return false;
    }

    /**
     * Navigates to the URL, handles the environment and user level logins, and then
     * navigates to the Carrier select page where the contract load process begins.
     * @param dataLoad contains the contracts to be loaded, as well as the login information
     *                 used to enter the system.
     * @throws InterruptedException
     */
    public void navigateToContractAddManager(UIContractDataLoad dataLoad) throws InterruptedException {
        String environmentPassword = BaseStepDefinitions.envs.get(dataLoad.getEnvironment());
        String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)).append("://")
                .append(dataLoad.getEnvironment()).append(":").append(environmentPassword).append("@")
                .append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)).append("/ptrade/jsp/Digest.jsp")
                .toString();
        System.out.println("Trying url: " + digestUrl);
        this.getDriver().get(digestUrl);

        // This should throw an error if the user is not actually on the loginPage.
        new LoginPage(this.getDriver()).login(dataLoad.getUser(),dataLoad.getUserPass());

        new RateSearchStartPage(this.getDriver()).navigateToCarrierRateManagement();
        Thread.sleep(500);
    }

    /**
     * Performs a the loading of a contract from the Carrier Select page, and then returns to
     * the carrier select page so the function may be performed iteratively over multiple contracts.
     * @param contract the contract to be loaded through the UI.
     * @throws InterruptedException
     */
    public void doContractDataLoad(UIContractDataLoad.Contract contract) throws InterruptedException {

        System.out.println("Loading data for " + contract.getContractName());
        carrierSelectPage = new CarrierSelectPage(this.getDriver());

        addCarrierIfDoesNotExist(contract.getCarrier());
        navigateToAddRatesManager(contract);

        enterRequiredContractInfoIntoUI(contract);
        enterOptionalContractInfoIntoUI(contract);
        enterRatesIntoUI(contract);

        contractAddPage.clickSubmitRatesButton();
        Thread.sleep(500);

        // Return to company select menu
        new NavigationMenuBar(this.getDriver()).getRateMgmtNav().clickChooseCarrierLink();
        Thread.sleep(500);
    }


    /**
     * Searches for a carrier by SCAC at the carrier select page, and then
     * adds that carrier if there are no results.
     * TODO implement the additional carrier details contained in Add Carrier modal.
     * @param carrier the SCAC of the carrier to be added.
     * @throws InterruptedException
     */
    public void addCarrierIfDoesNotExist(String carrier) throws InterruptedException {
        if(!carrierSelectPage.carrierExists(carrier)) {
            carrierSelectPage.getAddCarrierModal().addCarrierByExactScac(carrier);
        }
    }

    public void navigateToAddRatesManager(UIContractDataLoad.Contract contract) throws InterruptedException {
        carrierSelectPage.navigateToContractManagementConsoleByExactScac(contract.getCarrier());
        ContractMgmtConsolePage console = new ContractMgmtConsolePage(this.getDriver());
        console.clickAddRatesButton();
        contractAddPage = new ContractAddManagerPage(this.getDriver());
        if(contract.isLcl()) {
            contractAddPage.clickAddLCLRatesLink();
        }
        Thread.sleep(500);
    }

    /**
     * Calls sub-methods that enter the required fields contained in the contract
     * object into the UI.
     * @param contract the contract with parameters to be entered into the UI
     * @throws InterruptedException
     */
    public void enterRequiredContractInfoIntoUI(UIContractDataLoad.Contract contract) throws InterruptedException {
        addContract(contract);
        Thread.sleep(500);
        addTradeLane(contract);
        Thread.sleep(500);
        addCommodityGroup(contract);
        Thread.sleep(500);
        addEffDate();
        Thread.sleep(500);
        addExpDate();
        Thread.sleep(500);
        addContainerTypes(contract);
    }

    /**
     * Calls sub-methods to add optional fields for a contract if those fields are not null.
     * @param contract the contract with optional parameters to be added through the UI.
     * @throws InterruptedException
     */
    public void enterOptionalContractInfoIntoUI(UIContractDataLoad.Contract contract) throws InterruptedException {
        if(contract.getServiceType() != null) {
            addServiceType(contract);
        }

        String serviceString = contract.getServiceString();
        if(serviceString != null) {
            addServiceString(serviceString);
        }

        // Add vessel if not null
        String vesselName = contract.getVessel();
        if(vesselName != null) {
            addVessel(vesselName);
        }

        // Add rate type if not null
        String rateType = contract.getRateType();
        if(rateType != null) {
            addRateType(rateType);
        }

        // Add rate type two if not null
        String rateTypeTwo = contract.getRateTypeTwo();
        if(rateTypeTwo != null) {
            addRateTypeTwo(rateTypeTwo);
        }

        // TODO implement adding named accounts through UI.
        // Add named account if not null
        Contract.NamedAccountGroup namedAccountGroup = contract.getNamedAccountGroup();
        if(namedAccountGroup != null) {
            addNamedAccountGroup(namedAccountGroup);
        }

        // Add Add-On if not null
        String addOn = contract.getAddOn();
        if(addOn != null) {
            addAddOn(addOn);
        }
    }

    /**
     * Opens the New Contract popup, enters the contract name and selects Add Contract.
     * TODO add ability to assign contract ownership and other contract parameters here.
     * @param contract the contract to be added through the UI.
     */
    public void addContract(UIContractDataLoad.Contract contract){
        NewContractPopup contractPopup = contractAddPage.getContractSelectPopup().getNewContractPopup();
        contractPopup.typeIntoContractNameInput(contract.getContractName());
        contractPopup.clickAddContractButton();
    }

    /**
     * Opens the New Trade Lane popup and selects the contract's trade lane option if it
     * exists, otherwise adds the trade lane and applies it.
     * @param contract the contract with trade line data to be added through the UI.
     */
    public void addTradeLane(UIContractDataLoad.Contract contract) throws InterruptedException {
        NewTradeLanePopup tradeLanePopup = contractAddPage.getTradeLaneSelectPopup().getNewTradeLanePopup();
        if(tradeLanePopup.tradeLaneExists(contract.getTradeLane())) {
            tradeLanePopup.useExistingTradeLane(contract.getTradeLane());
        } else {
            tradeLanePopup.typeIntoTradeLaneNameTextInput("U.S. to Europe");
            tradeLanePopup.clickAddTradeLaneButton();
        }
    }

    /**
     * Opens the commodity group select popup and applies the contract's commodity group argument
     * option if it exists.  Otherwise opens the New Commodity Group popup and adds a commodity group
     * based on the information in the contract's nested CommodityGroup class.
     * @param contract the contract with the CommodityGroup to be added through the UI.
     * @throws InterruptedException
     */
    public void addCommodityGroup(UIContractDataLoad.Contract contract) throws InterruptedException {
        UIContractDataLoad.Contract.CommodityGroup commGroup = contract.getCommodityGroup();
        String commGroupName = commGroup.getCommodityGroupName();

        CommGroupSelectPopup commGroupSelectPopup = contractAddPage.getCommGroupSelectPopup();

        if (commGroupSelectPopup.commGroupExists(commGroupName)) {
            commGroupSelectPopup.useExistingCommGroup(commGroupName);
        } else {
            NewCommGroupPopup commGroupPopup = commGroupSelectPopup.getNewCommGroupPopup();
            Thread.sleep(300);

            // Select commodity group type radio
            switch (commGroup.getCommodityGroupType().toLowerCase()) {
                case "global":
                    commGroupPopup.clickGlobalCommGroupRadio();
                    break;
                case "ours":
                    commGroupPopup.clickOurCommGroupRadio();
                    break;
                case "general":
                    commGroupPopup.clickGeneralCommGroupRadio();
                    break;
                default:
                    String message = "Invalid comm group type " + commGroup.getCommodityGroupType() + "for " +
                            commGroupName + "expected \"global\", \"ours\", or \"general\", case insensitive.";
                    throw new InvalidArgumentException(message);
            }

            // Add individual commodities
            for(String commodityName : commGroup.getCommodities()) {
                commGroupPopup.addCommodityByExactName(commodityName);
                Thread.sleep(300);
            }

            commGroupPopup.typeIntoCommGroupNameTextInput(commGroupName);
            // FAK is checked by default
            if(!commGroup.isFak()) {
                commGroupPopup.clickFakCheckBox();
            }

            // Select hazardous indicator
            switch (commGroup.getHazardousIndicator().toLowerCase()) {
                case "n":
                    commGroupPopup.clickNonHazardousRadio();
                    break;
                case "h":
                    commGroupPopup.clickHazardousRadio();
                    break;
                case "b":
                    commGroupPopup.clickNonHazardousAndHazardousRadio();
                    break;
                case "u":
                    commGroupPopup.clickUnspecifiedRadio();
                    break;
                default:
                    String message = "Invalid hazardous indicator " + commGroup.getCommodityGroupType() + "for " +
                            commGroupName + "expected \"n\", \"h\", \"b\", or \"u\", case insensitive.";
                    throw new InvalidArgumentException(message);
            }
            commGroupPopup.clickAddCommodityGroupButton();

            // If duplicate commodity group exists for system, select it from the popup.
            Thread.sleep(400);
            if(commGroupPopup.isDuplicateCommGroupPopupVisible()) {
                commGroupPopup.selectDuplicateCommGroupByName(commGroupName);
            }
        }
    }

    public void addEffDate() throws InterruptedException {
        // TODO: Implement date selection, currently picks current date as effective date.
        DatePicker effDatePicker = contractAddPage.getEffDateSelectPopup().getEffDatePicker();
        Thread.sleep(500);
        effDatePicker.clickSelectedDate();
        Thread.sleep(500);
        contractAddPage.getEffDateSelectPopup().clickAddDateButton();
    }

    public void addExpDate() throws InterruptedException {
        // TODO: Implement date selection, currently picks one month from today as expiration date.
        DatePicker expDatePicker = contractAddPage.getExpDateSelectPopup().getExpDatePicker();
        Thread.sleep(500);
        expDatePicker.clickNextMonthButton();
        expDatePicker.clickSelectedDate();
        Thread.sleep(300);
        contractAddPage.getExpDateSelectPopup().clickAddExpirationDateButton();
    }

    public void addContainerTypes(UIContractDataLoad.Contract contract) {
        if(contract.isLcl()){
            LCLUnitSelectPopup unitSelectPopup = contractAddPage.getLCLUnitSelectPopup();
            for(String unitType : contract.getContainerTypes()) {
                unitSelectPopup.selectUnitType(unitType);
            }
            unitSelectPopup.clickSelectButton();
        } else {
            ContainerSelectPopup containerSelectPopup = contractAddPage.getContainerSelectPopup();
            for(String containerType : contract.getContainerTypes()) {
                containerSelectPopup.selectContainerType(containerType);
            }
            containerSelectPopup.clickSelectButton();
        }

    }

    /**
     * Opens the Service Type popup, selects the contract's serviceType option, and applies it.
     * @param contract the contract with the service type to be applied.
     * @throws InterruptedException
     */
    public void addServiceType(UIContractDataLoad.Contract contract) throws InterruptedException {
        ServiceTypeSelectPopup serviceTypeSelectPopup = contractAddPage.getServiceTypeSelectPopup();
        Thread.sleep(300);
        serviceTypeSelectPopup.selectServiceType(contract.getServiceType());
        serviceTypeSelectPopup.clickSelectButton();
    }

    /**
     * Opens the Service String popup, selects and applies the serviceString argument's option if it
     * exists, otherwise opens the New Service String popup and adds it.
     * @param serviceString the service string to be added or selected.
     * @throws InterruptedException
     */
    public void addServiceString(String serviceString) throws InterruptedException {
        ServiceStringSelectPopup serviceStringSelectPopup = contractAddPage.getServiceStringSelectPopup();
        Thread.sleep(500);

        if(serviceStringSelectPopup.serviceStringExists(serviceString)) {
            serviceStringSelectPopup.useExistingServiceString(serviceString);
        } else {
            serviceStringSelectPopup.getNewServiceStringPopup().addNewServiceString(serviceString);
        }
    }

    /**
     * Opens the Vessel popup, selects and applies the vesselName argument's option if it
     * exists, otherwise opens the New Vessel popup and adds it.
     * @param vesselName the vessel to be added or selected.
     * @throws InterruptedException
     */
    public void addVessel(String vesselName) throws InterruptedException {
        VesselSelectPopup vesselSelectPopup = contractAddPage.getVesselSelectPopup();
        Thread.sleep(300);
        if(vesselSelectPopup.vesselExists(vesselName)) {
            vesselSelectPopup.useExistingVessel(vesselName);
        } else {
            vesselSelectPopup.getNewVesselPopup().addNewVessel(vesselName);
        }
    }

    /**
     * Opens the Rate Type popup, selects and applies the rateType argument's option if it
     * exists, otherwise opens the New Rate Type popup and adds it.
     * @param rateType the rate type to be added or selected.
     * @throws InterruptedException
     */
    public void addRateType(String rateType) throws InterruptedException {
        RateTypeSelectPopup rateTypeSelectPopup = contractAddPage.getRateTypeSelectPopup();
        Thread.sleep(300);
        if(rateTypeSelectPopup.rateTypeExists(rateType)){
            rateTypeSelectPopup.useExistingRateType(rateType);
        } else {
            rateTypeSelectPopup.getNewRateTypePopup().addNewRateType(rateType);
        }
    }

    public void addRateTypeTwo(String rateTypeTwo) throws InterruptedException {
        RateTypeTwoSelectPopup rateTypeTwoSelectPopup = contractAddPage.getRateTypeTwoSelectPopup();
        Thread.sleep(300);
        if(rateTypeTwoSelectPopup.rateTypeTwoExists(rateTypeTwo)){
            rateTypeTwoSelectPopup.useExistingRateTypeTwo(rateTypeTwo);
        } else {
            rateTypeTwoSelectPopup.getNewRateTypeTwoPopup().addNewRateTypeTwo(rateTypeTwo);
        }
    }

    public void addNamedAccountGroup(Contract.NamedAccountGroup namedAccountGroup) throws InterruptedException {
        NamedAccountGroupSelectPopup selectPopup = contractAddPage.getNamedAccountSelectPopup();
        Thread.sleep(300);
        if(selectPopup.namedAccountExists(namedAccountGroup.getNamedAccountGroupName())) {
            selectPopup.useExistingNamedAccount(namedAccountGroup.getNamedAccountGroupName());
        } else {
            selectPopup.getNewNamedAccountGroupPopup().addNewNamedAccountGroup(namedAccountGroup);
        }
    }

    /**
     * Opens addOnSelect popup, selects the addOn argument option and applies it.
     * @param addOn the Add-On to be selected.
     * @throws InterruptedException
     */
    public void addAddOn(String addOn) throws InterruptedException {
        AddOnSelectPopup addOnSelectPopup = contractAddPage.getAddOnSelectPopup();
        Thread.sleep(300);
        addOnSelectPopup.selectAddOn(addOn);
        addOnSelectPopup.clickSelectButton();
    }

    /**
     * Opens the PortRampDoor UI and then enters origins / destination pairs with rates.
     * The order the data is entered is respective to the order in the JSON the contract
     * object was created from.
     * @param contract contract object with origins, destinations, and rates to enter.
     * @throws InterruptedException
     */
    public void enterRatesIntoUI(UIContractDataLoad.Contract contract) throws InterruptedException {

        ThroughRatesInput rateInput = contractAddPage.getThroughRatesInput();
        Thread.sleep(300);

        UIContractDataLoad.Contract.Origin[] origins = contract.getOrigins();
        for(int i = 0; i < origins.length; i ++) {
            rateInput.assignPortToOriginForRow(origins[i].getOrigin(), i);
            String routing = origins[i].getRouting();
            if(routing != null) {
                rateInput.assignPOLForRowByExactName(routing, i);
            }
            Thread.sleep(300);
        }

        UIContractDataLoad.Contract.Destination[] destinations = contract.getDestinations();
        for(int i = 0; i < destinations.length; i ++) {
            rateInput.assignPortToDestinationForRow(destinations[i].getDestination(), i);
            Thread.sleep(300);
            String routing = destinations[i].getRouting();
            if(routing != null) {
                rateInput.assignPODForRowByExactName(routing, i);
            }
        }

        int rateIterator = 0;
        for(int i = 0; i < origins.length; i ++) {
            for(int j = 0; j < contract.getContainerTypes().length; j++) {
                rateInput.enterRateIntoCell(contract.getRates()[rateIterator], i, j);
                rateIterator++;
            }
        }
    }

    public void doSurchargeLoad(Contract contract) throws InterruptedException {
        SurchargeData surchargesData = contract.getSurchargeData();
        if(surchargesData != null) {
            doLevelOneSurchargeLoad(contract);
        }
    }

    public void doLevelOneSurchargeLoad(Contract contract) throws InterruptedException {
        LevelOneSurcharge[] levelOneSurcharges = contract.getSurchargeData().getLevelOneSurcharges();
        if(levelOneSurcharges.length > 0){
            LevelOneSurchargeLoader loader = new LevelOneSurchargeLoader(this.getDriver(), carrierSelectPage);
            loader.navigateToAddSurchargeConsoleForContract(contract);
            loader.addContractSurchargesThroughUI(levelOneSurcharges);
        }
    }

    private Connection getConn () throws SQLException, IOException {

        Map<String, String> env = System.getenv();

        String dbHost = env.get("TEST_DB_HOST") == null ? "localhost" : env.get("TEST_DB_HOST");
        String dbName = env.get("TEST_DB_NAME") == null ? "local" : env.get("TEST_DB_NAME");
        String dbPort = env.get("TEST_DB_PORT") == null ? "5433" : env.get("TEST_DB_PORT");
        String dbUser = env.get("TEST_DB_USER") == null ? "postgres" : env.get("TEST_DB_USER");
        String dbPass = env.get("TEST_DB_PASS") == null ? "cs123" : env.get("TEST_DB_PASS");

        String connString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Properties connectionProps = new Properties();
        connectionProps.put("user", dbUser);
        connectionProps.put("password", dbPass);

        return DriverManager.getConnection(connString, connectionProps);
    }
}
