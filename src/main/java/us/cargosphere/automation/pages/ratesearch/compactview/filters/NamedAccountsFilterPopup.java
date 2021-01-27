package us.cargosphere.automation.pages.ratesearch.compactview.filters;

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

public class NamedAccountsFilterPopup extends BasePage {

    @FindBy(how = How.ID, using = "buttonApplyNamedAcct")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelNamedAcct")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearNamedAcct")
    private WebElement clearFiltersButton;
    @FindBy(how = How.CSS, using = "#ui-select-named-accounts > div:nth-child(1) > input")
    private WebElement searchBar;
    @FindBy(how = How.CLASS_NAME, using = "ui-select-choices-group")
    private WebElement searchBarResultsElement;

    public NamedAccountsFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    /**
     * Searches for named accounts to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param namedAcctName - exact name of the named account to be filtered on
     */
    public void addNamedAcctFilterByExactName (String namedAcctName) throws InterruptedException {
        searchForNamedAcct(namedAcctName);
        Thread.sleep(400);
        selectResult(0);
        clickConfirmButton();
    }

    public void searchForNamedAcct(String searchValue) throws InterruptedException {
        clickSearchBar();
        Thread.sleep(200);
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
        String [] resultsText  = SeleniumUtil.getText(searchBarResultsElement, false).split("\n");
        return resultsText.length;
    }

    public List<String> getNamedAccountNames () {
        String[] resultBarText = SeleniumUtil.getText(searchBarResultsElement, false).split("\n");
        return new ArrayList<>(Arrays.asList(resultBarText));
    }

    public void clickConfirmButton() {confirmButton.click();}

    public void clickClearFiltersButton() {clearFiltersButton.click();}
}
