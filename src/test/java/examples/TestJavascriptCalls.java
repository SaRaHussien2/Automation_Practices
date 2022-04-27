package examples;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavascriptCalls {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@Test
	public void testJavaScriptCalls() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String title=(String) js.executeScript("return document.title");
		assertEquals("Google",title);
		System.out.println(title);
		long links = (Long)js
				.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		assertEquals(18,links);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
