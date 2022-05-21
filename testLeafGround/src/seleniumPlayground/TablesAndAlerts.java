package seleniumPlayground;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		
		//
		//List<String>  =) driver.findElements(By.xpath("//td[2]"))).getText();
		List<WebElement> leastPercents = driver.findElements(By.xpath("//td[2]"));
		List<Integer> perecentages = new ArrayList<Integer>();
		for (WebElement element : leastPercents) {
			String value = element.getText().replace("%", "");
			perecentages.add(Integer.parseInt(value));
		}
		
		// Check the vital task for the least completed progress.
		int smallValue = Collections.min(perecentages);
		WebElement minVitalTask = driver.findElement(By.xpath("//td[normalize-space()='"+smallValue+"%']//following-sibling::td[1]"));
		minVitalTask.click();
	
	}

}
