package us.cargosphere.automation.settings;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.settings.ManageFmcUsersPage;

public class FmcSteps extends BaseStepDefinitions{
	
	private ManageFmcUsersPage fmcUsersPage;
	public FmcSteps(TestContext context) {
		super(context);
		fmcUsersPage = this.testContext.getPageObjectManager().getFmcPage();
	}
	

	@And("^user enter fmc user name \"([^\"]*)\"$")
	public void userEnterFmcUserName(String name) throws Throwable {
		fmcUsersPage.EnterFmcName(name);
	}

	@And("^user enter login id \"([^\"]*)\"$")
	public void userEnterLoginId(String loginid) throws Throwable {
		fmcUsersPage.EnterLoginId(loginid);
	}

	@And("^user enter email id \"([^\"]*)\"$")
	public void userEnterEmailId(String emailid) throws Throwable {
		fmcUsersPage.EnterEmailId(emailid);
	}

	@And("^user click on save button$")
	public void userClickOnSaveButton() throws Throwable {
		Thread.sleep(4000);
		fmcUsersPage.ClickSaveUser();
	}

	@And("^user click on add fmcuser button$")
	public void userClickOnAddFmcuserButton() throws Throwable {
		fmcUsersPage.ClickAddUser();
	}
	
}
