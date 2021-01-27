package us.cargosphere.automation.pages.ratesearch.compactview.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class RoutingsFilterPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#ui-select-origin-routings > div:nth-child(1) > input")
    private WebElement originRoutingsSearchBar;
    @FindBy(how = How.CSS, using = "#ui-select-destination-routings > div:nth-child(1) > input")
    private WebElement destinationRoutingsSearchBar;
    @FindBy(how = How.ID, using = "ui-select-choices-10")
    private WebElement originRoutingResults;
    @FindBy(how = How.ID, using = "ui-select-choices-11")
    private WebElement destinationRoutingResults;
    @FindBy(how = How.ID, using = "buttonApplyOriginRoutings")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelOriginRoutings")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearOriginRoutings")
    private WebElement clearFiltersButton;

    public RoutingsFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    public void searchForOriginRouting(String originName) throws InterruptedException {
        originRoutingsSearchBar.click();
        originRoutingsSearchBar.sendKeys(originName);
        Thread.sleep(300);
    }

    public void selectOriginRoutingResult (int n) {
        for (int i = 0; i < n; i ++) {
            originRoutingsSearchBar.sendKeys(Keys.ARROW_DOWN);
        }
        originRoutingsSearchBar.sendKeys(Keys.ENTER);
    }

    public void searchForDestinationRouting(String destinationName) throws InterruptedException {
        destinationRoutingsSearchBar.click();
        destinationRoutingsSearchBar.sendKeys(destinationName);
        Thread.sleep(300);
    }


    public void selectDestinationRoutingResult (int n) {
        for (int i = 0; i < n; i ++) {
            destinationRoutingsSearchBar.sendKeys(Keys.ARROW_DOWN);
        }
        destinationRoutingsSearchBar.sendKeys(Keys.ENTER);
    }

    public void clickOriginRoutingsSearchBar() {
        originRoutingsSearchBar.click();
    }

    public void clickDestinationRoutingsSearchBar() {
        destinationRoutingsSearchBar.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public void clickClearFiltersButton() {clearFiltersButton.clear();}

    /**
     * Searches for origin routings to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param originName - exact name of the origin routing location
     */
    public void addOriginRoutingFilterByExactName (String originName) throws InterruptedException {
        searchForOriginRouting(originName);
        Thread.sleep(100);
        selectOriginRoutingResult(0);
    }

    /**
     * Searches for destination routings to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param destinationName - exact name of the destination routing location
     */
    public void addDestinationRoutingFilterByExactName (String destinationName) throws InterruptedException {
        searchForDestinationRouting(destinationName);
        Thread.sleep(100);
        selectDestinationRoutingResult(0);
    }

    public List<String> getOriginRoutingNames() throws InterruptedException {
        clickOriginRoutingsSearchBar();
        Thread.sleep(500);

        List<String> originOptions = new ArrayList<>();
        List<WebElement> results = webDriver.findElements(By.className("dropdownFlex1"));
        for(WebElement result : results) {
            originOptions.add(result.getText());
        }

        originRoutingsSearchBar.sendKeys(Keys.ESCAPE);
        return originOptions;
    }

    public List<String> getDestinationRoutingNames() throws InterruptedException {
        clickDestinationRoutingsSearchBar();
        Thread.sleep(500);

        List<String> destinationOptions = new ArrayList<>();
        List<WebElement> results = webDriver.findElements(By.className("dropdownFlex1"));
        for(WebElement result : results) {
            destinationOptions.add(result.getText());
        }

        originRoutingsSearchBar.sendKeys(Keys.ESCAPE);
        return destinationOptions;
    }
}
