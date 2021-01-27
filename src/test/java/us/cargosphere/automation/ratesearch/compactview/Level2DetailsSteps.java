package us.cargosphere.automation.ratesearch.compactview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details.Tab;
import us.cargosphere.automation.util.SeleniumUtil;

public class Level2DetailsSteps extends BaseStepDefinitions {
    private RateSearchResultsPage resultsPage;

    public Level2DetailsSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^the Level 2 details are shown for row (\\d+) of the compact view$")
    public void level2_details_are_shown_for_row(int row) {
        assertTrue(resultsPage.getCompactView().getRowByIndex(row - 1).showsLevel2Details());
    }

    @When("^the user clicks the tab header button \"([^\"]*)\" in the level 2 details of row (\\d+)$")
    public void user_changes_tabs(String tab, int rowNum) {
        Level2Details level2Details = resultsPage.getCompactView().getRowByIndex(rowNum - 1).getLevel2Details();
        switch (tab) {
            case "Service Info":
                level2Details.clickTabHeaderBtn(Tab.SERVICE_INFO);
                break;
            case "Pricing":
                level2Details.clickTabHeaderBtn(Tab.PRICING);
                break;
            case "Commodities":
                level2Details.clickTabHeaderBtn(Tab.COMMODITIES);
                break;
            case "Contract":
                level2Details.clickTabHeaderBtn(Tab.CONTRACT);
                break;
            case "Schedule":
                level2Details.clickTabHeaderBtn(Tab.SCHEDULES);
                break;
            case "Named Accounts":
                level2Details.clickTabHeaderBtn(Tab.NAMED_ACCOUNTS);
                break;
            case "Free Time":
                level2Details.clickTabHeaderBtn(Tab.FREE_TIME);
                break;
            default:
                throw new IllegalArgumentException("unsupported tab string");
        }
    }

    @Then("^the Level 2 details are not shown for row (\\d+) of the compact view$")
    public void level2_details_are_not_shown_for_row(int rowNum) {
        assertFalse(resultsPage.getCompactView().getRowByIndex(rowNum - 1).showsLevel2Details());
    }

    @Then("^the Level 2 detail header of row (\\d+) says \"([^\"]*)\"$")
    public void level2_detail_header_says(int rowNum, String expectedHeaderText) {
        assertEquals(expectedHeaderText,
                resultsPage.getCompactView().getRowByIndex(rowNum - 1).getLevel2Details().getHeaderText());
    }

    @Then("^the Level 2 details of row (\\d+) show the date range \"([^\"]*)\"$")
    public void level2_detail_of_row_x_shows_the_date_range(int rowNum, String expectedDateText) {
        assertEquals(expectedDateText,
                resultsPage.getCompactView().getRowByIndex(rowNum - 1).getLevel2Details().getDateRangeText());
    }

    @Then("^the level2 details of row (\\d+) Service Info tab shows the following data for Inlands:$")
    public void service_info_tab_compare_inland_text(int row, List<String> expected) {
        assertEquals(expected, SeleniumUtil.getText(resultsPage.getCompactView().getRowByIndex(row - 1)
                .getLevel2Details().getServiceInfoTab().getInlandDataRows(), true));
    }

}