package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.pages.BasePage;

/**
 * A Page Object fragment representing the Service Info tab of the level 2 details
 * from the Compact View of the rate search.
 */
public class ServiceInfoTab extends BasePage {
    private WebElement context;
    private String rowNum;
    private ServiceInfoTabBaseInfo baseInfo;
    private ServiceInfoTabInlandInfo inlandInfo;
    private ServiceInfoTabOutlandInfo outlandInfo;
    private ServiceInfoTabMaerskSpotInfo maerskSpotInfo;

    public ServiceInfoTab(WebDriver webDriver, WebElement context, String rowNum) {
        super(webDriver, context);
        this.context = context;
        this.rowNum = rowNum;

        if (isMaerskSpot()) {
            maerskSpotInfo = new ServiceInfoTabMaerskSpotInfo(context, rowNum);
        }

        if (context.findElements(By.id("#compact-service-info-inland-" + rowNum)).size() > 0) {
            inlandInfo = new ServiceInfoTabInlandInfo(webDriver, rowNum);
        }

        baseInfo = new ServiceInfoTabBaseInfo(webDriver, rowNum);

        if (context.findElements(By.id("#compact-service-info-outland-" + rowNum)).size() > 0) {
            outlandInfo = new ServiceInfoTabOutlandInfo(webDriver, rowNum);
        }
    }

    /**
     * Checks whether the Service Info tab shows Maersk Spot data.
     * 
     * @return {@code true} if Maersk Spot data is shown, {@code false} otherwise.
     */
    public boolean isMaerskSpot() {
        String c = context.getAttribute("class");
        if (c == null)
            return false;
        return c.contains("compactMaerskServiceInfo");
    }

    public boolean showsInlandData() {
        return inlandInfo != null;
    }

    public boolean showsOutlandData() {
        return outlandInfo != null;
    }

    public boolean showsBaseData() {
        return baseInfo != null;
    }

    /**
     * Gets the info from Base to Base section of the Service Info Tab.
     * @return {@link ServiceInfoTabBaseInfo}
     */
    public ServiceInfoTabBaseInfo getBaseInfo() {
        return this.baseInfo;
    };

    /**
     * Gets the info from Inland to Base section of the Service Info Tab.
     * @return {@link ServiceInfoTabInlandInfo}
     */
    public ServiceInfoTabInlandInfo getInlandInfo() {
        return this.inlandInfo;
    };

    /**
     * Gets the info from Base to Outland section of the Service Info Tab.
     * @return {@link ServiceInfoTabOutlandInfo}
     */
    public ServiceInfoTabOutlandInfo getOutlandInfo() {
        return this.outlandInfo;
    };

    /**
     * Gets the info from Maersk Spot section of the Service Info Tab.
     * @return {@link ServiceInfoTabMaerskSpotInfo}
     */
    public ServiceInfoTabMaerskSpotInfo getMaerskSpotInfo() {
        return this.maerskSpotInfo;
    };

    /**
     * Gets the {@link WebElement} of the Inland location routing header.
     */
    public WebElement getInlandHeader() {
        return context.findElement(By.id("#compact-service-info-inland-header-" + rowNum));
    }

    /**
     * Gets the {@link WebElement} of the Inland Service Info information rows.
     */
    public List<WebElement> getInlandDataRows() {
        return context.findElements(By.cssSelector("#compact-service-info-inland-data-" + rowNum + " > .info"));
    }

    /**
     * Gets the {@link WebElement} of the Base location routing header.
     */
    public WebElement getBaseHeader() {
        return context.findElement(By.id("#compact-service-info-base-header-" + rowNum));
    }

    /**
     * Gets the {@link WebElement} of the Base Service Info information rows.
     */
    public List<WebElement> getBaseDataRows() {
        return context.findElements(By.cssSelector("#compact-service-info-base-data-" + rowNum + " > .info"));
    }

    /**
     * Gets the {@link WebElement} of the Outland location routing header.
     */
    public WebElement getOutlandHeader() {
        return context.findElement(By.id("#compact-service-info-outland-header-" + rowNum));
    }

    /**
     * Gets the {@link WebElement}s of the Outland Service Info information rows.
     */
    public List<WebElement> getOutlandDataRows() {
        return  context.findElements(By.cssSelector("#compact-service-info-outland-data-" + rowNum + " > .info"));
    }

    /**
     * Gets the {@link WebElement}s of the Maersk Spot information rows.
     * This should include the Rate ID, Product Code, and Routing Code.
     */
    public List<WebElement> getMaerskSpotDataRows() {
        return context.findElements(By.cssSelector("section > *"));
    }
}