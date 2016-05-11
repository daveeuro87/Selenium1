package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ksrtc.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtretnDateRtrip")).click();
		Thread.sleep(5000);
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//td"));
		
		int total_node = dates.size();
		
		for(int i=0;i<total_node;i++)
		{
			String date = dates.get(i).getText();
	
		     if(date.equalsIgnoreCase("25"))
			{
				dates.get(i).click();
				break;
			}		
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
