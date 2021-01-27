package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.util.SeleniumUtil;

public class ContractTabContractInfo {
    private String carrier;
    private String contractScope;
    private String tradeLane;
    private String internalOwners;
    private String externalOwners;

    public ContractTabContractInfo(WebElement context) {
        List<WebElement> elements = context.findElements(By.cssSelector(".info > span"));
        carrier = SeleniumUtil.getText(elements.get(0), false);
        contractScope = SeleniumUtil.getText(elements.get(1), false);
        tradeLane = SeleniumUtil.getText(elements.get(2), false);
        internalOwners = SeleniumUtil.getText(elements.get(3), false);
        externalOwners = SeleniumUtil.getText(elements.get(4), false);
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getContractScope() {
        return this.contractScope;
    }

    public void setContractScope(String contractScope) {
        this.contractScope = contractScope;
    }

    public String getTradeLane() {
        return this.tradeLane;
    }

    public void setTradeLane(String tradeLane) {
        this.tradeLane = tradeLane;
    }

    public String getInternalOwners() {
        return this.internalOwners;
    }

    public void setInternalOwners(String internalOwners) {
        this.internalOwners = internalOwners;
    }

    public String getExternalOwners() {
        return this.externalOwners;
    }

    public void setExternalOwners(String externalOwners) {
        this.externalOwners = externalOwners;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContractTabContractInfo)) {
            return false;
        }
        ContractTabContractInfo contractTabContractInfo = (ContractTabContractInfo) o;
        return Objects.equals(carrier, contractTabContractInfo.carrier)
                && Objects.equals(contractScope, contractTabContractInfo.contractScope)
                && Objects.equals(tradeLane, contractTabContractInfo.tradeLane)
                && Objects.equals(internalOwners, contractTabContractInfo.internalOwners)
                && Objects.equals(externalOwners, contractTabContractInfo.externalOwners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrier, contractScope, tradeLane, internalOwners, externalOwners);
    }

    @Override
    public String toString() {
        return "{" +
            " carrier='" + getCarrier() + "'" +
            ", contractScope='" + getContractScope() + "'" +
            ", tradeLane='" + getTradeLane() + "'" +
            ", internalOwners='" + getInternalOwners() + "'" +
            ", externalOwners='" + getExternalOwners() + "'" +
            "}";
    }
    
}