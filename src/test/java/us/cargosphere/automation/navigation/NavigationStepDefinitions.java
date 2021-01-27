package us.cargosphere.automation.navigation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cucumber.api.java.en.And;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.CucumberRunner;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;
import us.cargosphere.automation.pages.navigation.RateMgmtSubMenu;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtChooseCarrierPage;
import us.cargosphere.automation.util.Flags;

public class NavigationStepDefinitions extends BaseStepDefinitions {

	private NavigationMenuBar navigationMenuBar;
	private RateMgmtSubMenu ratemanagementSubMenu;
	private RateMgmtChooseCarrierPage carrierPage;

	public NavigationStepDefinitions(TestContext testContext) {
		super(testContext);
		navigationMenuBar = this.testContext.getPageObjectManager().getNavigationMenuBar();
	}

	private static final Map<String, String> navigationMenuItems = new HashMap<>();
	static {
		navigationMenuItems.put("Rate Search", "rateSearchMenu");
		navigationMenuItems.put("Rate Management", "rateMgmtMenu");
		navigationMenuItems.put("Rate Mesh", "rateMeshMenu");
		navigationMenuItems.put("Quoting", "quotingMenu");
		navigationMenuItems.put("FMC", "fmcMenu");
		navigationMenuItems.put("Reports", "reportsMenu");
		navigationMenuItems.put("Admin", "adminMenuLink");
		navigationMenuItems.put("User Profile", "userMenuLink");
		navigationMenuItems.put("Create QP", "ui-id-1");
		navigationMenuItems.put("Single Routing", "ui-id-2");
		navigationMenuItems.put("Ocean-FCL", "ui-id-4");
		navigationMenuItems.put("Create New", "ui-id-9");
	}

	@Given("^that user navigates to \"([^\"]*)\"$")
	public void navigateToPage(String page) throws Throwable {
		String url = this.buildUrl(page);
		System.out.println("Trying url: " + url);
		this.getDriver().get(url);
		Thread.sleep(2000);
	}

