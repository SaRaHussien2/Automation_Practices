package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToBottomUsingJavascript {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com");
	}

	@Test
	public void TestScrollWithJS() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4300)");
		WebElement amazonLogo =driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		Assert.assertTrue(amazonLogo.isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
