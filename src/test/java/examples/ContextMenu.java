package examples;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextMenu {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
	}

	@Test
	public void testContextMenu() {
		WebElement clickMeBtn = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement editBtn = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
		Actions actionorbuilder = new Actions(driver);
		actionorbuilder.contextClick(clickMeBtn)
		.moveToElement(editBtn)
		.click().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		assertEquals("clicked: edit", alert.getText());
		alert.dismiss();

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
