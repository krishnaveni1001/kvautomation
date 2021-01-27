package us.cargosphere.automation.pages.contractmanagement.addsurchargeconsole;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.common.DatePicker;

public class ContractAddSurchargesPage extends BasePage {

    @FindBy(how = How.ID, using = "newEffDate")
    private WebElement newEffDateInput;
    @FindBy(how = How.ID, using = "newExpDate")
    private WebElement newExpDateInput;
    @FindBy(how = How.ID, using = "updateRates")
    private WebElement addButton;

    public ContractAddSurchargesPage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void addTermToRow(String term, int rowNum) {
        WebElement termInput = webDriver.findElement(By.id("surchargeTerm" + rowNum));
        termInput.click();
        termInput.sendKeys(term);
    }

    public void selectSurchargeTypeForRow(String surchargeType, int rowNum) {
        Select surchargeTypeSelect = new Select(webDriver.findElement(
                By.id("surchargeTypeSel" + rowNum)));
        surchargeTypeSelect.selectByVisibleText(surchargeType);
    }

    public void selectSurchargeCategoryForRow(String surchargeCategory, int rowNum) {
        Select surchargeCategorySelect = new Select(webDriver.findElement(
                By.id("surchargeCategory" + rowNum)));
        surchargeCategorySelect.selectByVisibleText(surchargeCategory);
    }

    public void selectPriceByForRow(String priceByOption, int rowNum) {
        Select surchargeCategorySelect = new Select(webDriver.findElement(
                By.id("selSurPriceBy" + rowNum)));
        surchargeCategorySelect.selectByVisibleText(priceByOption);
    }

    public void addSurchargeAmountToRow(String amount, int rowNum) {
        WebElement surchargeAmountInput = webDriver.findElement(By.id("surchargeAmt" + rowNum));
        surchargeAmountInput.click();
        surchargeAmountInput.sendKeys(amount);
    }

    public void selectCurrencyForRow (String currency, int rowNum) {
        Select surchargeTypeSelect = new Select(webDriver.findElement(
                By.cssSelector("#tbSurchargeInfo > tr:nth-child(" + (rowNum+1) +") > td:nth-child(5) > select")));
        surchargeTypeSelect.selectByVisibleText(currency);
    }

    public void selectExcludeFromTotalRateValue (String value, int rowNum) {
        Select excludeFromTotalRateSelect = new Select(webDriver.findElement(
                By.cssSelector("#tbSurchargeInfo > tr:nth-child(" + (rowNum+1) +") > td:nth-child(6) > select")));
        excludeFromTotalRateSelect.selectByVisibleText(value);
    }

    public void selectContainerType (String containerType, int rowNum) {
        Select containerSelect = new Select(webDriver.findElement(
                By.cssSelector("#tbSurchargeInfo > tr:nth-child(" + (rowNum+1) +") > td:nth-child(7) > select")));
        containerSelect.selectByVisibleText(containerType);
    }

    public void selectOrigin (String origin, int rowNum) {
        Select originSelect = new Select(webDriver.findElement(
                By.cssSelector("#tbSurchargeInfo > tr:nth-child(" + (rowNum+1) +") > td:nth-child(8) > select")));
        originSelect.selectByVisibleText(origin);
    }

    public void selectDestination (String origin, int rowNum) {
        Select destinationSelect = new Select(webDriver.findElement(
                By.cssSelector("#tbSurchargeInfo > tr:nth-child(" + (rowNum+1) +") > td:nth-child(9) > select")));
        destinationSelect.selectByVisibleText(origin);
    }

    public DatePicker getEffDatePicker () {
        clickNewEffDateInput();
        return new DatePicker(webDriver, webDriver.findElement(By.id("theDatePicker")));
    }

    public DatePicker getExpDatePicker () {
        clickNewExpDateInput();
        return new DatePicker(webDriver, webDriver.findElement(By.id("theDatePicker")));
    }

    public void clickNewEffDateInput () {
        newEffDateInput.click();
    }

    public void clickNewExpDateInput () {
        newExpDateInput.click();
    }

    public void clickAddButton () {
        addButton.click();
    }
}
