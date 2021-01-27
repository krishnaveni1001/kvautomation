package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.pages.BasePage;

/**
 * A PageObject fragment representing the Pricing Tab of the Level 2 details
 * that are shown when a user clicks the price of a rate.
 */
public class PricingTab extends BasePage {
    private static final String byCssSurchargeRow = ".compactPricingRow > div > #surchargeInfoMain > .surchargeContainer > .compactPricingRow > .dataRow";
    private static final String byCssBasePriceRow = ".compactPricingRow > .basePriceRow";
    private static final String byCssHeaderRow = ".compactLocationRow > .location";
    private List<PricingTabDataRow> inlandImsSurcharges;
    private List<PricingTabDataRow> inlandImsBaseRates;
    private List<WebElement> inlandImsHeaders;
    private List<PricingTabDataRow> inlandSurcharges;
    private List<PricingTabDataRow> inlandBaseRates;
    private List<WebElement> inlandHeaders;
    private List<PricingTabDataRow> baseSurcharges;
    private List<PricingTabDataRow> baseBaseRates;
    private List<WebElement> baseHeaders;
    private List<PricingTabDataRow> outlandSurcharges;
    private List<PricingTabDataRow> outlandBaseRates;
    private List<WebElement> outlandHeaders;
    private List<PricingTabDataRow> outlandImsSurcharges;
    private List<PricingTabDataRow> outlandImsBaseRates;
    private List<WebElement> outlandImsHeaders;
    private List<PricingTabDataRow> bolSurcharges;
    private List<PricingTabDataRow> additionalChargesSurcharges;
    private List<WebElement> tradelaneNotes;
    private List<WebElement> rateNotes;
    private List<WebElement> disclaimerNotes;

    public PricingTab(WebDriver webDriver, WebElement context, String rowNum) {
        super(webDriver, context);

        // init Base to Base leg
        baseSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableBase > " + byCssSurchargeRow)));
        baseBaseRates = convertToSurchargeRows(context.findElements(By.cssSelector("#compactPricingTableBase > " + byCssBasePriceRow)));
        baseHeaders = context.findElements(By.cssSelector("#compactPricingTableBase > " + byCssHeaderRow));

        // init Inland IMS leg
        inlandImsSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableInlandIMS > " + byCssSurchargeRow)));
        inlandImsBaseRates = convertToSurchargeRows(context
                .findElements(By.cssSelector("#compactPricingTableInlandIMS > " + byCssBasePriceRow)));
        inlandImsHeaders = context.findElements(By.cssSelector("#compactPricingTableInlandIMS > " + byCssHeaderRow));

        // init Inland leg
        inlandSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableInland > " + byCssSurchargeRow)));
        inlandBaseRates = convertToSurchargeRows(context.findElements(By.cssSelector("#compactPricingTableInland > " + byCssBasePriceRow)));
        inlandHeaders = context.findElements(By.cssSelector("#compactPricingTableInland > " + byCssHeaderRow));

        // init Outland leg
        outlandSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableOutland > " + byCssSurchargeRow)));
        outlandBaseRates = convertToSurchargeRows(context.findElements(By.cssSelector("#compactPricingTableOutland > " + byCssBasePriceRow)));
        outlandHeaders = context.findElements(By.cssSelector("#compactPricingTableOutland > " + byCssHeaderRow));

        // init Outland IMS leg
        outlandImsSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableOutlandIMS > " + byCssSurchargeRow)));
        outlandImsBaseRates = convertToSurchargeRows(context
                .findElements(By.cssSelector("#compactPricingTableOutlandIMS > " + byCssBasePriceRow)));
        outlandImsHeaders = context.findElements(By.cssSelector("#compactPricingTableOutlandIMS > " + byCssHeaderRow));

        // init BOL Surcharges and Additional Charges
        bolSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableBOL > " + byCssSurchargeRow)));
        additionalChargesSurcharges = convertToSurchargeRows(
                context.findElements(By.cssSelector("#compactPricingTableAddCharges > " + byCssSurchargeRow)));

        // init notes
        tradelaneNotes = context
                .findElements(By.cssSelector("#compact-pricing-tradelane-notes-" + rowNum + " div > ol > li"));
        rateNotes = context.findElements(By.cssSelector("#compact-pricing-rate-notes-" + rowNum + " > div > ol > li"));
        disclaimerNotes = context
                .findElements(By.cssSelector("#compact-pricing-disclaimers-" + rowNum + " > div > ol > li"));
    }

    /**
     * Gets the rows of surcharge data for Inland IMS leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getInlandImsSurcharges() {
        return this.inlandImsSurcharges;
    }

    /**
     * Gets the rows of base rate data for Inland IMS leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getInlandImsBaseRates() {
        return this.inlandImsBaseRates;
    }

    /**
     * Gets the rows of header data for Inland IMS leg.
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getInlandImsHeaders() {
        return this.inlandImsHeaders;
    }

    /**
     * Gets the rows of surcharge data for Inland leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getInlandSurcharges() {
        return this.inlandSurcharges;
    }

    /**
     * Gets the rows of base rate data for Inland leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getInlandBaseRates() {
        return this.inlandBaseRates;
    }

    /**
     * Gets the rows of header data for Inland leg.
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getInlandHeaders() {
        return this.inlandHeaders;
    }

    /**
     * Gets the rows of surcharge data for Base to Base leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getBaseSurcharges() {
        return this.baseSurcharges;
    }

    /**
     * Gets the rows of base rate data for Base to Base leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getBaseBaseRates() {
        return this.baseBaseRates;
    }

    /**
     * Gets the rows of header data for Base to Base leg.
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getBaseHeaders() {
        return this.baseHeaders;
    }

    /**
     * Gets the rows of surcharge data for Outland leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getOutlandSurcharges() {
        return this.outlandSurcharges;
    }

    /**
     * Gets the rows of base rate data for Outland leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getOutlandBaseRates() {
        return this.outlandBaseRates;
    }

    /**
     * Gets the rows of header data for Outland leg.
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getOutlandHeaders() {
        return this.outlandHeaders;
    }

    /**
     * Gets the rows of surcharge data for Outland IMS leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getOutlandImsSurcharges() {
        return this.outlandImsSurcharges;
    }

    /**
     * Gets the rows of base rate data for Outland IMS leg.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getOutlandImsBaseRates() {
        return this.outlandImsBaseRates;
    }

    /**
     * Gets the rows of header data for Outland IMS leg.
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getOutlandImsHeaders() {
        return this.outlandImsHeaders;
    }

    /**
     * Gets the rows of surcharge data for BOL section.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getBolSurcharges() {
        return bolSurcharges;
    }

    /**
     * Gets the rows of surcharge data for Additional Charges section.
     * 
     * @return a list of {@link PricingTabDataRow}s
     */
    public List<PricingTabDataRow> getAdditionalChargesSurcharges() {
        return additionalChargesSurcharges;
    }

    /**
     * Gets the rows of data from the Tradelane Notes section
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getTradelaneNotes() {
        return this.tradelaneNotes;
    }

    /**
     * Gets the rows of data from the Rate Notes section
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getRateNotes() {
        return this.rateNotes;
    }

    /**
     * Gets the rows of data from the Disclaimers section
     * 
     * @return a list of {@link WebElement}s
     */
    public List<WebElement> getDisclaimerNotes() {
        return this.disclaimerNotes;
    }

    private List<PricingTabDataRow> convertToSurchargeRows(List<WebElement> rows) {
        List<PricingTabDataRow> rtn = new ArrayList<>();
        for (WebElement el : rows) {
            rtn.add(new PricingTabDataRow(el));
        }
        return rtn;
    }
}