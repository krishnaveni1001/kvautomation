package us.cargosphere.automation.pages.ratesearch;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import us.cargosphere.automation.pages.BasePage;

public class ClassicView extends BasePage implements ResultsView {
    WebElement context;

    @FindBy(how = How.CSS, using = "#compactViewTemplate > compact-filters > div.sortFilters > div.cartInfo > div:nth-child(1) > strong")
    WebElement resultCountSpan;

    public ClassicView(WebDriver webDriver, WebElement searchContext) {
        super(webDriver, searchContext);
    }

    @Override
    public int getResultCount() {
        return Integer.parseInt(resultCountSpan.getText());
    }
}