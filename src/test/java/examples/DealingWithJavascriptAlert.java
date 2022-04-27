package examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DealingWithJavascriptAlert {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	@Test
	public void showAlertBox() {

		WebElement alertBtn = driver.findElement(By.id("simple"));

		alertBtn.click();

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		Assert.assertEquals("Hello! I am an alert box!", alertText);
		alert.accept();

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
