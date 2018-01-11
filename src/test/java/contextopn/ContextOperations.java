package contextopn;

import static com.selenium.configuration.BrowserConfig.CHROME_DRIVER_PATH;
import static com.selenium.configuration.BrowserConfig.CHROME_SYS_KEY;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextOperations {
WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty(CHROME_SYS_KEY, CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test(testName = "mouseHoverTest")
	public void mouseHoverTest()throws Exception{
		driver.get("http://amazon.in");
		WebElement shopByCategory = driver.findElement(By.id("nav-link-shopall"));
		WebElement echoAlexa = driver.findElement(By.xpath("//div[@id='nav-flyout-shopAll']/div[2]/span/span[@class='nav-text']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(shopByCategory);
		
		actions.moveToElement(echoAlexa);
//		actions.click().build().perform();
		
		WebElement echoDot = driver.findElement(By.
				cssSelector("div.nav-column nav-column-first>div.nav-panel>a"));
		actions.moveToElement(echoDot).click().build().perform();
		
		Thread.sleep(1500);
		
		
	}
}
