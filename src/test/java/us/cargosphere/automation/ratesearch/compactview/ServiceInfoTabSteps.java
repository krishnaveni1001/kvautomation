package us.cargosphere.automation.ratesearch.compactview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.ServiceInfoTab;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.ServiceInfoTabBaseInfo;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details.Tab;

public class ServiceInfoTabSteps extends BaseStepDefinitions {
    private RateSearchResultsPage resultsPage;

    public ServiceInfoTabSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^the Service Info tab is active in the Level 2 details for row (\\d+) of the compact view$")
    public void the_service_info_tab_is_active(int rowNum) {
        int rowIdx = rowNum - 1;
        assertTrue(resultsPage.getCompactView().getRowByIndex(rowIdx).getLevel2Details().isTabActive(Tab.SERVICE_INFO));
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Service Info tab of the level2 details of row 11 shows the following text in the "base" section:
     *     |header | itemNumber | serviceType | rateType | rateType2 | serviceString | vessel | transitTime | frequency | addOnAssignment |
     *     |MAAGA - Agadir, Morocco ( Port ) AEAUH - Abu Dhabi, United Arab Emirates ( Port )|1|- -|- -|- -|- -|- -|- -|- -|- -|
     *
     *   Then the Service Info tab of the level2 details of row 11 shows the following text in the "inland" section:
     *     |header | itemNumber | inlandModeType | inlandWeightBreak | inlandRateType|
     *     |abc|def|ghi|jkl|mno|
     * 
     *   Then the Service Info tab of the level2 details of row 11 shows the following text in the "outland" section:
     *     |header | itemNumber | outlandModeType | outlandWeightBreak | outlandRateType|
     *     |abc|def|ghi|jkl|mno|
     * 
     *   Then the Service Info tab of the level2 details of row 11 shows the following text in the "Maersk Spot" section:
     *     |rateId | productCode | routeCode |
     *     |abc|def|ghi|
     * </pre>
     */
    @Then("^the Service Info tab of the level2 details of row (\\d+) shows the following text in the \"([^\"]*)\" section:$")
    public void compare_section_info_text(int row, String section, List<ServiceInfoTabBaseInfo> expected) {
        ServiceInfoTab serviceInfoTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getServiceInfoTab();
        switch (section) {
            case "base":
                assertEquals(expected.get(0), serviceInfoTab.getBaseInfo());
                break;
            case "inland":
                assertEquals(expected.get(0), serviceInfoTab.getInlandInfo());
                break;
            case "outland":
                assertEquals(expected.get(0), serviceInfoTab.getOutlandInfo());
                break;
            case "Maersk Spot":
                assertEquals(expected.get(0), serviceInfoTab.getMaerskSpotInfo());
                break;
            default:
                throw new UnsupportedOperationException(
                        "Unexpected section type. Please use one of the following: \"base\", \"inland\", \"outland\", \"Maersk Spot\"");
        }
    }

    @Then("^the Service Info tab of the level2 details of row (\\d+) shows the \"([^\"]*)\" section$")
    public void expect_a_section_to_be_shown(int row, String section) {
        ServiceInfoTab serviceInfoTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getServiceInfoTab();
        switch (section) {
            case "base":
                assertTrue(serviceInfoTab.showsBaseData());
                break;
            case "inland":
                assertTrue(serviceInfoTab.showsInlandData());
                break;
            case "outland":
                assertTrue(serviceInfoTab.showsOutlandData());
                break;
            case "Maersk Spot":
                assertTrue(serviceInfoTab.isMaerskSpot());
                break;
            default:
                throw new UnsupportedOperationException(
                        "Unexpected section type. Please use one of the following: \"base\", \"inland\", \"outland\", \"Maersk Spot\"");
        }
    }

    @Then("^the Service Info tab of the level2 details of row (\\d+) does not show the \"([^\"]*)\" section$")
    public void expect_a_section_to_not_be_shown(int row, String section) {
        ServiceInfoTab serviceInfoTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getServiceInfoTab();
        switch (section) {
            case "base":
                assertFalse(serviceInfoTab.showsBaseData());
                break;
            case "inland":
                assertFalse(serviceInfoTab.showsInlandData());
                break;
            case "outland":
                assertFalse(serviceInfoTab.showsOutlandData());
                break;
            case "Maersk Spot":
                assertFalse(serviceInfoTab.isMaerskSpot());
                break;
            default:
                throw new UnsupportedOperationException(
                        "Unexpected section type. Please use one of the following: \"base\", \"inland\", \"outland\", \"Maersk Spot\"");
        }
    }
}