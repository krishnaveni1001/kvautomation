package us.cargosphere.automation.pages.contractmanagement.contractaddmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class ThroughRatesInput extends PortRampDoorRatesInput {

    @FindBy(how = How.ID, using = "selInitOptions")
    private WebElement tableClearOptionsDropdown;
    @FindBy(how = How.CSS, using = "#initOptions > a")
    private WebElement clearTableGoButton;
    @FindBy(how = How.ID, using = "selCurrencyId")
    private WebElement currencySelectDropdown;

    public ThroughRatesInput (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    // Override for origin and destination inputs because element ID is different
    @Override
    public WebElement getOriginInputForRowNumber (int rowNumber) {
        return webDriver.findElement(By.id("DropContainerOrig_" + rowNumber));
    }

    @Override
    public WebElement getDestinationInputForRow (int rowNumber) {
        return webDriver.findElement(By.id("DropContainerDest_" + rowNumber));
    }

    public WebElement getPOLInputForRowNumber (int rowNumber) {
        try {
            return webDriver.findElements(By.id("origRouting")).get(rowNumber);
        } catch (NoSuchElementException e) {
            String message = "POL Input for row " + rowNumber +" does not exist";
            throw new InvalidArgumentException(message);
        }
    }

    public WebElement getPODInputForRowNumber (int rowNumber) {
        try {
            return webDriver.findElements(By.id("destRouting")).get(rowNumber);
        } catch (NoSuchElementException e) {
            String message = "POL Input for row " + rowNumber +" does not exist";
            throw new InvalidArgumentException(message);
        }
    }

    public void assignPOLForRowByExactName(String polName, int rowNumber) throws InterruptedException {
        WebElement input = getPOLInputForRowNumber(rowNumber);
        input.click();
        input.sendKeys(polName);
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("#orig-popup" + rowNumber+ " > ul > li.selected")).click();
    }

    public void assignPODForRowByExactName(String podName, int rowNumber) throws InterruptedException {
        WebElement input = getPODInputForRowNumber(rowNumber);
        input.click();
        input.sendKeys(podName);
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("#dest-popup" + rowNumber +" > ul > li.selected")).click();
    }

    @Override
    public WebElement getRateInput (int rowNumber, int containerNumber) {
        try {
            return webDriver.findElement(By.id("odRate_" + containerNumber + "_" + rowNumber));
        } catch (NoSuchElementException e) {
            String message = "Rate input for container type " + containerNumber + " in row " + rowNumber + " does not exist";
            throw new InvalidArgumentException(message);
        }
    }

}
