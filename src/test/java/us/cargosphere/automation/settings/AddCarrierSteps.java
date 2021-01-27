package us.cargosphere.automation.settings;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.settings.CarriersPage;

public class AddCarrierSteps extends BaseStepDefinitions{
	
	private CarriersPage addCarrierPage;			
	public AddCarrierSteps(TestContext context) {
		super(context);
		addCarrierPage = this.testContext.getPageObjectManager().getCarriersPage();
}
	

	@And("^user clicks on add carrier button$")
	public void userClicksOnAddCarrierButton() throws Throwable {
		addCarrierPage.ClickAddUser();
	}

	@And("^user enter company name \"([^\"]*)\"$")
	public void userEnterCompanyName(String comName) throws Throwable {
		Thread.sleep(2000);
		addCarrierPage.EnterCompanyCode(comName);
		Thread.sleep(2000);
	}

	@And("^user enter contact name \"([^\"]*)\"$")
	public void userEnterContactName(String contName) throws Throwable {
		addCarrierPage.EnterContactName(contName);
	}

	@And("^user enter emailid \"([^\"]*)\"$")
	public void userEnterEmailid(String emailId) throws Throwable {
		addCarrierPage.EnterEmail(emailId);
	}


	@And("^user click on save carrier button$")
	public void userClickOnSaveCarrierButton() throws Throwable {
		addCarrierPage.ClickSaveUser();
		Thread.sleep(5000);
	}

	
	@And("^user enter scac code \"([^\"]*)\"$")
	public void userEnterScacCode(String scd) throws Throwable {
		addCarrierPage.EnterScacCode(scd);
	}


	@And("^user clicks on cancel button$")
	public void userClicksOnCancelButton() throws Throwable {
		addCarrierPage.ClickCancelButton();
	}


	@And("^user click on save carrier button with a popup$")
	public void userClickOnSaveCarrierButtonWithAPopup() throws Throwable {
		addCarrierPage.ClickSaveUserWithPopup();
		System.out.println("Warning-No SCAC selected");
		Thread.sleep(5000);
	}


	@And("^user get the warning message$")
	public void userGetTheWarningMessage() throws Throwable {
		assertTrue(addCarrierPage.showsError());
		System.out.println("Error message for mandotory field");
	}


	@And("^user catch the wrong email format error$")
	public void userCatchTheWrongEmailFormatError() throws Throwable {
		assertTrue(addCarrierPage.catchError());
		System.out.println("Wrong email format");
	}


	@And("^user catch the duplicate carrier warning message$")
	public void userCatchTheDuplicateCarrierWarningMessage() throws Throwable {
		assertTrue(addCarrierPage.catchDupCarrierError());
		System.out.println("Duplicate carrier");
	}
	
	
}