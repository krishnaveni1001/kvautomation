package us.cargosphere.automation.pages.admin.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import us.cargosphere.automation.pages.BasePage;

import java.util.List;

public class UserInfoRow extends BasePage {

	private final String name;
	private final String loginId;
	private final String email;
	private final String userType;
	private final String country;
	private final String businessUnit;
	private final String status;

	private final boolean rateSearchPerm;
	private final boolean rateManagementPerm;
	private final boolean fmcPerm;
	private final boolean quotingPerm;
	private final boolean reportsPerm;
	private final boolean accountAdminPerm;
	private final boolean systemAdminPerm;

	public UserInfoRow(WebDriver webDriver, int rowNumber) {
		super(webDriver);
		List<WebElement> rowCells = webDriver.findElements(By.cssSelector(
				"#borderLayout_eGridPanel > div.ag-bl-center.ag-bl-full-height-center > div > div.ag-body.ag-row-no-animation > div.ag-body-viewport-wrapper > div > div > div:nth-child("
						+ (rowNumber + 1) + ") > div.ag-cell"));

		// Cell 0 contains checkbox
		this.name = rowCells.get(1).getAttribute("innerText");
		this.loginId = rowCells.get(2).getAttribute("innerText");
		this.email = rowCells.get(3).getAttribute("innerText");
		this.userType = rowCells.get(4).getAttribute("innerText");

		// Set permissions based on if the cells have the child elements that contain a
		// checkmark
		this.rateSearchPerm = rowCells.get(5).findElements(By.xpath(".//*")).size() > 0;
		this.rateManagementPerm = rowCells.get(6).findElements(By.xpath(".//*")).size() > 0;
		this.fmcPerm = rowCells.get(7).findElements(By.xpath(".//*")).size() > 0;
		this.quotingPerm = rowCells.get(8).findElements(By.xpath(".//*")).size() > 0;
		this.reportsPerm = rowCells.get(9).findElements(By.xpath(".//*")).size() > 0;

		this.accountAdminPerm = rowCells.get(10).findElements(By.xpath(".//*")).size() > 0;
		this.systemAdminPerm = rowCells.get(11).findElements(By.xpath(".//*")).size() > 0;

		this.country = rowCells.get(13).getAttribute("innerText");
		this.businessUnit = rowCells.get(14).getAttribute("innerText");
		this.status = rowCells.get(16).getAttribute("innerText");

	}

	public String getName() {
		return name;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getEmail() {
		return email;
	}

	public String getUserType() {
		return userType;
	}

	public String getCountry() {
		return country;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public String getStatus() {
		return status;
	}

	public boolean getRateSearchPerm() {
		return rateSearchPerm;
	}

	public boolean getRateManagementPerm() {
		return rateManagementPerm;
	}

	public boolean getFmcPerm() {
		return fmcPerm;
	}

	public boolean getQuotingPerm() {
		return quotingPerm;
	}

	public boolean getReportsPerm() {
		return reportsPerm;
	}

	public boolean getAccountAdminPerm() {
		return accountAdminPerm;
	}

	public boolean getSystemAdminPerm() {
		return systemAdminPerm;
	}

}
