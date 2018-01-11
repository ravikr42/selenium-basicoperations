package com.ravi.config;

import java.io.File;

public final class BrowserConfig {
	
	public static final String BASE_PATH = System.getProperty("user.dir")+File.separator+"drivers"+File.separator;

    public static final String CHROME_SYS_KEY = "webdriver.chrome.driver";
    public static final String FF_SYS_KEY = "webdriver.gecko.driver";
    public static final String EDGE_SYS_KEY = "webdriver.edge.driver";
    public static final String IE_SYS_KEY = "webdriver.ie.driver";

    public static final String CHROME_DRIVER_PATH = BASE_PATH+"chromedriver.exe";
    public static final String IE_DRIVER_PATH = BASE_PATH+"IEDriverServer.exe";
    public static final String EDGE_DRIVER_PATH = BASE_PATH+"MicrosoftWebDriver15.exe";
    public static final  String FF_DRIVER_PATH = BASE_PATH+"geckodriver.exe";
}
