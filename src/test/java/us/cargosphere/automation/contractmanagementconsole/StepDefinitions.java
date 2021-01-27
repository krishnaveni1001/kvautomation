package us.cargosphere.automation.contractmanagementconsole;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;

public class StepDefinitions extends BaseStepDefinitions {
	WebDriverWait wait = new WebDriverWait(this.getDriver(), 10);

	@Given("^that scac is active for \"([^\"]*)\"$")
	public void that_scac_is_active_for(String arg1) throws Throwable {
		// do nothing
	}

	@Given("^that scac is active for \"([^\"]*)\" and contract \"([^\"]*)\" exists$")
	public void that_scac_is_active_for(String arg1, String arg2) throws Throwable {
		// do nothing
	}

	/* This will clear cache */
	@Given("^user clears cache for Chrome Browser$")
	public void clearCache() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://WebDrivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("start-maximized");
		this.getDriver().get("chrome://settings/clearBrowserData");
		Thread.sleep(3000);
		this.getDriver().switchTo().activeElement();
		this.getDriver().findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@Given("^that user enters console in SCAC \"([^\"]*)\" with carrierID \"([^\"]*)\"$")
	public void that_user_enters_SCAC(String scac, String carrierId) throws Throwable {
		try {
			// Go to Rate Management Page ,choose the scac and navigate to console.
			this.getDriver().manage().window().maximize();
			this.getDriver().findElements(By.id("logoMenuLink")).get(0).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("RATE MANAGEMENT")));
			this.getDriver().findElements(By.linkText("RATE MANAGEMENT")).get(0).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"carrierInput\"]/input")));
			this.getDriver().findElement(By.xpath("//*[@id=\"carrierInput\"]/input")).click();
			this.getDriver().findElement(By.xpath("//*[@id=\"carrierInput\"]/input")).clear();
			this.getDriver().findElement(By.xpath("//*[@id=\"carrierInput\"]/input")).sendKeys(scac);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='button'][@value='...']")));
			// Navigate to Console
			this.getDriver().findElement(By.xpath("//input[@type='button'][@value='...']")).click();
			this.getDriver().findElement(By.id("consolePage")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("consoleViewRates")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("openContractFilter")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding Contract Name to a new FCL Contract. Does not choose existing contract
	// name.
	@Then("^user adds an Ocean contract name \"([^\"]*)\"$")
	public void user_adds_contract_name(String contractname) throws Throwable {
		this.getDriver().findElement(By.id("toAddRates")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("divselBidGroupIds")));
		Select contracts = new Select(this.getDriver().findElement(By.id("selBidGroupIds")));
		contracts.selectByIndex(0);
		this.getDriver().findElement(By.id("contractSelect")).click();
		this.getDriver().findElement(By.id("newContract")).click();
		this.getDriver().findElement(By.id("newContract")).clear();
		this.getDriver().findElement(By.id("newContract")).sendKeys(contractname);
		this.getDriver().findElement(By.xpath("//input[@type='button'][@value='ADD CONTRACT']")).click();
		System.out.println("Adding contract " + contractname + " in console");
		Thread.sleep(2000);
	}

	// Adding a new Trade Lane. Does not check for existing Trade Lane.
	@Then("^user adds tradeLane \"([^\"]*)\"$")
	public void user_adds_tradeLane(String tradelane) throws Throwable {
		try {
			this.getDriver().findElement(By.id("divselTradeLaneIds")).click();
			Select tradeLane = new Select(this.getDriver().findElement(By.id("selTradeLaneIds")));
			tradeLane.selectByIndex(0);
			this.getDriver().findElements(By.xpath("//input[contains(@value, 'SELECT')]")).get(1).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("newTradeLane")));
			this.getDriver().findElement(By.id("newTradeLane")).click();
			this.getDriver().findElement(By.id("newTradeLane")).clear();
			this.getDriver().findElement(By.id("newTradeLane")).sendKeys(tradelane);
			this.getDriver().findElement(By.xpath("//input[@type='button'][@value='ADD TRADE LANE']")).click();
			System.out.println("Adding Trade Lane " + tradelane + " in console");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding a new Commodity group. Does not check for existing commodity.
	@Then("^user adds commodity \"([^\"]*)\" and commodity group name \"([^\"]*)\" and commodity ID \"([^\"]*)\"$")
	public void user_adds_commodity_group(String commodity, String commodityGroupName, String commIdValue)
			throws Throwable {
		try {

			this.getDriver().findElement(By.id("divselCommodityGrpIds")).click();
			Select commoditygroup = new Select(this.getDriver().findElement(By.id("selCommodityGrpIds")));
			commoditygroup.selectByIndex(0);
			this.getDriver().findElement(By.id("commGroupSelect")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("commodity")));
			this.getDriver().findElement(By.id("commodity")).click();
			this.getDriver().findElement(By.id("commodity")).clear();
			this.getDriver().findElement(By.id("commodity")).sendKeys(commodity);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"commodity-popup\"]/ul/li[1]")));
			WebElement actualCommodity = this.getDriver()
					.findElement(By.xpath("//*[@id=\"commodity-popup\"]/ul/li[1]"));
			JavascriptExecutor executor = (JavascriptExecutor) this.getDriver();
			executor.executeScript("arguments[0].click();", actualCommodity);
			this.getDriver().findElement(By.id("trNewCommGroup")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("newCommGroupName")));
			this.getDriver().findElement(By.id("newCommGroupName")).click();
			this.getDriver().findElement(By.id("addCommGrp")).click();
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				System.out.println("Clicking on Alert pop up to continue");
				this.getDriver().switchTo().alert().accept();
			}
			System.out.println("Adding Commodity " + commodity + " in console");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding effective and Expiration Date.
	@Then("^user adds dates from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void user_sets_Valid_from_to(String effDate, String expDate) throws Throwable {
		try {
			System.out.println("Adding Effective and Expiration dates.");
			// Adding Effective Date
			wait.until(ExpectedConditions.elementToBeClickable(By.id("selEffectiveDates")));
			this.getDriver().findElement(By.id("selEffectiveDates")).click();
			this.getDriver().findElement(By.id("effDateSelect")).click();
			this.getDriver().findElement(By.id("newEffDate")).click();
			this.getDriver().findElement(By.id("newEffDate")).sendKeys(effDate);
			this.getDriver().findElement(By.id("addEffDate")).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"theDatePicker\"]/table/tbody/tr[3]/td[6]")));
			this.getDriver().switchTo().defaultContent();
			this.getDriver().findElement(By.xpath("//*[@id=\"theDatePicker\"]/table/tbody/tr[3]/td[6]")).click();
			// Adding Expiration Date
			this.getDriver().findElement(By.id("selExpirationDates")).click();
			this.getDriver().findElement(By.id("expDateSelect")).click();
			this.getDriver().findElement(By.id("newExpDate")).click();
			this.getDriver().findElement(By.id("newExpDate")).sendKeys(expDate);
			this.getDriver().findElement(By.id("addExpDate")).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"theDatePicker\"]/table/tbody/tr[3]/td[6]")));
			this.getDriver().findElement(By.xpath("//*[@id=\"theDatePicker\"]/table/tbody/tr[3]/td[6]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding Container types
	@Then("^user adds Container types$")
	public void user_adds_Container_types(DataTable cntrtype) throws Throwable {
		try {
			Select containertype = new Select(this.getDriver().findElement(By.id("selUnitTypeIds")));
			List<String> cntrList = cntrtype.asList(String.class);
			for (int i = 0; i < cntrList.size(); i++) {
				System.out.println("Adding Container Type " + cntrList.get(i));
				containertype.selectByVisibleText(cntrList.get(i));
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.id("contTypeSelect")));
			this.getDriver().findElement(By.id("contTypeSelect")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding Rates in Console using the Input format option 'Through Rates'
	@Then("^user adds rates as 'Through rates'$")
	public void user_adds_rates_throughRates() throws Throwable {
		try {
			this.getDriver().findElement(By.id("inputFormat")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("inputFormatMenu")));
			this.getDriver().findElement(By.id("throughRates")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("DropContainerOrig_0")));
			System.out.println("Adding rates as 'Through rates' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding origin and Destination Locations from Datatable
	@Then("^user adds Locations to add rates$")
	public void user_adds_Locations(DataTable userlocations) throws Throwable {
		try {
			this.getDriver().findElement(By.id("DropContainerOrig_0")).click();
			System.out.println("Clicking on Location Add text box ");
			for (Map<String, String> locList : userlocations.asMaps(String.class, String.class)) {
				this.getDriver().findElement(By.id("searchString")).click();
				System.out.println("Adding origin location " + locList.get("Origin"));
				System.out.println("Adding destination location " + locList.get("Destination"));
				this.getDriver().findElement(By.id("aMoveOrig")).click();
				this.getDriver().findElement(By.id("searchString")).sendKeys(locList.get("Origin"));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("DragContainer")));
				// Double-clicking the location in the list through Actions
				Actions actions = new Actions(this.getDriver());
				WebElement origelementLocator = this.getDriver()
						.findElement(By.xpath("//*[@id=\"DragContainer\"]/div"));
				actions.doubleClick(origelementLocator).perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("searchString")));
				this.getDriver().findElement(By.id("searchString")).click();
				this.getDriver().findElement(By.id("aMoveDest")).click();
				this.getDriver().findElement(By.id("searchString")).sendKeys(locList.get("Destination"));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("DragContainer")));
				Actions actionsdest = new Actions(this.getDriver());
				WebElement destelementLocator = this.getDriver()
						.findElement(By.xpath("//*[@id=\"DragContainer\"]/div"));
				actionsdest.doubleClick(destelementLocator).perform();
			}
			this.getDriver().findElement(By.xpath("//*[@id=\"divLocationContainer\"]/div[1]/a/img")).click();
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//*[@id=\"divLocationContainer\"]/div[1]/a/img")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding the amount for the given Cntr Types from the datatable.Every Location
	// has the same amount for each cntr type but diff cntr types can have diff
	// amounts
	@Then("^user adds amount for \"([^\"]*)\" Container Types for \"([^\"]*)\" set of locations$")
	public void user_adds_amount_for_container_Types(String noOfCntrs, String noOfLocs, DataTable containerAmounts)
			throws Throwable {
		try {
			int maxNoOfLocs = Integer.parseInt(noOfLocs);
			for (int jLocs = 0; jLocs < maxNoOfLocs; jLocs++) {
				int iCntrs = 0;
				System.out.println("Clicking on Location Add text box for Location " + (jLocs + 1));
				for (Map<String, String> cntrAmt : containerAmounts.asMaps(String.class, String.class)) {
					System.out.println("Adding amount for container " + cntrAmt.get("CntrType"));
					this.getDriver().findElement(By.id("odRate_" + iCntrs + "_" + jLocs + "")).click();
					this.getDriver().findElement(By.id("odRate_" + iCntrs + "_" + jLocs + ""))
							.sendKeys(cntrAmt.get("Amount"));
					iCntrs++;
				}
				if (jLocs > 3) {
					this.getDriver().findElement(By.partialLinkText("Add 1 Row")).click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Add the rates by clicking on Submit Button
	@Then("^user Submits rates$")
	public void user_submits_rates() throws Throwable {
		try {
			System.out.println("Submitting Rates");
			this.getDriver().findElement(By.id("submitRates")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Clicking on the Action Failed pop-up which actually confirms the action of
	// new rates added as completed.
	@Then("^user confirms creation of rates$")
	public void user_confirms_creation_of_rates() throws Throwable {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("divReturnButton")));
			this.getDriver().findElement(By.id("divReturnButton")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Return to console to check that the contract was added .
	// Search for the Ocean contract in the console and open the contract
	@Then("^user views created rates for the contract \"([^\"]*)\"$")
	public void user_views_created_rates(String contractcreated) throws Throwable {
		try {
			this.getDriver().findElement(By.id("contractViewRates")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchStrAssigned")));
			this.getDriver().findElement(By.id("searchStrAssigned")).click();
			this.getDriver().findElement(By.id("searchStrAssigned")).sendKeys(contractcreated);
			System.out.println("Opening contract " + contractcreated + " in console");
			// Selecting the first contract in list after the search is performed with the
			// contract name
			Select contractToView = new Select(this.getDriver().findElement(By.id("selContractGrpIds")));
			contractToView.selectByIndex(0);
			// Scrolling to the Select button so that it can be located to click
			WebElement invisibleselectbutton = this.getDriver().findElement(By.id("selectAContract"));
			((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					invisibleselectbutton);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("selectAContract")));
			this.getDriver().findElement(By.id("selectAContract")).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Open an Ocean contract in console
	@Then("^user selects an Ocean Contract with name \"([^\"]*)\"$")
	public void user_selects_an_Ocean_Contract_with_name(String contractTobeviewed) throws Throwable {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("divContractFilter")));
			this.getDriver().findElement(By.id("searchStrAssigned")).click();
			this.getDriver().findElement(By.id("searchStrAssigned")).sendKeys(contractTobeviewed);
			Select contractToSelect = new Select(this.getDriver().findElement(By.id("selContractGrpIds")));
			contractToSelect.selectByIndex(0);
			WebElement scrolltoContractSelectButton = this.getDriver().findElement(By.id("selectAContract"));
			((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					scrolltoContractSelectButton);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("selectAContract")));
			this.getDriver().findElement(By.id("selectAContract")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Applying Different Key value Filters in console for Ocean Contract
	@Then("^user filters on Effective Date \"([^\"]*)\" and Expiration Date \"([^\"]*)\"$")
	public void user_filters_on_Effective_Date_and_Expiration_Date(String arg1, String arg2) throws Throwable {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divContractFilter")));
			// Adding Effective Date Filter by choosing the first date in the list
			this.getDriver().findElement(By.id("openEffDateFilter")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("effDateTableType")));
			Select EffDateSelect = new Select(this.getDriver().findElement(By.id("effDateTableType")));
			EffDateSelect.selectByIndex(1);
			Select EffDateValue = new Select(this.getDriver().findElement(By.id("selEffectiveDates")));
			EffDateValue.selectByIndex(0);
			this.getDriver().findElement(By.xpath("//*[@id=\"divselEffectiveDatesButton\"]/input[1]")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divEffectiveDateFilter")));
			Thread.sleep(2000);
			// Adding Expiration Date Filter by choosing the first date in the list
			this.getDriver().findElement(By.id("openExpDateFilter")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("expDateTableType")));
			Select ExpDateSelect = new Select(this.getDriver().findElement(By.id("expDateTableType")));
			ExpDateSelect.selectByIndex(1);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("selExpirationDates")));
			Select ExpDateValue = new Select(this.getDriver().findElement(By.id("selExpirationDates")));
			ExpDateValue.selectByIndex(0);
			this.getDriver().findElement(By.xpath("//*[@id=\"divselExpirationDatesButton\"]/input[1]")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Adding origin filter.Only One origin can be selected at this time.
	@Then("^user filters on origin location by UNLOC code$")
	public void user_filters_on_origin_location(DataTable oLocation) throws Throwable {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divContractFilter")));
			// Adding origin Location Filters
			this.getDriver().findElement(By.id("openOrigLoc")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("addOFilter")));
			this.getDriver().findElement(By.id("oState")).click();
			List<String> oLocList = oLocation.asList(String.class);
			for (int i = 0; i < oLocList.size(); i++) {
				System.out.println("Adding origin location filter");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("searchOLocStrAssigned")));
				this.getDriver().findElement(By.id("searchOLocStrAssigned")).click();
				this.getDriver().findElement(By.id("searchOLocStrAssigned")).clear();
				this.getDriver().findElement(By.id("searchOLocStrAssigned")).sendKeys(oLocList.get(i));
				Select originSelect = new Select(this.getDriver().findElement(By.id("selOrigIds")));
				originSelect.selectByValue(oLocList.get(i));
			}
			this.getDriver().findElement(By.id("addOFilter")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Adding destination filter.Only One Destination can be selected at this time.
	@Then("^user filters on destination location by UNLOC code$")
	public void user_filters_on_destination_location(DataTable dLocation) throws Throwable {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divContractFilter")));
			// Adding Destination Location Filters
			this.getDriver().findElement(By.id("openDFilter")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("addDFilter")));
			this.getDriver().findElement(By.id("dUNLOC")).click();
			List<String> dLocList = dLocation.asList(String.class);
			for (int i = 0; i < dLocList.size(); i++) {
				System.out.println("Adding Destination location filter");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("searchDLocStrAssigned")));
				this.getDriver().findElement(By.id("searchDLocStrAssigned")).click();
				this.getDriver().findElement(By.id("searchDLocStrAssigned")).clear();
				this.getDriver().findElement(By.id("searchDLocStrAssigned")).sendKeys(dLocList.get(i));
				Select destSelect = new Select(this.getDriver().findElement(By.id("selDestIds")));
				destSelect.selectByValue(dLocList.get(i));
			}
			this.getDriver().findElement(By.id("addDFilter")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Adding Container Type filter.Only One Container can be selected at this time.
	@Then("^user filters on container type$")
	public void user_filters_on_containerType(DataTable CntrType) throws Throwable {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divContractFilter")));
			// Adding Destination Location Filters
			this.getDriver().findElement(By.id("getUnitTypeFilters")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("addUnitTypeFilter")));
			List<String> CntrTypeList = CntrType.asList(String.class);
			for (int i = 0; i < CntrTypeList.size(); i++) {
				System.out.println("Adding Container Type filter");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("selUnitTypeIds")));
				Select cntrTypeSelect = new Select(this.getDriver().findElement(By.id("selUnitTypeIds")));
				// cntrTypeSelect.selectByValue(dCntrTypeList.get(i));
				cntrTypeSelect.selectByVisibleText(CntrTypeList.get(i));
			}
			this.getDriver().findElement(By.id("addUnitTypeFilter")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Adding Commodity filter.Only One Commodity can be selected at this time.
	@Then("^user filters on commodity$")
	public void user_filters_on_commodity(DataTable commGroup) throws Throwable {
		try {
			// Waiting to close the contract select drop down box.
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divContractFilter")));
			// Adding commodity Filter
			this.getDriver().findElement(By.id("openCommGroupFilters")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("addCommGroupFilters")));
			List<String> commGroupList = commGroup.asList(String.class);
			for (int i = 0; i < commGroupList.size(); i++) {
				System.out.println("Adding Commodity group filter");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("selCommodityGrpIds")));
				Select commgroupSelect = new Select(this.getDriver().findElement(By.id("selCommodityGrpIds")));
				commgroupSelect.selectByVisibleText(commGroupList.get(i));
			}
			this.getDriver().findElement(By.id("addCommGroupFilters")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//Clearing Different Filters

	// Clearing container type filter
	@Then("^user clears container type filter$")
	public void user_clears_cntrType_filter() throws Throwable {
		try {

			// Clearing container type filter
			this.getDriver().findElement(By.xpath("//*[@id=\"TRselUnitTypeIds\"]/td[1]/a")).click();
			System.out.println(" User clears Container Type filter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Clearing Origin Location filter
	@Then("^user clears origin location filter$")
	public void user_clears_originLoc_filter() throws Throwable {
		try {

			// Clearing container type filter
			this.getDriver().findElement(By.xpath("//*[@id=\"TRselOrigIds\"]/td[1]/a")).click();
			System.out.println(" User clears Origin Location filter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Clearing Destination Location filter
	@Then("^user clears destination location filter$")
	public void user_clears_destLoc_filter() throws Throwable {
		try {

			// Clearing container type filter
			this.getDriver().findElement(By.xpath("//*[@id=\"TRselDestIds\"]/td[1]/a")).click();
			System.out.println(" User clears Destination Location filter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Clearing Commodity group filter
	@Then("^user clears commodity group filter$")
	public void user_clears_commodity_group_filter() throws Throwable {
		try {

			// Clearing commodity group filter
			this.getDriver().findElement(By.xpath("//*[@id=\"TRselCommodityGrpIds\"]/td[1]/a")).click();
			System.out.println(" User clears Commodity group filter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Clear All filters
	@Then("^user clears all filters$")
	public void user_clears_all_filters() throws Throwable {
		try {

			// Clearing all filters
			this.getDriver().findElement(By.xpath("//*[@id=\"spnFilterButton\"]/a")).click();
			System.out.println(" User clears All filters");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Opening console rate detail for the first rate
	@Then("^user opens rate detail$")
	public void user_opens_rate_detail() throws Throwable {
		try {

			// Clicking on first Rate Detail
			this.getDriver().findElement(By.id("imgDetail0")).click();
			System.out.println(" User opens rate detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Comparing the total amount in summary with the expected amount
	@Then("^user compares total rate amount in the console summary with expected amount \"([^\"]*)\"$")
	public void user_compares_total_rate_amount_in_consoleSummary(String consoleSummaryTotalExpectedAmount)
			throws Throwable {
		try {
			// Clicking on first Rate Summary
			String consoleSummaryTotal = this.getDriver().findElement(By.id("totalRate0")).getText();
			Assert.assertEquals(consoleSummaryTotalExpectedAmount, consoleSummaryTotal);
			System.out.println("The Summary Total is compared and results match");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Comparing surcharge applicability and amount inserted with the expected
	// amount and type.
	@Then("^user checks surcharge \"([^\"]*)\" is \"([^\"]*)\" with total surcharge amount \"([^\"]*)\"$")
	public void user_checks_surcharge(String surchargeWithCategory, String surchargeType, String surchargeTotalAmt)
			throws Throwable {
		try {
			// Checking for Applicability
			if (surchargeType.equals("Applicable")) {
				String surchargeApplicability = this.getDriver().findElement(By.id("applSurcharge")).getText();
				if (surchargeApplicability.equals(surchargeType)) {
					String surchargeName = this.getDriver()
							.findElement(By.xpath("//*[@id=\"applSurchargeData0\"]/span/span[1]")).getText();
					Assert.assertEquals(surchargeName, surchargeWithCategory);
					String surchargeTotalAmount = this.getDriver().findElement(By.id("level2SurchargesData")).getText();
					Assert.assertEquals(surchargeTotalAmount, surchargeTotalAmt);
				}
			} else if (surchargeType.equals("B/L surcharges")) {
				String surchargeApplicability = this.getDriver().findElement(By.id("blSurchrges")).getText();
				if (surchargeApplicability.equals(surchargeType)) {
					String surchargeName = this.getDriver()
							.findElement(By.xpath("//*[@id=\"blSurchrgesData0\"]/span/span[1]")).getText();
					Assert.assertEquals(surchargeName, surchargeWithCategory);
					String surchargeTotalAmount = this.getDriver().findElement(By.id("level2BolSurData")).getText();
					Assert.assertEquals(surchargeTotalAmount, surchargeTotalAmt);
				}
			} else if (surchargeType.equals("Subject To")) {
				String surchargeApplicability = this.getDriver().findElement(By.id("subjectTo")).getText();
				if (surchargeApplicability.equals(surchargeType)) {
					String surchargeName = this.getDriver()
							.findElement(By.xpath("//*[@id=\"subjectToData2\"]/span/span[1]")).getText();
					Assert.assertEquals(surchargeName, surchargeWithCategory);
				}
			} else if (surchargeType.equals("Included")) {
				String surchargeApplicability = this.getDriver().findElement(By.id("included")).getText();
				if (surchargeApplicability.equals(surchargeType)) {
					String surchargeName = this.getDriver()
							.findElement(By.xpath("//*[@id=\"includedData0\"]/span/span[1]")).getText();
					Assert.assertEquals(surchargeName, surchargeWithCategory);
				}
			} else if (surchargeType.equals("Not-Applicable")) {
				String surchargeApplicability = this.getDriver().findElement(By.id("notApplicable")).getText();
				if (surchargeApplicability.equals(surchargeType)) {
					String surchargeName = this.getDriver()
							.findElement(By.xpath("//*[@id=\"notApplicableData3\"]/span/span[1]")).getText();
					Assert.assertEquals(surchargeName, surchargeWithCategory);
				}
			}
			System.out.println("The Surcharge " + surchargeWithCategory + " is loaded successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Opening the Console Menu 'Pricing Info'
	@Then("^user opens Pricing Info drop down in console$")
	public void user_open_pricingInfo_in_console() throws Throwable {
		try {
			// Clicking on Pricing Info drop down in console
			this.getDriver().findElement(By.id("pricingInfoDropDown")).click();
			System.out.println("Opening the Pricing Info Menu");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Selecting 'Surcharge view & add/update/delete ' option from the console
	// 'Pricing Info' Menu
	@Then("^user chooses Level 1 Surcharge editor in console$")
	public void user_chooses_level1_surchargeEditor_console() throws Throwable {
		try {
			// Clicking on Pricing Info drop down in console
			wait.until(
					ExpectedConditions.elementToBeClickable(By.partialLinkText("Surcharge view & add/update/delete")));
			this.getDriver().findElement(By.partialLinkText("Surcharge view & add/update/delete")).click();
			System.out.println("Opening the Surcharge View & add/update/delete");
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Surcharge descriptions")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Selecting 'Surcharge Add Only ' option from the console 'Pricing Info' Menu
	@Then("^user chooses Level 1 Surcharge add only in console$")
	public void user_chooses_level1_surchargeAddOnly_console() throws Throwable {
		try {
			// Clicking on Pricing Info drop down in console
			this.getDriver().findElement(By.partialLinkText("Surcharge add only")).click();
			System.out.println("Opening the Surcharge Add Only in Console");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("surchargeTerm0")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding Surcharge through Surcharge Editor. Currently adding only one at a
	// time
	@Then("^user adds Level 1 surcharges to the rates in \"([^\"]*)\"$")
	public void user_adds_levelOneSurcharges(String amdNo, DataTable levelOneSurcharges) throws Throwable {
		try {
			int i = 0;
			for (Map<String, String> surchargeList : levelOneSurcharges.asMaps(String.class, String.class)) {
				// Adding Surcharge Term
				wait.until(ExpectedConditions.elementToBeClickable(By.id("tdResetButton")));
				this.getDriver().findElement(By.id("surchargeTerm" + i + "")).click();
				System.out.println("Adding Surcharge " + surchargeList.get("Surcharge Term") + " value of i is " + i);
				// Searching for the surcharge and typing it in the text box
				this.getDriver().findElement(By.id("surchargeTerm" + i + ""))
						.sendKeys(surchargeList.get("Surcharge Term"));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-" + (i + 1) + "")));
				List<WebElement> optionsToSelect = this.getDriver().findElements(By.id("ui-id-" + (i + 1) + ""));
				optionsToSelect.get(0).click();
				System.out.println(optionsToSelect.get(0));
				// Adding Surcharge Applicability
				System.out.println("Adding surcharge applicability " + surchargeList.get("Applicability"));
				this.getDriver().findElements(By.name("surchargeTypeSel")).get(i).click();
				String applicability = surchargeList.get("Applicability");
				Select surchargeApplicability = new Select(
						this.getDriver().findElements(By.name("surchargeTypeSel")).get(i));
				if (applicability.equals("Applicable")) {
					surchargeApplicability.selectByValue("A");
				} else if (applicability.equals("Subject To")) {
					surchargeApplicability.selectByValue("S");
				} else if (applicability.equals("Included")) {
					surchargeApplicability.selectByValue("I");
				} else if (applicability.equals("Not-Applicable")) {
					surchargeApplicability.selectByValue("N");
				}

				// Adding Surcharge category
				System.out.println("Adding Surcharge category " + surchargeList.get("Category"));
				String category = surchargeList.get("Category");
				this.getDriver().findElements(By.name("surchargeCategory")).get(i).click();
				Select surchargeCategory = new Select(
						this.getDriver().findElements(By.name("surchargeCategory")).get(i));
				if (category.equals("Unspecified")) {
					surchargeCategory.selectByValue("U");
				} else if (category.equals("Origin")) {
					surchargeCategory.selectByValue("O");
				} else if (category.equals("Destination")) {
					surchargeCategory.selectByValue("D");
				}

				// Adding Surcharge PriceBy
				System.out.println("Adding Surcharge PriceBy " + surchargeList.get("PriceBy"));
				this.getDriver().findElements(By.name("selSurPriceBy")).get(i).click();
				String priceBy = surchargeList.get("PriceBy");
				Select surchargePriceBy = new Select(this.getDriver().findElements(By.name("selSurPriceBy")).get(i));
				if (priceBy.equals("Per BOL")) {
					surchargePriceBy.selectByVisibleText("Per BOL");
				} else if (priceBy.equals("Per Container")) {
					surchargePriceBy.selectByVisibleText("Per Container");
				} else if (priceBy.equals("Percent")) {
					surchargePriceBy.selectByVisibleText("Percent");
				}

				// Adding Surcharge Amount
				System.out.println("Adding Surcharge Amount " + surchargeList.get("Amount"));
				this.getDriver().findElements(By.name("surchargeAmt")).get(i).click();
				this.getDriver().findElements(By.name("surchargeAmt")).get(i).sendKeys(surchargeList.get("Amount"));

				// Adding Surcharge currency
				System.out.println("Adding Surcharge Currency " + surchargeList.get("Currency"));
				String currency = surchargeList.get("Currency");
				this.getDriver().findElement(By.id("selCurrencyId")).click();
				Select surchargeCurrency = new Select(this.getDriver().findElement(By.id("selCurrencyId")));
				surchargeCurrency.selectByVisibleText(currency);

				// Adding Exclude from total
				System.out.println("Adding Exclude from Total as " + surchargeList.get("ExcludeFromTotal"));
				String exclusion = surchargeList.get("ExcludeFromTotal");
				Select surchargeExclusion = new Select(
						this.getDriver().findElements(By.name("excludeFromRateTotal")).get(i));
				if (applicability.equals("Applicable")) {
					surchargeExclusion.selectByVisibleText(exclusion);
				}

				// Adding Effective Date
				this.getDriver().findElements(By.name("newEffDate")).get(i).click();
				this.getDriver().findElements(By.name("newEffDate")).get(i).clear();
				this.getDriver().findElements(By.name("newEffDate")).get(i).sendKeys(surchargeList.get("EffDate"));

				// Adding Expiration Date
				this.getDriver().findElements(By.name("newExpDate")).get(i).click();
				this.getDriver().findElements(By.name("newExpDate")).get(i).click();
				this.getDriver().findElements(By.name("newExpDate")).get(i).sendKeys(surchargeList.get("ExpDate"));
				i++;
				if (i >= 4) {
					this.getDriver().findElement(By.id("addRow")).click();
					Thread.sleep(2000);
				}

			}
			// Click on 'Update' button to add the surcharges
			this.getDriver().findElement(By.id("updateRates")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("amendmentName")));

			// Click on Amendment number
			this.getDriver().findElement(By.id("amendmentName")).click();
			this.getDriver().findElement(By.id("amendmentName")).sendKeys(amdNo);
			this.getDriver().findElement(By.xpath("//*[@id=\"selectValue\"]/li/div")).click();
			this.getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button[3]")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			this.getDriver().switchTo().alert().accept();
			this.getDriver().findElement(By.xpath("//*[@id=\"tdReturnButton\"]/input")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete rates after calling method of Effective date filter and Expiration
	// date filter
	@Then("^user deletes rates$")
	public void user_deletes_rates() throws Throwable {
		try {

			// Clicking on Delete Rates Button
			this.getDriver().findElement(By.id("deleteRatesLink")).click();
			this.getDriver().findElement(By.id("deleteButton")).click();
			this.getDriver().switchTo().alert().accept();
			Thread.sleep(2000);
			this.getDriver().switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Checking Contract List to see if contract got deleted
	@Then("^user confirms deletion of rates for the contract \"([^\"]*)\"$")
	public void user_confirms_deletion_of_rates(String contractName) throws Throwable {
		try {
			// Clicking on Contract tab to load contracts
			this.getDriver().findElement(By.id("openContractFilter")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchStrAssigned")));
			this.getDriver().findElement(By.id("searchStrAssigned")).click();
			this.getDriver().findElement(By.id("searchStrAssigned")).clear();
			this.getDriver().findElement(By.id("searchStrAssigned")).sendKeys(contractName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Making a rate mesh contract by clicking on Share button to share to a
	// company. Rate mesh contract from e-maeu to QA Auto.
	@Then("^user selects share button for rate sharing to \"([^\"]*)\"$")
	public void user_selects_share_button_for_rate_sharing(String sharedEnv) throws Throwable {
		try {
			// Selecting the Share button to share the contract
			this.getDriver().findElement(By.id("RateMeshShare")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("select_2")));
			this.getDriver().findElement(By.id("select_2")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("selectedInput")));
			this.getDriver().findElement(By.id("selectedInput")).sendKeys(sharedEnv);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("1")));
			this.getDriver().findElement(By.id("1")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("shareCusContinue")));
			this.getDriver().findElement(By.id("shareCusContinue")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"dialogContent_5\"]/div[3]/button[3]/span")));
			;
			this.getDriver().findElement(By.xpath("//*[@id=\"dialogContent_5\"]/div[3]/button[3]/span")).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Navigate to Audit Page
	@Then("^user clicks on Audit page button$")
	public void user_clicks_on_audit_page_button() throws Throwable {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("toAuditRates")));
			this.getDriver().findElement(By.id("toAuditRates")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("returnTonContractConsole")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Navigate to console from Audit page
	@Then("^user clicks on Return to console button$")
	public void user_clicks_on_returntoconsole_button() throws Throwable {
		try {
			this.getDriver().findElement(By.id("returnTonContractConsole")).click();
			System.out.println("Returning to console");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("spnContractFilter")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Navigate to Rate mesh Contract option in console contract list
	@Then("^user opens a Rate mesh contract$")
	public void user_opens_ratemeshcontract() throws Throwable {
		try {
			System.out.println("Opening a Rate mesh contract");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("divContractFilter")));
			WebElement oCheckBox = this.getDriver().findElement(By.cssSelector("input[value='RM']"));
			oCheckBox.click();
			// checking if contract loading pop up is visible or not
			wait.until(ExpectedConditions.elementToBeClickable(By.id("divContractFilter")));
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Clicking on Amendment Approval Button in Audit page for a Rate mesh-ed
	// contract. Also adding a new carrier contact to send email.
	// Needs rework to handle few pop-ups once notification service is added to
	// system-tests
	@Then("^user clicks on Amendment Approve button and sends email to contact name \"([^\"]*)\" with email \"([^\"]*)\"$")
	public void user_clicks_amendmentApprove(String contactName, String contactEmail) throws Throwable {
		try {
			System.out.println("Clicking Amendment Approve Button");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("approveButtonRM")));
			this.getDriver().findElement(By.id("approveButtonRM")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("carrierDropdownOpenRM")));
			this.getDriver().findElement(By.id("carrierDropdownOpenRM")).click();
			Thread.sleep(1000);
			// Adding a new contact
			this.getDriver().findElement(By.id("editNewContactRM3")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("newContactNameRM")));
			// Adding New contact name and email
			this.getDriver().findElement(By.id("newContactNameRM")).click();
			this.getDriver().findElement(By.id("newContactNameRM")).sendKeys(contactName);
			this.getDriver().findElement(By.id("newContactEmailRM")).sendKeys(contactEmail);
			this.getDriver().findElement(By.id("addNewContactConfirmRM")).click();
			this.getDriver().findElement(By.id("changeAmendUpdateRM")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Clicking on Amendment Approval Button in Audit page for a Rate mesh-ed
	// contract. Also adding a new carrier contact to send email.Choose different
	// contract or different contact to avoid existing contact scenario.
	// Needs rework to handle few pop-ups once notification service is added to
	// system-tests
	@Then("^user clicks on Amendment Reject button and sends email to contact name \"([^\"]*)\" with email \"([^\"]*)\"$")
	public void user_clicks_amendmentReject(String contactName, String contactEmail) throws Throwable {
		try {
			System.out.println("Clicking Amendment Reject Button");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("rejectButtonRM")));
			this.getDriver().findElement(By.id("rejectButtonRM")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("carrierDropdownOpenRM")));
			this.getDriver().findElement(By.id("carrierDropdownOpenRM")).click();
			Thread.sleep(1000);
			// Adding a new contact
			this.getDriver().findElement(By.id("editNewContactRM3")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("newContactNameRM")));
			// Adding New contact name and email
			this.getDriver().findElement(By.id("newContactNameRM")).click();
			this.getDriver().findElement(By.id("newContactNameRM")).sendKeys(contactName);
			this.getDriver().findElement(By.id("newContactEmailRM")).sendKeys(contactEmail);
			this.getDriver().findElement(By.id("addNewContactConfirmRM")).click();
			this.getDriver().findElement(By.id("changeAmendUpdateRM")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Then("^select a carrier \"([^\"]*)\"$")
	public void selectACarrier(String carrierName) throws InterruptedException {
		Thread.sleep(2000);
		this.getDriver().findElement(By.id("carrierSearchInput")).sendKeys(carrierName);
		Thread.sleep(2000);
		WebElement we = this.getDriver().findElement(By.className("consoleBtn"));
		we.click();
	}
}
