package us.cargosphere.automation.pages.quoting;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class NewQuotePage extends BasePage {
//	private NavigationMenuBar naviMenuBar;

//    public NavigationMenuBar getNaviMenuBar() {
//		return naviMenuBar;
//	}

	@FindBy(how = How.ID, using = "cityOrig")
	private WebElement cityOrigin;

	@FindBy(how = How.ID, using = "cityDest")
	private WebElement cityDestination;

	@FindBy(how = How.ID, using = "startDate")
	private WebElement startDate;

	@FindBy(how = How.ID, using = "endDate")
	private WebElement endDate;

	@FindBy(how = How.ID, using = "commodity")
	private WebElement Commodity;

	@FindBy(how = How.ID, using = "lclContainerTypeId")
	private WebElement FCL_Unit_type;

	@FindBy(how = How.ID, using = "basePrice0")
	private WebElement buyRate;

	@FindBy(how = How.ID, using = "searchStr")
	private WebElement agentName;

	@FindBy(how = How.XPATH, using = "//td//td[2]//span[1]//input[1]")
	private WebElement agentClick;

	@FindBy(how = How.ID, using = "createQuote")
	private WebElement createQuote;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add new customer')]")
	private WebElement createAgentLink;

	@FindBy(how = How.XPATH, using = "//ul[@id = 'ui-id-1']")
	private WebElement dropDownCommodity;

	@FindBy(how = How.ID, using = "companyName")
	private WebElement companyName;

	@FindBy(how = How.NAME, using = "userName")
	private WebElement contactName;

	@FindBy(how = How.XPATH, using = "//body//span[1]")
	private WebElement agentButton;

	@FindBy(how = How.XPATH, using = "//input[@id='submitButton']")
	private WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//a[@class='navLink']")
	private WebElement closeWindow;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'by Contact Person')]")
	private WebElement byContactPerson;

	@FindBy(how = How.XPATH, using = "//input[@id='custExtRefNo']")
	private WebElement ref;

	@FindBy(how = How.XPATH, using = "//div[@id='popup']//ul")
	private WebElement dropDownAgent;

	public NewQuotePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		// Check that we are on the correct page.
		if (!webDriver.getCurrentUrl().contains("ptrade/jsp/QuoteCreateMultiCntr.jsp")) {
			throw new IllegalStateException(
					"This is not new customer quote page. Currently on: " + webDriver.getCurrentUrl());
		}
		// naviMenuBar = new NavigationMenuBar(webDriver);
	}

	public void origin(String origin) throws InterruptedException {

		cityOrigin.click();
		cityOrigin.sendKeys(origin);
		Thread.sleep(2000);
		cityOrigin.sendKeys(Keys.ENTER);
		return;
	}

	public void destination(String destination) throws InterruptedException {

		cityDestination.click();
		cityDestination.sendKeys(destination);
		Thread.sleep(2000);
		cityDestination.sendKeys(Keys.ENTER);
		return;
	}

	public void start_Date(String effdate) {

		startDate.click();
		startDate.clear();
		startDate.sendKeys(effdate);
		startDate.sendKeys(Keys.ENTER);
		return;
	}

	public void end_Date(String expdate) {

		endDate.click();
		endDate.clear();
		endDate.sendKeys(expdate);
		endDate.sendKeys(Keys.ENTER);
		return;
	}

	public void send_commodity(String commodity) throws InterruptedException {
		Commodity.click();
		Commodity.sendKeys(commodity);
		Thread.sleep(3000);
		WebElement ul_element = dropDownCommodity;
		List<WebElement> li_All = ul_element.findElements(By.tagName("li"));
		System.out.println(li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(500);
			System.out.println(li_All.get(i).getText());
			String divVal = li_All.get(i).getText();

			if (commodity.equals(divVal)) {
				ul_element.click();
			}

		}

		return;
	}

	public void container_select(List<String> cntrList) {
		Select cntr_dropdown = new Select(FCL_Unit_type);

		for (int i = 0; i < cntrList.size(); i++) {
			System.out.println("Adding Container Type " + cntrList.get(i));
			cntr_dropdown.selectByVisibleText(cntrList.get(i));
		}

	}

	public void enter_buy_rate(String buy_rate) {
		buyRate.sendKeys(buy_rate);
		return;
	}

	public void send_agent(String agent) throws InterruptedException {
		agentName.click();
		agentName.sendKeys(agent);
		Thread.sleep(2000);
		agentName.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		/*
		 * WebElement ul_agent = dropDownAgent; List<WebElement> li_All_agent =
		 * ul_agent.findElements(By.tagName("li"));
		 * System.out.println(li_All_agent.size()); for (int i = 0; i <
		 * li_All_agent.size(); i++) { Thread.sleep(500);
		 * System.out.println(li_All_agent.get(i).getText()); String divVal =
		 * li_All_agent.get(i).getText();
		 * 
		 * if (agent.equals(divVal)) { ul_agent.click(); }
		 * 
		 * } // agentName.sendKeys(Keys.ENTER); // return; //ref.click();
		 */
	}

	public void select_agent() {
		agentClick.click();
		ref.click();

	}

	public void create_quote() {
		createQuote.click();
		return;
	}

	public void created_quote_landing_page() {
		webDriver.getCurrentUrl().contains("ptrade/jsp/QuoteCreateMultiCntr.jsp");
	}

	public void click_agent_link() {
		createAgentLink.click();
	}

	public void add_agent(String agent) throws InterruptedException {
		createAgentLink.click();
		String parentWindow = webDriver.getWindowHandle();
		Set<String> handles = webDriver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				webDriver.switchTo().window(windowHandle);
				companyName.sendKeys(agent);
				contactName.click();
				contactName.sendKeys(agent);
				agentButton.click();
				submitButton.click();
				closeWindow.click();
				// webDriver.close();
				webDriver.switchTo().window(parentWindow);
			}
		}
	}

	public void select_agent_assignment(String assignment) {
		if (assignment.equals("by contact person"))
			byContactPerson.click();
		ref.click();
	}
}
