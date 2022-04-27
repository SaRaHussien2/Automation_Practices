package examples;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShots {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
	}

	@Test
	public void testScreenshot() {
		WebElement searchtxt  = driver.findElement(By.id("twotabsearchtextbox"));
		searchtxt.sendKeys("selenium webdriver books");
		searchtxt.submit();
		assertTrue(driver.getTitle().contains("selenium"));
	}

	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException 
	{
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			// create reference of TakesScreenShots
			TakesScreenshot ts = (TakesScreenshot)driver; 
			File source = ts.getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(source, new File("./Screenshots/"+ result.getName()+".png"));
		}
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
