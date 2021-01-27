package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ContractSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement addNewContractOption;
    @FindBy(how = How.ID, using = "contractSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "contractClose")
    private WebElement closeButton;

    public ContractSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddNewContractOption() {
        addNewContractOption.click();
    }

    public void clickContractSelectButton() {
        selectButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public NewContractPopup getNewContractPopup() {
        addNewContractOption.click();
        selectButton.click();
        return new NewContractPopup(webDriver,
                webDriver.findElement(By.id("divContractNew")));
    }

}
