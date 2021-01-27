package us.cargosphere.automation.pages.ratesearch.startpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;
import us.cargosphere.automation.pages.ratesearch.TopNavBar;

/**
 * A PageObject representing the rate search start page that is located at
 * "/ptrade/ratesearch/start.jsp"
 */
public class RateSearchStartPage extends BasePage {

    public RateSearchStartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public SearchControls getSearchControls() {
        return new SearchControls(webDriver,
                webDriver.findElement(By.id("searchFieldsBox")));
    }

    public ViewSwitch getViewSwitch() {
        return new ViewSwitch(webDriver,
                webDriver.findElement(By.cssSelector("#rateSearchForm > div.negativeMargin > div > div")));
    }

    public NavigationMenuBar getTopNavigationMenuBar() {
        return new NavigationMenuBar(webDriver);
    }

    public void navigateToCarrierRateManagement() throws InterruptedException {
        getTopNavigationMenuBar().getRateMgmtNav().clickConsolePageLink();
    }
}
