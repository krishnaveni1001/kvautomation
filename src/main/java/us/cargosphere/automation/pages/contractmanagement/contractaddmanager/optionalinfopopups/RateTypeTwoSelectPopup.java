package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class RateTypeTwoSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement newRateTypeTwoSelect;
    @FindBy(how = How.ID, using = "rateTypeTwoSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "rateTypeTwoClose")
    private WebElement closeButton;

    public RateTypeTwoSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickNewRateTypeTwoSelect() {
        newRateTypeTwoSelect.click();
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewRateTypeTwo() {
        clickNewRateTypeTwoSelect();
        clickSelectButton();
    }

    public NewRateTypeTwoPopup getNewRateTypeTwoPopup() {
        clickNewRateTypeTwoSelect();
        clickSelectButton();
        return new NewRateTypeTwoPopup(webDriver,
                webDriver.findElement(By.id("divRateTypeTwoNew")));
    }

    /**
     * Checks if the argument string is an existing rate type two in existing Rate Type Two select.
     * @param rateTypeTwo the rate type to check for.
     * @return true if the rateTypeTwo argument is found in the existing Rate Type Two select.
     */
    public boolean rateTypeTwoExists(String rateTypeTwo) {
        Select select = new Select(webDriver.findElement(By.id("selRateTypesTwo")));
        for(WebElement option : select.getOptions()){
            if(option.getAttribute("innerText").equals(rateTypeTwo))
                return true;
        }
        return false;
    }

    /**
     * Selects an existing rate type two option that matches the argument String and
     * clicks the select button.
     * @param rateTypeTwo the existing rate type two to select.
     */
    public void useExistingRateTypeTwo(String rateTypeTwo) {
        Select select = new Select(webDriver.findElement(By.id("selRateTypesTwo")));
        select.selectByValue(rateTypeTwo);
        clickSelectButton();
    }
}
