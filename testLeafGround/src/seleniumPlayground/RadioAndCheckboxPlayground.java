package seleniumPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckboxPlayground {

	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating back
		driver.manage().window().maximize();

		// Navigating through a Radio Playground
		driver.get("http://www.leafground.com/pages/radio.html");

		// Selecting option
		driver.findElement(By.id("yes")).click();

		// Find default selected radio button
		boolean unChecked = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/div/div/input[1]"))
				.isSelected();
		boolean checked = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/div/div/input[2]"))
				.isSelected();
		System.out.println("Which option is selected default\nChecked: " + checked + "\nUnchecked: " + unChecked);

		// Select your age group (Only if choice wasn't selected)
		boolean Age1to20 = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/div/div/input[1]"))
				.isSelected();
		boolean Age21to40 = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/div/div/input[2]"))
				.isSelected();
		boolean AgeAbove40 = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/div/div/input[3]"))
				.isSelected();
		if ((Age1to20 & Age21to40 & AgeAbove40) == false)
			driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/div/div/input[1]")).click();

		
		
		// Into check boxes playground
		// Navigating through a check box Playground
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/section/section/div/ul/li/a/img")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div/ul/li[7]/a/img")).click();

		// Selecting multiple check boxes. Select the languages that you know.
		driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/input[3]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/input[4]")).click();
		
		// Verify the Selenium check box is selected or not
		boolean isChecked = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/input")).isSelected();
		System.out.println((isChecked == true) ? "Selenium is checked" : "Selenium is not checked");

		// DeSelect the checked items
		for (int i = 1; i <= 2; i++) {
			WebElement cbs1 = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/input[" + i + "]"));
			if (cbs1.isSelected())
				cbs1.click();
		}

		// Select all below checkboxes. Selecting without mentioning xpath for all the
		// element.
		for (int i = 1; i <= 6; i++) {
			WebElement cbs2 = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/input[" + i + "]"));
			if (cbs2.isSelected() == false)
				cbs2.click();
		}

	}

}
