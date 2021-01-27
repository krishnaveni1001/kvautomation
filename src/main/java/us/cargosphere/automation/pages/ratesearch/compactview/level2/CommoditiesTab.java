package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

/**
 * A PageObject fragment representing the Commodities Tab of the Level 2 details
 * that are shown when a user clicks the price of a rate.
 */
public class CommoditiesTab extends BasePage {
    private int rowNum;
    private WebElement context;
    private List<WebElement> includedCommodities;
    private List<WebElement> excludedCommodities;

    public CommoditiesTab(WebDriver webDriver, WebElement context, String rowNum) {
        super(webDriver, context);
        this.rowNum = Integer.parseInt(rowNum);
        this.context = context;
        includedCommodities = context.findElements(By.cssSelector("#includedCommodityGroups > .info"));
        excludedCommodities = context.findElements(By.cssSelector("#excludedCommodityGroups > .info"));
    }

    /**
     * Gets the included commoditiy list.
     * 
     * @return a list of {@link WebElement}s where each WebElement is one commodity.
     */
    public List<WebElement> getIncludedCommodities() {
        return includedCommodities;
    }

    public List<String> getIncludedCommodityNames() {
        List<String> commodityNames = new ArrayList<>();
        for(WebElement commodity : includedCommodities) {
            commodityNames.add(commodity.getAttribute("innerText"));
        }
        return commodityNames;
    }

    /**
     * Gets the excluded commoditiy list.
     * 
     * @return a list of {@link WebElement}s where each WebElement is one commodity.
     */
    public List<WebElement> getExcludedCommodities() {
        return excludedCommodities;
    }

    /**
     * Gets the text next to "Commodity Group:" in the header section.
     */
    public String getCommodityGroupHeaderText() {
        return String.join("",
                SeleniumUtil.getText(context.findElements(By.cssSelector(".compactCommodityHeader > span")), false));
    }
}