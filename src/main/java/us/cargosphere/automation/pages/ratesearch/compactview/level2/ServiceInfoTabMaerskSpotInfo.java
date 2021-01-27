package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.util.SeleniumUtil;

public class ServiceInfoTabMaerskSpotInfo {
    private String rateId;
    private String productCode;
    private String routeCode;

    public ServiceInfoTabMaerskSpotInfo(WebElement context, String rowNum) {
        List<WebElement> els = context.findElements(By.cssSelector("section > *"));
        rateId = SeleniumUtil.getText(els.get(0), false);
        productCode = SeleniumUtil.getText(els.get(1), false);
        routeCode = SeleniumUtil.getText(els.get(2), false);
    }

    public String getRateId() {
        return this.rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getRouteCode() {
        return this.routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ServiceInfoTabMaerskSpotInfo)) {
            return false;
        }
        ServiceInfoTabMaerskSpotInfo serviceInfoTabMaerskSpotInfo = (ServiceInfoTabMaerskSpotInfo) o;
        return Objects.equals(rateId, serviceInfoTabMaerskSpotInfo.rateId)
                && Objects.equals(productCode, serviceInfoTabMaerskSpotInfo.productCode)
                && Objects.equals(routeCode, serviceInfoTabMaerskSpotInfo.routeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateId, productCode, routeCode);
    }

    @Override
    public String toString() {
        return "{" +
            " rateId='" + getRateId() + "'" +
            ", productCode='" + getProductCode() + "'" +
            ", routeCode='" + getRouteCode() + "'" +
            "}";
    }

}