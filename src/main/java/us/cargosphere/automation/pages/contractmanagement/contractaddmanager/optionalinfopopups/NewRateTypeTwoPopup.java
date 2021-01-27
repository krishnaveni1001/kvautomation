package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class NewRateTypeTwoPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#divRateTypeTwoNew > table > tbody > tr:nth-child(1) > td.smallNonBoldBlack > div > input")
    private WebElement useExistingButton;
    @FindBy(how = How.ID, using = "selNewRateTypes")
    private WebElement existingRateTypeTwoSelect;
    @FindBy(how = How.ID, using = "newRateTypeTwo")
    private WebElement newRateTypeTwoTextInput;
    @FindBy(how = How.CSS, using = "#divRateTypeTwoNew > div > input:nth-child(1)")
    private WebElement addNewRateTypeTwoButton;
    @FindBy(how = How.CSS, using = "#divRateTypeTwoNew > div > input:nth-child(2)")
    private WebElement closeButton;

    public NewRateTypeTwoPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickUseExistingButton() {
        useExistingButton.click();
    }

    public void clickExistingRateTypeTwoSelect() {
        existingRateTypeTwoSelect.click();
    }

    public void clickNewRateTypeTwoTextInput() {
        newRateTypeTwoTextInput.click();
    }

    public void typeIntoNewRateTypeTwoTextInput(String rateTypeTwo) {
        newRateTypeTwoTextInput.sendKeys(rateTypeTwo);
    }

    public void clickAddNewRateTypeTwoButton() {
        addNewRateTypeTwoButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void addNewRateTypeTwo(String rateTypeTwo) {
        clickNewRateTypeTwoTextInput();
        typeIntoNewRateTypeTwoTextInput(rateTypeTwo);
        clickAddNewRateTypeTwoButton();
    }

}
