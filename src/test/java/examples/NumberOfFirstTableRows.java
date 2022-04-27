package examples;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class NumberOfFirstTableRows {
	WebDriver driver;


	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");

	}

	@Test
	public void clickSortableDataTableslink() {
		WebElement tableLink = driver.findElement(By.linkText("Sortable Data Tables"));
		tableLink.click();
	}

	@Test
	public void getFirstTableRowsNumber() {
		WebElement firstTableNumbers = driver.findElement(By.id("table1"));
		List<WebElement> numberofRows = firstTableNumbers.findElements(By.tagName("tr"));
		System.out.println("the number of rows  = "+numberofRows.size());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
