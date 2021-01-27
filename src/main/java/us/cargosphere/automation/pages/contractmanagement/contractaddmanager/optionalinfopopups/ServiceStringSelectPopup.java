package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups.NewTradeLanePopup;

public class ServiceStringSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement newServiceStringSelect;
    @FindBy(how = How.ID, using = "serStringSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "serStringClose")
    private WebElement closeButton;

    public ServiceStringSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickNewServiceStringSelect () {
        newServiceStringSelect.click();
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewServiceString() {
        clickNewServiceStringSelect();
        clickSelectButton();
    }

    public NewServiceStringPopup getNewServiceStringPopup() {
        clickNewServiceStringSelect();
        clickSelectButton();
        return new NewServiceStringPopup(webDriver,
                webDriver.findElement(By.id("divServiceStringNew")));
    }

    /**
     * Checks if the argument string is an existing service string in existing Service String select.
     * @param serviceStringName the service string to check for.
     * @return true if the service string name argument is found in the existing Service STring select.
     */
    public boolean serviceStringExists(String serviceStringName) {
        Select select = new Select(webDriver.findElement(By.id("selServiceStrings")));
        for(WebElement option : select.getOptions()){
            if(option.getAttribute("innerText").equals(serviceStringName))
                return true;
        }
        return false;
    }

    /**
     * Selects an existing Service String option that matches the argument String and
     * clicks the select button.
     * @param serviceStringName the existing service string to select.
     */
    public void useExistingServiceString(String serviceStringName) {
        Select select = new Select(webDriver.findElement(By.id("selServiceStrings")));
        select.selectByValue(serviceStringName);
        clickSelectButton();
    }

}
