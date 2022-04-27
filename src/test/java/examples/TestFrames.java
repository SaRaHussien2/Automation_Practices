package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFrames {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/Frames.html");
	}

	@Test
	public void TestWindoFrame() {
		driver.switchTo().frame("left");
		WebElement msg = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Left Frame", msg.getText());
		System.out.println(msg.getText());
		driver.switchTo().defaultContent();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
