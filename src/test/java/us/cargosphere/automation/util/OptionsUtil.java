package us.cargosphere.automation.util;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsUtil {

	static CommandLineParser parser = new DefaultParser();

	private static Options loadOptions() {
		Options options = new Options();
		options.addRequiredOption(Flags.Short.CHROME_DRIVER_PATH, Flags.Long.CHROME_DRIVER_PATH, true,
				"The fully qualified path to chromedriver");
		options.addRequiredOption(Flags.Short.FEATURE, Flags.Long.FEATURE, true, "The feature(s) to run");
		options.addRequiredOption(Flags.Short.BASE_URL, Flags.Long.BASE_URL, true, "The host name");
		options.addRequiredOption(Flags.Short.PROTOCOL, Flags.Long.PROTOCOL, true, "Either http or https");
		options.addRequiredOption(Flags.Short.REPORT_PATH, Flags.Long.REPORT_PATH, true, "The directory to write report output to");
		options.addOption(Flags.Short.UI_DATA_LOAD_PATH, Flags.Long.UI_DATA_LOAD_PATH, true, "The directory containing the UI Data load JSONS.");
		options.addOption(Flags.Short.HEADLESS, Flags.Long.HEADLESS, false, "Run chrome headless if true");
		options.addRequiredOption(Flags.Short.EMAIL_URL, Flags.Long.EMAIL_URL, true, "The email host name");
		return options;
	}

	public static CommandLine parseCommand(String[] args) {
		Options options = OptionsUtil.loadOptions();
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args, true);
		} catch (ParseException e) {
			System.err.println("Failed to parse arguments: " + e.getMessage());
			System.exit(1);
		}
		return cmd;
	}
}
