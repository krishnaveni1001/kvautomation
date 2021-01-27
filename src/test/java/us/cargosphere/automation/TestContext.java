package us.cargosphere.automation;

import org.openqa.selenium.WebDriver;
import us.cargosphere.automation.managers.PageObjectManager;
import us.cargosphere.automation.util.BrowserUtil;

import java.util.concurrent.TimeUnit;

/**
 * TestContext stores state that is shared throughout a single test.
 * 
 * This context can be used to share state across multiple Cucumber
 * StepDefinitions.
 */
public class TestContext {
    private PageObjectManager pageObjectManager;
    ScenarioContext scenarioContext;

    public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public TestContext() {
        pageObjectManager = new PageObjectManager(BrowserUtil.getInstance().getWebDriver());
        scenarioContext = new ScenarioContext();
    }

    /**
     * Retrieves the test's {@link PageObjectManager}
     */
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}