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

public class PrompetAlert {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	@Test
	public void promptAlert() {
		WebElement promptBtn = driver.findElement(By.id("prompt"));
		promptBtn.click();
		Alert alert =driver.switchTo().alert();
		alert.sendKeys("sara");
		alert.accept();
		WebElement msg = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello sara! How are you today?", msg.getText());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
