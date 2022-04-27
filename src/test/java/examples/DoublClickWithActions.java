package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoublClickWithActions {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}

	@Test
	public void DoubleClickTest() {
		WebElement messageBox = driver.findElement(By.id("message"));

		// the message background color is rgba(0, 0, 255, 1)
		Assert.assertEquals("rgba(0, 0, 255, 1)", messageBox.getCssValue("background-color"));
		Actions builder = new Actions(driver);

		builder.doubleClick(messageBox).perform();
		//the essagebox background after doubleClick is rgba(255, 255, 0, 1)
		//System.out.println(messageBox.getCssValue("background-color"));
		Assert.assertEquals("rgba(255, 255, 0, 1)", messageBox.getCssValue("background-color"));
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
