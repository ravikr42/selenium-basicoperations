package dragNDrop;

import static com.selenium.configuration.BrowserConfig.CHROME_DRIVER_PATH;
import static com.selenium.configuration.BrowserConfig.CHROME_SYS_KEY;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropDemo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty(CHROME_SYS_KEY, CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public void dragAndDrop(WebElement source, WebElement destination){
		try {
			if(source.isDisplayed() && destination.isDisplayed()){
				Actions actions = new Actions(driver);
				actions.dragAndDrop(source, destination).build().perform();
			}else{
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page Document");
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			System.out.println("Element is not found in DOM Structure");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Error During drag and drop operation");
		}
		
	}
	
	@Test(testName="dragAndDropExample1")
	public void dragAndDropExample1(){
		driver.navigate().to("http://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));
		dragAndDrop(Sourcelocator, Destinationlocator);
		String actualText=driver.findElement(By.cssSelector("#droppable>p")).getText();
		Assert.assertEquals(actualText, "Dropped!");

	}
	
	
	
	
}
