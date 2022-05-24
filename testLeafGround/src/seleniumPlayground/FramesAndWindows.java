package seleniumPlayground;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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

		System.out.println("Total no of frames: " + totalFrames);

		// Back to default content
		driver.switchTo().defaultContent();

		// Windows handling
		// Navigating through a Alerts Playground
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		driver.findElement(By.xpath("//img[@alt='Windows']")).click();

		String Parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[contains(text(),'Open Home Page')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();

		Set<String> child1 = driver.getWindowHandles();
		System.out.println("Number of windows opened: " + child1.size()); // Should return 4
		
		// Close all the windows except parent
		driver.findElement(By.xpath("//button[contains(text(),'Do not close me')]")).click();
		Set<String> childs = driver.getWindowHandles();
		for (String child : childs) {
			driver.switchTo().window(child);
			if (!child.equals(Parent))
				driver.close();
		}

		driver.switchTo().window(Parent);
		driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();
		// Wait for 2 new Windows to open and close it
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Set<String> childssss = driver.getWindowHandles();
		for (String child : childssss) {
			driver.switchTo().window(child);
			if (!child.equals(Parent))
				driver.close();
		}

	}
}
