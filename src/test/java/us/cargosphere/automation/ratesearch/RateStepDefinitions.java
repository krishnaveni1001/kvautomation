package us.cargosphere.automation.ratesearch;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;

public class RateStepDefinitions extends BaseStepDefinitions {

	@Given("^that user search with \"([^\"]*)\" origin and destination \"([^\"]*)\"$")
	public void thatUserSearchWithOriginAndDestination(String origin, String destination) throws Throwable {
		// Click on the origin search box container
		this.getDriver().manage().window().maximize();
		this.getDriver().findElements(By.className("originContainer")).get(0).click();
		WebElement originSearchBox = this.getDriver().findElement(By.id("originSearch"));
		System.out.println("Sending " + origin + " to origin search box…");
		originSearchBox.sendKeys(origin);
		Thread.sleep(2000);
		System.out.println("Selecting first element in autocomplete results…");
		originSearchBox.sendKeys(Keys.TAB, Keys.ENTER);
		
		this.getDriver().findElements(By.className("destContainer")).get(0).click();
		WebElement destinationSearchBox = this.getDriver().findElement(By.id("destSearch"));
		destinationSearchBox.sendKeys(destination);
		Thread.sleep(2000);
		destinationSearchBox.sendKeys(Keys.TAB, Keys.ENTER);
		//Thread.sleep(2000);
		this.getDriver().findElement(By.id("buySellRates")).click();
		this.getDriver().findElement(By.id("searchfclBuyRadio")).click();
		//Thread.sleep(2000);
		this.getDriver().findElement(By.id("rateSearchBtn")).click();
		Thread.sleep(2000);
	}

	@Given("^that rates are uploaded for \"([^\"]*)\" to \"([^\"]*)\"$")
	public void thatRatesAreUploadedForTo(String arg1, String arg2) throws Throwable {
		// The rate upload code will go here
		// Check the if the data is loaded using file status table
	}

	@Then("^the user should be able to see total \"([^\"]*)\" matching rate results$")
	public void userShouldBeAbleToSeeTotalMatchingRateResults(String expectedTotal) throws Throwable {
		String totalResults = this.getDriver().findElement(By.id("totalResultsSpan")).getText();
		Assert.assertEquals(expectedTotal, totalResults);
	}

	@Then("^first summary total should match with the detail total$")
	public void firstSummaryTotalShouldMatchWithTheDetailTotal() throws Throwable {
		String SummaryTotal = this.getDriver().findElements(By.className("results-normal-rate")).get(0).getText();
		this.getDriver().findElement(By.id("containerRates")).click();
		Thread.sleep(2000);
		String DetailTotal = this.getDriver().findElements(By.className("container-price")).get(0).getText();
		Assert.assertEquals(SummaryTotal, DetailTotal);
		System.out.println("summary total should match with the detail total" + SummaryTotal);
		System.out.println("summary total should match with the detail total" + DetailTotal);
	}

//	@Then("^clear rate search$")
	public void clearRateSearch() throws Throwable {
		this.getDriver().findElement(By.className("originContainer")).click();
		Thread.sleep(1000);
		this.getDriver().findElement(By.className("clearLocations")).click();
		Thread.sleep(1000);
		this.getDriver().findElement(By.className("destContainer")).click();
		Thread.sleep(1000);
		this.getDriver().findElements(By.className("clearLocations")).get(1).click();
		Thread.sleep(1000);
		
	}//


	
	@Then("^add page to quote cart$")
	public void addPageToQuoteCart() throws Throwable {
		this.getDriver().findElement(By.id("addPageToQuoteCart")).click();
		System.out.println("page added");
	}

	@Then("^check the rates in quote cart$")
	public void checkTheRatesInQuoteCart() throws Throwable {
		this.getDriver().findElement(By.className("cartViewTable")).findElement(By.linkText("CART")).click();
		Thread.sleep(1000);
	}

	@Then("^return to rate search page$")
	public void returnToRateSearchPage() throws Throwable {
			this.getDriver().findElement(By.className("fa fa-arrow-left")).click();
	}

