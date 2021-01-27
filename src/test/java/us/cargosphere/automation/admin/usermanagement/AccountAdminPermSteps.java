package us.cargosphere.automation.admin.usermanagement;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.AccountAdminPermissionTab;
import us.cargosphere.automation.pages.admin.usermanagement.CommonPermissionPage;
import us.cargosphere.automation.pages.admin.usermanagement.SystemAdminPermissionTab;

public class AccountAdminPermSteps extends BaseStepDefinitions{
	
 	private AccountAdminPermissionTab accountAdmPermPage;	
	public AccountAdminPermSteps(TestContext context) {
		super(context);
	accountAdmPermPage = this.testContext.getPageObjectManager().getAccountAdmPermPage();
	
	} 

	
	@And("^user clicks on disableall button$")
	public void userClicksOnDisableallButton() throws Throwable {
		accountAdmPermPage.clickDisableButton();
	}

	@And("^user click on enable all button$")
	public void userClickOnEnableAllButton() throws Throwable {
		accountAdmPermPage.clickAccEnableButton();
	}
	
}
