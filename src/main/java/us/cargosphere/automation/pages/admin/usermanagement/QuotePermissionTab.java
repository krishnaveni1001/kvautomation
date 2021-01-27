package us.cargosphere.automation.pages.admin.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import us.cargosphere.automation.pages.BasePage;

public class QuotePermissionTab extends BasePage {

	private WebElement enableAllButton;

		public QuotePermissionTab(WebDriver webDriver) {
		super(webDriver);
		this.enableAllButton = webDriver.findElement(By.id("quotingEnableAll"));
	}

	public void clickEnableAllButton() {
		enableAllButton.click();
	}

}
