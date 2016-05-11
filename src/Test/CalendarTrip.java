package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CalendarTrip {

	public static void main(String[] args) throws InterruptedException {

		Logger logger = Logger.getLogger("CalendarTrip");
		PropertyConfigurator.configure("Log4j.properties");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.tripadvisor.com/");
		logger.info("App start");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("searchbox")).sendKeys("Nice");
		driver.findElement(By.id("date_picker_in_1")).click();
		Thread.sleep(2000);
		
		List<WebElement> dates1 = driver.findElements(By.xpath("//div[@class='month'][@style='left: 0px;']//td"));
		int total_nodes1 = dates1.size();
		
		for(int i=0;i<total_nodes1;i++){
			
			String date = dates1.get(i).getText();
			if(date.equalsIgnoreCase("27")){
				dates1.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.id("date_picker_out_1")).click();
		Thread.sleep(2000);
		
		List<WebElement> dates2 = driver.findElements(By.xpath("//div[@class='month'][@style='left: 195px;']//td"));
		int total_nodes2 = dates2.size();
		
		for(int i=0;i<total_nodes2;i++){
			
			String date = dates2.get(i).getText();
			if(date.equalsIgnoreCase("5")){
				dates2.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.id("SUBMIT_HOTEL")).click();
		logger.info("Test Completed");

		Thread.sleep(5000);
		driver.quit();
	}

}
