package us.cargosphere.automation.ratesearch;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.startpage.RateSearchStartPage;
import us.cargosphere.automation.pages.ratesearch.startpage.SearchControls;
import us.cargosphere.automation.pages.ratesearch.startpage.SearchControls.BuyType;
import us.cargosphere.automation.pages.ratesearch.startpage.SearchControls.LoadType;

public class RateSearchStartPageSteps extends BaseStepDefinitions {
    private RateSearchStartPage startPage;

    public RateSearchStartPageSteps(TestContext context) {
        super(context);
        startPage = this.testContext.getPageObjectManager().getRateSearchStartPage();
    }

    @When("^the user navigates from the rate search start page to the activity menu$")
    public void theUserNavigatesFromTheRateSearchStartPageToTheActivityMenu()
            throws InterruptedException {
        startPage.getTopNavigationMenuBar().clickRateMgmtNav();
        Thread.sleep(2000);
    }

    @When("^the user performs a classic view rate search for \"([^\"]*)\" to \"([^\"]*)\"$")
    public void that_user_performs_a_classic_rate_search_for(String originString, String destinationString)
            throws InterruptedException {

        String [] origins = originString.replace(" ", "").split(",");
        String [] destinations = destinationString.replace(" ", "").split(",");

        startPage.getViewSwitch().clickClassicViewBtn();
        SearchControls searchControls = startPage.getSearchControls();

        for(String origin : origins) {
            searchControls.selectOrigin(origin);
        }

        for(String destination : destinations) {
            searchControls.selectDestination(destination);
        }

        searchControls.search();
    }

    // Search for multiple origin and destinations by passing a comma separated list of location names
    @When("^the user performs a compact view rate search for \"([^\"]*)\" to \"([^\"]*)\"$")
    public void that_user_performs_a_compact_rate_search_for(String originString, String destinationString)
            throws InterruptedException {

        String [] origins = originString.replace(" ", "").split(",");
        String [] destinations = destinationString.replace(" ", "").split(",");

        startPage.getViewSwitch().clickCompactViewBtn();
        SearchControls searchControls = startPage.getSearchControls();

        for(String origin : origins) {
            searchControls.selectOrigin(origin);
        }

        for(String destination : destinations) {
            searchControls.selectDestination(destination);
        }

        searchControls.search();
    }

    // Search for multiple origin and destinations by passing a comma separated list of location names
    @When("^the user performs a rate search for \"([^\"]*)\" to \"([^\"]*)\"$")
    public void that_user_performs_a_rate_search_for(String originString, String destinationString)
            throws InterruptedException {
        String [] origins = originString.replace(" ", "").split(",");
        String [] destinations = destinationString.replace(" ", "").split(",");

        SearchControls searchControls = startPage.getSearchControls();

        for(String origin : origins) {
            searchControls.selectOrigin(origin);
        }

        for(String destination : destinations) {
            searchControls.selectDestination(destination);
        }

        searchControls.selectRateTypeOption(LoadType.FCL, BuyType.BUY);
        searchControls.search();
        Thread.sleep(2000);
    }

    @Then("^the user is redirected to the rate search results page$")
    public void the_user_is_redirected_to_the_rate_search_results_page() {
        assertTrue(this.getDriver().getCurrentUrl().contains("ptrade/ratesearch/results.jsp"));
    }

    @Given("^the user is on the rate search Start page$")
    public void the_user_is_on_the_rate_search_Start_page() {
        assertTrue(this.getDriver().getCurrentUrl().contains("ptrade/ratesearch/start.jsp"));
    }

    @When("^the user changes the View Toggle from Classic View to Compact View$")
    public void the_user_changes_the_View_Toggle_from_Classic_View_to_Compact_View() {
        startPage.getViewSwitch().clickClassicViewBtn();
        startPage.getViewSwitch().clickCompactViewBtn();
    }

    @When("^the user changes the View Toggle from Compact View to Classic View$")
    public void the_user_changes_the_View_Toggle_from_Compact_View_to_Classic_View() {
        startPage.getViewSwitch().clickCompactViewBtn();
        startPage.getViewSwitch().clickClassicViewBtn();
    }

    @And("^the user changes the rate type to LCL Buy$")
    public void theUserChangesTheRateTypeToLCLBuy() throws InterruptedException {
        startPage.getSearchControls().selectRateTypeOption(LoadType.LCL, BuyType.BUY);
    }
}
