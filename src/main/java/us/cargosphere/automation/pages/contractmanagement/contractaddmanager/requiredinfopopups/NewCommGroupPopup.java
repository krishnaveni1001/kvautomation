package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

import java.util.List;

public class NewCommGroupPopup extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"divCommGroupNewSelect\"]/table[1]/tbody/tr[1]/td/input[1]")
    private WebElement onlyThisContractRadio;
    @FindBy(how = How.XPATH, using = "//*[@id=\"divCommGroupNewSelect\"]/table[1]/tbody/tr[1]/td/input[2]")
    private WebElement forAllContractsRadio;
    @FindBy(how = How.XPATH, using = "//*[@id=\"divCommGroupNewSelect\"]/table[1]/tbody/tr[2]/td[2]/a")
    private WebElement viewDetailLink;
    @FindBy(how = How.ID, using = "useExistButton")
    private WebElement useExistingButton;
    @FindBy(how = How.ID, using = "selNewCommodityGrpIds")
    private WebElement existingCommodityGroupSelect;
    @FindBy(how = How.CSS, using = "#trNewCommGroup > td > span > input[type=radio]:nth-child(1)")
    private WebElement globalCommSpecificGroupRadio;
    @FindBy(how = How.CSS, using = "#trNewCommGroup > td > span > input[type=radio]:nth-child(2)")
    private WebElement ourCommSpecificGroupRadio;
    @FindBy(how = How.CSS, using = "#trNewCommGroup > td > span > input[type=radio]:nth-child(3)")
    private WebElement generalCommGroupRadio;
    @FindBy(how = How.ID, using = "commodity")
    private WebElement commodityTextInput;
    @FindBy(how = How.ID, using = "commodityList")
    private WebElement commoditiesSelect;
    @FindBy(how = How.ID, using = "newCommGroupName")
    private WebElement newCommGroupNameInput;
    @FindBy(how = How.ID, using = "cbFak")
    private WebElement fakCheckbox;
    @FindBy(how = How.ID, using = "commGroupRemove")
    private WebElement removeButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"trAddSpecificCom\"]/td/table/tbody/tr[5]/td/input[1]")
    private WebElement nonHazardousRadio;
    @FindBy(how = How.XPATH, using = "//*[@id=\"trAddSpecificCom\"]/td/table/tbody/tr[5]/td/input[2]")
    private WebElement hazardousRadio;
    @FindBy(how = How.XPATH, using = "//*[@id=\"trAddSpecificCom\"]/td/table/tbody/tr[5]/td/input[3]")
    private WebElement nonHazAndHazardousRadio;
    @FindBy(how = How.XPATH, using = "//*[@id=\"trAddSpecificCom\"]/td/table/tbody/tr[5]/td/input[4]")
    private WebElement unspecifiedRadio;
    @FindBy(how = How.ID, using = "addCommGrp")
    private WebElement addCommodityGroupButton;
    @FindBy(how = How.ID, using = "btnCommGrpCancel")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "btnCommGrpClose")
    private WebElement closeButton;

    public NewCommGroupPopup(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void typeIntoCommodityTextInput (String text) {
        if(!commodityTextInput.isSelected()){
            commodityTextInput.click();
        }
        try {
            commodityTextInput.sendKeys(text);
        }catch (ElementClickInterceptedException e) {
            // Click the dropdown input, press enter and dismiss the redundant commodity group popup.
            System.out.println("Click Intercepted by dropdown element, closing dropdown and trying again");
            commodityTextInput.sendKeys(Keys.ENTER);
            webDriver.switchTo().alert().dismiss();
            commodityTextInput.click();
            commodityTextInput.sendKeys(text);
        }
    }

    /**
     * Selects the commodity with the argument name from the results select based
     * on case insensitive text match.
     * @param commodityName name of the commodity to be added, case-insensitive.
     */
    public void selectCommodityResultByExactName (String commodityName) {
        List<WebElement> commSelects = webDriver.findElements(By.className("ui-corner-all"));
        boolean foundMatchingCommodity = false;
        for(WebElement commodity : commSelects) {
            if(commodity.getText().toLowerCase().equals(commodityName.toLowerCase())) {
                commodity.click();
                foundMatchingCommodity = true;
            }
        }

        if(!foundMatchingCommodity) {
            throw new InvalidArgumentException("Commodity " + commodityName + " not found in commodity results");
        }
    }

    public void addCommodityByExactName (String commName) throws InterruptedException {
        typeIntoCommodityTextInput(commName);
        Thread.sleep(500);
        selectCommodityResultByExactName(commName);
    }

    public void typeIntoCommGroupNameTextInput (String text) {
        try {
            newCommGroupNameInput.click();
        } catch (ElementClickInterceptedException e) {
            // To close the results, select an already existing commGroup and dismiss the alert.
            System.out.println("Click Intercepted by dropdown element, closing dropdown and trying again");
            commodityTextInput.sendKeys(Keys.ARROW_UP);
            commodityTextInput.sendKeys(Keys.ENTER);
            webDriver.switchTo().alert().dismiss();
            newCommGroupNameInput.click();
        }
        newCommGroupNameInput.clear();
        newCommGroupNameInput.sendKeys(text);
    }

    public void clickFakCheckBox() {
        fakCheckbox.click();
    }

    public void clickAddCommodityGroupButton (){
        addCommodityGroupButton.click();
    }

    public void clickGlobalCommGroupRadio() {
        globalCommSpecificGroupRadio.click();
    }

    public void clickOurCommGroupRadio() {
        ourCommSpecificGroupRadio.click();
    }

    public void clickGeneralCommGroupRadio() {
        generalCommGroupRadio.click();
    }

    public void clickNonHazardousRadio () {
        // This is in a try catch block because the select for commodities may remain open
        // and cover the nonHazardousRadio element.
        try {
            nonHazardousRadio.click();
        } catch (ElementClickInterceptedException e) {
            // Click the dropdown input, press enter and dismiss the redundant commodity group popup.
            System.out.println("Click Intercepted by dropdown element, closing dropdown and trying again");
            commodityTextInput.click();
            commodityTextInput.sendKeys(Keys.ENTER);
            webDriver.switchTo().alert().dismiss();
            nonHazAndHazardousRadio.click();
        }
    }

    public void clickHazardousRadio () {
        hazardousRadio.click();
    }

    public void clickNonHazardousAndHazardousRadio () {
        nonHazAndHazardousRadio.click();
    }

    public void clickUnspecifiedRadio () {
        unspecifiedRadio.click();
    }

    public boolean isDuplicateCommGroupPopupVisible() {
        return webDriver.findElement(By.id("divCommDuplicate")).isDisplayed();
    }

    /**
     * Selects the commodity group name in the duplicate comm group select popup
     * that matches the String argument, clicks the select button and waits 200 milliseconds
     * for the popups to disappear.
     * @param commGroupName The name of the commodity group to select
     * @throws InterruptedException
     */
    public void selectDuplicateCommGroupByName(String commGroupName) throws InterruptedException {
        Select select = new Select(webDriver.findElement(By.id("selDupCommodityGrpIds")));
        select.selectByVisibleText(commGroupName);
        webDriver.findElement(By.cssSelector("#divCommWarnSelect > input")).click();
        Thread.sleep(200);
    }
}
