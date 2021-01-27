package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class NewTradeLanePopup extends BasePage {

    @FindBy(how = How.ID, using = "selNewTradeLaneIds")
    private WebElement tradeLaneList;
    @FindBy(how = How.CSS, using = "#divTradeLaneNewSelect > table > tbody > tr:nth-child(1) > td.smallNonBoldBlack > div > input")
    private WebElement useExistingButton;
    @FindBy(how = How.ID, using = "newTradeLane")
    private WebElement newTradeLaneNameTextInput;
    @FindBy(how = How.CSS, using = "#divTradeLaneNewSelect > input:nth-child(4)")
    private WebElement addTradeLaneButton;
    @FindBy(how = How.CSS, using = "#divTradeLaneNewSelect > input:nth-child(5)")
    private WebElement closeButton;

    public NewTradeLanePopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickTradeLaneList() {
        tradeLaneList.click();
    }

    public void clickUseExistingButton() {
        useExistingButton.click();
    }

    public void typeIntoTradeLaneNameTextInput (String tradeLaneName) {
        newTradeLaneNameTextInput.click();
        newTradeLaneNameTextInput.sendKeys(tradeLaneName);
    }

    public void clickAddTradeLaneButton () {
        addTradeLaneButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    /**
     * Checks if the argument string is an existing trade lane in Existing Trade Lanes select.
     * @param tradeLane the trade lane name to check for.
     * @return true if the trade lane argument name is found in the Existing Trade Lanes select.
     */
    public boolean tradeLaneExists(String tradeLane) {
        Select select = new Select(webDriver.findElement(By.id("selNewTradeLaneIds")));
        for(WebElement option : select.getOptions()) {
            if (option.getText().equals(tradeLane)) {
                System.out.println("Trade lane does exist");
                return true;
            }
        }
        System.out.println("Trade lane does not exist");
        return false;
    }

    /**
     * Selects an existing Trade Lane option that matches the argument String and
     * clicks the Use Existing Trade Lane button.
     * @param tradeLane the existing trade lane to select.
     */
    public void useExistingTradeLane(String tradeLane) throws InterruptedException {
        Select select = new Select(webDriver.findElement(By.id("selNewTradeLaneIds")));
        select.selectByVisibleText(tradeLane);
        clickUseExistingButton();
    }
}
