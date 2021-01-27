package us.cargosphere.automation.pages.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class BaseTrendDashboardPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	 public BaseTrendDashboardPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        // Need to find tabId
	        if (!webDriver.getCurrentUrl().contains("ptrade/dashboard/dashboard.jsp#/baseRateTrends")) {
	            throw new IllegalStateException("This is not baserate trending dashboard tab. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }

}
