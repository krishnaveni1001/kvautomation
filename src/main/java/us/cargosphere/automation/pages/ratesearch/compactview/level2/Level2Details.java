package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.pages.BasePage;

/**
 * A PageObject fragment representing the Level2 details that are shown when a
 * user clicks on a price
 */
public class Level2Details extends BasePage {
    private final String row;

    private WebElement context;

    private PricingTab pricingTab;
    private ServiceInfoTab serviceInfoTab;
    private CommoditiesTab commoditiesTab;
    private ContractTab contractTab;
    private NamedAccountsTab namedAccountsTab;

    /**
     * Enumeration of the possible tabs in the level2 details
     */
    public enum Tab {
        PRICING, SERVICE_INFO, COMMODITIES, CONTRACT, SCHEDULES, NAMED_ACCOUNTS, FREE_TIME
    }

    public Level2Details(WebDriver webDriver, WebElement searchContext, int rowNum) {
        super(webDriver, searchContext);
        this.row = Integer.toString(rowNum);
        this.context = searchContext;
        // We can initialize the pricing tab in the constructor because it is always 
        // available in the DOM. This is not possible with the other tabs because 
        // they are conditionally shown with ng-if statements.
        pricingTab = new PricingTab(webDriver,
                context.findElement(By.cssSelector("#compactPricingTab")), row);
    }

    /**
     * Checks whether the given tab of the level2 detail area is selected.
     * 
     * @param tab the {@link Tab} within the level2 details
     * @return {@code true} if the given tab is active, {@code false} otherwise.
     */
    public boolean isTabActive(Tab tab) {
        String c = getTabHeaderBtn(tab).getAttribute("class");
        if (c != null && c.contains("headerActive"))
            return true;
        return false;
    }

    /**
     * Gets the WebElement representing the Tab Header
     */
    public WebElement getTabHeaderBtn(Tab tab) {
        String baseCssId;

        switch (tab) {
            case PRICING:
                baseCssId = "#pricing-header-";
                break;
            case SERVICE_INFO:
                baseCssId = "#service-info-header-";
                break;
            case COMMODITIES:
                baseCssId = "#commodities-header-";
                break;
            case CONTRACT:
                baseCssId = "#contract-header-";
                break;
            case SCHEDULES:
                baseCssId = "#schedules-header-";
                break;
            case NAMED_ACCOUNTS:
                baseCssId = "#named-accounts-header-";
                break;
            case FREE_TIME:
                baseCssId = "#free-time-header-";
                break;
            default:
                throw new UnsupportedOperationException(
                        "method getTabHeaderBtn has not implemented handling for the given Tab type");
        }

        return context.findElement(By.cssSelector(baseCssId + row + " > span:nth-child(1)"));
    }

    /**
     * Clicks the given Level 2 detail tab
     */
    public void clickTabHeaderBtn(Tab tab) {
        getTabHeaderBtn(tab).click();
    }

    public PricingTab getPricingTab() {
        if (!isTabActive(Tab.PRICING)) {
            throw new IllegalStateException(
                    "The Pricing tab cannot be retrieved unless it is currently visible tab. You may need to click the tab first.");
        }
        return pricingTab;
    }

    public ServiceInfoTab getServiceInfoTab() {
        if (!isTabActive(Tab.SERVICE_INFO)) {
            throw new IllegalStateException(
                    "The Service Info tab cannot be retrieved unless it is currently visible tab. You may need to click the tab first.");
        }
        if (serviceInfoTab == null) {
            serviceInfoTab = new ServiceInfoTab(webDriver,
                    context.findElement(By.cssSelector("#compact-service-info-" + row)), row);
        }
        return serviceInfoTab;
    }

    public CommoditiesTab getCommoditiesTab() {
        if (!isTabActive(Tab.COMMODITIES)) {
            throw new IllegalStateException(
                    "The Commodities tab cannot be retrieved unless it is currently visible tab. You may need to click the tab first.");
        }
        if (commoditiesTab == null) {
            commoditiesTab = new CommoditiesTab(webDriver,
                    context.findElement(By.id("compactCommoditiesTab")), row);
        }
        return commoditiesTab;
    }

    public ContractTab getContractTab() {
        if (!isTabActive(Tab.CONTRACT)) {
            throw new IllegalStateException(
                    "The Contract tab cannot be retrieved unless it is currently visible tab. You may need to click the tab first.");
        }
        if (contractTab == null) {
            contractTab = new ContractTab(webDriver,
                    context.findElement(By.id("compactContractTab")));
        }
        return contractTab;
    }

    public NamedAccountsTab getNamedAccountsTab() {
        if (!isTabActive(Tab.NAMED_ACCOUNTS)) {
            clickTabHeaderBtn(Tab.NAMED_ACCOUNTS);
        }
        if (namedAccountsTab == null) {
            namedAccountsTab = new NamedAccountsTab(webDriver,
                    context.findElement(By.id("compactNamedAccountsTab")));
        }
        return namedAccountsTab;
    }

    /**
     * Gets the text from the header of the level 2 detail
     */
    public String getHeaderText() {
        return context.findElement(By.id("detail-header-" + row)).getText();
    }

    /**
     * Gets the date range that is shown in the level 2 details. This should be the
     * date range that the price is effective for.
     */
    public String getDateRangeText() {
        return context.findElement(By.className("dateHeader")).getText();
    }
}