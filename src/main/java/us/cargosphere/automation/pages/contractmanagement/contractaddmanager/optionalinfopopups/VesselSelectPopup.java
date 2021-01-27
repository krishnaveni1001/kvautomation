package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class VesselSelectPopup extends BasePage {

    @FindBy(how = How.ID, using = "option0")
    private WebElement addNewVesselSelect;
    @FindBy(how = How.ID, using = "vesselSelect")
    private WebElement selectButton;
    @FindBy(how = How.ID, using = "vesselClose")
    private WebElement closeButton;

    public VesselSelectPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickAddNewVesselSelect() {
        addNewVesselSelect.click();
    }

    public void clickSelectButton () {
        selectButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void openAddNewVesselPopup() {
        clickAddNewVesselSelect();
        clickSelectButton();
    }

    public NewVesselPopup getNewVesselPopup() {
        clickAddNewVesselSelect();
        clickSelectButton();
        return new NewVesselPopup(webDriver,
                webDriver.findElement(By.id("divVesselNew")));
    }

    /**
     * Checks if the argument string is an existing vessel in existing Vessel select.
     * @param vesselName the vessel to check for.
     * @return true if the vessel name argument is found in the existing Vessel select.
     */
    public boolean vesselExists(String vesselName) {
        Select select = new Select(webDriver.findElement(By.id("selVessels")));
        for(WebElement option : select.getOptions()){
            if(option.getAttribute("innerText").equals(vesselName))
                return true;
        }
        return false;
    }

    /**
     * Selects an existing vessel option that matches the argument String and
     * clicks the select button.
     * @param vesselName the existing vessel to select.
     */
    public void useExistingVessel(String vesselName) {
        Select select = new Select(webDriver.findElement(By.id("selVessels")));
        select.selectByValue(vesselName);
        clickSelectButton();
    }
}
