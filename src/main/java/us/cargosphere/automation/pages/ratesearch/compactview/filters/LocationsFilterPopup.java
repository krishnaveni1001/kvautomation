package us.cargosphere.automation.pages.ratesearch.compactview.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationsFilterPopup extends BasePage {

    @FindBy(how = How.ID, using = "buttonApplyLocations")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelLocations")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearLocations")
    private WebElement clearFiltersButton;
    @FindBy(how = How.CSS, using = "#ui-select-origins > div:nth-child(1) > input")
    private WebElement originSearchBar;
    @FindBy(how = How.CSS, using = "#ui-select-choices-8")
    private WebElement originSearchBarResultsElement;
    @FindBy(how = How.CSS, using = "#ui-select-destinations > div:nth-child(1) > input")
    private WebElement destinationSearchBar;
    @FindBy(how = How.CSS, using = "#ui-select-choices-9")
    private WebElement destinationSearchBarResultsElement;

    public LocationsFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }


    /**
     * Searches for origin locations to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param originName - exact name of the origin location
     */
    public void addOriginFilterByExactName (String originName) throws InterruptedException {
        searchForOrigin(originName);
        selectOriginResult(0);
        clickConfirmButton();
        Thread.sleep(500);
    }

    /**
     * Searches for destination location to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param destinationName - exact name of the destination location
     */
    public void addDestinationFilterByExactName (String destinationName) throws InterruptedException {
        searchForDestination(destinationName);
        selectDestinationResult(0);
        clickConfirmButton();
        Thread.sleep(500);
    }

    public void searchForOrigin(String searchValue) throws InterruptedException {
        clickOriginSearchBar();
        typeIntoOriginSearchBar(searchValue);
        Thread.sleep(500);
    }

    public void searchForDestination(String searchValue) throws InterruptedException {
        clickDestinationSearchBar();
        typeIntoDestinationSearchBar (searchValue);
        Thread.sleep(500);
    }

    public void clickOriginSearchBar() {
        originSearchBar.click();
    }

    public void typeIntoOriginSearchBar(String searchValue) {
        originSearchBar.sendKeys(searchValue);
    }

    public void clickDestinationSearchBar() {
        destinationSearchBar.click();
    }

    public void typeIntoDestinationSearchBar(String searchValue) {
        destinationSearchBar.sendKeys(searchValue);
    }

    public void selectOriginResult(int resultNumber) {
        // select the resultNumberth result
        for(int i=0; i < resultNumber; i++){
            originSearchBar.sendKeys(Keys.ARROW_DOWN);
        }

        originSearchBar.sendKeys(Keys.ENTER);
    }

    public void selectDestinationResult(int resultNumber) {
        // select the resultNumberth result
        for(int i=0; i < resultNumber; i++){
            destinationSearchBar.sendKeys(Keys.ARROW_DOWN);
        }

        destinationSearchBar.sendKeys(Keys.ENTER);
    }

    /**
     * Clicks the origins search bar to get origin filter options, adds the suggested
     * origin names to a list, closes the search bar results and returns the list.
     * @return list of the names of available origins to filter on.
     * @throws InterruptedException
     */
    public List<String> getOriginNames () throws InterruptedException {
        clickOriginSearchBar();
        Thread.sleep(500);

        List<String> originNames = new ArrayList<>();
        List<WebElement> results = webDriver.findElements(By.className("dropdownFlex1"));
        for(WebElement result : results) {
            originNames.add(result.getText());
        }

        originSearchBar.sendKeys(Keys.ESCAPE);
        return originNames;
    }

    /**
     * Clicks the destinations search bar to get destination filter options, adds the suggested
     * destination names to a list, closes the search bar results and returns the list.
     * @return list of names of the available destinations to filter on.
     * @throws InterruptedException
     */
    public List<String> getDestinationNames () throws InterruptedException {
        clickDestinationSearchBar();
        Thread.sleep(500);

        List<String> destinationNames = new ArrayList<>();
        List<WebElement> results = webDriver.findElements(By.className("dropdownFlex1"));
        for(WebElement result : results) {
            destinationNames.add(result.getText());
        }

        destinationSearchBar.sendKeys(Keys.ESCAPE);
        return destinationNames;
    }

    public void clickConfirmButton() {confirmButton.click();}

    public void clickClearFiltersButton() {clearFiltersButton.click();}
}
