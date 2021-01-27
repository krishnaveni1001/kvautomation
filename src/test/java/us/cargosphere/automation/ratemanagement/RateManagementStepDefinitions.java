package us.cargosphere.automation.ratemanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtChooseCarrierPage;

public class RateManagementStepDefinitions extends BaseStepDefinitions {
     
	RateMgmtChooseCarrierPage carrierpage;

	private static final Map<String, String> ratemanagementMenuItems = new HashMap<>();
	static {
		ratemanagementMenuItems.put("SUDS", "sudsLink");
		ratemanagementMenuItems.put("Console", "consolePageLink");
		ratemanagementMenuItems.put("Level 2 Surcharges", "level2SurLink");
		ratemanagementMenuItems.put("Audit", "auditLink");
		ratemanagementMenuItems.put("Level 3 Scope Definition", "level3ScopeLink");
		ratemanagementMenuItems.put("Level 3 Surcharges", "level3SurLink");
		ratemanagementMenuItems.put("Level 3 GRIs", "level3GriLink");
		ratemanagementMenuItems.put("FreeTime", "freeTimeLink");
	}
	
	
	@When("^user clicks on freetime link$")
	public void user_clicks_on_freetime_link() throws Throwable {
		Thread.sleep(2000);
		this.getDriver().findElement(By.cssSelector("#cardDropdown > a:nth-child(1)")).click();
	}


	@Then("^user click on searchbox$")
	public void userClickOnSearchbox() throws Throwable {
		System.out.println("check box");
		Thread.sleep(5000);

		this.getDriver().findElement(By.id("quickFilter")).sendKeys("Latha QA Auto");
		Thread.sleep(5000);
	}

	@Then("^user clicks on rate management submenu$")
	public void userClicksOnRateManagementSubmenu() throws Throwable {
		Thread.sleep(5000);
		for (String rtnavigation : ratemanagementMenuItems.keySet()) {
			this.getDriver().findElement(By.id("rateMgmtMenu")).click();
			Assert.assertEquals(true,
					this.getDriver().findElement(By.id(ratemanagementMenuItems.get(rtnavigation))).isDisplayed());
			Thread.sleep(2000);
			this.getDriver().findElement(By.id(ratemanagementMenuItems.get(rtnavigation))).click();
			Thread.sleep(1000);
			System.out.println("rate management navigation");
		}

	}

	@Then("^user clicks on \"([^\"]*)\" under Ratemanagement submenu$")
	public void userClicksOnNavigationMenuItem(String menuItem) throws Throwable {
		Thread.sleep(2000);
		if (ratemanagementMenuItems.get(menuItem) != null) {
			this.getDriver().findElement(By.id(ratemanagementMenuItems.get(menuItem))).click();
		} else {
			this.getDriver().findElement(By.id(menuItem)).click();
		}
		Thread.sleep(2000);
	}

	@Then("^user choose one carrier$")
	public void userChooseOneCarrier() throws Throwable {
		this.getDriver().findElement(By.id("chooseCarrierLink")).click();
	}

	@Then("^user logout from the environment$")
	public void userLogoutFromTheEnvironment() throws Throwable {
		this.getDriver().findElement(By.id("userMenu")).click();
		this.getDriver().findElement(By.id("logoutCenterLink")).click();
		Thread.sleep(5000);
	}

	@Then("^manage select contracts$")
	public void manageSelectContracts() throws Throwable {
	}

