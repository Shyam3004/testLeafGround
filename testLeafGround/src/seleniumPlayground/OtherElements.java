package seleniumPlayground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OtherElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating maximize
		driver.manage().window().maximize();

		// Navigating to Auto complete Playground
		driver.get("http://www.leafground.com/pages/autoComplete.html");
		
		driver.findElement(By.id("tags")).sendKeys("a");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for (WebElement element : options) {
			if (element.getText().equals("Protractor")) {
				element.click();
				break;
			}
		}

	}

}
