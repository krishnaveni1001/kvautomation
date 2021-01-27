package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

public class NewContractPopup extends BasePage {

    @FindBy(how = How.ID, using = "newContract")
    private WebElement newContractNameInput;
    @FindBy(how = How.ID, using = "ownership")
    private WebElement ownershipWeDoRadio;
    @FindBy(how = How.CSS, using = "#divContractNew > div:nth-child(9) > input")
    private WebElement addContractButton;

    public NewContractPopup (WebDriver driver, WebElement el) {
        super(driver, el);
        PageFactory.initElements(webDriver, this);
    }

    public void typeIntoContractNameInput (String contractName) {
        newContractNameInput.click();
        newContractNameInput.sendKeys(contractName);
    }

    public void clickOwnershipWeDoRadio () {
        ownershipWeDoRadio.click();
    }

    public void clickAddContractButton () {
        addContractButton.click();
    }
    
}
