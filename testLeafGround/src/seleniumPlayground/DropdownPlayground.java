package seleniumPlayground;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPlayground {

	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating back
		driver.manage().window().maximize();

		// Navigating through a Dropdown Hyperlink Playground
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		// Select training program using index
		WebElement webDropdown1= driver.findElement(By.id("dropdown1"));
		Select dropdown1 = new Select(webDropdown1);
		dropdown1.selectByIndex(3);
		
		// Select training program using text
		WebElement webDropdown2= driver.findElement(By.name("dropdown2"));
		Select dropdown2 = new Select(webDropdown2);
		dropdown2.selectByVisibleText("Appium");
		
		// Select training program using value
		WebElement webDropdown3= driver.findElement(By.id("dropdown3"));
		Select dropdown3 = new Select(webDropdown3);
		dropdown3.selectByValue("4");
		
		// Get the number of dropdown options
		WebElement webDropdown4= driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/select"));
		Select dropdown4 = new Select(webDropdown4);
		List<WebElement> listOfOptions = dropdown4.getOptions();
		System.out.println("The number of dropdown options: " + listOfOptions.size());
		
		// Using sendKeys to select
		WebElement webDropdown5= driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
		webDropdown5.sendKeys("Selenium");
		
		// Select training program using value
		WebElement webDropdown6= driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));
		Select dropdown6 = new Select(webDropdown6);
		dropdown6.selectByValue("4");
		dropdown6.selectByIndex(3);
		dropdown6.selectByVisibleText("Appium");
	}

}
