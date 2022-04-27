package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTests {
	WebDriver driver; 
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
	}

	@Test 
	public void selectOptionFromDropDown() throws InterruptedException{
		WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
		dropdownLink.click();

		WebElement  getSelectMenu = driver.findElement(By.id("dropdown"));
		Select getOption= new Select(getSelectMenu);
		Assert.assertFalse(getOption.isMultiple());
		Assert.assertEquals(3, getOption.getOptions().size());
		getOption.selectByValue("1");
		//getOption.selectByIndex(1);
		//getOption.selectByVisibleText("Option 1");
		Assert.assertEquals("Option 1", getOption.getFirstSelectedOption().getText());
		Thread.sleep(3000);

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
