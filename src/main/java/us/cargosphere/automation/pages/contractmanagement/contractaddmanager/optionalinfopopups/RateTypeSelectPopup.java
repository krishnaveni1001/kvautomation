package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class RateTypeSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement newRateTypeSelect;
    @FindBy(how = How.ID, using = "rateTypeSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "rateTypeClose")
    private WebElement closeButton;

    public RateTypeSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickNewRateTypeSelect() {
        newRateTypeSelect.click();
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewRateType() {
        clickNewRateTypeSelect();
        clickSelectButton();
    }

    public NewRateTypePopup getNewRateTypePopup() {
        clickNewRateTypeSelect();
        clickSelectButton();
        return new NewRateTypePopup(webDriver,
                webDriver.findElement(By.id("divRateTypeNew")));
    }

    /**
     * Checks if the argument string is an existing rateType in existing Rate Type select.
     * @param rateType the rate type to check for.
     * @return true if the rateType argument is found in the existing Rate Type select.
     */
    public boolean rateTypeExists(String rateType) {
        Select select = new Select(webDriver.findElement(By.id("selRateTypes")));
        for(WebElement option : select.getOptions()){
            if(option.getAttribute("innerText").equals(rateType))
                return true;
        }
        return false;
    }

    /**
     * Selects an existing rate type option that matches the argument String and
     * clicks the select button.
     * @param rateType the existing rate type to select.
     */
    public void useExistingRateType(String rateType) {
        Select select = new Select(webDriver.findElement(By.id("selRateTypes")));
        select.selectByValue(rateType);
        clickSelectButton();
    }

}
