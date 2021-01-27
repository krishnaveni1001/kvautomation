package us.cargosphere.automation.admin.usermanagement;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.AddUserPopup;
import us.cargosphere.automation.pages.admin.usermanagement.QuotePermissionTab;
import us.cargosphere.automation.pages.admin.usermanagement.UserInfoRow;
import us.cargosphere.automation.pages.admin.usermanagement.UserManagementAdminPage;
import us.cargosphere.automation.pages.quoting.QuotePermissionsTabPage;

import java.util.List;
import java.util.Map;

public class UserManagementSteps extends BaseStepDefinitions {

	private UserManagementAdminPage userManagementAdminPage;
	private AddUserPopup addUserPopup;

	public void switchDriverToAdminFrame() {
		this.getDriver().switchTo().frame(this.getDriver().findElement(By.id("adminFrame")));
	}

	public void switchDriverToMainWindow() {
		this.getDriver().switchTo().parentFrame();
	}

	public UserManagementSteps(TestContext context) {
		super(context);
		userManagementAdminPage = this.testContext.getPageObjectManager().getUserManagementAdminPage();
	}

	@When("^the user populates the add user form with this data$")
	public void theUserPopulatesTheUserManagementFormWithThisData(DataTable dataTable) throws InterruptedException {
		
		userManagementAdminPage.clickAddUserButton();

		if (addUserPopup == null) {
			addUserPopup = userManagementAdminPage.getAddUserPopup();
		}
		Thread.sleep(2000);
		List<Map<String, String>> userDataList = dataTable.asMaps(String.class, String.class);
		Map<String, String> userData = userDataList.get(0);
		String userType = userData.get("User Type");

		addUserPopup.typeIntoNameInput(userData.get("Name"));
		addUserPopup.typeIntoEmailInput(userData.get("Email"));
		addUserPopup.typeIntoUserIdInput(userData.get("Login ID"));
		addUserPopup.selectCountry(userData.get("Country"));
		addUserPopup.selectUserType(userType);
		addUserPopup.selectBusinessUnit(userData.get("Business Unit"));

		if (Boolean.parseBoolean(userData.get("Rate Search"))) {
			addUserPopup.toggleRateSearchPermission();
		}

		if (Boolean.parseBoolean(userData.get("Rate Management"))) {
			addUserPopup.toggleRateManagementPermission();
		}

		if (Boolean.parseBoolean(userData.get("Quoting"))) {
			addUserPopup.toggleQuotingPermission();
		}

		if (Boolean.parseBoolean(userData.get("FMC"))) {
			addUserPopup.toggleFmcPermission();
		}

		if (Boolean.parseBoolean(userData.get("Reports"))) {
			addUserPopup.toggleReportsPermission();
		}

		if (Boolean.parseBoolean(userData.get("Account Admin"))) {
			addUserPopup.toggleAccountAdminPermission();
		}

		// These permissions are only visible if super user type is selected
		if (userType.toLowerCase().equals("super user")) {
			if (Boolean.parseBoolean(userData.get("System Admin"))) {
				addUserPopup.toggleSystemAdminPermission();
			}
			if (Boolean.parseBoolean(userData.get("Rate Mesh"))) {
				addUserPopup.toggleRateMeshPermission();
			}
		}

		// Unless user is specifically inactive, don't change user status default
		if (userData.get("User Status").toLowerCase().equals("inactive")) {
			addUserPopup.clickInactiveStatusRadio();
		}

	}

	@When("^the user opens the add user popup$")
	public void theUserOpensTheAddUserPopup() throws InterruptedException {
		switchDriverToAdminFrame();
		addUserPopup = userManagementAdminPage.getAddUserPopup();
	}

	@When("^the user submits the user management form$")
	public void theUserSubmitsTheUserManagementForm() throws InterruptedException {
		if (addUserPopup == null) {
			addUserPopup = userManagementAdminPage.getAddUserPopup();
		}

		addUserPopup.clickSaveUserButton();
		switchDriverToMainWindow();
	}

	@When("^the user refreshes the page$")
	public void theUserRefreshesThePage() throws InterruptedException {
		this.getDriver().navigate().refresh();
	}

