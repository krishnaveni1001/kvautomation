package us.cargosphere.automation.pages.ratesearch.compactview.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.ServiceProviderFilterPopup;

public class FilterControls extends BasePage {
    @FindBy(how = How.ID, using = "dropdownMenu3")
    private WebElement contractsButton;
    @FindBy(how = How.ID, using = "dropdownMenu4")
    private WebElement serviceProvidersButton;
    @FindBy(how = How.ID, using = "dropdownMenu5")
    private WebElement commodityGroupsButton;
    @FindBy(how = How.ID, using = "dropdownMenu6")
    private WebElement commoditiesButton;
    @FindBy(how = How.ID, using = "dropdownMenu7")
    private WebElement namedAccountsButton;
    @FindBy(how = How.ID, using = "dropdownMenu9")
    private WebElement locationsButton;
    @FindBy(how = How.ID, using = "dropdownMenu8")
    private WebElement routingsButton;
    @FindBy(how = How.ID, using = "dropdownMenu10")
    private WebElement moreFiltersButton;

    public FilterControls(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickContractsButton () {
        contractsButton.click();
    }

    public String getContractsFilterText () {
        return contractsButton.getText();
    }

    public ContractFilterPopup getContractsFilterPopup () throws InterruptedException {
        if(contractsButton.getAttribute("aria-expanded").equals("false")){
            contractsButton.click();
        }
        Thread.sleep(1000);
        return new ContractFilterPopup(webDriver, webDriver.findElement(
                By.id("contractsFilterDropDown")
        ));
    }

    public void clickServiceProvidersButton () {
        serviceProvidersButton.click();
    }

    public String getServiceProviderFilterText () {
        return serviceProvidersButton.getText();
    }

    public ServiceProviderFilterPopup getServiceProviderFilterPopup () throws InterruptedException {
        if(serviceProvidersButton.getAttribute("aria-expanded").equals("false")){
            serviceProvidersButton.click();
        }
        Thread.sleep(500);
        return new ServiceProviderFilterPopup(webDriver, webDriver.findElement(
                By.id("serviceProvidersFilterDropDown")
        ));
    }

    public void clickCommoditiesGroupButton () {
        commodityGroupsButton.click();
    }

    public String getCommodityGroupsFilterText () {
        return commodityGroupsButton.getText();
    }

    public CommodityGroupFilterPopup getCommodityGroupFilterPopup () throws InterruptedException {
        if(commodityGroupsButton.getAttribute("aria-expanded").equals("false")){
            commodityGroupsButton.click();
        }
        Thread.sleep(1000);
        return new CommodityGroupFilterPopup(webDriver, webDriver.findElement(
                By.id("commodityGroupsFilterDropdown")
        ));
    }

    public void clickCommoditiesButton () {
        commoditiesButton.click();
    }

    public String getCommoditiesFilterText () {
        return commoditiesButton.getText();
    }

    public CommoditiesFilterPopup getCommoditiesFilterPopup () throws InterruptedException {
        if(commoditiesButton.getAttribute("aria-expanded").equals("false")){
            commoditiesButton.click();
        }
        Thread.sleep(1000);
        return new CommoditiesFilterPopup(webDriver, webDriver.findElement(
                By.id("commoditiesFilterDropdown")
        ));
    }

    public void clickNamedAccountsButton () {
        namedAccountsButton.click();
    }

    public String getNamedAccountsFilterText () {
        return namedAccountsButton.getText();
    }

    public NamedAccountsFilterPopup getNamedAccountsFilterPopup () throws InterruptedException {
        if(namedAccountsButton.getAttribute("aria-expanded").equals("false")){
            namedAccountsButton.click();
        }
        Thread.sleep(1000);
        return new NamedAccountsFilterPopup(webDriver, webDriver.findElement(
                By.id("namedAccountsFilterDropdown")
        ));
    }

    public void clickLocationsButton () {
        locationsButton.click();
    }

    public String getLocationsFiltersText () {
        return locationsButton.getText();
    }

    public LocationsFilterPopup getLocationsFilterPopup () throws InterruptedException {
        if(locationsButton.getAttribute("aria-expanded").equals("false")){
            locationsButton.click();
        }
        Thread.sleep(1000);
        return new LocationsFilterPopup(webDriver, webDriver.findElement(
                By.id("locationsFilterDropdown")
        ));
    }

    public void clickRoutingsButton () {
        routingsButton.click();
    }

    public String getRoutingsFiltersText () {
        return routingsButton.getText();
    }

    public RoutingsFilterPopup getRoutingsFilterPopup () throws InterruptedException {
        if(routingsButton.getAttribute("aria-expanded").equals("false")){
            routingsButton.click();
        }
        Thread.sleep(1000);
        return new RoutingsFilterPopup(webDriver, webDriver.findElement(
                By.id("routingsFilterDropdown")
        ));
    }

    public void clickMoreFiltersButton () {
        moreFiltersButton.click();
    }

    public String getMoreFiltersText () {
        return moreFiltersButton.getText();
    }

    public MoreFiltersPopup getMoreFiltersPopup () throws InterruptedException {
        if(moreFiltersButton.getAttribute("aria-expanded").equals("false")){
            moreFiltersButton.click();
        }
        Thread.sleep(2000);
        return new MoreFiltersPopup(webDriver, webDriver.findElement(
                By.id("moreFiltersDropdown")
        ));
    }

    public boolean isVisible () {
        WebElement filterBanner = webDriver.findElement(By.cssSelector("#compactViewTemplate > compact-filters > div.primaryFilters"));
        return !Boolean.parseBoolean(filterBanner.getAttribute("aria-hidden"));
    }
}
