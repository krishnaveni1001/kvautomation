package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class CommGroupSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement addNewCommGroupOption;
    @FindBy(how = How.ID, using = "commGroupSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "commGroupClose")
    private WebElement closeButton;

    public CommGroupSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public NewCommGroupPopup getNewCommGroupPopup () {
        addNewCommGroupOption.click();
        selectButton.click();
        return new NewCommGroupPopup(webDriver,
                webDriver.findElement(By.id("divCommGroupNewSelect")));
    }

    public void clickCommGroupOption (int n) {
        try {
            WebElement option = webDriver.findElement(By.id("option" + n));
        } catch (NoSuchElementException e) {
            throw new InvalidArgumentException("Commodity group option " + n + " does not exist");
        }
    }

    /**
     * Checks if the argument string is an existing service string in existing Commodity Group select.
     * @param commGroupName the commodity group name to check for.
     * @return true if the commodity group name argument is found in the existing Commodity Group select.
     */
    public boolean commGroupExists(String commGroupName) {
        Select select = new Select(webDriver.findElement(By.id("selCommodityGrpIds")));
        for(WebElement option : select.getOptions()){
            if(option.getAttribute("innerText").equals(commGroupName))
                return true;
        }
        return false;
    }

    /**
     * Selects an existing Commodity Group option that matches the argument String and
     * clicks the select button.
     * @param commGroupName the existing commodity group to select.
     */
    public void useExistingCommGroup(String commGroupName) {
        Select select = new Select(webDriver.findElement(By.id("selCommodityGrpIds")));
        select.selectByValue(commGroupName);
        clickSelectButton();
    }
}
