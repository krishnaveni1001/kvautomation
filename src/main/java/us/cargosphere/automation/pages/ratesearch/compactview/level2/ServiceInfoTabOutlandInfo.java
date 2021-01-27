package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import us.cargosphere.automation.util.SeleniumUtil;

public class ServiceInfoTabOutlandInfo {
    private String header;
    private String itemNumber;
    private String outlandModeType;
    private String outlandWeightBreak;
    private String outlandRateType;

    public ServiceInfoTabOutlandInfo(WebDriver driver, String rowNum) {
        header = SeleniumUtil.getText(driver.findElement(By.id("compact-service-info-outland-header-" + rowNum)),
                false);
        String byIdBaseData = "#compact-service-info-outland-data-" + rowNum;
        itemNumber = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(1)")),
                false);
        outlandModeType = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(2)")),
                false);
        outlandWeightBreak = SeleniumUtil
                .getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(3)")), false);
        outlandRateType = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(4)")),
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

    public String getOutlandModeType() {
        return this.outlandModeType;
    }

    public void setOutlandModeType(String inlandModeType) {
        this.outlandModeType = inlandModeType;
    }

    public String getOutlandWeightBreak() {
        return this.outlandWeightBreak;
    }

    public void setOutlandWeightBreak(String inlandWeightBreak) {
        this.outlandWeightBreak = inlandWeightBreak;
    }

    public String getOutlandRateType() {
        return this.outlandRateType;
    }

    public void setOutlandRateType(String inlandRateType) {
        this.outlandRateType = inlandRateType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ServiceInfoTabOutlandInfo)) {
            return false;
        }
        ServiceInfoTabOutlandInfo serviceInfoTabOutlandInfo = (ServiceInfoTabOutlandInfo) o;
        return Objects.equals(header, serviceInfoTabOutlandInfo.header)
                && Objects.equals(itemNumber, serviceInfoTabOutlandInfo.itemNumber)
                && Objects.equals(outlandModeType, serviceInfoTabOutlandInfo.outlandModeType)
                && Objects.equals(outlandWeightBreak, serviceInfoTabOutlandInfo.outlandWeightBreak)
                && Objects.equals(outlandRateType, serviceInfoTabOutlandInfo.outlandRateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, itemNumber, outlandModeType, outlandWeightBreak, outlandRateType);
    }

    @Override
    public String toString() {
        return "{" +
            " header='" + getHeader() + "'" +
            ", itemNumber='" + getItemNumber() + "'" +
            ", outlandModeType='" + getOutlandModeType() + "'" +
            ", outlandWeightBreak='" + getOutlandWeightBreak() + "'" +
            ", outlandRateType='" + getOutlandRateType() + "'" +
            "}";
    }
}