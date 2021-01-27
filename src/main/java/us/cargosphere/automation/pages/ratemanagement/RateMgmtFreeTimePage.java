package us.cargosphere.automation.pages.ratemanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class RateMgmtFreeTimePage extends BasePage {

	private NavigationMenuBar naviMenuBar;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Carrier')]")
	private WebElement carrier_text;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Contract')]")
	private WebElement contract_text;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Date Range')]")
	private WebElement daterange_text;

	@FindBy(how = How.XPATH, using = "//button[@id='addFreeTimebtn']")
	private WebElement freetime_button;

	@FindBy(how = How.XPATH, using = "//input[@id='dateRange']")
	private WebElement daterange;

	@FindBy(how = How.XPATH, using = "//input[@id='modalDateRangeStart']")
	private WebElement startdatefield;

	@FindBy(how = How.XPATH, using = "//input[@id='modalDateRangeEnd']")
	private WebElement enddatefield;

	@FindBy(how = How.CSS, using = "#modalDateRangeOpenStartLabel > span.checkmark-check")
	private WebElement startcheckbox;

	@FindBy(how = How.CSS, using = "#modalDateRangeOpenEndLabel > span.checkmark-check")
	private WebElement endcheckbox;

	@FindBy(how = How.CSS, using = "#dateRangeModal > div > div > div.modal-footer > button.btn.btn-primary")
	private WebElement applyButton;

	@FindBy(how = How.CLASS_NAME, using = "toast-title")
	private WebElement toastTitle;

	@FindBy(how = How.CLASS_NAME, using = "toast-message")
	private WebElement toastMessage;

	@FindBy(how = How.CSS, using = "#dateRangeModal > div > div > div.modal-footer > button:nth-child(2)")
	private WebElement cancelButton;

	@FindBy(how = How.CSS, using = "#dateRangeModal > div > div")
	private WebElement datePopupWindow;

	public RateMgmtFreeTimePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);

	}

	public void click_apply() {

		applyButton.click();
	}

	public void click_cancel() {

		cancelButton.click();
	}

	public String get_toastTitle() {
		return toastTitle.getText();

	}

	public String get_toastMessage() {
		return toastMessage.getText();

	}

	public String carrier_text_assert() {
		return carrier_text.getText();
	}

	public String daterange_text_assert() {
		return daterange_text.getText();
	}

	public String freetimebutton_text_assert() {
		return freetime_button.getText();
	}

	public String contract_text_assert() {
		return contract_text.getText();
	}

	public void click_daterange() {

		daterange.click();
	}

	public WebElement start_datefield() {
		return startdatefield;
	}

	public void clear_start_datefield() {
		startdatefield.click();
		startdatefield.clear();

	}

	public WebElement end_datefield() {
		return enddatefield;
	}

	public WebElement startcheckbox() {
		return startcheckbox;
	}

	public void uncheck_startcheckbox() {
		startcheckbox.click();
	}

	public void uncheck_endcheckbox() {
		endcheckbox.click();
	}

	public WebElement endcheckbox() {
		return endcheckbox;
	}

	public boolean open_start_checkbox() {

		if (!startcheckbox.isSelected())
			startcheckbox.click();
		String text = this.getWebDriver().findElement(By.xpath("//input[@id='modalDateRangeStart']"))
				.getAttribute("value");
		if ((text).equals("Open")) {
			return true;
		}
		return false;

	}

	public boolean open_end_checkbox() {

		if (!endcheckbox.isSelected())
			endcheckbox.click();
		String text = this.getWebDriver().findElement(By.xpath("//input[@id='modalDateRangeEnd']"))
				.getAttribute("value");
		if ((text).equals("Open")) {
			return true;
		}
		return false;

	}

	public boolean datePopup_window() {

		if (!datePopupWindow.isDisplayed()) {

			return true;
		}
		return false;

	}

	public void enter_start_Date(String effdate) {

		startdatefield.click();
		startdatefield.clear();
		startdatefield.sendKeys(effdate);
		startdatefield.sendKeys(Keys.ENTER);
		return;
	}

	public void enter_end_Date(String effdate) {

		enddatefield.click();
		enddatefield.clear();
		enddatefield.sendKeys(effdate);
		enddatefield.sendKeys(Keys.ENTER);
		return;
	}

}
