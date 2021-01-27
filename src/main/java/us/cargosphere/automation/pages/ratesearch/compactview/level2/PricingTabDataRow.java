package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.util.SeleniumUtil;

public class PricingTabDataRow {
    private String term;
    private String description;
    private String rate;
    private String priceBy;
    private String info;
    private String min;
    private String max;
    private String paymentType;

    public PricingTabDataRow(WebElement context) {
        // Hovertext includes surcharge notes and e-booking symbol.
        term = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.className("term")), true);
        description = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context,By.className("description")), false);
        rate = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.className("rate")), false);
        priceBy = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.className("priceBy")), false);
        // info section can include icons. We include hovertext here to determine which icons are shown.
        info = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.className("info")), true);
        min = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.cssSelector("[id^=\"freight-min-amount-\"")), false);
        max = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.cssSelector("[id^=\"freight-max-amount-\"")), false);
        paymentType = SeleniumUtil.getText(SeleniumUtil.findNullableElement(context, By.className("paymentType")), false);
    }

    public PricingTabDataRow(String term, String description, String rate, String priceBy, String info, String min, String max, String paymentType) {
        this.term = term;
        this.description = description;
        this.rate = rate;
        this.priceBy = priceBy;
        this.info = info;
        this.min = min;
        this.max = max;
        this.paymentType = paymentType;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPriceBy() {
        return this.priceBy;
    }

    public void setPriceBy(String priceBy) {
        this.priceBy = priceBy;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMin() {
        return this.min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public PricingTabDataRow term(String term) {
        this.term = term;
        return this;
    }

    public PricingTabDataRow description(String description) {
        this.description = description;
        return this;
    }

    public PricingTabDataRow rate(String rate) {
        this.rate = rate;
        return this;
    }

    public PricingTabDataRow priceBy(String priceBy) {
        this.priceBy = priceBy;
        return this;
    }

    public PricingTabDataRow info(String info) {
        this.info = info;
        return this;
    }

    public PricingTabDataRow min(String min) {
        this.min = min;
        return this;
    }

    public PricingTabDataRow max(String max) {
        this.max = max;
        return this;
    }

    public PricingTabDataRow paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PricingTabDataRow)) {
            return false;
        }
        PricingTabDataRow surchargeRow = (PricingTabDataRow) o;
        return Objects.equals(term, surchargeRow.term) && Objects.equals(description, surchargeRow.description)
                && Objects.equals(rate, surchargeRow.rate) && Objects.equals(priceBy, surchargeRow.priceBy)
                && Objects.equals(info, surchargeRow.info) && Objects.equals(min, surchargeRow.min)
                && Objects.equals(max, surchargeRow.max) && Objects.equals(paymentType, surchargeRow.paymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, description, rate, priceBy, info, min, max, paymentType);
    }

    @Override
    public String toString() {
        return "{" +
            " term='" + getTerm() + "'" +
            ", description='" + getDescription() + "'" +
            ", rate='" + getRate() + "'" +
            ", priceBy='" + getPriceBy() + "'" +
            ", info='" + getInfo() + "'" +
            ", min='" + getMin() + "'" +
            ", max='" + getMax() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            "}";
    }

}