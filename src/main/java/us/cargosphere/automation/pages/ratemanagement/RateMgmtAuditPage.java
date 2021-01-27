package us.cargosphere.automation.pages.ratemanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class RateMgmtAuditPage  extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	 public RateMgmtAuditPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/jsp/ContractManagement/Ocean/AuditRates.jsp")) {
	            throw new IllegalStateException("This is not the Audit page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }
}
