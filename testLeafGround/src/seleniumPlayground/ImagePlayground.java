package seleniumPlayground;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImagePlayground {
	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();
		
		//Navigating back
		driver.manage().window().maximize();
		
		// Navigating through a Leaf Hyperlink Playground
		driver.get("http://www.leafground.com/pages/Image.html");
		
		// Click Home image to travel home page
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img")).click();
		
		//Navigating back
		driver.navigate().back(); 
		
		//Initializing HttpURLConnection and Verifying the image is broken or not
		HttpURLConnection huc = null;
		WebElement brokenImg = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"));
		String url = brokenImg.getAttribute("src");
		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			int respCode = huc.getResponseCode();
			if(respCode >= 400){
				System.out.println("The image is broken");
			}
			else{
				System.out.println("The image is valid");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		// Click Home image to travel home page
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img")).click();
		
		
	}

}