	@Then("^clear cart$")
	public void clearCart() throws Throwable {
			this.getDriver().findElement(By.xpath("//*[@id=\"middleLayer\"]/div[4]/div/span")).click();
			this.getDriver().findElement(By.id("clearCart")).click();
			Thread.sleep(2000);
	}

	@Then("^number of rates in the cart$")
	public void numberOfRatesInTheCart() throws Throwable {
		String quotecartTotal = this.getDriver().findElement(By.id("cartTotal")).getText();
		this.getDriver().findElement(By.className("cartViewTable")).findElement(By.linkText("CART")).click();
		String quoteTotalRows = this.getDriver().findElement(By.id("totalRows")).getText().replace("Total Rows :", "").trim();
		Assert.assertEquals(quotecartTotal, quoteTotalRows);
		Thread.sleep(2000);
	}

	@Then("^clear quote cart filters$")
	public void clearQuoteCartFilters() throws Throwable {
		this.getDriver().findElement(By.className("clearFilter")).findElement(By.id("clearFilter")).click();
	}

	@Then("^the default quote cart date should be rate search date$")
	public void theDefaultQuoteCartDateShouldBeRateSearchDate() throws Throwable {
		String ratesearchDate = this.getDriver().findElement(By.id("dateCellValue")).getAttribute("value");
		this.getDriver().findElement(By.className("cartViewTable")).findElement(By.linkText("CART")).click();
		String quotecartDate = this.getDriver().findElement(By.id("gridDateCell")).getAttribute("value");
		Assert.assertEquals(ratesearchDate, quotecartDate);
	}

	@Then("^add first rate to quote cart$")
	public void addFirstRateToQuoteCart() throws Throwable {
		this.getDriver().findElements(By.className("addCartButton")).get(0).click();
		System.out.println("first rate added");
	//	Thread.sleep(3000);
	}

	@Then("^goto quote cart page$")
	public void gotoQuoteCartPage() throws Throwable {
		Thread.sleep(2000);
		this.getDriver().findElement(By.className("cartViewTable")).findElement(By.linkText("CART")).click();
	}

	@Then("^clear cart in rate search page$")
	public void clearCartInRateSearchPage() throws Throwable {
				String quotecartTotal = this.getDriver().findElement(By.id("cartTotal")).getText();
				if (quotecartTotal.equals("0"))
				{		
					System.out.println(quotecartTotal);
				} else
				{
					System.out.println("dhsdhdfhsh");
					this.getDriver().findElement(By.className("cartViewTable")).findElement(By.linkText("CART")).click();
					Thread.sleep(2000);
					this.getDriver().findElement(By.id("clearCart")).click();
					Thread.sleep(2000);
				}
			}

	@Then("^add all rates to quote cart$")
	public void addAllRatesToQuoteCart() throws Throwable {
		this.getDriver().findElement(By.id("adRatesToCart")).click();
		System.out.println("All rates added");
		Thread.sleep(2000);
	}

	@Then("^check surcharge preference$")
	public void checkSurchargePreference() throws Throwable {
		this.getDriver().findElement(By.id("dropdownMenu1")).click();
		Thread.sleep(3000);
		if (this.getDriver().findElement(By.id("originCheckbox")).isSelected())
			{
				System.out.println("Origin check box is already checked");
			}
		else
			{
				this.getDriver().findElement(By.id("originCheckbox")).click();
				System.out.println("Origin check box is checked");
			}
		if (this.getDriver().findElement(By.id("destinationCheckbox")).isSelected())
			{
			System.out.println("Destination check box is already checked");
			}
		else
			{
			this.getDriver().findElement(By.id("destinationCheckbox")).click();
			System.out.println("Destination check box is checked");
			}
		this.getDriver().findElement(By.id("buttonApply")).click();
		Thread.sleep(3000);
		}

	@Then("^show level(\\d+) result$")
	public void showLevelResult(int arg1) throws Throwable {
		this.getDriver().findElement(By.id("containerRates")).click();
		Thread.sleep(6000);
	}

