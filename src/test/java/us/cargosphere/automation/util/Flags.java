package us.cargosphere.automation.util;

public final class Flags {
	private Flags() {
	}

	public final class Long {
		private Long() {
		}

		public static final String BASE_URL = "base-url";
		public static final String CHROME_DRIVER_PATH = "chrome-driver-path";
		public static final String FEATURE = "features";
		public static final String HEADLESS = "headless";
		public static final String PROTOCOL = "protocol";
		public static final String UI_DATA_LOAD_PATH = "ui-data-load-path";
		public static final String REPORT_PATH = "report-directory-path";
		public static final String EMAIL_URL = "email-url";
	}

	public final class Short {
		private Short() {
		}

		public static final String BASE_URL = "u";
		public static final String CHROME_DRIVER_PATH = "d";
		public static final String FEATURE = "f";
		public static final String HEADLESS = "h";
		public static final String PROTOCOL = "p";
		public static final String UI_DATA_LOAD_PATH = "l";
		public static final String REPORT_PATH = "o";
		public static final String EMAIL_URL = "v";
	}
}