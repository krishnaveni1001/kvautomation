package us.cargosphere.automation.pages.settings;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class UsersPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
	
    
    @FindBy(how = How.ID, using = "usersLink")
   	private WebElement addUserLink;
    
    @FindBy(how = How.ID, using = "addUserButton")
   	private WebElement addUserButton;

    @FindBy(how = How.ID, using = "userDetails_tab")
   	private WebElement userDetailsTab;
    
    @FindBy(how = How.ID, using = "form_address")
   	private WebElement formAddress;
    
    @FindBy(how = How.ID, using = "form_address1")
   	private WebElement formAddress1;
    
    @FindBy(how = How.ID, using = "form_city")
   	private WebElement formCity;
    
    @FindBy(how = How.ID, using = "form_state")
   	private WebElement formState;
    
    @FindBy(how = How.ID, using = "form_postalCode")
   	private WebElement formPostalCode;
    
    @FindBy(how = How.ID, using = "form_phoneNum")
   	private WebElement formPhoneNum;
    
    @FindBy(how = How.ID, using = "form_cellNum")
   	private WebElement formCellNum;
    
    @FindBy(how = How.ID, using = "welcomeEmailCheck")
   	private WebElement welcomeEmailCheck;
    
    @FindBy(how = How.ID, using = "register")
   	private WebElement saveButton;
    
    @FindBy(how = How.ID, using = "cancelBtn")
   	private WebElement cancelButton;
    
    
    
    @FindBy(how = How.ID, using = "contactInfo_tab")
   	private WebElement contactInfoTab;
    
    @FindBy(how = How.ID, using = "form_name")
   	private WebElement formName;
    
    @FindBy(how = How.ID, using = "form_email")
   	private WebElement formEmail;
    
    @FindBy(how = How.ID, using = "form_userId")
   	private WebElement formLoginId;
    
    @FindBy(how = How.ID, using = "countryField")
   	private WebElement countryField;
    
    @FindBy(how = How.ID, using = "userTypeField")
   	private WebElement userTypeField;
    
    @FindBy(how = How.ID, using = "buField")
   	private WebElement businessUnit;
    
    @FindBy(how = How.ID, using = "userActive")
   	private WebElement userActive;
    
    @FindBy(how = How.ID, using = "userInactive")
   	private WebElement userInactive;
    
    @FindBy(how = How.ID, using = "rateSearchPermission")
   	private WebElement rateSearchPermission;
    
    @FindBy(how = How.ID, using = "rateMgmtPermission")
   	private WebElement rateMgmtPermission;
    
    @FindBy(how = How.ID, using = "quotingPermission")
   	private WebElement quotingPermission;
    
    @FindBy(how = How.ID, using = "fmcPermission")
   	private WebElement fmcPermission;
    
    @FindBy(how = How.ID, using = "reportsPermission")
   	private WebElement reportsPermission;
    
    @FindBy(how = How.ID, using = "accountAdminPermission")
   	private WebElement accountAdminPermission;
    
    @FindBy(how = How.ID, using = "systemAdminPermission")
   	private WebElement systemAdminPermission;
    
    @FindBy(how = How.ID, using = "rateMeshPermission")
   	private WebElement rateMeshPermission;
    
    @FindBy(how = How.XPATH, using ="//*[@id=\"addUserDetailsContent\"]/div/div[2]/div/div/div/div[7]/span[1]")
   	private WebElement checkAll;   

    @FindBy(how = How.XPATH, using ="//*[@id=\"addUserDetailsContent\"]/div/div[2]/div/div/div/div[7]/span[2]")
   	private WebElement clearAll;   
    
    @FindBy(how = How.ID, using = "cloneUserField")
   	private WebElement cloneUserField;
    
    @FindBy(how = How.XPATH, using =" //*[@id=\"dropdownMenu\"]")
   	private WebElement exportUserPermission;  
    
    
    
    public void clickUserLink() {
    	addUserLink.click();
    }
  
    
    public void clickAddUserButton() {
    	addUserButton.click();
    }

   
    
    public UsersPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/user-admin/admin.jsp")) {
	            throw new IllegalStateException("This is not Users page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }


}