	@Then("^enter surcharge data$")
	public void surchargeData(DataTable dt) throws Throwable {
		String serviceId = this.getDriver().findElement(By.id("serviceIdNumber")).getText();
		System.out.println(">>"+ serviceId);
		System.out.println("Additional"+ this.getDriver().findElement(By.id("addchr_base_FA_rate_1")).getAttribute("cs-value"));
		List<Map<String, String>> lstInput = dt.asMaps(String.class, String.class);
			for(int i=0; i<lstInput.size(); i++) {
				String key = lstInput.get(i).get("pattern") + "_" + lstInput.get(i).get("charge") + "_charge_" + lstInput.get(i).get("index"); 
			//	System.out.println(key);
				Thread.sleep(2000); 
				String surcharge = this.getDriver().findElement(By.id(key)).getAttribute("cs-value");
				System.out.println("Surcharge: "+surcharge);
				Assert.assertEquals("SurchargeTerm", surcharge, lstInput.get(i).get("charge"));
				
				String key1 = lstInput.get(i).get("pattern") + "_" + lstInput.get(i).get("charge") + "_rate_" + lstInput.get(i).get("index"); 
		//		System.out.println(key1);
				String surcharge1 = this.getDriver().findElement(By.id(key1)).getAttribute("cs-value");
				System.out.println("Rate: "+surcharge1);
				Assert.assertEquals("Rate", surcharge1, lstInput.get(i).get("rate"));
				
				String key2 = lstInput.get(i).get("pattern") + "_" + lstInput.get(i).get("charge") + "_priceBy_" + lstInput.get(i).get("index"); 
		//		System.out.println(key2);
				String surcharge2 = this.getDriver().findElement(By.id(key2)).getAttribute("cs-value");
				System.out.println("PriceBy: "+surcharge2);
				Assert.assertEquals("Price By", surcharge2, lstInput.get(i).get("priceBy"));
				
				String key3 = lstInput.get(i).get("pattern") + "_" + lstInput.get(i).get("charge") + "_type_" + lstInput.get(i).get("index"); 
		//		System.out.println(key3);
				String surcharge3 = this.getDriver().findElement(By.id(key3)).getAttribute("cs-value");;
				System.out.println("Type: "+surcharge3);
				Assert.assertEquals("Type", surcharge3, lstInput.get(i).get("type"));
	
				String key4 = lstInput.get(i).get("pattern") + "_" + lstInput.get(i).get("charge") + "_category_" + lstInput.get(i).get("index"); 
		//		System.out.println(key4);
				String surcharge4 = this.getDriver().findElement(By.id(key4)).getAttribute("cs-value");
				System.out.println("Category: "+surcharge4);
				Assert.assertEquals("Category", surcharge4, lstInput.get(i).get("category"));
		}
	}

	@Then("^compare baserate$")
	public void compareBaserate(DataTable dt) throws Throwable {
			
		List<Map<String, String>> lstInput = dt.asMaps(String.class, String.class);
		
		
		String c1 =lstInput.get(0).get("charge");
		Assert.assertEquals("Base rate", this.getDriver().findElement(By.id("ocean_baserate_BASERATE_charge_0")).getAttribute("cs-value"), c1);
		System.out.println("Base Rate "+c1);
		
		String c2 = lstInput.get(0).get("rate");
		Assert.assertEquals("Rate",this.getDriver().findElement(By.id("ocean_baseRate_BASERATE_rate_0")).getAttribute("cs-value"), c2);
		System.out.println("Rate  "+c2);
		
		String c3 = lstInput.get(0).get("priceBy");
		Assert.assertEquals("Price By", this.getDriver().findElement(By.id("ocean_baseRate_BASERATE_priceBy")).getAttribute("cs-value"), c3);
		System.out.println("Price By  "+c3);
		
		String c4 = lstInput.get(0).get("type");
		Assert.assertEquals("Type", this.getDriver().findElement(By.id("ocean_baseRate_BASERATE_type")).getAttribute("cs-value"), c4);
		System.out.println("Type  "+c4);
	
	}

}
			
