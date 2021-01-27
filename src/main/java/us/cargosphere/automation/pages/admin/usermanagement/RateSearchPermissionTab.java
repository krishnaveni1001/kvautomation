package us.cargosphere.automation.pages.admin.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import us.cargosphere.automation.pages.BasePage;

public class RateSearchPermissionTab extends BasePage {

    private WebElement enableAllButton;

    public RateSearchPermissionTab (WebDriver webDriver) {
        super(webDriver);
        this.enableAllButton = webDriver.findElement(By.id("rateSearchEnableAll"));
    }

    public void clickEnableAllButton () {
        enableAllButton.click();
    }
}
