package us.cargosphere.automation.ratesearch.compactview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.InvalidArgumentException;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.CompactView;
import us.cargosphere.automation.pages.ratesearch.compactview.CompactViewRow;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.ServiceProviderFilterPopup;

import java.util.List;

import static org.junit.Assert.*;

public class CompactViewSteps extends BaseStepDefinitions {
    private final RateSearchResultsPage resultsPage;
    private CompactView compactView;

    public CompactViewSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
        compactView = resultsPage.getCompactView();
    }

    /**
     * @param rowNum row number, counting starts from 1.
     */
    @When("^the user clicks the 20 ft container rate price on row (\\d+) of the compact view$")
    public void the_user_clicks_the_20_ft_price_on_row(int rowNum) throws InterruptedException {
        int rowIdx = rowNum - 1;
        compactView.getRowByIndex(rowIdx).clickCntr20ftPrice();
        Thread.sleep(2000);
    }

    /**
     * @param rowNum row number, counting starts from 1.
     */
    @When("^the user clicks the 40 ft container rate price on row (\\d+) of the compact view$")
    public void the_user_clicks_the_40_ft_price_on_row(int rowNum) throws InterruptedException {
        int rowIdx = rowNum - 1;
        compactView.getRowByIndex(rowIdx).clickCntr40ftPrice();
        Thread.sleep(2000);
    }

    @Then("^(\\d+) rate search results are shown in the compact view$")
    public void x_rate_search_results_are_shown(int expectedCount) {
        assertEquals(expectedCount, compactView.getResultCount());
    }

    @Then("^the grid column order is \"([^\"]*)\"$")
    public void the_grid_column_order_is(String colOrderString) {
        // Strip argument string of delimiting spaces and place in array
        colOrderString = colOrderString.replaceAll(", ", ",");
        String[] colOrderArray = colOrderString.split(",");

        ArrayList<String> colOrderList = new ArrayList<>(Arrays.asList(colOrderArray));
        assertEquals(colOrderList, compactView.getColumnNames());
    }

    @When("^the user moves the \"([^\"]*)\" column to position (\\d+)$")
    public void the_user_swaps_columns(String colName, int position) {
        compactView.moveColumnToPosition(colName, position);
        compactView = resultsPage.getCompactView();
    }

    @When("^the user saves the column order preference$")
    public void the_user_saves_the_column_order_preference() throws Throwable {
        compactView.getDropDown().saveColumnOrder();
    }

    @When("^the user resets the column order preference$")
    public void the_user_resets_the_column_order_preference() throws Throwable {
        compactView.getDropDown().resetColumnOrder();
    }

    @When("^the user applies a Service Provider filter for \"([^\"]*)\"$")
    public void the_user_applies_a_service_provider_filter_for(String providerName) throws Throwable {
        ServiceProviderFilterPopup filterPopup = compactView.getFilterControls().getServiceProviderFilterPopup();
        filterPopup.addServiceProviderFilterByExactName(providerName);
    }

    @When("^the user clears their filters through the dropdown$")
    public void theUserClearsTheirFiltersThroughTheDropdown() throws Throwable {
        compactView.getDropDown().clearFilters();
    }

    @When("^the user toggles the filter visibility through the dropdown$")
    public void theUserHidesTheFiltersThroughTheDropdown() throws InterruptedException {
        compactView.getDropDown().toggleFilterVisibility();
    }


    @Then("^the contracts present in the grid view result are$")
    public void theContractsPresentInTheGridViewResultAre(List<String> contractNames) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String contractName = row.getContractName();
            assertTrue(contractNames.contains(contractName));
        }
    }

    @Then("^the service providers present in the grid view result are$")
    public void theServiceProvidersPresentInTheGridViewResultAre(List<String> carrierNames) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String actual = row.getCarrierName().trim();
            String message = "Carrier name " + actual + " not in expected carriers.";
            assertTrue(message, carrierNames.contains(actual));
        }
    }

    @Then("^the commodity groups present in the grid view result are$")
    public void theCommodityGroupsPresentInTheGridViewResultAre(List<String> commGroupNames) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String actual = row.getCommGroupName().trim();
            String message = "Comm group name " + actual + " not in expected comm group names.";
            assertTrue(message, commGroupNames.contains(actual));
        }
    }


    @Then("^the named account groups present in the grid view result are$")
    public void theNamedAccountGroupsPresentInTheGridViewResultAre(List<String> namedAcctGroupNames) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String actual = row.getNamedAccountGroup().trim();
            String message = "Named account group " + actual + " not in expected named account group names.";
            assertTrue(message, namedAcctGroupNames.contains(actual));
        }
    }

    @Then("^the named accounts present in the grid view result are$")
    public void theNamedAccountsPresentInTheGridViewResultAre(List<String> namedAcctNames) throws InterruptedException {
        List<CompactViewRow> resultRows = compactView.getRows();
        System.out.println("resultRows size = " + resultRows.size());
        for(CompactViewRow row : resultRows) {
            for(String namedAccount : row.getNamedAccounts()) {
                String actual = namedAccount.trim();
                String message = "Named account " + actual + " not in expected named account names.";
                assertTrue(message, namedAcctNames.contains(actual));
            }
        }
    }

    @Then("^there are no rates with named accounts in the results$")
    public void thereAreNoRatesWithNamedAccountsInTheResults() {
        // If there are no rates with named accounts, the column will not be displayed
        assertFalse(compactView.getColumnNames().contains("Named Account"));
    }

    @Then("^the origins present in the grid view result are$")
    public void theOriginsPresentInTheGridViewResultAre(List<String> originNames) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String actual = row.getOrigin().trim();
            String message = "Origin name " + actual + " not in expected origins.";
            assertTrue(message, originNames.contains(actual));
        }
    }

    @Then("^the destinations present in the grid view result are$")
    public void theDestinationsPresentInTheGridViewResultAre(List<String> destinationNames) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String actual = row.getDestination().trim();
            String message = "Origin name " + actual + " not in expected origins.";
            assertTrue(message, destinationNames.contains(actual));
        }
    }

    @Then("^all rates in the results have prices for container type \"([^\"]*)\"$")
    public void allRatesInTheResultsHavePricesForContainerType(String containerType) throws Throwable {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String price;
            switch (containerType) {
                case "Cntr. 20 ft":
                    price = row.getContainer20FootPrice();
                    break;
                case "Cntr. 40 ft":
                    price = row.getContainer40FootPrice();
                    break;
                case "Cntr. 40 ft HC":
                    price = row.getContainer40FootHCPrice();
                    break;
                case "Cntr. 45 ft HC":
                    price = row.getContainer45FootHCPrice();
                    break;
                default:
                    throw new InvalidArgumentException("Not a valid container type");
            }
            assertNotNull(price);
            assertFalse(price.isEmpty());
        }
    }

    @Then("^all grid view results have the commodities$")
    public void allGridViewResultsHaveTheCommodities(List<String> expected) throws InterruptedException {
        List<CompactViewRow> resultRows = compactView.getRows();
        for(CompactViewRow row : resultRows) {
            row.clickCommGroupDropdownArrow();
            List<String> commodityNames = row.getLevel2Details().getCommoditiesTab().getIncludedCommodityNames();
            for (String expectedCommName : expected) {
                String message = "Commodity name " + expectedCommName + " not contained in included commodities";
                assertTrue(message, commodityNames.contains(expectedCommName));
            }
        }
    }

    @Then("^all rates in the results have rate type \"([^\"]*)\"$")
    public void allRatesInTheResultsHaveRateType(String expected) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String rateType = row.getRateType();
            assertEquals(expected, rateType);
        }
    }

    @Then("^all rates in the results have rate type two \"([^\"]*)\"$")
    public void allRatesInTheResultsHaveRateTypeTwo(String expected) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String rateTypeTwo = row.getRateTypeTwo();
            assertEquals(expected, rateTypeTwo);
        }
    }

    @Then("^all rates in the results have service string \"([^\"]*)\"$")
    public void allRatesInTheResultsHaveServiceString(String expected) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String serviceString = row.getServiceString();
            assertEquals(expected, serviceString);
        }
    }

    @Then("^all rates in the results have service type \"([^\"]*)\"$")
    public void allRatesInTheResultsHaveServiceType(String expected) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String serviceType = row.getServiceType();
            assertEquals(expected, serviceType);
        }
    }

    @Then("^all rates in the results have vessel \"([^\"]*)\"$")
    public void allRatesInTheResultsHaveVessel(String expected) {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            String vessel = row.getVessel();
            assertEquals(expected, vessel);
        }
    }

    @Then("^all rates in the results have routing for origin \"([^\"]*)\" and destination \"([^\"]*)\"$")
    public void allRatesInTheResultsHaveRoutingFor(String origin, String dest) throws Throwable {
        List<CompactViewRow> resultRows = compactView.getRows();

        for(CompactViewRow row : resultRows) {
            List<String> routing = row.getRouting();
            assertEquals("Expected result to have both origin and destination routing.", routing.size(), 4);

            String actualOriginRouting = routing.get(1);
            String originMessage = "Expected origin routing to be " + origin + ", actual: " + actualOriginRouting;
            assertEquals(originMessage, origin, actualOriginRouting);

            String actualDestRouting = routing.get(2);
            String destMessage = "Expected destination routing to be " + dest + ", actual: " + actualDestRouting;
            assertEquals(destMessage, dest, actualDestRouting);
        }
    }
    
    @Then("^the user should see the Carrier logo$")
    public void the_user_should_see_the_carrier_logo() throws Throwable {
    	assertTrue(compactView.showCarrierLogo());
    	
        }
    
    @Then("^the user should see Owner logo$")
    public void the_user_should_see_Owner_logo() throws Throwable {
    	assertTrue(compactView.showOwnerLogo());
    }

    @Then("^the shipment info field is hidden$")
    public void theShipmentInfoFieldIsHidden() {
        assertFalse(compactView.isPiecesDropdownButtonDisplayed());
    }

    @Then("^the shipment info field is visible$")
    public void theShipmentInfoFieldIsVisible() {
        assertTrue(compactView.isPiecesDropdownButtonDisplayed());
    }
}