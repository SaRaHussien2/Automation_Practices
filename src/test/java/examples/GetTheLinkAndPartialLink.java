package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTheLinkAndPartialLink {
	WebDriver driver; 
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void getlinkText() {
		WebElement linkText = driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(linkText.getAttribute("href"));
	}

	@Test
	public void getPartialLinkText() {
		WebElement partialLinkText = driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(partialLinkText.getAttribute("href"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
