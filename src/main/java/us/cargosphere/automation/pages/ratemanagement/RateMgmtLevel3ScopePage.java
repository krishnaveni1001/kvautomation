package us.cargosphere.automation.pages.ratemanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class RateMgmtLevel3ScopePage extends BasePage{
	
private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	 public RateMgmtLevel3ScopePage (WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/jsp/GlobalScopeManagement.jsp")) {
	            throw new IllegalStateException("This is not Level 3 scope page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }


}
