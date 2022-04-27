package examples;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindows {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
	}
	@Test(priority = 1)
	public void testWindowUsingTitle() {
		//Store window of parent window
		String CurrentWindowID = driver.getWindowHandle();
		WebElement visitBtn = driver.findElement(By.id("visitbutton"));
		visitBtn.click();
		for(String windowID : driver.getWindowHandles()) {
			String windowTitle =	driver.switchTo().window(windowID).getTitle();
			if(windowTitle.equals("Visit Us")) {
				Assert.assertEquals("Visit Us", driver.getTitle());
				//write any code here in visit us page as you want
				System.out.println(driver.getTitle());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(CurrentWindowID);
	}

	@Test(priority = 2)
	private void testWindoUsingName() {
		//Store window of parent window
		String CurrentWindowID = driver.getWindowHandle();
		WebElement helpBtn = driver.findElement(By.id("helpbutton"));
		helpBtn.click();
		driver.switchTo().window("HelpWindow");
		assertEquals("Help", driver.getTitle());
		//write any code here in visit us page as you want
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(CurrentWindowID);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
