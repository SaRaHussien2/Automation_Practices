package examples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FindElementBytagName {
	WebDriver driver;


	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void openUrl() {

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("test", Keys.TAB);

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("test",Keys.TAB);;

		WebElement loginBtn = driver.findElement(By.tagName("Button"));
		loginBtn.click();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
