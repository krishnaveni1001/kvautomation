package us.cargosphere.automation.pages.admin.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

public class UserManagementAdminPage extends BasePage {

	@FindBy(how = How.ID, using = "addUserButton")
	private WebElement addUserPopupButton;

	@FindBy(how = How.CSS, using = "#borderLayout_eGridPanel > div.ag-bl-center.ag-bl-full-height-center > div > div.ag-body.ag-row-no-animation > div.ag-body-viewport-wrapper > div > div > div.ag-row.ag-row-even.ag-row-level-0.ag-row-focus > div:nth-child(2)")
	WebElement secondRowClick;

	public UserManagementAdminPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public void clickAddUserButton() {
		addUserPopupButton = webDriver.findElement(By.id("addUserButton"));
		addUserPopupButton.click();
	}

	public AddUserPopup getAddUserPopup() {

		return new AddUserPopup(webDriver, webDriver.findElement(By.cssSelector("#addUserDialog")));

	}

	public AddUserPopup AddUserPopup() {
		return new AddUserPopup(webDriver, webDriver.findElement(By.cssSelector("body > modal-container > div")));

	}

	public UserInfoRow getRow(int rowNum) {
		return new UserInfoRow(webDriver, rowNum);
	}

	public void clickRow(String user) {
		Actions actions = new Actions(webDriver);

		if (user.equals("Owner")) {
			secondRowClick = webDriver.findElement(By.cssSelector(
					"div.container ag-grid-angular.ag-theme-material.ag-grid:nth-child(2) div.ag-bl.ag-bl-normal.ag-layout-normal.ag-scrolls.ag-ltr div.ag-bl-center-row.ag-bl-normal-center-row:nth-child(2) div.ag-bl-center.ag-bl-normal-center div.ag-bl.ag-bl-full-height div.ag-bl-center.ag-bl-full-height-center div.ag-root.ag-font-style.ag-hacked-scroll div.ag-body.ag-row-no-animation div.ag-body-viewport-wrapper div.ag-body-viewport div.ag-body-container div.ag-row.ag-row-no-focus.ag-row-odd.ag-row-level-0:nth-child(2) > div.ag-cell.ag-cell-not-inline-editing.ag-cell-with-height.ag-cell-no-focus.ag-cell-value:nth-child(5)"));
			actions.doubleClick(secondRowClick).perform();
		} else if (user.equals("Super User")) {
			secondRowClick = webDriver.findElement(By.cssSelector(
					"div.container ag-grid-angular.ag-theme-material.ag-grid:nth-child(2) div.ag-bl.ag-bl-normal.ag-layout-normal.ag-scrolls.ag-ltr div.ag-bl-center-row.ag-bl-normal-center-row:nth-child(2) div.ag-bl-center.ag-bl-normal-center div.ag-bl.ag-bl-full-height div.ag-bl-center.ag-bl-full-height-center div.ag-root.ag-font-style.ag-hacked-scroll div.ag-body.ag-row-no-animation div.ag-body-viewport-wrapper div.ag-body-viewport div.ag-body-container div.ag-row.ag-row-no-focus.ag-row-even.ag-row-level-0:nth-child(1) > div.ag-cell.ag-cell-not-inline-editing.ag-cell-with-height.ag-cell-no-focus.ag-cell-value:nth-child(5)"));
			actions.doubleClick(secondRowClick).perform();
		} else if (user.equals("Standard")) {
			secondRowClick = webDriver.findElement(By.cssSelector(
					"div.container ag-grid-angular.ag-theme-material.ag-grid:nth-child(2) div.ag-bl.ag-bl-normal.ag-layout-normal.ag-scrolls.ag-ltr div.ag-bl-center-row.ag-bl-normal-center-row:nth-child(2) div.ag-bl-center.ag-bl-normal-center div.ag-bl.ag-bl-full-height div.ag-bl-center.ag-bl-full-height-center div.ag-root.ag-font-style.ag-hacked-scroll div.ag-body.ag-row-no-animation div.ag-body-viewport-wrapper div.ag-body-viewport div.ag-body-container div.ag-row.ag-row-no-focus.ag-row-even.ag-row-level-0:nth-child(1) > div.ag-cell.ag-cell-not-inline-editing.ag-cell-with-height.ag-cell-no-focus.ag-cell-value:nth-child(5)"));
			actions.doubleClick(secondRowClick).perform();
		} else if (user.equals("Rate Manager")) {
			secondRowClick = webDriver.findElement(By.cssSelector(
					"div.container ag-grid-angular.ag-theme-material.ag-grid:nth-child(2) div.ag-bl.ag-bl-normal.ag-layout-normal.ag-scrolls.ag-ltr div.ag-bl-center-row.ag-bl-normal-center-row:nth-child(2) div.ag-bl-center.ag-bl-normal-center div.ag-bl.ag-bl-full-height div.ag-bl-center.ag-bl-full-height-center div.ag-root.ag-font-style.ag-hacked-scroll div.ag-body.ag-row-no-animation div.ag-body-viewport-wrapper div.ag-body-viewport div.ag-body-container div.ag-row.ag-row-no-focus.ag-row-even.ag-row-level-0:nth-child(1) > div.ag-cell.ag-cell-not-inline-editing.ag-cell-with-height.ag-cell-no-focus.ag-cell-value:nth-child(5)"));
			actions.doubleClick(secondRowClick).perform();

		}
	}
}