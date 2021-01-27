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

public class CommoditiesFilterPopup extends BasePage {

    @FindBy(how = How.ID, using = "buttonApplyCommodities")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelCommodities")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearCommodities")
    private WebElement clearFiltersButton;
    @FindBy(how = How.CSS, using = "#ui-select-commodities > div:nth-child(1) > input")
    private WebElement searchBar;
    @FindBy(how = How.CLASS_NAME, using = "ui-select-choices-row ng-scope active")
    private List<WebElement> searchBarResults;

    public CommoditiesFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    /**
     * Searches for commodities to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param commodityName - exact name of the commodity to be filtered on
     */
    public void addCommodityFilterByExactName (String commodityName) throws InterruptedException {
        searchForCommodity(commodityName);
        selectResult(0);
        clickConfirmButton();
    }

    public void searchForCommodity (String searchValue) throws InterruptedException {
        clickSearchBar();
        typeIntoSearchBar(searchValue);
        Thread.sleep(500);
    }

    public void clickSearchBar () {
        searchBar.click();
    }

    public void typeIntoSearchBar (String searchValue) {
        searchBar.sendKeys(searchValue);
    }

    public void selectResult (int resultNumber) {
        // select the resultNumberth result
        for(int i=0; i < resultNumber; i++){
            searchBar.sendKeys(Keys.ARROW_DOWN);
        }

        searchBar.sendKeys(Keys.ENTER);
    }

    public int getResultCount () throws InterruptedException {
        searchBar.click();
        Thread.sleep(3000);
        return searchBarResults.size();
    }

    public List<String> getCommodityNames () throws InterruptedException {
        clickSearchBar();
        Thread.sleep(500);

        List<String> destinationNames = new ArrayList<>();
        List<WebElement> results = webDriver.findElements(By.className("dropdownFlex1"));
        for(WebElement result : results) {
            destinationNames.add(result.getAttribute("innerText"));
        }

        searchBar.sendKeys(Keys.ESCAPE);
        return destinationNames;
    }

    public void clickConfirmButton() {confirmButton.click();}

    public void clickClearFiltersButton() {clearFiltersButton.click();}
}
