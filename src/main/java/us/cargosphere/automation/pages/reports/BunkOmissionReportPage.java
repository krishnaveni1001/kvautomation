package us.cargosphere.automation.pages.reports;

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

import cucumber.api.DataTable;
import cucumber.api.java.en.When;


import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class BunkOmissionReportPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	
    @FindBy(how = How.NAME, using = "privacyIndBF")
	private WebElement enableButton;
    
	@FindBy(how = How.ID, using = "otherBFUsers")
	private WebElement availableUsers;
	
	 
	@FindBy(how = How.ID, using = "selectedBFUsers")
	private WebElement selectedUsers;
	
	@FindBy(how = How.ID, using = "selectUserBF")
	private WebElement selectButton;
	
	@FindBy(how = How.ID, using = "altEmailAddress")
	private WebElement reportEmail;
	
	@FindBy(how = How.ID, using = "GenerateButton")
	private WebElement repGenarateButton;
	
	
	public void SelectAvailableUser(String user) {
		Select selAvailableUser = new Select(availableUsers);
		
		boolean userFound = false;
		for (WebElement userElement: selAvailableUser.getOptions()) {
			if (userElement.getText().equals(user)) {
				userElement.click();
				userFound = true;
				break;
			}
		}
		
		if ( userFound == false ) {
			 System.out.println("User not found");
		}
	}
    
	public void ClickMoveButton() {
		selectButton.click();
		
	}
	
	public void CheckSelectedUsers() {
		Select selSelectedUsers = new Select(selectedUsers);
		
		if ( selSelectedUsers.getOptions().size() > 0 ) {
			//User selected and good to proceed
		}
		else {
			//Exception no user selected
		}
	}
    

	public void EnterEmail(String email) {
		reportEmail.click();
		reportEmail.sendKeys(email);
		reportEmail.sendKeys(Keys.ENTER);
		
	}
	
	public void ClickGenerateReport() {
		repGenarateButton.submit();
	}
	
    public BunkOmissionReportPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("tabId=BFReportTab")) {
	            throw new IllegalStateException("This is not bunker omission report page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }
	

}
