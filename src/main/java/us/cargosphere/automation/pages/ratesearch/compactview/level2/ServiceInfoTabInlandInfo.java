package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import us.cargosphere.automation.util.SeleniumUtil;

public class ServiceInfoTabInlandInfo {
    private String header;
    private String itemNumber;
    private String inlandModeType;
    private String inlandWeightBreak;
    private String inlandRateType;

    public ServiceInfoTabInlandInfo(WebDriver driver, String rowNum) {
        header = SeleniumUtil.getText(driver.findElement(By.id("compact-service-info-inland-header-" + rowNum)), false);
        String byIdBaseData = "#compact-service-info-inland-data-" + rowNum;
        itemNumber = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(1)")),
                false);
        inlandModeType = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(2)")),
                false);
        inlandWeightBreak = SeleniumUtil
                .getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(3)")), false);
        inlandRateType = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(4)")),
                false);
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getItemNumber() {
        return this.itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getInlandModeType() {
        return this.inlandModeType;
    }

    public void setInlandModeType(String inlandModeType) {
        this.inlandModeType = inlandModeType;
    }

    public String getInlandWeightBreak() {
        return this.inlandWeightBreak;
    }

    public void setInlandWeightBreak(String inlandWeightBreak) {
        this.inlandWeightBreak = inlandWeightBreak;
    }

    public String getInlandRateType() {
        return this.inlandRateType;
    }

    public void setInlandRateType(String inlandRateType) {
        this.inlandRateType = inlandRateType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ServiceInfoTabInlandInfo)) {
            return false;
        }
        ServiceInfoTabInlandInfo serviceInfoTabInlandInfo = (ServiceInfoTabInlandInfo) o;
        return Objects.equals(header, serviceInfoTabInlandInfo.header)
                && Objects.equals(itemNumber, serviceInfoTabInlandInfo.itemNumber)
                && Objects.equals(inlandModeType, serviceInfoTabInlandInfo.inlandModeType)
                && Objects.equals(inlandWeightBreak, serviceInfoTabInlandInfo.inlandWeightBreak)
                && Objects.equals(inlandRateType, serviceInfoTabInlandInfo.inlandRateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, itemNumber, inlandModeType, inlandWeightBreak, inlandRateType);
    }

    @Override
    public String toString() {
        return "{" +
            " header='" + getHeader() + "'" +
            ", itemNumber='" + getItemNumber() + "'" +
            ", inlandModeType='" + getInlandModeType() + "'" +
            ", inlandWeightBreak='" + getInlandWeightBreak() + "'" +
            ", inlandRateType='" + getInlandRateType() + "'" +
            "}";
    }
}