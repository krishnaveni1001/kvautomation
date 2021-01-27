package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class AddOnSelectPopup extends BasePage {

    public final static String UNSPECIFIED = "Unspecified";
    public final static String ONLY_ORIGINS_ALLOWED = "Only Origins Allowed";
    public final static String ONLY_DESTINATIONS_ALLOWED = "Only Destinations Allowed";
    public final static String ORIGINS_AND_DESTINATIONS_ALLOWED = "Origins and Destinations Allowed";
    public final static String NOT_ALLOWED = "Not Allowed";

    @FindBy(how = How.CSS, using = "#selArbs > option:nth-child(1)")
    private WebElement unspecifiedSelect;
    @FindBy(how = How.CSS, using = "#selArbs > option:nth-child(2)")
    private WebElement onlyOriginsAllowedSelect;
    @FindBy(how = How.CSS, using = "#selArbs > option:nth-child(3)")
    private WebElement onlyDestinationsAllowedSelect;
    @FindBy(how = How.CSS, using = "#selArbs > option:nth-child(4)")
    private WebElement originsAndDestinationsAllowedSelect;
    @FindBy(how = How.CSS, using = "#selArbs > option:nth-child(5)")
    private WebElement notAllowedSelect;
    @FindBy(how = How.ID, using = "addOnSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "addOnClose")
    private WebElement closeButton;

    public AddOnSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void selectAddOn(String addOn) {

        Actions action = new Actions(webDriver);
        action.keyDown(Keys.CONTROL).build().perform();

        switch(addOn) {
            case UNSPECIFIED:
                unspecifiedSelect.click();
                break;
            case ONLY_ORIGINS_ALLOWED:
                onlyOriginsAllowedSelect.click();
                break;
            case ONLY_DESTINATIONS_ALLOWED:
                onlyDestinationsAllowedSelect.click();
                break;
            case ORIGINS_AND_DESTINATIONS_ALLOWED:
                originsAndDestinationsAllowedSelect.click();
                break;
            case NOT_ALLOWED:
                notAllowedSelect.click();
                break;
            default:
                String message = "Invalid service type: " + addOn + " does not exist or is not implemented.";
                throw new IllegalArgumentException(message);
        }

        action.keyUp(Keys.CONTROL).build().perform();
    }

    public void selectUnspecified () {
        selectAddOn(UNSPECIFIED);
    }

    public void selectOnlyOriginsAllowed () {
        selectAddOn(ONLY_ORIGINS_ALLOWED);
    }

    public void selectOnlyDestinationsAllowed () {
        selectAddOn(ONLY_DESTINATIONS_ALLOWED);
    }

    public void selectOriginsAndDestinationsAllowed () {
        selectAddOn(ORIGINS_AND_DESTINATIONS_ALLOWED);
    }

    public void selectNotAllowed () {
        selectAddOn(NOT_ALLOWED);
    }

    public void clickSelectButton () {
        selectButton.click();
    }

}
