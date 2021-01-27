package us.cargosphere.automation.pages.contractmanagement.contractaddmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups.*;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups.*;

public class ContractAddManagerPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/a[1]")
    private WebElement changeCompaniesLink;
    @FindBy(how = How.CSS, using = "body > form > div:nth-child(3) > div:nth-child(2) > table > tbody > tr > td:nth-child(3) > a")
    private WebElement addLCLRatesLink;

    // Required information popup buttons
    @FindBy(how = How.CSS, using = "#spnContractSelect > a")
    private WebElement contractButton;
    @FindBy(how = How.CSS, using = "#spnTradeLaneSelect > a")
    private WebElement tradeLaneButton;
    @FindBy(how = How.CSS, using = "#spnCommGrpSelect > a")
    private WebElement commGrpButton;
    @FindBy(how = How.CSS, using = "#spnEffDateSelect > a")
    private WebElement effDateButton;
    @FindBy(how = How.CSS, using = "#spnExpDateSelect > a")
    private WebElement expDateButton;
    @FindBy(how = How.CSS, using = "#spnUnitTypeSelect > a")
    private WebElement containerUnitTypeButton;

    // Optional information popup buttons
    @FindBy(how = How.CSS, using = "#spnServiceTypeSelect > a")
    private WebElement serviceTypeButton;
    @FindBy(how = How.CSS, using = "#spnServiceStringSelect > a")
    private WebElement serviceStringButton;
    @FindBy(how = How.CSS, using = "#spnVesselSelect > a")
    private WebElement vesselButton;
    @FindBy(how = How.CSS, using = "#spnRateTypeSelect > a")
    private WebElement rateTypeButton;
    @FindBy(how = How.CSS, using = "#spnNamedAcctSelect > a")
    private WebElement namedAcctButton;
    @FindBy(how = How.CSS, using = "#spnRateTypeTwoSelect > a")
    private WebElement rateTypeTwoButton;
    @FindBy(how = How.CSS, using = "#spnArbsSelect > a")
    private WebElement addOnButton;

    // Action buttons
    @FindBy(how = How.CSS, using = "#inputFormat > span")
    private WebElement inputFormatButton;
    @FindBy(how = How.CSS, using = "#submitRates")
    private WebElement submitRatesButton;
    @FindBy(how = How.ID, using = "showHideInd")
    private WebElement doNotDisplayRatesImmediatelyCheckbox;

    // Input format options
    @FindBy(how = How.ID, using = "portRampRates")
    private WebElement portRampRatesOption;
    @FindBy(how = How.ID, using = "throughRates")
    private WebElement throughRatesOption;
    @FindBy(how = How.ID, using = "matrix")
    private WebElement matrixOption;

    public ContractAddManagerPage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickChangeCompaniesLink() {
        changeCompaniesLink.click();}

    public void clickAddLCLRatesLink() {
        addLCLRatesLink.click();
    }

    public void clickContractButton() {
        contractButton.click();
    }

    public void clickTradeLaneButton() {
        tradeLaneButton.click();
    }

    public void clickCommGrpButton() {
        commGrpButton.click();
    }

    public void clickEffDateButton () {
        effDateButton.click();
    }

    public void clickExpDateButton () {
        expDateButton.click();
    }

    public void clickContainerUnitTypeButton () {
        containerUnitTypeButton.click();
    }

    public void clickServiceTypeButton () {
        serviceTypeButton.click();
    }

    public void clickServiceStringButton () {
        serviceStringButton.click();
    }

    public void clickVesselButton() {
        vesselButton.click();
    }

    public void clickRateTypeButton () {
        rateTypeButton.click();
    }

    public void clickNamedAcctButton () {
        namedAcctButton.click();
    }

    public void clickRateTypeTwoButton () {
        rateTypeTwoButton.click();
    }

    public void clickAddOnButton () {
        addOnButton.click();
    }

    public void clickSubmitRatesButton () { submitRatesButton.click(); }

    public ContractSelectPopup getContractSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divContractSelect"));
        if(!popupElement.isDisplayed()){
            contractButton.click();
        }
        return new ContractSelectPopup(webDriver, popupElement);
    }

    public TradeLaneSelectPopup getTradeLaneSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divTradeLaneSelect"));
        if(!popupElement.isDisplayed()){
            tradeLaneButton.click();
        }
        return new TradeLaneSelectPopup(webDriver, popupElement);
    }

    public CommGroupSelectPopup getCommGroupSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divCommGroupSelect"));
        if(!popupElement.isDisplayed()){
            commGrpButton.click();
        }
        return new CommGroupSelectPopup(webDriver, popupElement);
    }

    public EffDateSelectPopup getEffDateSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divEffDateSelect"));
        if(!popupElement.isDisplayed()){
            effDateButton.click();
        }
        return new EffDateSelectPopup(webDriver, popupElement);
    }

    public ExpDateSelectPopup getExpDateSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divExpDateSelect"));
        if(!popupElement.isDisplayed()){
            expDateButton.click();
        }
        return new ExpDateSelectPopup(webDriver, popupElement);
    }

    public ContainerSelectPopup getContainerSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divUnitTypeSelect"));
        if(!popupElement.isDisplayed()){
            containerUnitTypeButton.click();
        }
        return new ContainerSelectPopup(webDriver, popupElement);

    }

    public LCLUnitSelectPopup getLCLUnitSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divUnitTypeSelect"));
        if(!popupElement.isDisplayed()) {
            containerUnitTypeButton.click();
        }
        return new LCLUnitSelectPopup(webDriver, popupElement);
    }

    public ServiceTypeSelectPopup getServiceTypeSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divServiceTypeSelect"));
        if(!popupElement.isDisplayed()){
            serviceTypeButton.click();
        }
        return new ServiceTypeSelectPopup(webDriver, popupElement);

    }

    public ServiceStringSelectPopup getServiceStringSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divServiceStringSelect"));
        if(!popupElement.isDisplayed()){
            serviceStringButton.click();
        }
        return new ServiceStringSelectPopup(webDriver, popupElement);

    }

    public VesselSelectPopup getVesselSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divVesselSelect"));
        if(!popupElement.isDisplayed()){
            vesselButton.click();
        }
        return new VesselSelectPopup(webDriver, popupElement);

    }

    public RateTypeSelectPopup getRateTypeSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divRateTypeSelect"));
        if(!popupElement.isDisplayed()){
            rateTypeButton.click();
        }
        return new RateTypeSelectPopup(webDriver, popupElement);

    }

    public NamedAccountGroupSelectPopup getNamedAccountSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divNamedAcctGroupSelect"));
        if(!popupElement.isDisplayed()){
            namedAcctButton.click();
        }
        return new NamedAccountGroupSelectPopup(webDriver, popupElement);

    }

    public RateTypeTwoSelectPopup getRateTypeTwoSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divRateTypeTwoSelect"));
        if(!popupElement.isDisplayed()){
            rateTypeTwoButton.click();
        }
        return new RateTypeTwoSelectPopup(webDriver, popupElement);

    }

    public AddOnSelectPopup getAddOnSelectPopup () {
        WebElement popupElement = webDriver.findElement(By.id("divArbsSelect"));
        if(!popupElement.isDisplayed()){
            addOnButton.click();
        }
        return new AddOnSelectPopup(webDriver, popupElement);

    }

    public PortRampDoorRatesInput getPortRampDoorRatesInput () {
        WebElement inputDiv = webDriver.findElement(By.id("tabPorts"));
        if(!inputDiv.isDisplayed()){
            inputFormatButton.click();
            portRampRatesOption.click();
        }
        return new PortRampDoorRatesInput(webDriver,
                webDriver.findElement(By.id("tabPorts")));
    }

    public ThroughRatesInput getThroughRatesInput () {
        WebElement inputDiv = webDriver.findElement(By.id("tabPorts"));
        if(!inputDiv.isDisplayed()){
            inputFormatButton.click();
            throughRatesOption.click();
        }
        return new ThroughRatesInput(webDriver,
                webDriver.findElement(By.id("tabODRouting")));
    }
}
