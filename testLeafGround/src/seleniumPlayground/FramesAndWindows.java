package seleniumPlayground;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAndWindows {
	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating maximize
		driver.manage().window().maximize();

		// Navigating to frames Playground
		driver.get("http://www.leafground.com/pages/frame.html");
		
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		
		// Finding frame1 in the page
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("Click")).click();
		
		// Back to default content
		driver.switchTo().defaultContent();
		
		// Finding frame2 in the page[Nested frame]
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(frame2);
		totalFrames += driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		
		// Back to default content
		driver.switchTo().defaultContent();
		
		// Final total no of frames
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@src='countframes.html']"));
		driver.switchTo().frame(frame3);
		totalFrames += driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("Total no of frames: "+totalFrames);
		
		
		
		
		
		
		
		
	}
}
