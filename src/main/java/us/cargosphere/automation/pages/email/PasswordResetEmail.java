package us.cargosphere.automation.pages.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import us.cargosphere.automation.pages.BasePage;

public class PasswordResetEmail extends BasePage {

    private WebElement resetLink;

    public PasswordResetEmail (WebDriver webDriver) {
        super(webDriver);
        this.resetLink = webDriver.findElement(By.id("resetLink"));
    }

    public void clickResetLink() {
        resetLink.click();
    }
}
