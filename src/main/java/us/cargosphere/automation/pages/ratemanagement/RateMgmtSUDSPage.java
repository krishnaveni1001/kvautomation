package us.cargosphere.automation.pages.ratemanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

/**
 * A PageObject representing the choose Carrier page that is located at
 * "/ptrade/jsp/Suds30/SudsContractOptions30.jsp"
 */
public class RateMgmtSUDSPage extends BasePage{

	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}

  public RateMgmtSUDSPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        // Check that we are on the correct page.
        if (!webDriver.getCurrentUrl().contains("ptrade/Suds30/SudsContractOptions30.jsp")) {
            throw new IllegalStateException("This is not the rateSearch start page. Currently on: " + webDriver.getCurrentUrl());
        }
        naviMenuBar = new NavigationMenuBar(webDriver);
    }
}
