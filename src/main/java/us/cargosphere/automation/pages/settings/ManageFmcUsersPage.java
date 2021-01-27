package us.cargosphere.automation.pages.settings;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class ManageFmcUsersPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	
    @FindBy(how = How.ID, using = "addUserButton")
	private WebElement addFmcUserButton;
    
    @FindBy(how = How.ID, using = "userName")
   	private WebElement addUserName;
    
    @FindBy(how = How.ID, using = "loginId")
   	private WebElement loginId;
    
    @FindBy(how = How.ID, using = "emailAddress")
   	private WebElement emailId;
    
    @FindBy(how = How.ID, using = "welcomeEmailCheck")
   	private WebElement welcomeEmailCheck;
    
    @FindBy(how = How.ID, using = "cancelCarrier")
   	private WebElement cancelButton;
    
    @FindBy(how = How.ID, using = "saveCarrier")
   	private WebElement saveButton;
    
  
    
  
    
    public void ClickAddUser() {
    	addFmcUserButton.click();
    }
    
    public void EnterFmcName(String name) {
    	addUserName.click();
    	addUserName.clear();
    	addUserName.sendKeys(name);
    	addUserName.sendKeys(Keys.ENTER);
    }
    
    public void EnterLoginId(String logid) {
    	loginId.click();
    	loginId.sendKeys(logid);
    	loginId.sendKeys(Keys.ENTER);
    }
   
    public void EnterEmailId(String email) {
    	emailId.click();
    	emailId.sendKeys(email);
    	emailId.sendKeys(Keys.ENTER);
    }
    
    public void CheckWelcomeEmailStatus() {
    	if (welcomeEmailCheck.isSelected()) {
    		System.out.println("Welcome email is checked");
    	}
    	else {
    		welcomeEmailCheck.click();
    	}
    }
    
    public void ClickSaveUser() {
    	saveButton.click();
    }
    
    public void ClickCancelButton() {
    	cancelButton.click();
    }
   
    public ManageFmcUsersPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/fmc-users/fmc-users-list.jsp")) {
	            throw new IllegalStateException("This is not Manage FMC tariff users page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }

}
