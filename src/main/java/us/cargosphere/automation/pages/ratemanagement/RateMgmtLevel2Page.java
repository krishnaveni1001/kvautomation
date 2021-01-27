package us.cargosphere.automation.pages.ratemanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class RateMgmtLevel2Page extends BasePage{
	
private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	 public RateMgmtLevel2Page(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/cgsm/contractGlobalSurMgmt.jsp	")) {
	            throw new IllegalStateException("This is not the Level 2 page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }

}
