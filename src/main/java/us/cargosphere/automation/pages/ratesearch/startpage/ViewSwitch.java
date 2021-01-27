package us.cargosphere.automation.pages.ratesearch.startpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

/**
 * ViewSwitch is a page fragment that represents the toggle for switching
 * between Compact View and Classic View.
 */
public class ViewSwitch extends BasePage {

    @FindBy(how = How.CSS, using = "#rateSearchForm > div.negativeMargin > div > div > img:nth-child(1)")
    private WebElement classicViewBtn;
    @FindBy(how = How.CSS, using = "#rateSearchForm > div.negativeMargin > div > div > img:nth-child(2)")
    private WebElement compactViewBtn;

    public ViewSwitch(WebDriver webDriver, WebElement searchContext) {
        super(webDriver, searchContext);
    }

    public void clickClassicViewBtn() {
        classicViewBtn.click();
    }

    public void clickCompactViewBtn() {
        compactViewBtn.click();
    }

    public WebElement getCompactViewBtn() {
        return compactViewBtn;
    }

    public WebElement getClassicViewBtn() {
        return classicViewBtn;
    }

    public boolean hasClassicViewToggled() {
        return classicViewBtn.getAttribute("class").equals("searchActive");
    }

    public boolean hasCompactViewToggled() {
        return compactViewBtn.getAttribute("class").equals("searchActive");
    }
}