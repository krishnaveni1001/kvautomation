package us.cargosphere.automation.pages.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class ConReqAprReportPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	 public ConReqAprReportPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("tabId=ContractAppReportTab")) {
	            throw new IllegalStateException("This is not contractsRequiring Approval report tab. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }
	
}
