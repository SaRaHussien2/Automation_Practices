package examples;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinkInThePage {
	WebDriver driver; 
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");
	}
	@Test
	public void getAllLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		assertEquals(46, links.size());

		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
