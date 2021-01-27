package us.cargosphere.automation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.util.BrowserUtil;

public class BaseStepDefinitions {
	public TestContext testContext;

	public BaseStepDefinitions() {}

	public BaseStepDefinitions(TestContext context) {
		this.testContext = context;
	}

	public static final Map<String,String> envs = new HashMap<>();
	public static final Map<String,String> users = new HashMap<>();
	public static final Map<String,String> emailUsers = new HashMap<>();

	static {
		envs.put("qaauto", "qaauto123");
		envs.put("e-maeu", "e-maeu123");
		envs.put("demo", "democs123");
		
		users.put("qaauto_super", "pass");
		users.put("e-maeu_super", "pass");
		users.put("nvo", "test@1234");
		

	}
	protected WebDriver getDriver() {
		return BrowserUtil.getInstance().getWebDriver();
	}
}
