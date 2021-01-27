package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class NewVesselPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#divVesselNew > table > tbody > tr:nth-child(1) > td.smallNonBoldBlack > div > input")
    private WebElement useExistingButton;
    @FindBy(how = How.ID, using = "selNewVessels")
    private WebElement existingVesselSelect;
    @FindBy(how = How.ID, using = "newVessel")
    private WebElement newVesselTextInput;
    @FindBy(how = How.CSS, using = "#divVesselNew > div > input:nth-child(1)")
    private WebElement addNewVesselButton;
    @FindBy(how = How.CSS, using = "#divVesselNew > div > input:nth-child(2)")
    private WebElement closeButton;

    public NewVesselPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickUseExistingButton() {
        useExistingButton.click();
    }

    public void clickExistingVesselSelect() {
        existingVesselSelect.click();
    }

    public void clickNewVesselTextInput() {
        newVesselTextInput.click();
    }

    public void typeIntoNewVesselTextInput(String vesselName) {
        newVesselTextInput.sendKeys(vesselName);
    }

    public void clickAddNewVesselButton () {
        addNewVesselButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    /**
     * Activate the vessel name text field, enter the string argument into the field,
     * and then click the ADD VESSEL button.
     * @param vesselName the vessel name to be added.
     */
    public void addNewVessel(String vesselName) {
        clickNewVesselTextInput();
        typeIntoNewVesselTextInput(vesselName);
        clickAddNewVesselButton();
    }

}
