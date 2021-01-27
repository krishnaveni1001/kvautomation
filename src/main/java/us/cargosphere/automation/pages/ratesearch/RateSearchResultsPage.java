package us.cargosphere.automation.pages.ratesearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.compactview.CompactView;
import us.cargosphere.automation.pages.ratesearch.startpage.SearchControls;
import us.cargosphere.automation.pages.ratesearch.startpage.ViewSwitch;

/**
 * A Page Object Model representing the rate search results page that is shown
 * after performing a rate search.
 */
public class RateSearchResultsPage extends BasePage {
    private ViewSwitch viewSwitch;
    private SearchControls searchControls;
    private CompactView compactView;
    private ClassicView classicView;

    public RateSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

        searchControls = new SearchControls(webDriver, webDriver.findElement(By.id("searchFieldsBox")));
        viewSwitch = new ViewSwitch(webDriver, webDriver.findElement(By.className("searchTypeIndicator")));

        findResultViews();
    }

    /**
     * returns the {@link SearchControls} part of the page.
     */
    public SearchControls getSearchControls() {
        return searchControls;
    }

    /**
     * Returns the {@link ViewSwitch} part of the page.
     */
    public ViewSwitch getViewSwitch() {
        return viewSwitch;
    }

    /**
     * Returns the {@link ClassicView} search results of the page
     */
    public ClassicView getClassicView() {
        if (classicView == null) {
            findResultViews();
        }
        return classicView;
    }

    /**
     * Returns the {@link CompactView} search results of the page
     */
    public CompactView getCompactView() {
        if (compactView == null) {
            findResultViews();
        }
        return compactView;
    }

    /**
     * Checks whether the compact view is shown
     * 
     * @return {@code true} if the compact view is being shown, {@code false}
     *         otherwise.
     */
    public boolean showsCompactView() {
        if (getCompactView() != null) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the classic view is shown
     * 
     * @return {@code true} if the classic view is being shown, {@code false}
     *         otherwise.
     */
    public boolean showsClassicView() {
        if (getClassicView() != null) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether search results are being shown.
     * 
     * @return {@code true} if either compact or classic view search results are on
     *         the page, {@code false} otherwise.
     */
    public boolean showsSearchResults() {
        if (getCompactView() != null) {
            return true;
        }

        if (getClassicView() != null) {
            if (classicView.getResultCount() > 0) {
                return true;
            }
        }
        return false;
    }

    private void findResultViews() {
        List<WebElement> compactViewElements = webDriver.findElements(By.id("compactViewTemplate"));
        if (compactViewElements.size() > 0) {
            compactView = new CompactView(webDriver, compactViewElements.get(0));
        } else {
            compactView = null;
        }

        List<WebElement> classicViewElements = webDriver.findElements(By.className("standardView"));
        if (classicViewElements.size() > 0) {
            classicView = new ClassicView(webDriver, classicViewElements.get(0));
        } else {
            classicView = null;
        }
    }
}
