package prompts;

import static com.selenium.configuration.BrowserConfig.CHROME_DRIVER_PATH;
import static com.selenium.configuration.BrowserConfig.CHROME_SYS_KEY;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PromptsDemo {
	
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
	
	@Test(testName="alertBoxTest")
	public void alertBoxTest()throws Exception{
		driver.get(System.getProperty("user.dir")+File.separator+"webpages"+File.separator+"alerts.html");
		driver.findElement(By.xpath("//button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(5000);
	}
	
	@Test(testName="confirmationBoxTest")
	public void confirmationBoxTest() throws Exception{
		driver.get(System.getProperty("user.dir")+File.separator+"webpages"+File.separator+"confirmation.html");
		driver.findElement(By.xpath("//button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//p[2]")).getText());
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button")).click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[2]")).getText());
		Thread.sleep(3000);
	}
	
	@Test(testName = "promptBoxDemo")
	public void promptBoxDemo() throws Exception{
		driver.get(System.getProperty("user.dir")+File.separator+"webpages"+File.separator+"prompt.html");
		driver.findElement(By.xpath("//button")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.sendKeys("Ravi Kumar");
		Thread.sleep(500);
		alert.accept();
		Thread.sleep(1000);
		
	}
	
	

}

