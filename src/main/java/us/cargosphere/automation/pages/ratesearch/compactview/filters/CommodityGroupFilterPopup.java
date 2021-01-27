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

public class CommodityGroupFilterPopup extends BasePage {

    @FindBy(how = How.ID, using = "buttonApplyCommodityGroups")
    private WebElement confirmButton;
    @FindBy(how = How.ID, using = "buttonCancelCommodityGroups")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "buttonClearCommodityGroups")
    private WebElement clearFiltersButton;
    @FindBy(how = How.CSS, using = "#ui-select-commodity-groups > div:nth-child(1) > input")
    private WebElement commodityGroupSearchBar;
    @FindBy(how = How.CLASS_NAME, using = "ui-select-choices-group")
    private WebElement commGroupSearchBarResultElement;
    @FindBy(how = How.CSS, using = "#ui-select-industry-groups > div:nth-child(1) > input")
    private WebElement industryGroupSearchBar;
    @FindBy(how = How.ID, using = "ui-select-choices-group")
    private WebElement industryGroupSearchBarResultsElement;


    public CommodityGroupFilterPopup (WebDriver driver, WebElement el){
        super(driver, el);
    }

    /**
     * Searches for commodity groups to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param commGroupName - exact name of the commodity group
     */
    public void addCommGroupFilterByExactName (String commGroupName) throws InterruptedException {
        searchForCommodityGroup(commGroupName);
        Thread.sleep(500);
        selectCommGroupResult(0);
        clickConfirmButton();
        Thread.sleep(500);
    }

    /**
     * Searches for industry commodity groups to filter and selects the first
     * result and then applies that filter.  Expects the name to be exact
     * because the method uses the first search result.
     * @param commGroupName - exact name of the industry commodity group
     */
    public void addIndustryCommGroupFilterByExactName (String commGroupName) {
        searchForIndustryCommodityGroup(commGroupName);
        selectIndustryCommGroupResult(0);
        clickConfirmButton();
    }

    public int getCommGroupResultCount () throws InterruptedException {
        commodityGroupSearchBar.click();
        Thread.sleep(500);
        String [] resultsText  = SeleniumUtil.getText(commGroupSearchBarResultElement, false).split("\n");
        return resultsText.length;
    }

    public void searchForCommodityGroup (String searchValue) {
        clickCommodityGroupSearchBar();
        typeIntoCommodityGroupSearchBar(searchValue);
    }

    public void searchForIndustryCommodityGroup (String searchValue) {

    }

    public void clickCommodityGroupSearchBar () {
        commodityGroupSearchBar.click();
    }

    public void typeIntoCommodityGroupSearchBar (String searchValue) {
        commodityGroupSearchBar.sendKeys(searchValue);
    }

    public void clickIndustryCommGroupSearchBar () {
        industryGroupSearchBar.click();
    }

    public void typeIntoIndustryCommGroupSearchBar (String searchValue) {
        industryGroupSearchBar.sendKeys(searchValue);
    }

    public void selectCommGroupResult (int resultNumber) {
        // select the resultNumberth result
        for(int i=0; i < resultNumber; i++){
            commodityGroupSearchBar.sendKeys(Keys.ARROW_DOWN);
        }

        commodityGroupSearchBar.sendKeys(Keys.ENTER);
    }

    public void selectIndustryCommGroupResult (int resultNumber) {
        // select the resultNumberth result
        for(int i=0; i < resultNumber; i++){
            industryGroupSearchBar.sendKeys(Keys.ARROW_DOWN);
        }

        industryGroupSearchBar.sendKeys(Keys.ENTER);
    }

    public List<String> getCommGroupNames () throws InterruptedException {
        clickSearchBarIfCommGroupResultsNotVisible();
        String[] resultBarText = SeleniumUtil.getText(commGroupSearchBarResultElement, false).split("\n");
        return new ArrayList<>(Arrays.asList(resultBarText));
    }

    public List<String> getIndustryCommGroupNames () {
        String[] resultBarText = SeleniumUtil.getText(industryGroupSearchBarResultsElement, false).split("\n");
        return new ArrayList<>(Arrays.asList(resultBarText));
    }

    public void clickSearchBarIfCommGroupResultsNotVisible () throws InterruptedException {
        int timeSpent = 0;
        while(!commGroupSearchBarResultElement.isDisplayed()) {
            commodityGroupSearchBar.click();
            Thread.sleep(100);
            timeSpent += 100;
            if(timeSpent >= 3000) {
                throw new IllegalStateException("Commodity Group filter result select element will not display.");
            }
        }
    }

    public void clickConfirmButton() {confirmButton.click();}

    public void clickClearFiltersButton() {clearFiltersButton.click();}
}
