package us.cargosphere.automation.pages.contractmanagement.console;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

public class ContractMgmtConsolePage extends BasePage {

    @FindBy(how = How.ID, using = "toAddRates")
    private WebElement addRatesButton;
    @FindBy(how = How.ID, using = "pricingInfoDropDown")
    private WebElement pricingInfoButton;
    @FindBy(how = How.ID, using = "openContractFilter")
    private WebElement ratePackageButton;
    @FindBy(how = How.ID, using = "divContractFilter")
    private WebElement contractSelectPopup;

    public ContractMgmtConsolePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddRatesButton() {
        addRatesButton.click();
    }

    public PricingInfoDropdown getPricingInfoDropdown() throws InterruptedException {

        WebElement dropdownElement = webDriver.findElement(By.id("subPricingInfo"));
        if (!dropdownElement.isDisplayed()) {
           clickPricingInfoButton();
           Thread.sleep(400);
        }
        return new PricingInfoDropdown(webDriver, dropdownElement);

    }

    public void clickPricingInfoButton () {
        pricingInfoButton.click();
    }

    public ContractSelectPopup getContractSelectPopup () {
        if(!contractSelectPopup.isDisplayed()){
            ratePackageButton.click();
        }
        return new ContractSelectPopup(webDriver, contractSelectPopup);
    }
}
