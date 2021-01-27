package us.cargosphere.automation.ratesearch.compactview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.PricingTab;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.PricingTabDataRow;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details.Tab;
import us.cargosphere.automation.util.SeleniumUtil;

public class PricingTabSteps extends BaseStepDefinitions {
    private RateSearchResultsPage resultsPage;

    public PricingTabSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^the Pricing tab is active in the Level 2 details for row (\\d+) of the compact view$")
    public void the_pricing_tab_is_active(int rowNum) {
        int rowIdx = rowNum - 1;
        assertTrue(resultsPage.getCompactView().getRowByIndex(rowIdx).getLevel2Details().isTabActive(Tab.PRICING));
    }

    @Then("^the level2 details of row (\\d+) pricing tab shows the following \"([^\"]*)\" surcharge text:$")
    public void compare_surcharge_text(int row, String legType, List<PricingTabDataRow> expected) {
        PricingTab pricingTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details().getPricingTab();
        switch (legType) {
            case "base":
                assertEquals(expected, pricingTab.getBaseSurcharges());
                break;
            case "inland":
                assertEquals(expected, pricingTab.getInlandSurcharges());
                break;
            case "inland IMS":
                assertEquals(expected, pricingTab.getInlandImsSurcharges());
                break;
            case "outland":
                assertEquals(expected, pricingTab.getOutlandSurcharges());
                break;
            case "outland IMS":
                assertEquals(expected, pricingTab.getOutlandImsSurcharges());
                break;
            default:
                throw new UnsupportedOperationException(
                        "Unexpected trip leg type. Please use one of the following: \"base\", \"inland\", \"inland IMS\", \"outland\", \"outland IMS\"");
        }
    }

    @Then("^the level2 details of row (\\d+) pricing tab shows the following surcharge text:$")
    public void compare_all_surcharge_text(int row, List<PricingTabDataRow> expected) {
        PricingTab pricingTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details().getPricingTab();
        List<PricingTabDataRow> actual = new ArrayList<>();
        actual.addAll(pricingTab.getInlandImsSurcharges());
        actual.addAll(pricingTab.getInlandSurcharges());
        actual.addAll(pricingTab.getBaseSurcharges());
        actual.addAll(pricingTab.getOutlandImsSurcharges());
        actual.addAll(pricingTab.getOutlandSurcharges());
        assertEquals(expected, actual);
    }

    /**
     * <pre>
     * Example Gherkin Usage: 
     * Scenario: ....
     *   When ....
     *   Then the level2 details of row 4 pricing tab shows the following "base" Base Rate text:
     *       | term | description | rate | priceBy | info | min | max | paymentType |
     *       |EBS | EMERGENCY BUNKER SURCHARGE ||Per Container|||||
     *       |PSS | Peak Season Surcharge ||Per Container|||||
     * </pre>
     * @param row the row number of the level1 search results (counting from 1).
     * @param legType one of: "base", "inland IMS", "inland", "outland", "outland IMS"
     * @param expected the expected results
     */
    @Then("^the level2 details of row (\\d+) pricing tab shows the following \"([^\"]*)\" Base Rate text:$")
    public void compare_base_rate_text(int row, String legType, List<PricingTabDataRow> expected) {
        PricingTab pricingTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details().getPricingTab();
        switch (legType) {
            case "base":
                assertEquals(expected, pricingTab.getBaseBaseRates());
                break;
            case "inland":
                assertEquals(expected, pricingTab.getInlandBaseRates());
                break;
            case "inland IMS":
                assertEquals(expected, pricingTab.getInlandImsBaseRates());
                break;
            case "outland":
                assertEquals(expected, pricingTab.getOutlandBaseRates());
                break;
            case "outland IMS":
                assertEquals(expected, pricingTab.getOutlandImsBaseRates());
                break;
            default:
                throw new UnsupportedOperationException(
                        "Unexpected trip leg type. Please use one of the following: \"base\", \"inland\", \"inland IMS\", \"outland\", \"outland IMS\"");
        }
    }

    /**
     * <pre>
     * Example Gherkin Usage: 
     * Scenario: ....
     *   When ....
     *   Then the level2 details of row 4 pricing tab shows the following Base Rate text:
     *       | term | description | rate | priceBy | info | min | max | paymentType |
     *       |EBS | EMERGENCY BUNKER SURCHARGE ||Per Container|||||
     *       |PSS | Peak Season Surcharge ||Per Container|||||
     * </pre>
     * @param row the row number of the level1 search results (counting from 1).
     * @param expected the expected results
     */
    @Then("^the level2 details of row (\\d+) pricing tab shows the following Base Rate text:$")
    public void compare_all_base_rate_text(int row, List<PricingTabDataRow> expected) {
        PricingTab pricingTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details().getPricingTab();
        List<PricingTabDataRow> actual = new ArrayList<>();
        actual.addAll(pricingTab.getInlandImsBaseRates());
        actual.addAll(pricingTab.getInlandBaseRates());
        actual.addAll(pricingTab.getBaseBaseRates());
        actual.addAll(pricingTab.getOutlandImsBaseRates());
        actual.addAll(pricingTab.getOutlandBaseRates());
        assertEquals(expected, actual);
    }

    @Then("^the level2 details of row (\\d+) pricing tab shows the following \"([^\"]*)\" header text:$")
    public void compare_header_text(int row, String legType, List<String> expected) {
        PricingTab pricingTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details().getPricingTab();
        switch (legType) {
            case "base":
                assertEquals(expected, SeleniumUtil.getText(pricingTab.getBaseHeaders(), true));
                break;
            case "inland":
                assertEquals(expected, SeleniumUtil.getText(pricingTab.getInlandHeaders(), true));
                break;
            case "inland IMS":
                assertEquals(expected, SeleniumUtil.getText(pricingTab.getInlandImsHeaders(), true));
                break;
            case "outland":
                assertEquals(expected, SeleniumUtil.getText(pricingTab.getOutlandHeaders(), true));
                break;
            case "outland IMS":
                assertEquals(expected, SeleniumUtil.getText(pricingTab.getOutlandImsHeaders(), true));
                break;
            default:
                throw new UnsupportedOperationException(
                        "Unexpected trip leg type. Please use one of the following: \"base\", \"inland\", \"inland IMS\", \"outland\", \"outland IMS\"");
        }
    }

    @Then("^the level2 details of row (\\d+) pricing tab shows the following header text:$")
    public void compare_all_header_text(int row, List<String> expected) {
        PricingTab pricingTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details().getPricingTab();
        List<String> actual = new ArrayList<>();
        actual.addAll(SeleniumUtil.getText(pricingTab.getInlandImsHeaders(), true));
        actual.addAll(SeleniumUtil.getText(pricingTab.getInlandHeaders(), true));
        actual.addAll(SeleniumUtil.getText(pricingTab.getBaseHeaders(), true));
        actual.addAll(SeleniumUtil.getText(pricingTab.getOutlandImsHeaders(), true));
        actual.addAll(SeleniumUtil.getText(pricingTab.getOutlandHeaders(), true));
        assertEquals(expected, actual);
    }
}