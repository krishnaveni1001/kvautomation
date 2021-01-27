package us.cargosphere.automation.pages.quoting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class QuotingChangePage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
       
	 public QuotingChangePage (WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/jsp/QuoteFinder.jsp")) {
	            throw new IllegalStateException("This is not quote changes page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	      //  naviMenuBar = new NavigationMenuBar(webDriver);
	    }

    
}
