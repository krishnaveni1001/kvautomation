package us.cargosphere.automation.ratesearch.compactview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.CommoditiesTab;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.ContractTabContractInfo;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details.Tab;
import us.cargosphere.automation.util.SeleniumUtil;

public class CommoditiesTabSteps extends BaseStepDefinitions {
    private RateSearchResultsPage resultsPage;

    public CommoditiesTabSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^the Commodities tab is active in the Level 2 details for row (\\d+) of the compact view$")
    public void the_contract_tab_is_active(int rowNum) {
        int rowIdx = rowNum - 1;
        assertTrue(resultsPage.getCompactView().getRowByIndex(rowIdx).getLevel2Details().isTabActive(Tab.COMMODITIES));
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Contract tab of the level2 details of row 11 shows the following included commodities:
     *     |commodity 1, commodity 2, commodity 3|
     * </pre>
     */
    @Then("^the Commodities tab of the level2 details of row (\\d+) shows the following included commodities:$")
    public void compare_included_commodities(int row, List<String> expected) {
        CommoditiesTab commoditiesTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getCommoditiesTab();

        assertEquals(expected, SeleniumUtil.getText(commoditiesTab.getIncludedCommodities(), false));
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Contract tab of the level2 details of row 11 shows the following excluded commodities:
     *     |commodity 1, commodity 2, commodity 3|
     * </pre>
     */
    @Then("^the Commodities tab of the level2 details of row (\\d+) shows the following excluded commodities:$")
    public void compare_excluded_commodities(int row, List<ContractTabContractInfo> expected) {
        CommoditiesTab commoditiesTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getCommoditiesTab();

        assertEquals(expected, SeleniumUtil.getText(commoditiesTab.getExcludedCommodities(), false));
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Contract tab of the level2 details of row 11 does not have any excluded commodities
     * </pre>
     */
    @Then("^the Commodities tab of the level2 details of row (\\d+) does not have any excluded commodities$")
    public void excluded_commodities_list_is_empty(int row) {
        CommoditiesTab commoditiesTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getCommoditiesTab();

        assertTrue(commoditiesTab.getExcludedCommodities().size() == 0);
    }

    @Then("^the Commodities tab of the level2 details of row (\\d+) shows the following text for Commodity Group: \"([^\"]*)\"$")
    public void compare_header_text(int row, String expected) {
        CommoditiesTab commoditiesTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
        .getCommoditiesTab();

        assertEquals(expected, commoditiesTab.getCommodityGroupHeaderText());
    }
}