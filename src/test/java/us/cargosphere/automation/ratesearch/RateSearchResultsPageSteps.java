package us.cargosphere.automation.ratesearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.startpage.ViewSwitch;

public class RateSearchResultsPageSteps extends BaseStepDefinitions {
    private RateSearchResultsPage resultsPage;

    public RateSearchResultsPageSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^the hover text of the classic view button says \"([^\"]*)\"$")
    public void verify_hover_text_classic_view(String expectedText) {
        assertEquals(expectedText, resultsPage.getViewSwitch().getClassicViewBtn().getAttribute("title"));
    }

    @Then("^the hover text of the compact view button says \"([^\"]*)\"$")
    public void verify_hover_text_compact_view(String expectedText) {
        assertEquals(expectedText, resultsPage.getViewSwitch().getCompactViewBtn().getAttribute("title"));
    }

    @Then("^the rate search results are shown in Compact View$")
    public void the_rate_search_results_are_shown_in_Compact_View() {
        assertTrue(resultsPage.showsCompactView());
        assertFalse(resultsPage.showsClassicView());
    }

    @Then("^the rate search results are shown in Classic View$")
    public void the_rate_search_results_are_shown_in_Classic_View() {
        assertTrue(resultsPage.showsClassicView());
        assertFalse(resultsPage.showsCompactView());
    }

    @Then("^the View Toggle in the Results page is set to Compact View$")
    public void the_View_Toggle_in_the_Results_page_is_set_to_Compact_View() {
        assertTrue(resultsPage.getViewSwitch().hasCompactViewToggled());
        assertFalse(resultsPage.getViewSwitch().hasClassicViewToggled());
    }

    @Then("^the View Toggle in the Results page is set to Classic View$")
    public void the_View_Toggle_in_the_Results_page_is_set_to_Classic_View() {
        assertTrue(resultsPage.getViewSwitch().hasClassicViewToggled());
        assertFalse(resultsPage.getViewSwitch().hasCompactViewToggled());
    }

    @When("^the user changes the results View Toggle from Classic View to Compact View$")
    public void the_user_changes_the_View_Toggle_from_Classic_View_to_Compact_View() throws InterruptedException {
        ViewSwitch vs = resultsPage.getViewSwitch();
        if (!vs.hasClassicViewToggled()) {
            throw new IllegalStateException("must first be on Classic View");
        }
        vs.clickCompactViewBtn();
        Thread.sleep(2000);
    }

    @When("^the user changes the results View Toggle from Compact View to Classic View$")
    public void the_user_changes_the_View_Toggle_from_Compact_View_to_Classic_View() throws InterruptedException {
        ViewSwitch vs = resultsPage.getViewSwitch();
        if (!vs.hasCompactViewToggled()) {
            throw new IllegalStateException("must first be on Compact view");
        }
        vs.clickClassicViewBtn();
        Thread.sleep(2000);
    }

    @When("^the user clicks search on the results page$")
    public void the_user_clicks_search_on_the_results_page() throws InterruptedException {
        resultsPage.getSearchControls().search();
        Thread.sleep(2000);
    }
}