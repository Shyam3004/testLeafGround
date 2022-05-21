package seleniumPlayground;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesAndAlerts {

	public static void main(String[] args) {
		// Configuring the system properties of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/shyam/chromedriver/chromedriver");

		// Initializing the browser driver
		WebDriver driver = new ChromeDriver();

		// Navigating back
		driver.manage().window().maximize();

		// Navigating through a Table Playground
		driver.get("http://www.leafground.com/pages/table.html");
		
		// Finding number of columns in a table
		List<WebElement> noOfColumns = driver.findElements(By.xpath("//th"));
		System.out.println("No of columns: "+ noOfColumns.size());
		
		// Finding number of rows in a table
		List<WebElement> noOfRows = driver.findElements(By.xpath("//tr"));
		System.out.println("No of rows: "+ noOfRows.size());
		
		
		//Get the progress value of 'Learn to interact with Elements' text
		String percent = driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following-sibling::td[1]")).getText();
		System.out.println("Progress of Learn to interact with Elements: "+percent);
		
		// Check the vital task for the least completed progress.
		List<WebElement> leastPercents = driver.findElements(By.xpath("//td[2]"));
		List<Integer> perecentages = new ArrayList<Integer>();
		for (WebElement element : leastPercents) {
			String value = element.getText().replace("%", "");
			perecentages.add(Integer.parseInt(value));
		}
		
		int smallValue = Collections.min(perecentages);
		WebElement minVitalTask = driver.findElement(By.xpath("//td[normalize-space()='"+smallValue+"%']//following-sibling::td[1]"));
		minVitalTask.click();
		
		
		// Alerts playground
		// Navigating through a Alerts Playground
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/section/section/div/ul/li/a/img")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div/ul/li[9]/a/img")).click();
		
		// Click the button to display a alert box and click OK in Alert.
		driver.findElement(By.xpath("//button[contains(text(),'Alert Box')]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Click the button to display a alert box and click OK in Alert.
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
				
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.dismiss();
		
		// Click the button to display a prompt box and enter value and click OK.
		driver.findElement(By.xpath("//button[contains(text(),'Prompt Box')]")).click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("PSG CAS");
		promptAlert.accept();
		
		//Click the button to learn line-breaks in an alert.
		driver.findElement(By.xpath("//button[contains(text(),'Line Breaks?')]")).click();
		Alert lbAlert = driver.switchTo().alert();
		System.out.println(lbAlert.getText());
		promptAlert.accept();
		
		
	}

}
