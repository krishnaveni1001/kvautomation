package us.cargosphere.automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;

import us.cargosphere.automation.util.Flags;
import us.cargosphere.automation.util.OptionsUtil;

public class CucumberRunner {

	public static CommandLine cmd;

	private static final String PLUGIN_OPTION = "--plugin";

	public static void main(String[] args) throws Exception {
		cmd = OptionsUtil.parseCommand(args);
		String reportPath = cmd.getOptionValue(Flags.Long.REPORT_PATH);
		String[] commonArgs = { //
				"--glue", "us.cargosphere.automation", //
				PLUGIN_OPTION, "html:" + reportPath + "/cucumber-html-report", //
				PLUGIN_OPTION, "pretty:" + reportPath + "/cucumber-pretty-report", //
				PLUGIN_OPTION, "json:" + reportPath + "/cucumber-json-report.json" };

		List<String> cargs = new ArrayList<>();
		cargs.addAll(Arrays.asList(commonArgs));
		cargs.addAll(cmd.getArgList());
		cargs.add(cmd.getOptionValue(Flags.Long.FEATURE));
		try {
			System.out.println("Loading cucumber");
			System.out.println("Additional args passed to Cucumber CLI: " + cmd.getArgList().toString());
			cucumber.api.cli.Main.main(cargs.toArray(new String[cargs.size()]));
		} catch (Throwable e) {
			System.err.println("Failed to run tests: " + e.getMessage());
			e.printStackTrace();
		}
	}
}


