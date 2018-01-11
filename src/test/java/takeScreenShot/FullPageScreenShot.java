package takeScreenShot;

import static com.ravi.config.BrowserConfig.CHROME_DRIVER_PATH;
import static com.ravi.config.BrowserConfig.CHROME_SYS_KEY;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ravi.config.StringUtil;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullPageScreenShot {
	private static final String SCRN_SHOT_DIR = System.getProperty("user.dir")+File.separator+"screenshot"+File.separator;
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		System.setProperty(CHROME_SYS_KEY, CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test(testName = "fullPageScreenShotTest")
	public void fullPageScreenShotTest()throws Exception{
		driver.get("http://www.flipkart.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("html/body/div[2]/div/div/button")).click();
		Thread.sleep(2000);
//		WebElement element = driver.findElement(By.xpath("//*[@id='container']/div/footer/div/div[5]/div/div/div/h2"));
//		System.out.println("Element Displayed: "+element.isDisplayed());
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		int yPosition = element.getLocation().getY();
//		js.executeScript("window.scroll(0, "+yPosition+") ");
//		Thread.sleep(3000L);
		
		Screenshot screenshot = new AShot().
				shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(SCRN_SHOT_DIR, 
				"Full_Ashot_"+StringUtil.getCurrentTimeStamp()));
		
//		File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(imageFile, new File(SCRN_SHOT_DIR, "Full"+StringUtil.getCurrentTimeStamp()+".png"));
		
//		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//		ImageIO.write(image, "png", new File(SCRN_SHOT_DIR, "Full_"+StringUtil.getCurrentTimeStamp()+".png")); 
		
		
		
	}
}
