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

public class ContractFilterPopup extends BasePage {
    @FindBy(how = How.ID, using = "buttonApplyContracts")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelContracts")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearContracts")
    private WebElement clearFiltersButton;
    @FindBy(how = How.CSS, using = "#ui-select-contracts > div:nth-child(1) > input")
    private WebElement searchBar;
    @FindBy(how = How.CLASS_NAME, using = "ui-select-choices-group")
    private WebElement searchBarResultsListElement;

    public ContractFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    /**
     * Searches for contracts by name to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param providerName - exact name of contract to be filtered on.
     */
    public void addContractFilterByExactName(String providerName) throws InterruptedException {
        searchForContracts(providerName);
        selectResult(0);
        clickConfirmButton();
        Thread.sleep(1000);
    }

    public void searchForContracts(String searchValue) {
        clickSearchBar();
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

    public int getResultCount () throws InterruptedException {
        searchBar.click();
        Thread.sleep(500);
        String [] resultsText  = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        return resultsText.length / 3;
    }

    public List<String> getSearchResultContractNames () throws InterruptedException {
        clickSearchBarIfResultsNotVisible();
        List<String> result = new ArrayList<>();
        String[] resultBarText = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        for(int i = 0; i < resultBarText.length; i = i+3) {
            result.add(resultBarText[i]);
        }
        return result;
    }

    public List<String> getSearchResultSystemNames () throws InterruptedException {
        clickSearchBarIfResultsNotVisible();
        List<String> result = new ArrayList<>();
        String[] resultBarText = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        for(int i = 1; i < resultBarText.length; i = i+3) {
            result.add(resultBarText[i]);
        }
        return result;
    }

    public List<String> getSearchResultCarrierNames () throws InterruptedException {
        clickSearchBarIfResultsNotVisible();
        List<String> result = new ArrayList<>();
        String[] resultBarText = SeleniumUtil.getText(searchBarResultsListElement, false).split("\n");
        for(int i = 2; i < resultBarText.length; i = i+3) {
            result.add(resultBarText[i]);
        }
        return result;
    }

    public void clickSearchBarIfResultsNotVisible() throws InterruptedException {
        int timeSpent = 0;
        while(!searchBarResultsListElement.isDisplayed()){
            searchBar.click();
            Thread.sleep(100);
            timeSpent += 100;
            if(timeSpent >= 3000) {
                throw new IllegalStateException("Contract Filter result select element will not display");
            }
        }
    }

    public void clickConfirmButton () {
        confirmButton.click();
    }

    public void clickClearFiltersButton () {
        clearFiltersButton.click();
    }
}
