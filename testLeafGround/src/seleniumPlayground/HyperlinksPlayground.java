package seleniumPlayground;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperlinksPlayground {

	public static void main(String[] args) {

		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating through a Leaf Hyperlink Playground
		driver.get("http://www.leafground.com/pages/Link.html");

		// Click on Home Page link using linkText
		driver.findElement(By.linkText("Go to Home Page")).click();

		// Navigating back
		driver.navigate().back();

		// Find where This link supposed to go without clicking
		String dest = driver.findElement(By.partialLinkText("without clicking")).getAttribute("href");
		System.out.println("Link: Find where am supposed to go without clicking me? goes to " + dest);

		// Initializing HttpURLConnection and Verifying the page is broken or not
		HttpURLConnection huc = null;
		WebElement brokenLink = driver.findElement(By.linkText("Verify am I broken?"));
		String url = brokenLink.getAttribute("href");
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			int respCode = huc.getResponseCode();
			if (respCode >= 400) {
				System.out.println("The link is broken");
			} else {
				System.out.println("The link valid");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Click on Home Page link using XPath
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/a")).click();
		// Navigating back
		driver.navigate().back();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size() + " links in this page");
	}

}
