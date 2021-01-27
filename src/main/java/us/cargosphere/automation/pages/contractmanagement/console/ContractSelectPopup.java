package us.cargosphere.automation.pages.contractmanagement.console;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class ContractSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "selContractGrpIds")
    private WebElement selectElement;
    @FindBy(how = How.ID, using = "selectAContract")
    private WebElement selectButton;

    public ContractSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void selectContractByName (String contractName) throws InterruptedException {
        Select contractSelect = new Select(selectElement);
        contractSelect.selectByVisibleText(contractName);
        Thread.sleep(100);
        clickSelectButton();
        Thread.sleep(500);
    }

}
