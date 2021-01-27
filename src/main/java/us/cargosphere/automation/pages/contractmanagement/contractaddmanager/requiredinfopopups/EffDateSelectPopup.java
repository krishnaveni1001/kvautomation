package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.common.DatePicker;

public class EffDateSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement addNewEffectiveDateOption;
    @FindBy(how = How.ID, using = "effDateSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "effDateClose")
    private WebElement closeButton;
    @FindBy(how = How.ID, using = "addEffDate")
    private WebElement addDateButton;


    public EffDateSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickSelectButton() {
        selectButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void clickAddDateButton() {
        try {
            webDriver.findElement(By.id("addEffDate")).click();
        } catch (NoSuchElementException e) {
            String message = "Add Effective Date button not found, it may not be visible in the UI.";
            throw new IllegalStateException(message);
        }
    }

    public DatePicker getEffDatePicker() {
        addNewEffectiveDateOption.click();
        selectButton.click();
        return new DatePicker(webDriver,
                webDriver.findElement(By.id("theDatePicker")));
    }
}
