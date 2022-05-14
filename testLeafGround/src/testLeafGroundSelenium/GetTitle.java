package testLeafGroundSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {

	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");
		
		//Initializing the browser driver
		WebDriver driver = new ChromeDriver();
		
		//Navigating through a Google.co.in
		driver.get("https://www.google.co.in");
		
		//Initializing SearchBox WebElement to store
		WebElement SearchBox = driver.findElement(By.name("q"));
		
		//Search for Virat Kohli
		SearchBox.sendKeys("Virat Kohli"+Keys.ENTER);
		
		//Entering Wikipedia of Virat
		driver.findElement(By.linkText("Wikipedia")).click();
		
		//Getting title of final page and printing
		String title = driver.getTitle();
		System.out.println(title);
		//Closing the browser
		driver.close();
		
	}

}
