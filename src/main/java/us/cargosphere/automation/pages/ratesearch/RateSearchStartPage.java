package us.cargosphere.automation.pages.ratesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;
import us.cargosphere.automation.pages.ratesearch.startpage.SearchControls;
import us.cargosphere.automation.pages.ratesearch.startpage.ViewSwitch;

/**
 * A PageObject representing the rate search start page that is located at
 * "/ptrade/ratesearch/start.jsp"
 */
public class RateSearchStartPage extends BasePage {
    private SearchControls searchControls;
    private ViewSwitch viewSwitch;

    private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}

	public RateSearchStartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        naviMenuBar = new NavigationMenuBar(webDriver);
        // Check that we are on the correct page.
        if (!webDriver.getCurrentUrl().contains("ptrade/ratesearch/start.jsp")) {
            throw new IllegalStateException("This is not the rateSearch start page. Currently on: " + webDriver.getCurrentUrl());
        }
        searchControls = new SearchControls(webDriver, webDriver.findElement(By.id("searchFieldsBox")));
        viewSwitch = new ViewSwitch(webDriver, webDriver.findElement(By.className("searchTypeIndicator")));
    }

    public SearchControls getSearchControls() {
        return searchControls;
    }

    public ViewSwitch getViewSwitch() {
        return viewSwitch;
    }
}
