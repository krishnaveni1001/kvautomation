package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

/**
 * A PageObject fragment representing the Contract Tab of the Level 2 details
 * that are shown when a user clicks the price of a rate.
 */
public class ContractTab extends BasePage {
    private String contractNumber;
    private ContractTabContractInfo contractInfo;
    private List<ContractTabAmendmentRow> amendmentDataRows;

    public ContractTab(WebDriver webDriver, WebElement context) {
        super(webDriver, context);

        contractNumber = SeleniumUtil.getText(context.findElement(By.cssSelector(".compactContractHeader > span")),
                false);
        contractInfo = new ContractTabContractInfo(context.findElement(By.className("compactContractInfo")));
        List<WebElement> amendmentEls = context.findElements(By.className("compactAmendmentRow"));
        amendmentDataRows = new ArrayList<>();
        for (WebElement el : amendmentEls) {
            amendmentDataRows.add(new ContractTabAmendmentRow(el));
        }
    }

    /**
     * Gets the contract number that is displayed in the header of the Contracts
     * Tab.
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Gets the Contract Info section. This includes: Contract Scope, Trade Lane,
     * Internal Owners, and External Owners
     * 
     * @return {@link ContractTabContractInfo} containing info about the contract.
     */
    public ContractTabContractInfo getContractInfo() {
        return this.contractInfo;
    }

    /**
     * Gets the Amendment list. Each item in the list may contain information about
     * the amendment name, the administrator, date received, and notes.
     * 
     * @return a list of {@link ContractTabAmendmentRow}s. Each entry contains info
     *         about a single amendment.
     */
    public List<ContractTabAmendmentRow> getAmendmentRows() {
        // The first row in the amendmentDataRows is the header info.
        // here, we skip returning the header row of data.
        if (this.amendmentDataRows.size() < 2) {
            return new ArrayList<>();
        }
        return this.amendmentDataRows.subList(1, this.amendmentDataRows.size());
    }
}