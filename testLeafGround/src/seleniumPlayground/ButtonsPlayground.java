package seleniumPlayground;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class ButtonsPlayground {

	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();
		
		//Navigating back
		driver.manage().window().maximize();
		
		// Navigating through a Leaf Hyperlink Playground
		driver.get("http://www.leafground.com/pages/Button.html");
		
		// Click button to travel home page
		driver.findElement(By.id("home")).click();
		
		//Navigating back
		driver.navigate().back(); 

		// Find position of button (x,y)
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Coordinates of an element: X = " + location.getX() +", Y = " +location.getY());
		
		// Find button color
		String btnColor = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("Color of the button is " + btnColor);
		
		
		// Find the height and width
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println("Height: " + size.getHeight() + ", Width: " + size.getWidth());
	}

}
