package us.cargosphere.automation.pages.ratesearch.compactview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class Dropdown extends BasePage {

    @FindBy(how = How.CSS, using = ".compactOptions > li:nth-child(1)")
    WebElement clearFiltersButton;
    @FindBy(how = How.CSS, using = ".compactOptions > li:nth-child(2)")
    WebElement saveColumnOrderButton;
    @FindBy(how = How.CSS, using = ".compactOptions > li:nth-child(3)")
    WebElement resetColumnOrderButton;
    @FindBy(how = How.CSS, using = ".compactOptions > li:nth-child(4)")
    WebElement toggleFilterVisibilityButton;
    @FindBy(how = How.CSS, using = ".compactOptions > li:nth-child(5)")
    WebElement minimizeSearchButton;

    public Dropdown (WebDriver driver, WebElement el) {
        super(driver, el);
    }

    public void saveColumnOrder() {
        saveColumnOrderButton.click();
    }

    public void resetColumnOrder() {
        resetColumnOrderButton.click();
    }

    public void clearFilters() {
        clearFiltersButton.click();
    }

    public void toggleFilterVisibility() {
        toggleFilterVisibilityButton.click();
    }

    public String getToggleFilterVisibilityButtonText () {
        return webDriver.findElement(By.cssSelector(
            ".compactOptions li:nth-child(4) > a > span.ng-binding"
        )).getAttribute("innerText");
    }

}
