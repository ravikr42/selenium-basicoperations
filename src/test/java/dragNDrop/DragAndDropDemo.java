package dragNDrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserConfig;

public class DragAndDropDemo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty(BrowserConfig.CHROME_SYS_KEY, BrowserConfig.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test(testName="dragAndDrop")
	public void dragAndDrop(){
		driver.navigate().to("http://jqueryui.com/droppable/");
		driver.findElement(By.linkText("Themes")).click();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));

	}
	
	
	
	
	
}