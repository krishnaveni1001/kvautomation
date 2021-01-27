package us.cargosphere.automation.pages.admin.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class AddUserPopup extends BasePage {

	@FindBy(how = How.ID, using = "form_name")
	private WebElement nameInput;
	@FindBy(how = How.ID, using = "form_userId")
	private WebElement userIdInput;
	@FindBy(how = How.CSS, using = "#userTypeField > div > ng-multiselect-dropdown > div > div:nth-child(1) > span")
	private WebElement userTypeInput;
	@FindBy(how = How.ID, using = "form_email")
	private WebElement emailInput;
	@FindBy(how = How.CSS, using = "#countryField > div > ng-multiselect-dropdown > div > div:nth-child(1) > span")
	private WebElement countryInput;
	@FindBy(how = How.CSS, using = "#buField > div > ng-multiselect-dropdown > div > div:nth-child(1) > span")
	private WebElement businessUnitInput;
	@FindBy(how = How.CSS, using = "#addUserDetailsContent > div > div.col-md-8 > div:nth-child(4) > div:nth-child(2) > div > div > label:nth-child(1) > input")
	private WebElement activeUserStatusRadio;
	@FindBy(how = How.CSS, using = "#addUserDetailsContent > div > div.col-md-8 > div:nth-child(4) > div:nth-child(2) > div > div > label:nth-child(2) > input")
	private WebElement inactiveUserStatusRadio;
	@FindBy(how = How.ID, using = "rateSearchPermission")
	private WebElement rateSearchCheckBox;
	@FindBy(how = How.ID, using = "rateMgmtPermission")
	private WebElement rateManagementCheckBox;
	@FindBy(how = How.ID, using = "quotingPermission")
	private WebElement quotingCheckBox;
	@FindBy(how = How.ID, using = "fmcPermission")
	private WebElement fmcCheckBox;
	@FindBy(how = How.ID, using = "reportsPermission")
	private WebElement reportsCheckBox;
	@FindBy(how = How.CSS, using = "accountAdminPermission")
	private WebElement accountAdminCheckBox;
	@FindBy(how = How.CSS, using = "#addUserDetailsContent > div > div.col-md-4 > div > div > div > div:nth-child(8) > span:nth-child(1)")
	private WebElement checkAllButton;
	@FindBy(how = How.CSS, using = "#addUserDetailsContent > div > div.col-md-4 > div > div > div > div:nth-child(8) > span:nth-child(2)")
	private WebElement clearAllButton;
	@FindBy(how = How.ID, using = "welcomeEmailCheck")
	private WebElement welcomeEmailCheckBox;
	@FindBy(how = How.ID, using = "register")
	private WebElement saveUserButton;

	@FindBy(how = How.CSS, using = "#addUserDialog > div > div > div > div.col-md-3 > ul > li.active > a")
	private WebElement userDetailsTab;
	 @FindBy(how = How.ID, using = "rateSearch_tab")
	 private WebElement rateSearchPermissionsTab;
	 @FindBy(how = How.ID, using = "rateMgmt_tab")
	private WebElement rateMgmtPermissionsTab;
	@FindBy(how = How.CSS, using = "#quoting_tab > a")
	private WebElement quotePermissionTab;

	public AddUserPopup(WebDriver webDriver, WebElement el) {
		super(webDriver, el);
	}

	public void typeIntoNameInput(String text) {
		nameInput.click();
		nameInput.sendKeys(text);
	}

	public void typeIntoUserIdInput(String text) {
		userIdInput.click();
		userIdInput.sendKeys(text);
	}

	public void selectUserType(String userType) {
		WebElement userTypeDropDown = webDriver.findElement(
				By.cssSelector("#userTypeField > div > ng-multiselect-dropdown > div > div.dropdown-list"));
		if (!userTypeDropDown.isDisplayed()) {
			userTypeInput.click();
		}
		WebElement userTypeTextInput = webDriver.findElement(By.cssSelector(
				"#userTypeField > div > ng-multiselect-dropdown > div > div.dropdown-list > ul.item1 > li > input"));
		userTypeTextInput.click();
		userTypeTextInput.sendKeys(userType);
		webDriver.findElement(By.cssSelector(
				"#userTypeField > div > ng-multiselect-dropdown > div > div.dropdown-list > ul.item2 > li:nth-child(1)"))
				.click();
	}

	public void typeIntoEmailInput(String text) {
		emailInput.click();
		emailInput.sendKeys(text);
	}

	public void selectCountry(String country) {
		WebElement countryDropDown = webDriver
				.findElement(By.cssSelector("#countryField > div > ng-multiselect-dropdown > div > div.dropdown-list"));
		if (!countryDropDown.isDisplayed()) {
			countryInput.click();
		}
		WebElement countryTextInput = webDriver.findElement(By.cssSelector(
				"#countryField > div > ng-multiselect-dropdown > div > div.dropdown-list > ul.item1 > li > input"));
		countryTextInput.click();
		countryTextInput.sendKeys(country);
		webDriver
				.findElement(By.cssSelector(
						"#countryField > div > ng-multiselect-dropdown > div > div.dropdown-list > ul.item2 > li"))
				.click();
	}

	public void selectBusinessUnit(String businessUnit) {
		WebElement countryDropDown = webDriver
				.findElement(By.cssSelector("#buField > div > ng-multiselect-dropdown > div > div.dropdown-list"));
		if (!countryDropDown.isDisplayed()) {
			businessUnitInput.click();
		}
		WebElement countryTextInput = webDriver.findElement(By.cssSelector(
				"#buField > div > ng-multiselect-dropdown > div > div.dropdown-list > ul.item1 > li > input"));
		countryTextInput.click();
		countryTextInput.sendKeys(businessUnit);
		webDriver.findElement(By.cssSelector(
				"#buField > div > ng-multiselect-dropdown > div > div.dropdown-list > ul.item2 > li:nth-child(1)"))
				.click();
	}

	public void clickActiveStatusRadio() {
		activeUserStatusRadio.click();
	}

	public void clickInactiveStatusRadio() {
		inactiveUserStatusRadio.click();
	}

	public void toggleRateSearchPermission() {
		rateSearchCheckBox.click();
	}

	public WebElement RateSearchPermission() {
		return rateSearchCheckBox;
	}

	public void toggleRateManagementPermission() {
		rateManagementCheckBox.click();
	}

	public void toggleQuotingPermission() {
		quotingCheckBox.click();
	}

	public void toggleFmcPermission() {
		fmcCheckBox.click();
	}

	public void toggleReportsPermission() {
		reportsCheckBox.click();
	}

	public void toggleAccountAdminPermission() {
		accountAdminCheckBox.click();
	}

	public void rateSearchTab() {
		rateSearchPermissionsTab.click();
	}

	public void toggleSystemAdminPermission() {
		WebElement sysAdminPermToggle = webDriver.findElement(By.id("systemAdminPermission"));
		if (!sysAdminPermToggle.isDisplayed()) {
			throw new IllegalStateException(
					"System Admin permission toggle not visible, the proper user type may not be selected.");
		}
		sysAdminPermToggle.click();
	}

	public void toggleRateMeshPermission() {
		WebElement rateMeshPermToggle = webDriver.findElement(By.id("rateMeshPermission"));
		if (!rateMeshPermToggle.isDisplayed()) {
			throw new IllegalStateException(
					"Rate Mesh permission toggle not visible, the proper user type may not be selected.");
		}
		rateMeshPermToggle.click();
	}

	public void clickCheckAllButton() {
		checkAllButton.click();
	}

	public void clickClearAllButton() {
		clearAllButton.click();
	}

	public void toggleSendWelcomeEmail() {
		welcomeEmailCheckBox.click();
	}

	public void clickSaveUserButton() {
		saveUserButton.click();
	}

	public void clickUserDetailsTab() {
		userDetailsTab.click();
	}

	public boolean isRateManagementEnabled() {
		return rateManagementCheckBox.isEnabled();
	}

	public RateManagementPermissionTab getRateManagementPermissionTab() {
		if (!rateMgmtPermissionsTab.isDisplayed()) {
			toggleRateManagementPermission();
		}
		rateMgmtPermissionsTab.click();
		return new RateManagementPermissionTab(webDriver);
	}

	public void clickRateMgmtPermissionTab() {
		rateMgmtPermissionsTab.click();
	}

	public RateSearchPermissionTab getRateSearchPermissionTab() {
		if (!rateSearchPermissionsTab.isDisplayed()) {
			toggleRateSearchPermission();
		}
		clickRateSearchPermissionsTab();
		return new RateSearchPermissionTab(webDriver);
	}

	public void clickRateSearchPermissionsTab() {
		rateSearchPermissionsTab.click();
	}

	public QuotePermissionTab getQuotePermissionTab() {
		if (!quotePermissionTab.isDisplayed()) {
			toggleQuotingPermission();
		}
		clickQuotePermissionTab();
		return new QuotePermissionTab(webDriver);
	}

	public QuotePermissionTab clickQuotePermissionTab() {
		quotePermissionTab.click();
		return new QuotePermissionTab(webDriver);
	}

}
