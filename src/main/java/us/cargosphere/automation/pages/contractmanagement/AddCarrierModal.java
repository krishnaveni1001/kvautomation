package us.cargosphere.automation.pages.contractmanagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class AddCarrierModal extends BasePage {

    @FindBy(how = How.CSS, using = "#uiSelectCarrier > div:nth-child(2) > div > div.ui-select-match.ng-scope > span")
    private WebElement scacSearchBar;
    @FindBy(how = How.XPATH, using = "//*[@id=\"uiSelectCarrier\"]/div[1]/div/input[1]")
    private WebElement scacSearchBarInput;
    @FindBy(how = How.ID, using = "ui-select-choices-0")
    private WebElement scacSearchResultsElement;
    @FindBy(how = How.ID, using = "selectCarrierName")
    private WebElement carrierNameInput;
    @FindBy(how = How.ID, using = "contactName")
    private WebElement contactNameInput;
    @FindBy(how = How.ID, using = "emailAddress")
    private WebElement notificationEmailInput;
    @FindBy(how = How.ID, using = "carrierCancel")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "carrierAdd")
    private WebElement addCarrierButton;


    public AddCarrierModal (WebDriver driver, WebElement el) {
        super(driver, el);
    }

    /**
     * Add a carrier by entering the scacId argument into the modal's scac search bar
     * and then selecting the first result.  Requires exact SCAC because the first search
     * result will be used.
     * @param scacID the exact SCAC ID of the carrier to be added
     */
    public void addCarrierByExactScac(String scacID) throws InterruptedException {
        scacSearchBar.click();
        Thread.sleep(500);
        scacSearchBarInput.sendKeys(scacID);
        scacSearchBarInput.sendKeys(Keys.ENTER);
        addCarrierButton.click();
        Thread.sleep(500);
        webDriver.switchTo().alert().accept();
    }
}
