package us.cargosphere.automation.dataload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import us.cargosphere.automation.domain.UIContractDataLoad.Contract;
import us.cargosphere.automation.domain.UIContractDataLoad.Contract.SurchargeData.LevelOneSurcharge;
import us.cargosphere.automation.pages.common.DatePicker;
import us.cargosphere.automation.pages.contractmanagement.CarrierSelectPage;
import us.cargosphere.automation.pages.contractmanagement.addsurchargeconsole.AmendmentPopup;
import us.cargosphere.automation.pages.contractmanagement.addsurchargeconsole.ContractAddSurchargesPage;
import us.cargosphere.automation.pages.contractmanagement.console.ContractMgmtConsolePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class LevelOneSurchargeLoader {

    private final WebDriver webDriver;
    private final CarrierSelectPage carrierSelectPage;
    private ContractAddSurchargesPage addSurchargesPage;

    public LevelOneSurchargeLoader(WebDriver webDriver, CarrierSelectPage carrierSelectPage) {
        if(carrierSelectPage == null) {
            throw new IllegalStateException("Carrier select page is null. Surcharge Loader must be" +
                    "initialized on the carrier select page");
        }
        this.webDriver = webDriver;
        this.carrierSelectPage = carrierSelectPage;
    }

    /**
     * Navigates from the CarrierSelectPage to the ContractAddSurchargesPage.
     * @param contract contract to navigate to the AddSurchargesPage for.
     * @throws InterruptedException
     */
    public void navigateToAddSurchargeConsoleForContract(Contract contract) throws InterruptedException {
        carrierSelectPage.navigateToContractManagementConsoleByExactScac(contract.getCarrier());
        ContractMgmtConsolePage contractMgmtConsolePage = new ContractMgmtConsolePage(webDriver);
        Thread.sleep(300);
        contractMgmtConsolePage.getContractSelectPopup().selectContractByName(contract.getContractName());
        contractMgmtConsolePage.getPricingInfoDropdown().clickSurchargeAddOnlyButton();
        this.addSurchargesPage = new ContractAddSurchargesPage(webDriver);
    }

    /**
     * Inputs the contract surcharges row by row into the ContractAddSurchargesPage inputs,
     * submits the surcharges, and then returns to the carrier select page for the contract
     * load process to continue.
     * @param surcharges array of surcharges to be loaded through the UI
     * @throws InterruptedException
     */
    public void addContractSurchargesThroughUI(LevelOneSurcharge[] surcharges) throws InterruptedException {
        if (addSurchargesPage == null) {
            throw new IllegalStateException("Must have called navigateToAddSurchargeConsoleForContract");
        }

        for(int i = 0; i < surcharges.length; i++) {
            loadSurchargeDataIntoRow(surcharges[i], i);
        }

        addDates();
        addSurchargesPage.clickAddButton();
        Thread.sleep(400);
        handleAmendmentPopup();

        NavigationMenuBar navBar = new NavigationMenuBar(webDriver);
        navBar.getRateMgmtNav().clickChooseCarrierLink();
    }

    /**
     * Inputs the fields of the Surcharge argument into an input row.
     * @param surcharge The surcharge object used to populate fields.
     * @param rowNum The row number of input values.
     */
    public void loadSurchargeDataIntoRow(LevelOneSurcharge surcharge, int rowNum) {
        addSurchargesPage.addTermToRow(surcharge.getTerm(), rowNum);
        addSurchargesPage.selectSurchargeTypeForRow(surcharge.getApplicability(), rowNum);
        addSurchargesPage.selectSurchargeCategoryForRow(surcharge.getCategory(), rowNum);
        addSurchargesPage.selectPriceByForRow(surcharge.getPriceBy(), rowNum);
        addSurchargesPage.addSurchargeAmountToRow(surcharge.getAmount(), rowNum);
        addSurchargesPage.selectCurrencyForRow(surcharge.getCurrency(), rowNum);
        addSurchargesPage.selectExcludeFromTotalRateValue(surcharge.getExcludeFromTotal(), rowNum);
        addSurchargesPage.selectContainerType(surcharge.getContainerType(), rowNum);
        addSurchargesPage.selectOrigin(surcharge.getOrigin(), rowNum);
        addSurchargesPage.selectDestination(surcharge.getDestination(), rowNum);
    }

    /**
     * Sets the effective date in the New Effective Date field to the current date
     * and sets the expiration date in the New Expiration Date to a month from the current
     * date.  TODO implement the accepting of dates as arguments.
     */
    public void addDates () {
        addSurchargesPage.getEffDatePicker().clickSelectedDate();
        DatePicker expDatePicker = addSurchargesPage.getExpDatePicker();
        expDatePicker.clickNextMonthButton();
        expDatePicker.clickSelectedDate();
    }

    /**
     * Clicks the skip button in the amendment popup and then waits
     * one second for application to return to contract management console.
     * TODO implement the amendment popup fields.
     */
    public void handleAmendmentPopup() throws InterruptedException {
        AmendmentPopup amendmentPopup = new AmendmentPopup(webDriver,
                webDriver.findElement(By.cssSelector("body > div.modal.fade.ng-isolate-scope.in > div > div")));
        amendmentPopup.clickSkipButton();
        Thread.sleep(1000);
    }
}
