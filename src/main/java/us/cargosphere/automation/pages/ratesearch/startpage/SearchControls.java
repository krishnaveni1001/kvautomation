package us.cargosphere.automation.pages.ratesearch.startpage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;

/**
 * SearchControls is a page fragment representing the origin/destination, search
 * button, LCL/FCL dropdown, and other search controls that are common to both
 * the rate search Start page and Results page.
 */
public class SearchControls extends BasePage {
    @FindBy(how = How.CLASS_NAME, using = "originContainer")
    @CacheLookup
    private WebElement originContainer;

    @FindBy(how = How.CLASS_NAME, using = "destContainer")
    @CacheLookup
    private WebElement destinationContainer;

    @FindBy(how = How.ID, using = "originSearch")
    @CacheLookup
    private WebElement originSearch;

    @FindBy(how = How.ID, using = "destSearch")
    @CacheLookup
    private WebElement destinationSearch;

    @FindBy(how = How.ID, using = "buySellRates")
    @CacheLookup
    private WebElement rateTypeDropdown;

    @FindBy(how = How.ID, using = "searchfclBuyRadio")
    @CacheLookup
    private WebElement fclBuyBtn;

    @FindBy(how = How.ID, using = "searchlclBuyRadio")
    @CacheLookup
    private WebElement lclBuyBtn;

    @FindBy(how = How.ID, using = "searchfclSellRadio")
    @CacheLookup
    private WebElement fclSellBtn;

    @FindBy(how = How.ID, using = "searchlclSellRadio")
    @CacheLookup
    private WebElement lclSellBtn;

    @FindBy(how = How.ID, using = "rateSearchBtn")
    @CacheLookup
    private WebElement searchBtn;

    /**
     * Options for load type to use for the rate search
     */
    public enum LoadType {
        LCL, FCL
    }

    /**
     * Options for Buy/Sell rate types
     */
    public enum BuyType {
        BUY, SELL
    }

    public SearchControls(WebDriver webDriver, WebElement container) {
        super(webDriver, container);
    }

    /**
     * Used to select the buy/sell, lcl/fcl rate type options.
     * 
     * @param loadType {@link LoadType} for example, LCL or FCL
     * @param buyType  {@link BuyType} for example BUY or SELL
     */
    public void selectRateTypeOption(LoadType loadType, BuyType buyType) {
        // open the dropdown menu
        rateTypeDropdown.click();

        // select an option
        if (loadType == LoadType.LCL && buyType == BuyType.BUY) {
            lclBuyBtn.click();
            return;
        } else if (loadType == LoadType.LCL && buyType == BuyType.SELL) {
            lclSellBtn.click();
            return;
        } else if (loadType == LoadType.FCL && buyType == BuyType.BUY) {
            fclBuyBtn.click();
            return;
        } else if (loadType == LoadType.FCL && buyType == BuyType.SELL) {
            fclSellBtn.click();
            return;
        }

        throw new IllegalArgumentException("Unsupported LoadType and/or BuyType.");
    }

    /**
     * Used to pick an origin for the search. This will perform an autocomplete
     * search and pick the first result from the autocomplete suggestions.
     * 
     * @param originSearchString The search string used for autocomplete
     */
    public void selectOrigin(String originSearchString) throws InterruptedException {
        originContainer.click();
        originSearch.sendKeys(originSearchString);
        Thread.sleep(2000);
        originSearch.sendKeys(Keys.TAB, Keys.ENTER);
    }

    /**
     * Used to pick a destination for the search. This will perform an autocomplete
     * search and pick the first result from the autocomplete suggestions.
     * 
     * @param destSearchString The search string used for autocomplete.
     */
    public void selectDestination(String destSearchString) throws InterruptedException {
        destinationContainer.click();
        destinationSearch.sendKeys(destSearchString);
        // TODO: replace Thread.sleep with wait
        Thread.sleep(2000);
        destinationSearch.sendKeys(Keys.TAB, Keys.ENTER);
    }

    /**
     * Performs a rate search.
     * 
     * @return {@link RateSearchResultsPage} the results page.
     * @throws InterruptedException
     */
    public RateSearchResultsPage search() throws InterruptedException {
        searchBtn.click();
        // TODO: replace Thread.sleep
        Thread.sleep(2000);
        return new RateSearchResultsPage(this.webDriver);
    }
}
