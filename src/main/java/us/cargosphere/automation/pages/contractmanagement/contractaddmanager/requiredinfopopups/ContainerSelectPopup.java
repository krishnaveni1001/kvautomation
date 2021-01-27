package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class ContainerSelectPopup extends BasePage {

    final String CONTAINER_20_FOOT = "Cntr. 20 ft";
    final String CONTAINER_20_FOOT_HC = "Cntr. 20 ft High Cube";
    final String CONTAINER_40_FOOT = "Cntr. 40 ft";
    final String CONTAINER_40_FOOT_HC = "Cntr. 40 ft HC";
    final String CONTAINER_40_FOOT_ANY_SIZE = "Cntr. 40ft of any size";
    final String CONTAINER_45_FOOT = "Cntr. 45 ft";
    final String CONTAINER_45_FOOT_HC = "Cntr. 45 ft HC";

    @FindBy(how = How.ID, using = "selUnitTypeIds")
    private WebElement containerSelect;
    // TODO implement remaining container type select elements
    @FindBy(how = How.ID, using = "contTypeSelect")
    private WebElement selectButton;

    public ContainerSelectPopup(WebDriver driver, WebElement el) {
        super(driver, el);
    }

    public void selectContainerType(String containerType) {
        Select select = new Select(containerSelect);
        select.selectByVisibleText(containerType);
    }

    public void selectCntr20Foot () {
        selectContainerType(CONTAINER_20_FOOT);
    }

    public void selectCntr20FootHC () {
        selectContainerType(CONTAINER_20_FOOT_HC);
    }

    public void selectCntr40Foot () {
        selectContainerType(CONTAINER_40_FOOT);
    }

    public void selectCntr40FootHC () {
        selectContainerType(CONTAINER_40_FOOT_HC);
    }

    public void selectCntr40FootAnySize () {
        selectContainerType(CONTAINER_40_FOOT_ANY_SIZE);
    }

    public void selectContainer45Foot () {
        selectContainerType(CONTAINER_45_FOOT);
    }

    public void selectContainer45FootHC () {
        selectContainerType(CONTAINER_45_FOOT_HC);
    }

    public void clickSelectButton () {
        selectButton.click();
    }
}
