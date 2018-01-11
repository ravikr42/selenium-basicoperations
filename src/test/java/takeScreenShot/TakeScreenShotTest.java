package takeScreenShot;

import static com.ravi.config.BrowserConfig.CHROME_DRIVER_PATH;
import static com.ravi.config.BrowserConfig.CHROME_SYS_KEY;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ravi.config.StringUtil;

public class TakeScreenShotTest {
	private static final String SCRN_SHOT_DIR = System.getProperty("user.dir")+File.separator+"screenshot"+File.separator;
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		System.setProperty(CHROME_SYS_KEY, CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public void getScreenShot() throws Exception{
		File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic, new File(SCRN_SHOT_DIR, "screenShot"+StringUtil.getCurrentTimeStamp()+".png"));
		
	}

	@Test(testName = "takeScreenShotTest")
	public void takeScreenShotTest(){
		driver.get("http://www.google.com");
		try {
			driver.findElement(By.id("testing")).sendKeys("test");
		} catch (Exception e) {
			System.out.println("Exception Occured");
			e.printStackTrace();
			try {
				getScreenShot();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		

	}

}
