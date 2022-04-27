package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CheckBox {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
	}


	@Test(priority = 1)
	public void goToTheCheckboxPage() {
		WebElement checkboxLink = driver.findElement(By.linkText("Checkboxes"));
		checkboxLink.click();
	}

	@Test(priority = 2,enabled = false)
	public void checkTheBox()  {
		WebElement check1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		check1.click();
		WebElement check2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		if(check2.isSelected()) 
		{
			check2.click();
		}
	}

	//Test method to check an element's presence before performing any action on it
	// this test method instead of checkTheBox() test method
	@Test(priority = 3)
	public void checkElementIsPresent() {
		if(isElementPresent(By.xpath("//input[@type='checkbox'][1]"))) {
			WebElement check1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
			if(!check1.isSelected()) {
				check1.click();
			}
		}else  { 
			Assert.fail("The Checkbox isn't checked");
		}
	}
	// isElementPresent() method to check if an element is present on a page
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
