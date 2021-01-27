package us.cargosphere.automation.admin.usermanagement;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.SystemAdminPermissionTab;

public class SystemAdminPermSteps extends BaseStepDefinitions{
	
	private SystemAdminPermissionTab systemAdmPermPage;	
	public SystemAdminPermSteps(TestContext context) {
		super(context);
	systemAdmPermPage = this.testContext.getPageObjectManager().getSysAdmPermPage();
	
	} 


	@And("^user clicks on search box \"([^\"]*)\"$")
	public void userClicksOnSearchBox(String searchId) throws Throwable {
		systemAdmPermPage.EnterUserId(searchId);
		systemAdmPermPage.clickEditLink();
	}


	@And("^user clicks on search box and enter \"([^\"]*)\"$")
	public void userClicksOnSearchBoxAndEnter(String searchId) throws Throwable {
		systemAdmPermPage.EnterUserId(searchId);
		systemAdmPermPage.clickEditLink();
	}


	@And("^user clicks on enable all button$")
	public void userClicksOnEnableAllButton() throws Throwable {
		systemAdmPermPage.clickEnableButton();
	}


	@And("^user clicks on Save user$")
	public void userClicksOnSaveUser() throws Throwable {
		systemAdmPermPage.clickSaveButton();
	//	Thread.sleep(4000);
		}


	@And("^user clicks on disable all button$")
	public void userClicksOnDisableAllButton() throws Throwable {
		systemAdmPermPage.clickDisableButton();
	}


	

	@And("^user clicks on quote settings$")
	public void userClicksOnQuoteSettings() throws Throwable {
	//	Thread.sleep(4000);
		systemAdmPermPage.clickEnableQuoteSettingsButton();
	//	Thread.sleep(4000);
	}


	@And("^user gets awarning message$")
	public void userGetsAwarningMessage() throws Throwable {
		assertTrue(systemAdmPermPage.showsError());
		System.out.println("Error message");
	//	Thread.sleep(4000);
	}


	@And("^user enable currency bump checkbox$")
	public void userEnableCurrencyBumpCheckbox() throws Throwable {
		systemAdmPermPage.clickEnableCurrencyBumpButton();
		System.out.println("currency enabled");
	//	Thread.sleep(4000);
}


	@And("^user get an alert$")
	public void userGetAnAlert() throws Throwable {
		systemAdmPermPage.clickAlertPopup();
	}


	@And("^user enable VIP button and disable the checkboxes$")
	public void userEnableVIPButtonAndDisableTheCheckboxes() throws Throwable {
		systemAdmPermPage.clickEnableVIPButton();
	//	Thread.sleep(4000);
		systemAdmPermPage.clickDisableVIP1Button();
		systemAdmPermPage.clickDisableVIP2Button();
	//	Thread.sleep(4000);
	}


}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
