package us.cargosphere.automation.pages.ratesearch.compactview.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

import java.util.List;

public class MoreFiltersPopup extends BasePage {
    @FindBy(how = How.ID, using = "buttonApplyMoreFilters")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelMoreFilters")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearMoreFilters")
    private WebElement clearFiltersButton;
    @FindBy(how = How.ID, using = "Cntr. 20 ft_0")
    private WebElement cntr20FtCheckBox;
    @FindBy(how = How.ID, using = "Cntr. 40 ft_1")
    private WebElement cntr40FtCheckBox;
    @FindBy(how = How.ID, using = "Cntr. 40 ft HC_2")
    private WebElement cntr40FtHCCheckBox;
    @FindBy(how = How.ID, using = "Cntr. 45 ft HC_3")
    private WebElement cntr45FtHCCheckBox;

    public MoreFiltersPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    public enum ContainerType {
        CNTR_20_FOOT,
        CNTR_40_FOOT ,
        CNTR_40_FOOT_HC,
        CNTR_45_FOOT_HC
    }

    public void addContainerFilter(ContainerType containerType) throws InterruptedException {
        switch(containerType){
            case CNTR_20_FOOT:
                cntr20FtCheckBox.click();
                break;
            case CNTR_40_FOOT:
                cntr40FtCheckBox.click();
                break;
            case CNTR_40_FOOT_HC:
                cntr40FtHCCheckBox.click();
                break;
            case CNTR_45_FOOT_HC:
                cntr45FtHCCheckBox.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid container type");
        }
        confirmButton.click();
        Thread.sleep(500);
    }

    public void addRateTypeFilter(String rateType) {
        List<WebElement> rateTypeRadios = webDriver.findElements(By.name("ratetype"));
        for(WebElement radio : rateTypeRadios) {
            if(radio.getAttribute("id").startsWith(rateType)) {
                radio.click();
                return;
            }
        }
        throw new InvalidArgumentException("Rate Type Two " + rateType + " not found in available filters");
    }

    public void addRateTypeTwoFilter(String rateTypeTwo) {
        List<WebElement> rateTypeTwoRadios = webDriver.findElements(By.name("ratetype2"));
        for(WebElement radio : rateTypeTwoRadios) {
            if(radio.getAttribute("id").startsWith(rateTypeTwo)) {
                radio.click();
                return;
            }
        }
        throw new InvalidArgumentException("Rate Type Two " + rateTypeTwo + " not found in available filters");
    }

    public void addServiceStringFilter(String serviceString) {
        List<WebElement> serviceStringRadios = webDriver.findElements(By.name("serviceStrings"));
        for(WebElement radio : serviceStringRadios) {
            if(radio.getAttribute("id").startsWith(serviceString)) {
                radio.click();
                return;
            }
        }
        throw new InvalidArgumentException("Service String " + serviceString + " not found in available filters");
    }

    public void addServiceTypeFilter(String serviceType) {
        List<WebElement> serviceTypeRadios = webDriver.findElements(By.name("serviceTypes"));
        for(WebElement radio : serviceTypeRadios) {
            if(radio.getAttribute("id").startsWith(serviceType)) {
                radio.click();
                return;
            }
        }
        throw new InvalidArgumentException("Service Type " + serviceType + " not found in available filters");
    }

    public void addVesselFilter (String vessel) {
        List<WebElement> vesselRadios = webDriver.findElements(By.name("vessels"));
        for(WebElement radio : vesselRadios) {
            if(radio.getAttribute("id").startsWith(vessel)) {
                radio.click();
                return;
            }
        }
        throw new InvalidArgumentException("Vessel " + vessel + " not found in available filters");
    }

    public void clickClearFiltersButton() {
        clearFiltersButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }
}
