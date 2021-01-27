package us.cargosphere.automation.pages.ratesearch.compactview.filters;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderFilterPopup extends BasePage {

    @FindBy(how = How.ID, using = "buttonApplyCarriers")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelCarriers")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearCarriers")
    private WebElement clearFiltersButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-select-service-providers\"]/div[1]/input")
    private WebElement searchBar;
    @FindBy(how = How.CLASS_NAME, using = "ui-select-choices-group")
    private WebElement searchBarResultsListElement;

    public ServiceProviderFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    /**
     * Searches for service providers to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param providerName - exact name of the search provider
     */
    public void addServiceProviderFilterByExactName (String providerName) throws InterruptedException {
        searchForServiceProvider(providerName);
        Thread.sleep(800);
        selectResult(0);
        clickConfirmButton();
        Thread.sleep(1000);
    }

    public int getResultCount () throws InterruptedException {
        searchBar.click();
        Thread.sleep(500);
        String [] resultsText  = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        return resultsText.length / 2;
    }

    public void searchForServiceProvider (String searchValue) throws InterruptedException {
        clickSearchBarIfResultsHidden();
        typeIntoSearchBar(searchValue);
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

    public List<String> getSearchResultCarrierNames () throws InterruptedException {
        clickSearchBarIfResultsHidden();
        List<String> result = new ArrayList<>();
        String[] resultBarText = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        for(int i = 0; i < resultBarText.length; i = i+3) {
            result.add(resultBarText[i]);
        }
        return result;
    }

    public List<String> getSearchResultSystemNames () throws InterruptedException {
        clickSearchBarIfResultsHidden();
        List<String> result = new ArrayList<>();
        String[] resultBarText = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        for(int i = 1; i < resultBarText.length; i = i+3) {
            result.add(resultBarText[i]);
        }
        return result;
    }

    public void clickSearchBarIfResultsHidden() throws InterruptedException {
        int timeSpent = 0;
        while(!searchBarResultsListElement.isDisplayed()) {
            searchBar.click();
            Thread.sleep(100);
            timeSpent += 100;
            if(timeSpent >= 3000) {
                throw new IllegalStateException("Service Provider result select will not display");
            }
        }
    }

    public void clickConfirmButton () {
        confirmButton.click();
    }

    public void clickClearFiltersButton () {clearFiltersButton.click();}
}
