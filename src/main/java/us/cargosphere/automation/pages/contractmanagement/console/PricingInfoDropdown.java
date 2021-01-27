package us.cargosphere.automation.pages.contractmanagement.console;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class PricingInfoDropdown extends BasePage {

    @FindBy(how = How.CSS, using = "#subPricingInfo > li:nth-child(1) > a")
    private WebElement baseRatesGRIAndMinsButton;
    @FindBy(how = How.ID, using = "surchargeViewAddDel")
    private WebElement surchargeViewAndAddUpdateDeleteButton;
    @FindBy(how = How.ID, using = "surchargeAddOnly")
    private WebElement surchargeAddOnlyButton;
    @FindBy(how = How.ID, using = "surchargePerShip")
    private WebElement surchargesPerShipmentBOLButton;
    @FindBy(how = How.ID, using = "specialEquipment")
    private WebElement specialEquipmentButton;

    public PricingInfoDropdown (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickSurchargeAddOnlyButton () {
        surchargeAddOnlyButton.click();
    }

}
