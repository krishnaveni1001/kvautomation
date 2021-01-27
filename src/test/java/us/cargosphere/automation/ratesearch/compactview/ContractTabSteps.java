package us.cargosphere.automation.ratesearch.compactview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.ContractTab;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.ContractTabAmendmentRow;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.ContractTabContractInfo;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details.Tab;

public class ContractTabSteps extends BaseStepDefinitions {
    private RateSearchResultsPage resultsPage;

    public ContractTabSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
    }

    @Then("^the Contract tab is active in the Level 2 details for row (\\d+) of the compact view$")
    public void the_contract_tab_is_active(int rowNum) {
        int rowIdx = rowNum - 1;
        assertTrue(resultsPage.getCompactView().getRowByIndex(rowIdx).getLevel2Details().isTabActive(Tab.CONTRACT));
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Contract tab of the level2 details of row 11 shows the following text in the info section:
     *     |carrier|contractScope|tradeLane|internalOwners|externalOwners|
     *     |abc|def|ghi|jkl|mno|
     * </pre>
     */
    @Then("^the Contract tab of the level2 details of row (\\d+) shows the following text in the info section:$")
    public void compare_contract_info_text(int row, List<ContractTabContractInfo> expected) {
        ContractTab contractTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getContractTab();
        assertEquals(expected.get(0), contractTab.getContractInfo());
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Contract tab of the level2 details of row 2 shows the contract number "TEST_CONTRACT_1"
     * </pre>
     */
    @Then("^the Contract tab of the level2 details of row (\\d+) shows the contract number \"([^\"]*)\"$")
    public void compare_contract_number(int row, String expectedContractNumber) {
        ContractTab contractTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getContractTab();
        assertEquals(expectedContractNumber, contractTab.getContractNumber());
    }

    /**
     * <pre>
     * Example Gherkin usage:
     *   Then the Contract tab of the level2 details of row 3 shows the following amendment information:
     *     |number|administrator|receivedDate|notes|
     *     |TEST_AMENDMENT_1|def|ghi|jkl|
     *     |TEST_AMENDMENT_2|asdf|jkl|qwerty|
     * </pre>
     */
    @Then("^the Contract tab of the level2 details of row (\\d+) shows the following amendment information:$")
    public void compare_amendments(int row, List<ContractTabAmendmentRow> expected) {
        ContractTab contractTab = resultsPage.getCompactView().getRowByIndex(row - 1).getLevel2Details()
                .getContractTab();
        assertEquals(expected, contractTab.getAmendmentRows());
    }
}