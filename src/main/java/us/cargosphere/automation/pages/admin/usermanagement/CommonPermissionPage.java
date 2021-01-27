package us.cargosphere.automation.pages.admin.usermanagement;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;

import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class CommonPermissionPage extends BasePage {
	
private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}

    
    
    
    public CommonPermissionPage(WebDriver webDriver) {
		super(webDriver);
	  
	    PageFactory.initElements(webDriver, this);
	    naviMenuBar = new NavigationMenuBar(webDriver);
	} 
}
