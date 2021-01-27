package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class NamedAccountGroupSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement newNamedAcctGroupSelect;
    @FindBy(how = How.ID, using = "namedAcctSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "namedAcctClose")
    private WebElement closeButton;

    public NamedAccountGroupSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickNewNamedAcctGroupSelect() {
        newNamedAcctGroupSelect.click();
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewNamedAcctGroup() {
        clickNewNamedAcctGroupSelect();
        clickSelectButton();
    }


    public NewNamedAccountGroupPopup getNewNamedAccountGroupPopup() throws InterruptedException {
        addNewNamedAcctGroup();
        Thread.sleep(300);
        return new NewNamedAccountGroupPopup(webDriver,
                webDriver.findElement(By.id("divNamedAcctNewSelect")));
    }

    /**
     * Checks if the argument string is an existing named account in existing Named Account Group select.
     * @param namedAccount the rate type to check for.
     * @return true if the namedAccount argument is found in the existing Named Account Group select.
     */
    public boolean namedAccountExists(String namedAccount) {
        Select select = new Select(webDriver.findElement(By.id("selNamedAcctGrpIds")));
        for(WebElement option : select.getOptions()){
            if(option.getAttribute("innerText").equals(namedAccount))
                return true;
        }
        return false;
    }

    /**
     * Selects an existing named account option that matches the argument String and
     * clicks the select button.
     * @param namedAccount the existing named account to select.
     */
    public void useExistingNamedAccount(String namedAccount) {
        Select select = new Select(webDriver.findElement(By.id("selNamedAcctGrpIds")));
        select.selectByValue(namedAccount);
        clickSelectButton();
    }
}
