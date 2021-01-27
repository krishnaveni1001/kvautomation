package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import us.cargosphere.automation.util.SeleniumUtil;

public class ServiceInfoTabBaseInfo {
    private String header;
    private String itemNumber;
    private String serviceType;
    private String rateType;
    private String rateType2;
    private String serviceString;
    private String vessel;
    private String transitTime;
    private String frequency;
    private String addOnAssignment;

    public ServiceInfoTabBaseInfo(WebDriver driver, String rowNum) {
        header = SeleniumUtil.getText(driver.findElement(By.id("compact-service-info-base-header-" + rowNum)), false);
        String byIdBaseData = "#compact-service-info-base-data-" + rowNum;
        itemNumber = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(1) > span")),
                false);
        serviceType = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(2) > span")),
                false);
        rateType = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(3) > span")),
                false);
        rateType2 = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(4) > span")),
                false);
        serviceString = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(5) > span")),
                false);
        vessel = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(6) > span")), false);
        transitTime = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(7) > span")),
                false);
        frequency = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(8) > span")),
                false);
        addOnAssignment = SeleniumUtil.getText(driver.findElement(By.cssSelector(byIdBaseData + " > div:nth-child(9) > span")),
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

    public String getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getRateType() {
        return this.rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getRateType2() {
        return this.rateType2;
    }

    public void setRateType2(String rateType2) {
        this.rateType2 = rateType2;
    }

    public String getServiceString() {
        return this.serviceString;
    }

    public void setServiceString(String serviceString) {
        this.serviceString = serviceString;
    }

    public String getVessel() {
        return this.vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getTransitTime() {
        return this.transitTime;
    }

    public void setTransitTime(String transitTime) {
        this.transitTime = transitTime;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAddOnAssignment() {
        return this.addOnAssignment;
    }

    public void setAddOnAssignment(String addOnAssignment) {
        this.addOnAssignment = addOnAssignment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ServiceInfoTabBaseInfo)) {
            return false;
        }
        ServiceInfoTabBaseInfo serviceInfoTabBaseInfo = (ServiceInfoTabBaseInfo) o;
        return Objects.equals(header, serviceInfoTabBaseInfo.header)
                && Objects.equals(itemNumber, serviceInfoTabBaseInfo.itemNumber)
                && Objects.equals(serviceType, serviceInfoTabBaseInfo.serviceType)
                && Objects.equals(rateType, serviceInfoTabBaseInfo.rateType)
                && Objects.equals(rateType2, serviceInfoTabBaseInfo.rateType2)
                && Objects.equals(serviceString, serviceInfoTabBaseInfo.serviceString)
                && Objects.equals(vessel, serviceInfoTabBaseInfo.vessel)
                && Objects.equals(transitTime, serviceInfoTabBaseInfo.transitTime)
                && Objects.equals(frequency, serviceInfoTabBaseInfo.frequency)
                && Objects.equals(addOnAssignment, serviceInfoTabBaseInfo.addOnAssignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, itemNumber, serviceType, rateType, rateType2, serviceString, vessel, transitTime,
                frequency, addOnAssignment);
    }

    @Override
    public String toString() {
        return "{" +
            " header='" + getHeader() + "'" +
            ", itemNumber='" + getItemNumber() + "'" +
            ", serviceType='" + getServiceType() + "'" +
            ", rateType='" + getRateType() + "'" +
            ", rateType2='" + getRateType2() + "'" +
            ", serviceString='" + getServiceString() + "'" +
            ", vessel='" + getVessel() + "'" +
            ", transitTime='" + getTransitTime() + "'" +
            ", frequency='" + getFrequency() + "'" +
            ", addOnAssignment='" + getAddOnAssignment() + "'" +
            "}";
    }
}