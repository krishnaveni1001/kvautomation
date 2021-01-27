package us.cargosphere.automation.admin;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.navigation.NavigationStepDefinitions;

public class StepDefinitions extends BaseStepDefinitions{
	
	@And ("^the user goes to the admin$")
	public void userGoestoTheAdmin() {
		this.getDriver().manage().window().maximize();
		this.getDriver().switchTo().frame(this.getDriver().findElement(By.id("adminFrame")));
	}
	
	@Then("^the user clicks on add user$")
	public void userClicksOnAddUsers()  throws Throwable{
		Thread.sleep(8000);
		this.getDriver().findElement(By.id("addUserButton")).click();
		WebDriverWait block = new WebDriverWait(this.getDriver(),10);
		Thread.sleep(8000);
	}
	
	@Then("^user want to see Carrier popup$") 
	public void userSeesCarrierPopup()  throws Throwable{
		Thread.sleep(5000);
		WebDriverWait block = new WebDriverWait(this.getDriver(),10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("addACarrierModal")));
		Assert.assertEquals(true, this.getDriver().findElement(By.id("addACarrierModal")).isDisplayed());
		Thread.sleep(2000);
	}
	
	@Then("fill up the new user form with following data")
	public void filTheNewUserForm(DataTable dt)throws Throwable {
		List<Map<String,String>> lstInput = dt.asMaps(String.class, String.class);
		for(Map<String,String> map:lstInput) {
			NavigationStepDefinitions naviStepDef = new NavigationStepDefinitions(testContext);
			this.userClicksOnAddUsers();
			naviStepDef.userSeesThePopup("addUserDialog");
			this.getDriver().findElement(By.id("form_name")).sendKeys(map.get("Name"));
			this.getDriver().findElement(By.id("form_email")).sendKeys(map.get("Email Address"));
			this.getDriver().findElement(By.id("form_userId")).sendKeys(map.get("Login Id"));
			  // Click checkboxes
			
			this.getDriver().findElement(By.xpath("//*[@id=\"countryField\"]/div/ng-multiselect-dropdown/div/div[1]/span/span[2]")).click();
			this.getDriver().findElement(By.xpath("//*[@id=\"countryField\"]/div/ng-multiselect-dropdown/div/div[2]"))
	                .findElements(By.tagName("li"))
	                .stream()
	                .filter(elem -> {
	                    String text = elem.getText();
	                    return text.contains(map.get("Country"));
	                }).forEach(WebElement::click);
			//this.getDriver().findElement(By.id("addUserDetailsContent")).click();
			//*[@id="addUserDetailsContent"]/div/div[1]/div[3]/div[1]/div/ng-multiselect-dropdown/div/div[1]/span/span[1]
			this.getDriver().findElement(By.xpath("//*[@id=\"addUserDetailsContent\"]/div/div[1]/div[3]/div[1]/div/ng-multiselect-dropdown/div/div[1]/span/span[2]")).click();
			this.getDriver().findElement(By.xpath("//*[@id=\"addUserDetailsContent\"]/div/div[1]/div[3]/div[1]/div/ng-multiselect-dropdown/div/div[2]"))
							.findElements(By.tagName("li"))
							.stream()
							.filter(elem -> {
								String text = elem.getText();
								return text.contains(map.get("User Type"));
							}).forEach(WebElement::click);
			this.getDriver().findElement(By.id("addUserDetailsContent")).click();
			
			this.getDriver().findElement(By.xpath("//*[@id=\"buField\"]/div/ng-multiselect-dropdown/div/div[1]/span/span[2]")).click();
			this.getDriver().findElement(By.xpath("//*[@id=\"buField\"]/div/ng-multiselect-dropdown/div/div[2]"))
			.findElements(By.tagName("li"))
			.stream()
			.filter(elem -> {
				String text = elem.getText();
				return text.contains(map.get("Business Unit"));
			}).forEach(WebElement::click);
			this.getDriver().findElement(By.id("addUserDetailsContent")).click();
			//Setting the user as active
			
			this.getDriver().findElement(By.id("user"+map.get("User Status"))).click();
			String text = this.getDriver().findElement(By.id("rateSearchPermLabel")).getText();
			if( Boolean.valueOf(map.get(text))) {
				this.getDriver().findElement(By.id("rateSearchPermission")).click();		
			}
			text = this.getDriver().findElement(By.id("rateMgmtPermLabel")).getText();
			if( Boolean.valueOf(map.get(text))) {
				this.getDriver().findElement(By.id("rateMgmtPermission")).click();		
			}
			text = this.getDriver().findElement(By.id("quotingPermLabel")).getText();
			if( Boolean.valueOf(map.get(text))) {
				this.getDriver().findElement(By.id("quotingPermission")).click();		
			}
			text = this.getDriver().findElement(By.id("fmcPermLabel")).getText();
			if( Boolean.valueOf(map.get(text))) {
				this.getDriver().findElement(By.id("fmcPermission")).click();		
			}
			text = this.getDriver().findElement(By.id("reportsPermLabel")).getText();
			if( Boolean.valueOf(map.get(text))) {
				this.getDriver().findElement(By.id("reportsPermission")).click();		
			}
			text = this.getDriver().findElement(By.id("accountAdminPermLabel")).getText();
			if( Boolean.valueOf(map.get(text))) {
				this.getDriver().findElement(By.id("accountAdminPermission")).click();		
			}
			if("Super User".equals(map.get("User Type"))) {
				text = this.getDriver().findElement(By.id("rateMeshPermLabel")).getText();
				if( Boolean.valueOf(map.get(text))) {
					this.getDriver().findElement(By.id("rateMeshPermission")).click();		
				}
				text = this.getDriver().findElement(By.id("systemAdminPermLabel")).getText();
				if( Boolean.valueOf(map.get(text))) {
					this.getDriver().findElement(By.id("systemAdminPermission")).click();		
				}
			}
			
			naviStepDef.userClicksOnNavigationMenuItem("register");
			naviStepDef.userSeesThePopup("userAddedDialog");
			naviStepDef.userClicksOnNavigationMenuItem("addEditCloseBtn");
	  }
	}
	
	@Then("select a new carrier by selecting the Carrier following data:$")
	public void fillTheNewCarrierForm(DataTable input)throws Throwable {
		List<Map<String,String>> lstInput = input.asMaps(String.class, String.class);
		for(Map<String,String> map:lstInput) {
			NavigationStepDefinitions sd = new NavigationStepDefinitions(testContext);
			sd.userClicksOnNavigationMenuItem("addUserButton");
			userSeesCarrierPopup();
			this.getDriver().findElement(By.xpath("//*[@id=\"uiSelectCarrier\"]/div[1]")).click();
			this.getDriver().findElement(By.xpath("/html/body/div[2]/form/div/div/div/div[2]/div[2]/div[1]/div/input[1]")).sendKeys(map.get("ScacId"));
			this.getDriver().findElement(By.xpath("//*[@id=\"uiSelectCarrier\"]/div[1]/div/ul"))
			.findElements(By.tagName("li"))
			.stream()
			.filter(elem -> {
				String text = elem.getText();
				return text.contains(map.get("ScacId"));
			}).forEach(WebElement::click);
			Thread.sleep(5000);
			this.getDriver().findElement(By.xpath("//*[@id=\"addACarrierModal\"]/div/div/div[3]/button[2]")).click();
			Thread.sleep(2000);
			Alert alert=this.getDriver().switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
		}
	}
	
	@Then("^login user edits the user \"([^\"]*)\"$")
	public void loginUserEditUser(String input) throws Throwable {
	  this.getDriver().findElement(By.id("quickFilter")).sendKeys(input);
	  Actions action = new Actions(this.getDriver());
      action.moveToElement(this.getDriver().findElement(By.xpath("/html/body/app-root/app-user-details/div[1]/div/ag-grid-angular/div/div[2]/div[2]/div/div[1]/div/div[4]/div[3]/div/div/div[1]"))).doubleClick().perform();
      Thread.sleep(5000);
      WebDriverWait block = new WebDriverWait(this.getDriver(),10);
      WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.className("addUserDialog")));
      Assert.assertEquals(true, this.getDriver().findElement(By.className("addUserDialog")).isDisplayed());
	}
	
	@Then("^login user enables all permissions of rate management$")
	public void loginUserEnableAllRatemgnt() throws Throwable {
		if (this.getDriver().findElement(By.id("rateMgmtPermission")).isEnabled()) {
			System.out.println("Rate management check box is selected");
		}else {
			this.getDriver().findElement(By.id("rateMgmtPermission")).click();
			}
		this.getDriver().findElement(By.id("rateMgmt_tab")).click();
		
		this.getDriver().findElement(By.xpath("/html/body/modal-container/div/div/div/div/div[2]/form/div/div[6]/div[1]/span/span[1]")).click();
	}
	
	@Then("^login user checks all rate search permissions$")
	public void loginUserEnableAllRatesearch() throws Throwable {
		if (this.getDriver().findElement(By.id("rateSearchPermission")).isEnabled()) {
			System.out.println("Rate search check box is selected");
		}else {
			this.getDriver().findElement(By.id("rateSearchPermission")).click();
			}
		this.getDriver().findElement(By.id("rateSearch_tab")).click();
		this.getDriver().findElement(By.xpath("/html/body/modal-container/div/div/div/div/div[2]/form/div/div[5]/div[1]/span/span[1]")).click();
	}
	
	@Then("^login user apply all quote permissions$")
	public void loginUserEnableAllQuote() throws Throwable {
		if (this.getDriver().findElement(By.id("quotingPermission")).isEnabled()) {
			System.out.println("Quote check box is selected");
		}else {
			this.getDriver().findElement(By.id("quotingPermission")).click();
			}
		this.getDriver().findElement(By.id("quoting_tab")).click();
		this.getDriver().findElement(By.xpath("/html/body/modal-container/div/div/div/div/div[2]/form/div/div[7]/div[2]/span/span[1]")).click();
	}
	
	@Then("^enable create quote permission $")
	public void enableCreateQuotePermission() throws Throwable {
		if (this.getDriver().findElement(By.id("quotingPermission")).isEnabled()) {
			System.out.println("Quote check box is selected");
		}else {
			this.getDriver().findElement(By.id("quotingPermission")).click();
			}
		this.getDriver().findElement(By.id("quoting_tab")).click();
		this.getDriver().findElement(By.id("mngQutCrtCustQuote")).click();
	}
	
	@When ("^we add user following users with create quote permission$")
	public void weAddUserWithQuotePermission(DataTable dt)throws Throwable {
		this.filTheNewUserForm(dt);
		this.loginUserEditUser("");
		this.enableCreateQuotePermission();
		
	}
}
