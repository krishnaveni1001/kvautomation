package us.cargosphere.automation.ratesearch.compactview;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.CommoditiesFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.CommodityGroupFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.ContractFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.FilterControls;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.LocationsFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.MoreFiltersPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.NamedAccountsFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.RoutingsFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.ServiceProviderFilterPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.MoreFiltersPopup.ContainerType;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FilterSteps extends BaseStepDefinitions {

    private RateSearchResultsPage resultsPage;

    public FilterSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^there are no filters applied$")
    public void there_are_no_filters_applied() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        assertEquals("Contracts", filterControls.getContractsFilterText());
        assertEquals("Service Providers", filterControls.getServiceProviderFilterText());
        assertEquals("Commodity Groups", filterControls.getCommodityGroupsFilterText());
        assertEquals("Commodities", filterControls.getCommoditiesFilterText());
        assertEquals("Named Accounts", filterControls.getNamedAccountsFilterText());
        assertEquals("Locations", filterControls.getLocationsFiltersText());
        assertEquals("Routings", filterControls.getRoutingsFiltersText());
        assertEquals("More Filters", filterControls.getMoreFiltersText());
    }


    @Then("^the filters are hidden$")
    public void the_filters_are_hidden() {
        assertFalse(resultsPage.getCompactView().getFilterControls().isVisible());
    }

    @Then("^the filters are visible$")
    public void the_filters_are_visible() {
        assertTrue(resultsPage.getCompactView().getFilterControls().isVisible());
    }

    @Then("^the toggle filter visibility button's text is now \"([^\"]*)\"$")
    public void the_toggle_filter_visibility_button_text_is_now(String text) throws Throwable {
        assertEquals(text, resultsPage.getCompactView().getDropDown().getToggleFilterVisibilityButtonText());
    }

    @When("^the user opens the contracts filter popup$")
    public void theUserOpensTheContractsFilterPopup() throws InterruptedException {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickContractsButton();
        Thread.sleep(300);
    }

    @Then("^the contract filter available contract names are$")
    public void theAvailableContractFilterNamesAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getContractsFilterPopup().getSearchResultContractNames()
        );
    }

    @Then("^the contract filter available carriers names are$")
    public void theAvailableCarriersNamesAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getContractsFilterPopup().getSearchResultCarrierNames()
        );
    }

    @Then("^the contract filter available source systems are$")
    public void theAvailableSourceSystemsAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getContractsFilterPopup().getSearchResultSystemNames()
        );
    }

    @When("^the user applies the contract filter for \"([^\"]*)\"$")
    public void theUserAppliesTheContractFilterFor(String contractName) throws Throwable {
        ContractFilterPopup popup = resultsPage.getCompactView().getFilterControls().getContractsFilterPopup();
        popup.addContractFilterByExactName(contractName);
    }

    @When("^the user clears the contract filters through the popup$")
    public void theUserClearsTheContractFiltersThroughThePopup() throws InterruptedException {
        ContractFilterPopup popup = resultsPage.getCompactView().getFilterControls().getContractsFilterPopup();
        popup.clickClearFiltersButton();
        Thread.sleep(500);
    }

    @When("^the user opens the service providers filter popup$")
    public void theUserOpensTheServiceProvidersFilterPopup() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickServiceProvidersButton();
    }

    @Then("^the available service provider filter carrier names are$")
    public void theAvailableServiceProviderFilterCarrierNamesAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getServiceProviderFilterPopup().getSearchResultCarrierNames()
        );
    }

    @Then("^the available service provider filter source system names are$")
    public void theAvailableServiceProviderFilterSourceSystemNamesAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getServiceProviderFilterPopup().getSearchResultSystemNames()
        );
    }

    @When("^the user applies the service providers filter for \"([^\"]*)\"$")
    public void theUserAppliesTheServiceProvidersFilterFor(String serviceProviderName) throws Throwable {
        ServiceProviderFilterPopup popup = resultsPage.getCompactView().getFilterControls().getServiceProviderFilterPopup();
        popup.addServiceProviderFilterByExactName(serviceProviderName);
    }

    @When("^the user clears the service providers filters through the popup$")
    public void theUserClearsTheServiceProvidersFiltersThroughThePopup() throws InterruptedException {
        ServiceProviderFilterPopup popup = resultsPage.getCompactView().getFilterControls().getServiceProviderFilterPopup();
        popup.clickClearFiltersButton();
        Thread.sleep(500);
    }

    @When("^the user opens the commodity groups filter popup$")
    public void theUserOpensTheCommodityGroupsFilterPopup() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickCommoditiesGroupButton();
    }

    @Then("^the available commodity groups are$")
    public void theAvailableCommodityGroupsAre(List<String> expected) throws InterruptedException {
        CommodityGroupFilterPopup popup = resultsPage.getCompactView().getFilterControls().getCommodityGroupFilterPopup();
        popup.clickCommodityGroupSearchBar();
        Thread.sleep(300);
        assertEquals(expected,
                popup.getCommGroupNames()
        );
    }

    @When("^the user applies the commodity group filter for \"([^\"]*)\"$")
    public void theUserAppliesTheCommodityGroupFilterFor(String commGroupName) throws Throwable {
        CommodityGroupFilterPopup popup = resultsPage.getCompactView().getFilterControls().getCommodityGroupFilterPopup();
        popup.addCommGroupFilterByExactName(commGroupName);
    }

    @When("^the user clears the commodity group filters through the popup$")
    public void theUserClearsTheCommodityGroupFiltersThroughThePopup() throws InterruptedException {
        CommodityGroupFilterPopup popup = resultsPage.getCompactView().getFilterControls().getCommodityGroupFilterPopup();
        popup.clickClearFiltersButton();
        Thread.sleep(500);
    }

    @When("^the user opens the commodities filter popup$")
    public void theUserOpensTheCommoditiesFilterPopup() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickCommoditiesButton();
    }

    @Then("^the available commodities are$")
    public void theAvailableCommoditiesAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getCommoditiesFilterPopup().getCommodityNames());
    }

    @When("^the user applies the commodities filter for \"([^\"]*)\"$")
    public void theUserAppliesTheCommoditiesFilterFor(String commodity) throws Throwable {
        CommoditiesFilterPopup popup = resultsPage.getCompactView().getFilterControls().getCommoditiesFilterPopup();
        popup.addCommodityFilterByExactName(commodity);
        Thread.sleep(500);
    }


    @When("^the user clears the commodities filters through the popup$")
    public void theUserClearsTheCommoditiesFiltersThroughThePopup() throws InterruptedException {
        CommoditiesFilterPopup popup = resultsPage.getCompactView().getFilterControls().getCommoditiesFilterPopup();
        popup.clickClearFiltersButton();
        Thread.sleep(500);
    }

    @When("^the user opens the named accounts filter popup$")
    public void theUserOpensTheNamedAccountsFilterPopup() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickNamedAccountsButton();
    }

    @Then("^the available named accounts are$")
    public void theAvailableNamedAccountsAre(List<String> expected) throws InterruptedException {
        NamedAccountsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getNamedAccountsFilterPopup();
        popup.clickSearchBar();
        Thread.sleep(500);
        assertEquals(expected,
                popup.getNamedAccountNames()
        );
    }

    @When("^the user applies the named account filter for \"([^\"]*)\"$")
    public void theUserAppliesTheNamedAccountFilterFor(String namedAcctName) throws Throwable {
        NamedAccountsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getNamedAccountsFilterPopup();
        popup.addNamedAcctFilterByExactName(namedAcctName);
        Thread.sleep(300);
    }

    @When("^the user opens the locations filter popup$")
    public void theUserOpensTheLocationsFilterPopup() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickLocationsButton();
    }

    @Then("^the available origin filters are$")
    public void theAvailableOriginFiltersAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getLocationsFilterPopup().getOriginNames());
    }

    @Then("^the available destination filters are$")
    public void theAvailableDestinationFiltersAre(List<String> expected) throws InterruptedException {
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getLocationsFilterPopup().getDestinationNames());
    }

    @When("^the user applies the origin filter for \"([^\"]*)\"$")
    public void theUserAppliesTheOriginFilterFor(String originName) throws Throwable {
        LocationsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getLocationsFilterPopup();
        popup.addOriginFilterByExactName(originName);
    }

    @When("^the user applies the destination filter for \"([^\"]*)\"$")
    public void theUserAppliesTheDestinationFilterFor(String destinationName) throws Throwable {
        LocationsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getLocationsFilterPopup();
        popup.addDestinationFilterByExactName(destinationName);
    }

    @When("^the user clears the location filters through the popup$")
    public void theUserClearsTheLocationFiltersThroughThePopup() throws InterruptedException {
        LocationsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getLocationsFilterPopup();
        popup.clickClearFiltersButton();
        Thread.sleep(500);
    }

    @When("^the user opens the routings filters popup$")
    public void theUserOpensTheRoutingsFiltersPopup() {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickRoutingsButton();
    }

    @Then("^the available origin routings filters are$")
    public void theAvailableOriginRoutingsFiltersAre(List<String> expected) throws InterruptedException {
        RoutingsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getRoutingsFilterPopup();
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getRoutingsFilterPopup().getOriginRoutingNames());
    }

    @Then("^the available destination routings filters are$")
    public void theAvailableDestinationRoutingsFiltersAre(List<String> expected) throws InterruptedException {
        RoutingsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getRoutingsFilterPopup();
        assertEquals(expected,
                resultsPage.getCompactView().getFilterControls().getRoutingsFilterPopup().getDestinationRoutingNames());
    }

    @When("^the user applies the routing filters for origin \"([^\"]*)\" and destination \"([^\"]*)\"$")
    public void theUserAppliesTheRoutingFiltersForOriginAndDestination(String origin, String dest) throws Throwable {
        RoutingsFilterPopup popup = resultsPage.getCompactView().getFilterControls().getRoutingsFilterPopup();
        popup.addOriginRoutingFilterByExactName(origin);
        popup.addDestinationRoutingFilterByExactName(dest);
        popup.clickConfirmButton();
        Thread.sleep(500);
    }

    @When("^the user opens the more filters popup$")
    public void theUserOpensTheMoreFiltersPopup() throws InterruptedException {
        FilterControls filterControls = resultsPage.getCompactView().getFilterControls();
        filterControls.clickMoreFiltersButton();
    }

    @When("^the user selects the 20 ft container filter$")
    public void theUserSelectsThe20FtContainerFilter() throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addContainerFilter(MoreFiltersPopup.ContainerType.CNTR_20_FOOT);
    }

    @When("^the user selects the 40 ft container filter$")
    public void theUserSelectsThe40FtContainerFilter() throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addContainerFilter(MoreFiltersPopup.ContainerType.CNTR_40_FOOT);
    }

    @When("^the user selects the 40 ft HC container filter$")
    public void theUserSelectsThe40FtHCContainerFilter() throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addContainerFilter(MoreFiltersPopup.ContainerType.CNTR_40_FOOT_HC);
    }

    @When("^the user selects the 45 ft HC container filter$")
    public void theUserSelectsThe45FtHCContainerFilter() throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addContainerFilter(MoreFiltersPopup.ContainerType.CNTR_45_FOOT_HC);
    }

    @When("^the user clears the filters through the more filters popup$")
    public void theUserClearsTheFiltersThroughTheMoreFiltersPopup() throws InterruptedException {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.clickClearFiltersButton();
    }

    @When("^the user selects the the Rate Type filter for \"([^\"]*)\"$")
    public void theUserSelectsTheTheRateTypeFilterFor(String rateType) throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addRateTypeFilter(rateType);
    }

    @When("^the user selects the the Rate Type Two filter for \"([^\"]*)\"$")
    public void theUserSelectsTheTheRateTypeTwoFilterFor(String rateTypeTwo) throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addRateTypeTwoFilter(rateTypeTwo);
    }

    @When("^the user selects the the Service String filter for \"([^\"]*)\"$")
    public void theUserSelectsTheTheServiceStringFilterFor(String serviceString) throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addServiceStringFilter(serviceString);
    }

    @When("^the user selects the the Service Type filter for \"([^\"]*)\"$")
    public void theUserSelectsTheTheServiceTypeFilterFor(String serviceType) throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addServiceTypeFilter(serviceType);
    }

    @When("^the user selects the the Vessel filter for \"([^\"]*)\"$")
    public void theUserSelectsTheTheVesselFilterFor(String vessel) throws Throwable {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.addVesselFilter(vessel);
    }

    @And("^the user applies the More Filters filters$")
    public void theUserAppliesTheMoreFiltersFilters() throws InterruptedException {
        MoreFiltersPopup popup = resultsPage.getCompactView().getFilterControls().getMoreFiltersPopup();
        popup.clickConfirmButton();
        Thread.sleep(500);
    }
}
