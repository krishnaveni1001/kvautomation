package us.cargosphere.automation.pages.contractmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

import java.util.List;

public class CarrierSelectPage extends BasePage {

    @FindBy(how = How.ID, using = "carrierSearchInput")
    private WebElement carrierScacSearchBar;
    @FindBy(how = How.CSS, using = "#companySelectApp > div > div > div > div.BODYwrap > div > div.bootstrap-iso.ng-scope > form > div:nth-child(1) > div.row > div > div > div:nth-child(1) > span > i")
    private WebElement addCarrierButton;
    @FindBy(how = How.ID, using = "addACarrierModal")
    private AddCarrierModal addCarrierModal;
    @FindBy(how = How.CLASS_NAME, using = "consoleBtn")
    private List<WebElement> carrierConsoleButtons;

    public CarrierSelectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(webDriver, this);
    }

    public AddCarrierModal getAddCarrierModal () {
        addCarrierButton.click();
        return new AddCarrierModal(webDriver,
                webDriver.findElement(By.id("addACarrierModal")));
    }

    public void searchForCarrier(String scacID) {
        carrierScacSearchBar.click();
        carrierScacSearchBar.sendKeys(scacID);
    }

    /**
     * Enters the scacID argument into the company select page search bar and then
     * clicks the first carrier present in carrier select menu.
     * @param scacID the scac ID of the carrier to select.
     */
    public void clickConsoleButtonForExactScac(String scacID) {
        searchForCarrier(scacID);
        clicktNthCarrierConsoleButton(0);
    }

    /**
     * Enters the scacID argument into the company select page search bar and then
     * clicks the dropdown's contract management console link for the first
     * carrier in the page.
     * @param scacID the scac ID of the carrier to go to the contract management console for
     */
    public void navigateToContractManagementConsoleByExactScac(String scacID) throws InterruptedException {
        searchForCarrier(scacID);
        Thread.sleep(200);
        clicktNthCarrierConsoleButton(0);
    }

    public void clicktNthCarrierConsoleButton(int n) {
        if (carrierConsoleButtons.size() > n){
            carrierConsoleButtons.get(n).click();
        } else {
            throw new InvalidArgumentException("Provided value " + n + " is outside range of carrier rate management buttons on page.");
        }
    }

    /**
     * Searches for the provided SCAC, and if no carriers are in the carrier select menu returns false.
     * @param scacID the SCAC ID to search for
     * @return true if there are any carriers in the menu after searching for the provided SCAC ID.
     */
    public boolean carrierExists(String scacID) {
        searchForCarrier(scacID);
        if(carrierConsoleButtons.size() > 0) {
            carrierScacSearchBar.clear();
            return true;
        }
        carrierScacSearchBar.clear();
        return false;
    }
}
