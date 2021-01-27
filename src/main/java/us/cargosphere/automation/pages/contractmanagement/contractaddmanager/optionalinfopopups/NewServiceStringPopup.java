package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class NewServiceStringPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#divServiceStringNew > table > tbody > tr:nth-child(1) > td.smallNonBoldBlack > div > input")
    private WebElement useExistingButton;
    @FindBy(how = How.ID, using = "selNewServiceStrings")
    private WebElement existingServiceStringSelect;
    @FindBy(how = How.ID, using = "newServiceString")
    private WebElement newServiceStringTextInput;
    @FindBy(how = How.CSS, using = "#divServiceStringNew > div > input:nth-child(1)")
    private WebElement addNewServiceStringButton;
    @FindBy(how = How.CSS, using = "#divServiceStringNew > div > input:nth-child(2)")
    private WebElement closeButton;

    public NewServiceStringPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickUseExistingButton() {
        useExistingButton.click();
    }

    public void clickExistingServiceStringSelect() {
        existingServiceStringSelect.click();
    }

    public void clickNewServiceStringTextInput() {
        newServiceStringTextInput.click();
    }

    public void typeIntoNewServiceStringTextInput(String serviceString) {
        newServiceStringTextInput.sendKeys(serviceString);
    }

    public void clickAddNewServiceStringButton () {
        addNewServiceStringButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewServiceString(String serviceString) {
        clickNewServiceStringTextInput();
        typeIntoNewServiceStringTextInput(serviceString);
        clickAddNewServiceStringButton();
    }

}
