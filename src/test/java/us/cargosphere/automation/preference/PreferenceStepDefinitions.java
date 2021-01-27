package us.cargosphere.automation.preference;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;

public class PreferenceStepDefinitions extends BaseStepDefinitions {
	
	
   @Given("^user clicks on Account info link$")
	public void user_clicks_on_Account_info_link() throws Throwable {
		WebDriverWait Account_infolink = new WebDriverWait(this.getDriver(), 20);
		Account_infolink.until(ExpectedConditions.elementToBeClickable(By.linkText("Account Info"))).click();
		Thread.sleep(2000);
	}
	
	@Given("^user clicks on Application settings link$")
	public void user_clicks_on_Application_settings_link() throws Throwable{
		
		this.getDriver().findElement(By.partialLinkText("Application Settin")).click();
		
		   
	}

	@Then("^the user should land on the Preference page$")
	public void the_user_should_land_on_the_Preference_page() throws InterruptedException {
		
	     Thread.sleep(2000);		
		String Verifytext= this.getDriver().findElement(By.id("headerContainer")).getText().trim();
		Assert.assertEquals(Verifytext, "Application Settings");
		
      
	}

}


	
	


