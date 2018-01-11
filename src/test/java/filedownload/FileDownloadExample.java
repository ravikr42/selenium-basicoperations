package filedownload;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.ravi.config.BrowserConfig;

public class FileDownloadExample {
	WebDriver driver;
	private static final String downloadPath = System.getenv("user.dir")+File.separator+"filedownload"+File.separator;
	public static FirefoxProfile FirefoxDriverProfile() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", downloadPath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		return profile;
	}

	@Test
	public void testDownload() throws Exception {
//		
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability(FirefoxDriver.PROFILE, FirefoxDriverProfile());
		System.setProperty(BrowserConfig.FF_SYS_KEY, BrowserConfig.FF_DRIVER_PATH);
		driver = new FirefoxDriver(new FirefoxOptions().setProfile(FirefoxDriverProfile()));	
		driver.manage().window().maximize();
		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
		driver.findElement(By.linkText("smilechart.xls")).click();
	}

}