	@Then("^user can edit the permission$")
	public void userCanEditThePermission() throws Throwable {
		Actions action = new Actions(this.getDriver());
		action.moveToElement(this.getDriver().findElement(By.xpath(
				"/html/body/app-root/app-user-details/div[1]/div/ag-grid-angular/div/div[2]/div[2]/div/div[1]/div/div[4]/div[3]/div/div/div[1]")))
				.doubleClick().perform();
		Thread.sleep(2000);
		WebDriverWait block = new WebDriverWait(this.getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.className("addUserDialog")));
		Assert.assertEquals(true, this.getDriver().findElement(By.className("addUserDialog")).isDisplayed());
	}

	@Then("^user give permisson to manage few contracts$")
	public void userGivePermissonToManageFewContracts() throws Throwable {
		this.getDriver().findElement(By.id("rateMgmtSelCont")).click();
		Thread.sleep(2000);
		this.getDriver().findElement(By.id("rateMgmtAddContractsBtn")).click();
		Thread.sleep(2000);
		this.getDriver().findElement(By.id("addContractDropdown")).click();
		Thread.sleep(2000);
		this.getDriver().findElement(By.xpath(
				"/html/body/modal-container[2]/div/div/form/div[1]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[1]/li/input"))
				.sendKeys("ZIM");
		Thread.sleep(2000);
		this.getDriver().findElement(By.xpath(
				"/html/body/modal-container[2]/div/div/form/div[1]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/div"))
				.click();
		Thread.sleep(2000);
		this.getDriver().findElement(By.xpath(
				"/html/body/modal-container[2]/div/div/form/div[2]/div[3]/ag-grid-angular/div/div[2]/div[2]/div/div[1]/div/div[4]/div[3]/div/div/div[1]/div[1]/span/span[1]/span[2]"))
				.click();
		Thread.sleep(2000);
		this.getDriver().findElement(By.id("addContractsRegister")).click();
		Thread.sleep(2000);
	}

	@Then("^user give permission to limit by contract attributes$")
	public void userGivePermissionToLimitByContractAttributes(DataTable dt) throws Throwable {
		this.getDriver().findElement(By.id("rateMgmtLimitCont")).click();

		List<Map<String, String>> lstInput = dt.asMaps(String.class, String.class);
		for (int i = 0; i < lstInput.size(); i++) {
			this.getDriver().findElement(By.id(lstInput.get(i).get("attribute"))).click();
			Thread.sleep(5000);
			this.getDriver().findElement(By.id(lstInput.get(i).get("attribute"))).findElement(By.className("item1"))
					.findElement(By.tagName("li")).findElement(By.className("ng-pristine"))
					.sendKeys(lstInput.get(i).get("value"));
			Thread.sleep(5000);
			this.getDriver().findElement(By.id(lstInput.get(i).get("attribute"))).findElement(By.className("item2"))
					.findElement(By.tagName("li")).click();
			Thread.sleep(5000);
			System.out.println("attribute" + lstInput.get(i).get("attribute"));
			this.getDriver().findElement(By.id(lstInput.get(i).get("attribute"))).click();
		}

	}

	@Then("^user find the number of contracts$")
	public void userFindTheNumberOfContracts() throws Throwable {
		List<WebElement> allElements = this.getDriver().findElements(By.id("divselContractGrpIds"));
		int totalCont = allElements.size();
		System.out.println("total no of contracts :" + totalCont);
		Assert.assertEquals(totalCont, 1);
		for (WebElement element : allElements) {
			System.out.println("Value :" + element.getText());
		}
	}

	@Then("^user can check internal contract owner permission$")
	public void userCanCheckInternalContractOwnerPermission() throws Throwable {
		this.getDriver().findElement(By.id("globalInfoDropDown")).click();
		Thread.sleep(5000);
		this.getDriver().findElement(By.linkText("Contract Information")).click();
		Thread.sleep(5000);
		this.getDriver().findElement(By.linkText("Internal Ownership (Individuals)")).click();
		Thread.sleep(5000);
		String owner = this.getDriver().findElement(By.id("multiselect0_avListContent"))
				.findElement(By.className("ui-state-default option-element")).getText();
		if (owner.equals("Latha QA Auto")) {
			System.out.println("Element Found...");
		} else {
			System.out.println("Element not found...");
		}
	}

	@Then("^user open a contract$")
	public void userOpenAContract() throws Throwable {
		Thread.sleep(5000);
		this.getDriver().findElement(By.id("openContractFilter")).click();
		this.getDriver().findElement(By.id("searchStrAssigned")).click();
		Thread.sleep(5000);
		this.getDriver().findElement(By.id("searchStrAssigned")).sendKeys("3456");
		Thread.sleep(5000);
		this.getDriver().findElement(By.xpath("//*[@id=\"selContractGrpIds\"]/option")).click();
		Thread.sleep(5000);
		this.getDriver().findElement(By.id("selectAContract")).click();

	}

	@Then("^user check customers and external agents link$")
	public void userCheckCustomersAndExternalAgentsLink() throws Throwable {
		this.getDriver().findElement(By.id("customerExtAgentsLink")).click();
		Thread.sleep(5000);
	}

	@Then("^user check manage tariff organization record$")
	public void userCheckManageTariffOrganizationRecord() throws Throwable {
		this.getDriver().findElement(By.id("tariffOrgRecordLink")).click();
		Thread.sleep(5000);
	}

	@Then("^user check fmc tariff users permission$")
	public void userCheckFmcTariffUsersPermission() throws Throwable {
		// FMC has logic change
	}

	@Then("^click on ratemesh permission$")
	public void clickOnRatemeshPermission() throws Throwable {

		Thread.sleep(2000);
		if (this.getDriver().findElement(By.id("rateMeshPermission")).isSelected()) {
			System.out.println("Rate mesh check box is selected");

		} else {
			this.getDriver().findElement(By.id("rateMeshPermission")).click();
			System.out.println("Rate mesh ");
		}
		Thread.sleep(2000);
		this.getDriver().findElement(By.id("rateMesh_tab")).click();
		Thread.sleep(2000);
	}

	@Then("^user check ratemesh submenu$")
	public void userCheckRatemeshSubmenu() throws Throwable {
		this.getDriver().findElement(By.id("rateShareReqLink")).click();
		Thread.sleep(2000);
	}

	private static final Map<String, String> reportMenuItems = new HashMap<>();
	static {
		reportMenuItems.put("Contracts", "contractReportLink");
		reportMenuItems.put("Contracts Requiring Approval", "conReqAprReportLink");
		reportMenuItems.put("Future Rate", "futureRateLink");
		reportMenuItems.put("GRI", "griLink");
		reportMenuItems.put("Quote Volume", "quoteLink");
		reportMenuItems.put("Quote Analytics", "quoteAnalyticsPermLink");
		reportMenuItems.put("Rate Expiration", "rateExpirationLink");
		reportMenuItems.put("Rate Summary", "vccReportLink");
		reportMenuItems.put("System Usage", "systemUsagePermLink");
		reportMenuItems.put("User Login", "userLoginLink");

		reportMenuItems.put("Contracts-Dashboard", "contractsDashLink");
		reportMenuItems.put("eSUDS", "esudsDashLink");
		reportMenuItems.put("SUDS", "sudsDashLink");
		reportMenuItems.put("Users and rate searches", "userRatesearchDashLink");

	}

	@Then("^user check report submenu$")
	public void userCheckReportSubmenu() throws Throwable {
		Thread.sleep(5000);
		for (String repNavigation : reportMenuItems.keySet()) {
			this.getDriver().findElement(By.id("reportsMenuLink")).click();
			Assert.assertEquals(true,
					this.getDriver().findElement(By.id(reportMenuItems.get(repNavigation))).isDisplayed());
			Thread.sleep(2000);
			this.getDriver().findElement(By.id(reportMenuItems.get(repNavigation))).click();
			Thread.sleep(1000);
			System.out.println("rate management navigation");
		}

	}

	@Then("^user check on report menu \"([^\"]*)\"$")
	public void userCheckOnReportMenu(String repMenuItems) throws Throwable {

		Thread.sleep(2000);
		if (reportMenuItems.get(repMenuItems) != null) {
			this.getDriver().findElement(By.id(reportMenuItems.get(repMenuItems))).click();
		} else {
			this.getDriver().findElement(By.id(repMenuItems)).click();
		}
		Thread.sleep(2000);
	}

	@Then("^user click on selected \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userClickOnSelectedAndAnd(String selMainItem, String selSubMenu, String keyValue1) throws Throwable {

		this.getDriver().findElement(By.id(selMainItem)).click();
		this.getDriver().findElement(By.id(selSubMenu)).click();
		this.getDriver().findElement(By.id(selSubMenu)).findElement(By.className("item1")).findElement(By.tagName("li"))
				.findElement(By.className("ng-pristine")).sendKeys(keyValue1);
		Thread.sleep(2000);
		this.getDriver().findElement(By.id(selSubMenu)).findElement(By.className("item2")).findElement(By.tagName("li"))
				.click();

	}

	@Then("^click on \"([^\"]*)\" and tab \"([^\"]*)\" and enable \"([^\"]*)\"$")
	public void clickOnAndTabAndEnable(String perm, String permTab, String enbAll) throws Throwable {

		Thread.sleep(2000);
		if (this.getDriver().findElement(By.id(perm)).isSelected()) {
			System.out.println("Report check box is selected");
		} else {
			this.getDriver().findElement(By.id(perm)).click();
		}
		Thread.sleep(2000);
		this.getDriver().findElement(By.id(permTab)).click();
		Thread.sleep(2000);
		this.getDriver().findElement(By.id(enbAll)).click();
		Thread.sleep(2000);

	}

	private static final Map<String, String> adminMenuItems = new HashMap<>();
	static {
		adminMenuItems.put("Business Unit", "businessUnitsLink");
		adminMenuItems.put("Company Profile", "companyProfileLink");
		adminMenuItems.put("Application Settings", "manageAppSettingsLink");
		adminMenuItems.put("IP Address Permissions", "ipAddressPermLink");
		adminMenuItems.put("Country Restrictions", "countryRestrictLink");
		adminMenuItems.put("Industry Commodity Group", "indCommGroupsLink");
		adminMenuItems.put("Contract Markup", "contractMarkUpLink");

		adminMenuItems.put("VIP Discounts", "mraDiscountsLink");
		adminMenuItems.put("Currency Bump", "currencyAdjustFactorLink");
		adminMenuItems.put("Value-Added Tax", "valueAddedTaxLink");
		// adminMenuItems.put("Quote Package Preferences", "quotePackagePrefLink");
		// adminMenuItems.put("Disclaimers", "quotePackagePrefLink");
		adminMenuItems.put("Terms and Conditions", "termsConditionsLink");
		adminMenuItems.put("Global Forward/Broker Fee", "globalForwarderLink");
	}

	@Then("^user clicks on adminsubmenu$")
	public void userClicksOnAdminsubmenu() throws Throwable {

		Thread.sleep(2000);
		for (String adminNavigation : adminMenuItems.keySet()) {
			this.getDriver().findElement(By.id("adminMenuLink")).click();
			Assert.assertEquals(true,
					this.getDriver().findElement(By.id(adminMenuItems.get(adminNavigation))).isDisplayed());
			Thread.sleep(2000);
			this.getDriver().findElement(By.id(adminMenuItems.get(adminNavigation))).click();
			Thread.sleep(3000);
			System.out.println("Admin navigation");
		}
	}

}
