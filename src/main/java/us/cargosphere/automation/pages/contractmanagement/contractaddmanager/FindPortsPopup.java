package us.cargosphere.automation.pages.contractmanagement.contractaddmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

import java.lang.reflect.Array;
import java.util.List;

public class FindPortsPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#divLocationContainer > div:nth-child(1) > a")
    private WebElement closeButton;
    @FindBy(how = How.ID, using = "aMoveOrig")
    private WebElement moveToOriginButton;
    @FindBy(how = How.ID, using = "aMoveDest")
    private WebElement moveToDestinationButton;
    @FindBy(how = How.ID, using = "findOptions")
    private WebElement findOptionsDropdown;
    @FindBy(how = How.ID, using = "searchString")
    private WebElement findPortTextInput;
    @FindBy(how = How.ID, using = "DragContainer")
    private WebElement locationsSelect;


    public FindPortsPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickCloseButton () {
        closeButton.click();
    }

    public void clickFindPortTextInput () {
        findPortTextInput.click();
    }

    public void typeIntoFindPortTextInput (String locationName) {
        clickFindPortTextInput();
        findPortTextInput.sendKeys(locationName);

    }

    public WebElement getLocationSearchResultElement(int resultNumber) {
        try {
            return webDriver.findElement(By.xpath("//*[@id=\"DragContainer\"]/div[" + (resultNumber+1) +"]"));
        } catch (NoSuchElementException e) {
            String message = "Result number " + resultNumber + " no found in location search result";
            throw new InvalidArgumentException(message);
        }
    }

    public void addOriginByExactName(String locationName) throws InterruptedException {
        typeIntoFindPortTextInput(locationName);
        Thread.sleep(500);
        moveToOriginButton.click();
        WebElement firstResult = getLocationSearchResultElement(0);
        SeleniumUtil.doubleClick(webDriver, firstResult);
    }

    public void addDestinationByExactName(String locationName) throws InterruptedException {
        typeIntoFindPortTextInput(locationName);
        Thread.sleep(500);
        moveToDestinationButton.click();
        WebElement firstResult = getLocationSearchResultElement(0);
        SeleniumUtil.doubleClick(webDriver, firstResult);
    }

}
