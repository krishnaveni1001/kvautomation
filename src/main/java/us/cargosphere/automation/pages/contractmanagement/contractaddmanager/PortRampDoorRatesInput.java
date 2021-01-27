package us.cargosphere.automation.pages.contractmanagement.contractaddmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

public class PortRampDoorRatesInput extends BasePage {

    @FindBy(how = How.ID, using = "selInitOptions")
    private WebElement tableClearOptionsDropdown;
    @FindBy(how = How.CSS, using = "#initOptions > a")
    private WebElement clearTableGoButton;
    @FindBy(how = How.ID, using = "selCurrencyId")
    private WebElement currencySelectDropdown;

    public PortRampDoorRatesInput (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public WebElement getOriginInputForRowNumber (int rowNumber) {
        return webDriver.findElement(By.id("DropContainerPortOrig_" + rowNumber));
    }

    public WebElement getDestinationInputForRow (int rowNumber) {
        return webDriver.findElement(By.id("DropContainerPortDest_" + rowNumber));
    }

    public WebElement getRateInput (int rowNumber, int containerNumber) {
        try {
            return webDriver.findElement(By.id("portRate_" + containerNumber + "_" + rowNumber));
        } catch (NoSuchElementException e) {
            String message = "Rate input for container type " + containerNumber + " in row " + rowNumber + " does not exist";
            throw new InvalidArgumentException(message);
        }
    }

    public WebElement getCopyRateAcrossCellsButtonForRow(int rowNumber) {
        try {
            return webDriver.findElement(By.cssSelector(
                    "#tbPortInfo > tr:nth-child(" + rowNumber + ") > td:nth-child(7) > table > tbody > tr > td:nth-child(1) > a:nth-child(3)"
            ));
        } catch (NoSuchElementException e) {
            String message = "Rate input row " + rowNumber + " does not exist";
            throw new InvalidArgumentException(message);
        }
    }

    public WebElement getCopyOriginDownCellsButtonForRow(int rowNumber) {
        try {
            return webDriver.findElement(By.cssSelector(
                    "#tbPortInfo > tr:nth-child(" + rowNumber+2 + ") > td:nth-child(6) > div > a:nth-child(1)"
            ));
        } catch (NoSuchElementException e) {
            String message = "Rate input row " + rowNumber + " does not exist";
            throw new InvalidArgumentException(message);
        }
    }

    public WebElement getCopyDestinationDownCellsButtonForRow(int rowNumber) {
        try {
            // use rowNumber + 2 because the nth-child index for this button starts at 2
            return webDriver.findElement(By.cssSelector(
                    "#tbPortInfo > tr:nth-child(" + rowNumber+2 + ") > td:nth-child(4) > div:nth-child(1) > span > a:nth-child(1)"
            ));
        } catch (NoSuchElementException e) {
            String message = "Rate input row " + rowNumber + " does not exist";
            throw new InvalidArgumentException(message);
        }
    }

    public void enterRateIntoCell(String value, int rowNumber, int containerNumber) {
        WebElement rateCell = getRateInput(rowNumber, containerNumber);
        rateCell.click();
        rateCell.sendKeys(value);
    }

    public void assignPortToOriginForRow(String portName, int rowNumber) throws InterruptedException {
        getOriginInputForRowNumber(rowNumber).click();
        FindPortsPopup popup = new FindPortsPopup(webDriver,
                webDriver.findElement(By.id("divLocationContainer")));
        popup.addOriginByExactName(portName);
        Thread.sleep(200);
        popup.clickCloseButton();
    }

    public void assignPortToDestinationForRow(String portName, int rowNumber) throws InterruptedException {
        getDestinationInputForRow(rowNumber).click();
        FindPortsPopup popup = new FindPortsPopup(webDriver,
                webDriver.findElement(By.id("divLocationContainer")));
        popup.addDestinationByExactName(portName);
        Thread.sleep(200);
        popup.clickCloseButton();
    }

    public void clickCopyOriginDownCellsButton(int rowNumber) {
        getCopyOriginDownCellsButtonForRow(rowNumber).click();
    }

    public void clickCopyDestinationDownCellsButton(int rowNumber) {
        getCopyDestinationDownCellsButtonForRow(rowNumber).click();
    }

    public void clickCopyRateAcrossCellsButtonForRow(int rowNumber) {
        getCopyRateAcrossCellsButtonForRow(rowNumber);
    }

}