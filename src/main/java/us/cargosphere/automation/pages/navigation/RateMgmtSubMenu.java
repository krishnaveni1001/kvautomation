package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.admin.usermanagement.AddUserPopup;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtLevel3ScopePage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtLevel3SurchargePage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtAuditPage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtChooseCarrierPage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtLevel2Page;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtLevel3SudsPage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtSUDSPage;

public class RateMgmtSubMenu extends BasePage {

	@FindBy(how = How.ID, using = "sudsLink")
	private WebElement sudsLink;

	@FindBy(how = How.ID, using = "consolePageLink")
	private WebElement consolePageLink;

	@FindBy(how = How.ID, using = "level2SurLink")
	private WebElement level2SurLink;

	@FindBy(how = How.ID, using = "auditLink")
	private WebElement auditLink;

	@FindBy(how = How.ID, using = "level3SudsLink")
	private WebElement level3SudsLink;

	@FindBy(how = How.ID, using = "level3ScopeLink")
	private WebElement level3ScopeLink;

	@FindBy(how = How.ID, using = "level3SurLink")
	private WebElement level3SurLink;

	@FindBy(how = How.ID, using = "chooseCarrierLink")
	private WebElement chooseCarrierLink;

	@FindBy(how = How.XPATH, using = "//a[@id='freeTimeLink']")
	private WebElement freeTimeLink;

	public RateMgmtSubMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public RateMgmtSubMenu(WebDriver webDriver, WebElement el) {
		super(webDriver, el);
	}

	public RateMgmtChooseCarrierPage clickChooseCarrierLink() {
		chooseCarrierLink.click();
		return new RateMgmtChooseCarrierPage(webDriver);
	}

	public RateMgmtSubMenu getsubMenuWindow() {
		return new RateMgmtSubMenu(webDriver, webDriver.findElement(By.cssSelector("#rateMgmtMenu > ul")));

	}

	public RateMgmtChooseCarrierPage clickfreeTimeLink() {
		freeTimeLink.click();
		return new RateMgmtChooseCarrierPage(webDriver);
	}

	public Object clickSudsLink() {
		sudsLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtSUDSPage(webDriver);
		}
	}

	private boolean checkIfCarrierSelect() {
		return true;
	}

	public Object clickConsolePageLink() {
		consolePageLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtSUDSPage(webDriver);
		}
	}

	public Object clickLevel2SurLink() {
		level2SurLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtLevel2Page(webDriver);
		}
	}

	public Object clickAuditLink() {
		auditLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtAuditPage(webDriver);
		}
	}

	public Object clickLevel3SudsLink() {
		level3SudsLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtLevel3SudsPage(webDriver);
		}
	}

	public Object clickLevel3ScopeLink() {
		level3ScopeLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtLevel3ScopePage(webDriver);
		}
	}

	public Object clickLevel3SurLink() {
		level3SurLink.click();
		if (checkIfCarrierSelect()) {
			return new RateMgmtChooseCarrierPage(webDriver);
		} else {
			return new RateMgmtLevel3SurchargePage(webDriver);
		}
	}

	

}