	@Then("^the user table contains this data$")
	public void theUserTableContainsThisData(DataTable dataTable) {
	//	switchDriverToAdminFrame();
		List<Map<String, String>> userDataList = dataTable.asMaps(String.class, String.class);

		for (int i = 0; i < userDataList.size(); i++) {
			Map<String, String> userData = userDataList.get(i);
			UserInfoRow actualUserRow = userManagementAdminPage.getRow(i);

			Assert.assertEquals(userData.get("Name"), actualUserRow.getName());
			Assert.assertEquals(userData.get("Login ID"), actualUserRow.getLoginId());
			Assert.assertEquals(userData.get("Email"), actualUserRow.getEmail());
			Assert.assertEquals(userData.get("User Type"), actualUserRow.getUserType());
			Assert.assertEquals(userData.get("Business Unit"), actualUserRow.getBusinessUnit());
			Assert.assertEquals(Boolean.parseBoolean(userData.get("Rate Search")), actualUserRow.getRateSearchPerm());
			Assert.assertEquals(Boolean.parseBoolean(userData.get("Rate Management")),
					actualUserRow.getRateManagementPerm());
			Assert.assertEquals(Boolean.parseBoolean(userData.get("Quoting")), actualUserRow.getQuotingPerm());
			Assert.assertEquals(Boolean.parseBoolean(userData.get("FMC")), actualUserRow.getFmcPerm());
			Assert.assertEquals(Boolean.parseBoolean(userData.get("Reports")), actualUserRow.getReportsPerm());
			Assert.assertEquals(Boolean.parseBoolean(userData.get("Account Admin")),
					actualUserRow.getAccountAdminPerm());
		}
	}

	@When("^the user enables all rate management permissions$")
	public void userEnablesAllRateManagement() throws Throwable {
		addUserPopup.getRateManagementPermissionTab().clickEnableAllButton();
		addUserPopup.clickUserDetailsTab();
	}

	@When("^the user enables all rate search permissions$")
	public void userEnablesAllRateSearchPermissions() {
		addUserPopup.getRateSearchPermissionTab().clickEnableAllButton();
		addUserPopup.clickUserDetailsTab();
	}

	@When("^the user enables all quote permissions$")
	public void userEnablesAllQuotePermissions() {
		addUserPopup.getQuotePermissionTab().clickEnableAllButton();
		addUserPopup.clickUserDetailsTab();
	}

	@Then("^the user clicks on the \"([^\"]*)\" row$")
	public void the_user_clicks_on_the_row(String arg1) throws Throwable {

		userManagementAdminPage.clickRow(arg1);

	}

	@Then("^all the rate search permissions are checked$")
	public void all_the_rate_search_permissions_are_checked() throws Throwable {
		Thread.sleep(2000);
		addUserPopup.rateSearchTab();

	}

	@Then("^the following permission categories are checked$")
	public void the_following_permission_categories_are_checked(DataTable table) throws Throwable {
		Thread.sleep(2000);
		List<String> list = table.asList(String.class);
		for (String permission : list) {
			switch (permission) {
			case "Rate Search":
				Assert.assertEquals(true,
						this.getDriver().findElement(By.cssSelector("#rateSearchPermLabel")).isEnabled());
				break;
			case "Rate Management":
				Assert.assertEquals(true,
						this.getDriver().findElement(By.cssSelector("#rateMgmtPermLabel")).isEnabled());
				break;
			case "Quoting":
				Assert.assertEquals(true,
						this.getDriver().findElement(By.cssSelector("#quotingPermLabel")).isEnabled());
				break;
			case "FMC":
				Assert.assertEquals(true, this.getDriver().findElement(By.cssSelector("#fmcPermLabel")).isEnabled());
				break;
			case "Reports":
				Assert.assertEquals(true,
						this.getDriver().findElement(By.cssSelector("#reportsPermLabel")).isEnabled());
				break;
			case "Account Admin":
				Assert.assertEquals(true,
						this.getDriver().findElement(By.cssSelector("#accountAdminPermLabel")).isEnabled());

			}

		}
	}

	@Then("^I click on Quote$")
	public void i_click_on_Quote() throws Throwable {
		Thread.sleep(20000);
		addUserPopup = userManagementAdminPage.AddUserPopup();
		addUserPopup.clickQuotePermissionTab();

	}

	@When("^the Rate Search permission is clicked$")
	public void the_Rate_Search_permission_is_clicked() throws Throwable {

		this.getDriver().findElement(By.xpath("//a[@class='leftPanel-tabs'][contains(text(),'Rate Search')]")).click();
	}

}
