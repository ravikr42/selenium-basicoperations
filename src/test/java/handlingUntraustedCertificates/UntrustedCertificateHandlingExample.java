package handlingUntraustedCertificates;

import static com.ravi.config.BrowserConfig.CHROME_DRIVER_PATH;
import static com.ravi.config.BrowserConfig.CHROME_SYS_KEY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UntrustedCertificateHandlingExample {
	
WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty(CHROME_SYS_KEY, CHROME_DRIVER_PATH);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver(caps);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test(testName="openApplication")
	public void openApplication() throws Exception{
		driver.get("https://cacert.org/");
		WebElement headingEle = driver.findElement(By.cssSelector(".story h3"));
		//Validate heading after accepting untrusted connection
		String expectedHeading = "Are you new to CAcert?";
		Assert.assertEquals(headingEle.getText(), expectedHeading);
		
		Thread.sleep(5000);
	}

}
