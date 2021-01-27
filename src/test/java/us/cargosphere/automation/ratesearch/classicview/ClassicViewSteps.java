package us.cargosphere.automation.ratesearch.classicview;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.ClassicView;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;

public class ClassicViewSteps extends BaseStepDefinitions {

    private RateSearchResultsPage resultsPage;
    private ClassicView classicView;

    public ClassicViewSteps(TestContext context) {
        super(context);
        resultsPage = this.testContext.getPageObjectManager().getRateSearchResultsPage();
        classicView = resultsPage.getClassicView();
    }

    @Then("^there should be (\\d+) total classic view rate search results$")
    public void userShouldBeAbleToSeeTotalMatchingRateResults(int expectedTotal) {
        int totalResults = classicView.getResultCount();
        Assert.assertEquals(expectedTotal, totalResults);
    }
}
