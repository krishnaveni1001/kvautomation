package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class TradeLaneSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement addNewTradeLaneOption;
    @FindBy(how = How.ID, using = "tradeLaneSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "tradeLaneClose")
    private WebElement closeButton;

    public TradeLaneSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickAddNewTradeLaneOption() {
        addNewTradeLaneOption.click();
    }

    public void clickSelectButton() {
        selectButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public NewTradeLanePopup getNewTradeLanePopup() {
        clickAddNewTradeLaneOption();
        clickSelectButton();
        return new NewTradeLanePopup(webDriver,
                webDriver.findElement(By.id("divTradeLaneNewSelect")));
    }

}
