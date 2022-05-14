package seleniumPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldPlayground {

	public static void main(String[] args) {
		// Configuring the system properties of Chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating through a Leaf Hyperlink Playground
		driver.get("http://www.leafground.com/pages/Edit.html");

		// Entering email in the text box
		driver.findElement(By.id("email")).sendKeys("sshyam.sundar@yahoo.com");

		// Append a text in a text box and press keyboard tab
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"))
				.sendKeys("Done" + Keys.TAB);

		// Get default text entered in a text box
		String defaultText = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(defaultText);

		// Clear the text inside text box
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input")).clear();

		// Confirm that Text box is disabled
		boolean TBenabled = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"))
				.isEnabled();
		System.out.println("Text box enabled? " + TBenabled);

	}
}
