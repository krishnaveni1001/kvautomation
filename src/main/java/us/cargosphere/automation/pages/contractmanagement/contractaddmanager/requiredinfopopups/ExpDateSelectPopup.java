package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.common.DatePicker;

public class ExpDateSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement addNewExpirationDateOption;
    @FindBy(how = How.ID, using = "expDateSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "expDateClose")
    private WebElement closeButton;
    @FindBy(how = How.ID, using = "addExpDate")
    private WebElement addExpirationDateButton;

    public ExpDateSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
        // PageFactory.initElements(webDriver, this);
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void clickAddExpirationDateButton() {
        try {
            webDriver.findElement(By.id("addExpDate")).click();
        } catch (NoSuchElementException e) {
            String message = "Add Effective Date button not found, it may not be visible in the UI.";
            throw new IllegalStateException(message);
        }
    }

    public DatePicker getExpDatePicker () {
        addNewExpirationDateOption.click();
        selectButton.click();
        return new DatePicker(webDriver,
                webDriver.findElement(By.id("theDatePicker")));
    }

}
