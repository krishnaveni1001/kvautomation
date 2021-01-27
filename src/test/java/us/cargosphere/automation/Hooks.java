package us.cargosphere.automation;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import us.cargosphere.automation.util.BrowserUtil;

public class Hooks {

	@Before
	public void init() {
		BrowserUtil.getInstance();
	}

	@After
	public void closeBrowser() {
	BrowserUtil.close();
	}

}
