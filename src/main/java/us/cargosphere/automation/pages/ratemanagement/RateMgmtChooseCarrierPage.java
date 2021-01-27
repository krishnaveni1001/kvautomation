package us.cargosphere.automation.pages.ratemanagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

/**
 * A PageObject representing the choose Carrier page that is located at
 * "/ptrade/jsp/CarrierSelect.jsp"
 */
public class RateMgmtChooseCarrierPage extends BasePage {

	private NavigationMenuBar naviMenuBar;

	private RateMgmtFreeTimePage freetimepage;

	public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}

	public RateMgmtFreeTimePage getFreeTime() {
		return freetimepage;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='carrierSearchInput']")
	private WebElement selectcarrier_txtfield;

	@FindBy(how = How.XPATH, using = "//body/div[@id='companyApp']/div[@id='companySelectApp']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/input[1]")
	private WebElement select_carrier;

	@FindBy(how = How.CSS, using = "#cardDropdown > a:nth-child(1)")
	private WebElement freetime_link_forcarrier;

	public RateMgmtChooseCarrierPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		// Check that we are on the correct page.
		if (!webDriver.getCurrentUrl().contains("ptrade/jsp/CarrierSelect.jsp")) {
			throw new IllegalStateException(
					"This is not the rateSearch start page. Currently on: " + webDriver.getCurrentUrl());
		}
		naviMenuBar = new NavigationMenuBar(webDriver);
	}

	public void selectCarrier(String carrier_text) {
		selectcarrier_txtfield.sendKeys(carrier_text);
		selectcarrier_txtfield.sendKeys(Keys.RETURN);
	}

	public void click_freetimelink_Carrier() throws InterruptedException {

		Thread.sleep(2000);
		freetime_link_forcarrier.click();

	}

}
