package examples;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmAndDismissAlert {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");
	}

	@Test(priority = 1)
	public void confirmAlert() {
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement message = driver.findElement(By.id("demo"));
		assertEquals("You Accepted Alert!", message.getText());
	}

	@Test(priority = 2)
	public void dismissAlert() {
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement message = driver.findElement(By.id("demo"));
		assertEquals("You Dismissed Alert!", message.getText());
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
