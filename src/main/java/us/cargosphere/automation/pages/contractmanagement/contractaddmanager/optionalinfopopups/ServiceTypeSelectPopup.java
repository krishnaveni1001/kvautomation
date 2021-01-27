package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class ServiceTypeSelectPopup extends BasePage {

    public final static String UNSPECIFIED = "Unspecified";
    public final static String ALL_WATER_SERVICE = "AWS All-Water Service";
    public final static String ALL_MOTOR = "All Motor";
    public final static String BREAK_BULK = "Break Bulk";
    public final static String DIRECT_CALL_ONLY = "Direct Call Only";
    public final static String DIRECT_CALL_AT_DESTINATION = "Direct Call At Destination";
    public final static String DIRECT_CALL_AT_ORIGIN = "Direct Call At Origin";

    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(1)")
    private WebElement unspecifiedSelect;
    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(2)")
    private WebElement allWaterServiceSelect;
    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(3)")
    private WebElement allMotorSelect;
    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(4)")
    private WebElement breakBulkSelect;
    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(5)")
    private WebElement directCallOnlySelect;
    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(6)")
    private WebElement directCallAtDestinationSelect;
    @FindBy(how = How.CSS, using = "#selServiceTypes > option:nth-child(7)")
    private WebElement directCallAtOriginSelect;
    @FindBy(how = How.ID, using = "serviceTypeSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "serviceTypeClose")
    private WebElement closeButton;

    public ServiceTypeSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void selectServiceType(String serviceType) {

        Actions action = new Actions(webDriver);
        action.keyDown(Keys.CONTROL).build().perform();

        switch(serviceType) {
            case UNSPECIFIED:
                unspecifiedSelect.click();
                break;
            case ALL_WATER_SERVICE:
                allWaterServiceSelect.click();
                break;
            case ALL_MOTOR:
                allMotorSelect.click();
                break;
            case BREAK_BULK:
                breakBulkSelect.click();
                break;
            case DIRECT_CALL_ONLY:
                directCallOnlySelect.click();
                break;
            case DIRECT_CALL_AT_DESTINATION:
                directCallAtDestinationSelect.click();
                break;
            case DIRECT_CALL_AT_ORIGIN:
                directCallAtOriginSelect.click();
                break;
            default:
                String message = "Invalid service type: " + serviceType + " does not exist or is not implemented.";
                throw new IllegalArgumentException(message);
        }

        action.keyUp(Keys.CONTROL).build().perform();
    }

    public void selectUnspecified () {
        selectServiceType(UNSPECIFIED);
    }

    public void selectAllWaterService () {
        selectServiceType(ALL_WATER_SERVICE);
    }

    public void selectAllMotor () {
        selectServiceType(ALL_MOTOR);
    }

    public void selectBreakBulk () {
        selectServiceType(BREAK_BULK);
    }

    public void selectDirectCallOnly () {
        selectServiceType(DIRECT_CALL_ONLY);
    }

    public void selectDirectCallAtDestination () {
        selectServiceType(DIRECT_CALL_AT_DESTINATION);
    }

    public void selectDirectCallAtOrigin () {
        selectServiceType(DIRECT_CALL_AT_ORIGIN);
    }

    public void clickSelectButton () {
        selectButton.click();
    }
}
