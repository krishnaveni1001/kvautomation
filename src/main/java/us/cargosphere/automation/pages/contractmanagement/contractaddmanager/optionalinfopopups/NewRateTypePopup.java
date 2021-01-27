package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class NewRateTypePopup extends BasePage {

    @FindBy(how = How.CSS, using = "#divRateTypeNew > table > tbody > tr:nth-child(1) > td.smallNonBoldBlack > div > input")
    private WebElement useExistingButton;
    @FindBy(how = How.ID, using = "selNewRateTypes")
    private WebElement existingRateTypeSelect;
    @FindBy(how = How.ID, using = "newRateType")
    private WebElement newRateTypeTextInput;
    @FindBy(how = How.CSS, using = "#divRateTypeNew > div > input:nth-child(1)")
    private WebElement addNewRateTypeButton;
    @FindBy(how = How.CSS, using = "#divRateTypeNew > div > input:nth-child(2)")
    private WebElement closeButton;

    public NewRateTypePopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickUseExistingButton() {
        useExistingButton.click();
    }

    public void clickExistingRateTypeSelect() {
        existingRateTypeSelect.click();
    }

    public void clickNewRateTypeTextInput() {
        newRateTypeTextInput.click();
    }

    public void typeIntoNewRateTypeTextInput(String rateType) {
        newRateTypeTextInput.sendKeys(rateType);
    }

    public void clickAddNewRateTypeButton() {
        addNewRateTypeButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewRateType(String rateType) {
        clickNewRateTypeTextInput();
        typeIntoNewRateTypeTextInput(rateType);
        clickAddNewRateTypeButton();
    }


}