	private String buildUrl(String page) {
		return new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)) //
				.append(page) //
				.toString();
	}

	@Then("^user is a \"([^\"]*)\"$")
	public void userIsAOwner(String userType) {
		Assert.assertEquals(userType, this.getDriver().findElement(By.id("userType")).getText());
	}

	@Then("^should be able to see all the menus$")
	public void shouldBeAbleToSeeAllTheMenus() {
		for (String navigation : navigationMenuItems.keySet()) {
			Assert.assertEquals(true,
					this.getDriver().findElement(By.id(navigationMenuItems.get(navigation))).isDisplayed());
		}
	}

	@Deprecated
	@Then("^user clicks on \"([^\"]*)\"$")
	public void userClicksOnNavigationMenuItem(String menuItem) throws Throwable {
		Thread.sleep(2000);
		if (navigationMenuItems.get(menuItem) != null) {
			this.getDriver().findElement(By.id(navigationMenuItems.get(menuItem))).click();
		} else {
			this.getDriver().findElement(By.id(menuItem)).click();
		}
		Thread.sleep(2000);
	}

	@When("^I choose below carrier$")
	public void i_choose_below_carrier(DataTable carrier) throws Throwable {
		List<List<String>> data = carrier.raw();

		this.getDriver().findElement(By.xpath("//input[@id='carrierSearchInput']")).sendKeys(data.get(0).get(0));

		this.getDriver().findElement(By.xpath("//input[@id='carrierSearchInput']")).sendKeys(Keys.RETURN);
		this.getDriver().findElement(By.id("dropdownMenuLink")).click();

	}

	@Then("^user sees \"([^\"]*)\" popup$")
	public void userSeesThePopup(String popupClass) throws Throwable {
		Thread.sleep(5000);
		WebDriverWait block = new WebDriverWait(this.getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.className(popupClass)));
		Assert.assertEquals(true, this.getDriver().findElement(By.className(popupClass)).isDisplayed());
		Thread.sleep(2000);
	}

	@Then("^find the user whose login is  \"([^\"]*)\"$")
	public void findUserByLoginId(String loginId) throws Throwable {
		Thread.sleep(5000);
		List<WebElement> lstColumn = this.getDriver()
				.findElement(By.xpath("//*[@id=\"borderLayout_eGridPanel\"]/div[1]/div/div[4]/div[3]/div/div"))
				.findElements(By.tagName("div")).stream().filter(elem -> {
					String text = elem.getText();
					return loginId.equals(text);
				}).collect(Collectors.toList());
		Actions action = new Actions(this.getDriver());
		for (int i = 0; i < lstColumn.size(); i++) {
			action.moveToElement(lstColumn.get(i)).doubleClick().perform();
		}
	}

	@Deprecated
	@Then("^enters email \"([^\"]*)\" for password reset$")
	public void enterTheEmailIDForResetPassword(String emailAddress) {
		this.getDriver().findElement(By.id("reset_email")).sendKeys(emailAddress);
		this.getDriver().findElement(By.id("reset_email")).sendKeys(Keys.ENTER);
		Assert.assertEquals("Email Sent!", this.getDriver().findElement(By.className("email_sent")).getText());
	}

	@Given("^try the reset password link \"([^\"]*)\" with environment \"([^\"]*)\"$")
	public void tryTheResetPasswordLink(String gResetPasswordLink, String env) throws Throwable {
		String resetPasswordLink = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.EMAIL_URL)) //
				.toString();
		String environmentPassword = BaseStepDefinitions.envs.get(env);

		StringBuilder resetUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append(env) //
				.append(":") //
				.append(environmentPassword) //
				.append("@") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)); //
		if (StringUtils.isNotEmpty(resetPasswordLink)) {
			resetUrl.append(resetPasswordLink);
		} else {
			resetUrl.append(gResetPasswordLink);
		}
		System.out.println("Trying url: " + resetUrl.toString());
		this.getDriver().get(resetUrl.toString());
		Thread.sleep(5000);
	}

	@Then("the following navigations are visible$")
	public void checkTheFollowingNavigations(DataTable dataTable) {
		List<String> list = dataTable.asList(String.class);
		for (String navigation : list) {
			switch (navigation) {
			case "Rate Search":
				Assert.assertTrue(navigationMenuBar.isRateSearchNavVisible());
				break;
			case "Rate Management":
				Assert.assertTrue(navigationMenuBar.isRateMgmtNavVisible());
				break;
			case "Quoting":
				Assert.assertTrue(navigationMenuBar.isQuotingNavVisible());
				break;
			case "Reports":
				Assert.assertTrue(navigationMenuBar.isReportsNavVisible());
			default:
				throw new InvalidArgumentException("Unknown navigation bar item: " + navigation);
			}
		}
	}

	@Then("^the user type indicator displays \"([^\"]*)\"$")
	public void theUserTypeIndicatorDisplays(String expected) {
		String message = "Expected user type indicator in navbar user submenu to match user's type";
		Assert.assertEquals(message, expected, navigationMenuBar.getUserSubMenu().getUserTypeInd());
	}

	@Then("^all the navigation menu options should be visible$")
	public void allTheNavigationMenuOptionsShouldBeVisible() {
		Assert.assertTrue(navigationMenuBar.isRateSearchNavVisible() && navigationMenuBar.isRateMgmtNavVisible()
				&& navigationMenuBar.isQuotingNavVisible() && navigationMenuBar.isFmcNavVisible()
				&& navigationMenuBar.isReportsNavVisible() && navigationMenuBar.isRateMeshNavVisible()
				&& navigationMenuBar.isAdminMenuButtonVisible());
	}

	@And("^the user navigates to the user management page$")
	public void theUserNavigatesToTheUserManagementPage() throws InterruptedException {
		navigationMenuBar.getAdminSubMenu().clickUserButton();
		Thread.sleep(1000);
	}
}
