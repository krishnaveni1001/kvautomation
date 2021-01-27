package us.cargosphere.automation.pages.ratesearch.compactview;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.compactview.level2.Level2Details;
import us.cargosphere.automation.util.SeleniumUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class CompactViewRow extends BasePage {
    private int rowNum;

    public CompactViewRow(WebDriver webDriver, WebElement container) {
        super(webDriver, container);
        rowNum = Integer.parseInt(container.getAttribute("row-id"));
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getCntr20ft() {
        return webDriver.findElement(By.id("ag-cntr-20-ft-" + Integer.toString(rowNum)));
    }

    public WebElement getCntr40ft() {
        return webDriver.findElement(By.id("ag-cntr-40-ft-" + Integer.toString(rowNum)));
    }

    public WebElement getNamedAccountDropdownArrow() {
        return webDriver.findElement(By.id("ag-named-account-arrow-" + Integer.toString(rowNum)));
    }

    public WebElement getCommGroupDropdownArrow() {
        return webDriver.findElement(By.id("ag-commodity-arrow-" + Integer.toString(rowNum)));
    }

    public void clickCntr20ftPrice() {
        getCntr20ft().click();
    }

    public void clickCntr40ftPrice() {
        getCntr40ft().click();
    }

    public void clickNamedAccountDropdownArrow() { getNamedAccountDropdownArrow().click(); }

    public void clickCommGroupDropdownArrow() { getCommGroupDropdownArrow().click(); }

    public Level2Details getLevel2Details() {
        return new Level2Details(webDriver,
                webDriver.findElement(By.id("level2Id" + Integer.toString(rowNum))), rowNum);
    }

    public boolean showsLevel2Details() {
        try {
            webDriver.findElement(By.id("level2Id" + Integer.toString(rowNum)));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String getContractName() {
        return webDriver.findElement(By.id("ag-contract-number-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    /**
     * Get the carrier name by reading the title of the carrier logo.
     * @return the carrier name
     */
    public String getCarrierName() {
        return webDriver.findElement(By.id("ag-carrier-" + Integer.toString(rowNum))).getAttribute("title");
    }

    public String getCommGroupName() {
        return webDriver.findElement(By.id("ag-commodity-group-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public List<String> getNamedAccounts() throws InterruptedException {
        if(!showsLevel2Details()) {
            clickNamedAccountDropdownArrow();
        }
        Level2Details details = getLevel2Details();
        details.clickTabHeaderBtn(Level2Details.Tab.NAMED_ACCOUNTS);
        return details.getNamedAccountsTab().getNamedAccounts();
    }

    public String getNamedAccountGroup() {
        if(!showsLevel2Details()) {
            clickNamedAccountDropdownArrow();
        }
        Level2Details details = getLevel2Details();
        details.clickTabHeaderBtn(Level2Details.Tab.NAMED_ACCOUNTS);
        return details.getNamedAccountsTab().getNamedAccountGroupName();
    }

    public String getOrigin() {
        // Inner html of this element also contains Routing text on second line, return first line of text only.
        return webDriver.findElement(By.id("ag-origin-" + Integer.toString(rowNum))).getAttribute("innerText").split("\n")[0];
    }

    public String getDestination() {
        // Inner html of this element also contains Routing text on second line, return first line of text only.
        return webDriver.findElement(By.id("ag-destination-" + Integer.toString(rowNum))).getAttribute("innerText").split("\n")[0];
    }

    public String getContainer20FootPrice() {
        return webDriver.findElement(By.id("ag-cntr-20-ft-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getContainer40FootPrice() {
        return webDriver.findElement(By.id("ag-cntr-40-ft-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getContainer40FootHCPrice() {
        return webDriver.findElement(By.id("ag-cntr-40-ft-hc-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getContainer45FootHCPrice() {
        return webDriver.findElement(By.id("ag-cntr-45-ft-hc-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getRateType() {
        return webDriver.findElement(By.id("ag-rate-type-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getRateTypeTwo() {
        return webDriver.findElement(By.id("ag-rate-type-2-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getServiceString() {
        return webDriver.findElement(By.id("ag-service-string-" + rowNum)).getAttribute("innerText");
    }

    public String getServiceType() {
        return webDriver.findElement(By.id("ag-service-type-" + Integer.toString(rowNum))).getAttribute("innerText");
    }

    public String getVessel() {
        if(!showsLevel2Details()) {
            clickCommGroupDropdownArrow();
            getLevel2Details().clickTabHeaderBtn(Level2Details.Tab.SERVICE_INFO);
        }
        return getLevel2Details().getServiceInfoTab().getBaseInfo().getVessel();
    }

    public List<String> getRouting () {
        List<String> routing = new ArrayList<>();
        routing.add(webDriver.findElement(
                By.cssSelector("#ag-origin-" + rowNum + " > div > ul > li:nth-child(1)")).getAttribute("innerText"));
        routing.add(webDriver.findElement(
                By.cssSelector("#ag-origin-" + rowNum + " > div > ul > li:nth-child(2)")).getAttribute("innerText"));

        // Origin and Destination routings may not exist for all rows, so do find in try catch
        try {
            routing.add(webDriver.findElement(
                    By.cssSelector("#ag-origin-" + rowNum + " > div > ul > li:nth-child(3)")).getAttribute("innerText"));
            routing.add(webDriver.findElement(
                    By.cssSelector("#ag-origin-" + rowNum + " > div > ul > li:nth-child(4)")).getAttribute("innerText"));
        } catch (NoSuchElementException e) {
            System.out.println("Only " + routing.size() + " routings found for row " + rowNum);
        }

        return routing;
    }
}