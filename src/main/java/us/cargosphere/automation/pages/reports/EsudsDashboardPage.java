package us.cargosphere.automation.pages.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class EsudsDashboardPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	 public EsudsDashboardPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        //Need to find tabID
	        if (!webDriver.getCurrentUrl().contains("/ptrade/dashboard/dashboard.jsp#/")) {
	            throw new IllegalStateException("This is not eSuds dashboard tab. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }

}
