package examples;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCookies {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://magento-demo.lexiconn.com/");
	}

	@Test
	public void testCookies() {
		WebElement langageSelected = driver.findElement(By.id("select-language"));
		Select select = new Select(langageSelected);

		Assert.assertEquals("English", select.getFirstSelectedOption().getText());
		//Store cookie should be none (null)


		Cookie storeCookie = driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storeCookie);

		//select German language
		select.selectByVisibleText("German");
		//Store Cookie should be populated with selected country
		storeCookie=driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storeCookie.getValue());
		System.out.println(storeCookie.getValue());


		// Get all cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("totla number of cookies = "+cookies.size());
		Iterator<Cookie> itr=cookies.iterator();

		while(itr.hasNext()) {
			Cookie cookie = itr.next();
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getExpiry());
			System.out.println("\n");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
