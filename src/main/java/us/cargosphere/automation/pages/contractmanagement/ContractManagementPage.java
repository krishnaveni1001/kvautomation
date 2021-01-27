package us.cargosphere.automation.pages.contractmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

public class ContractManagementPage extends BasePage {

    @FindBy(how = How.CSS, using = "#primaryOcean > a")
    private WebElement primaryOceanFreightButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/div/form/div/div[2]/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td/a")
    private WebElement addPrimaryOceanFreightButton;

    public ContractManagementPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickPrimaryOceanFreightButton () {
        primaryOceanFreightButton.click();
    }

    public void clickAddPrimaryOceanFreightButton() {
        addPrimaryOceanFreightButton.click();
    }
}
