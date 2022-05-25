package seleniumPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalenderDragDropTooltip {

	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating maximize
		driver.manage().window().maximize();

		// Navigating to calendars Playground
		driver.get("http://www.leafground.com/pages/Calendar.html");

		// Selecting date
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'10')]")).click();

		// Drag and drop handling
		// Navigating to Drag and drop Playground
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		driver.findElement(By.xpath("//img[@alt='drop']")).click();


		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		action.clickAndHold(draggable).moveToElement(droppable).release(droppable).build().perform();

		// Drag and drop handling
		// Navigating to Drag and drop Playground
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		driver.findElement(By.xpath("//img[@alt='tooltip']")).click();
		
		String tooltip = driver.findElement(By.id("age")).getAttribute("title");
		System.out.println("Tooltip text: "+tooltip);
	}

}
