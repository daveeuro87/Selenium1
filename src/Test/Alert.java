package Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alert {
	
	@Test
	public void handleAlert() throws InterruptedException{
		
		Logger logger = Logger.getLogger("Alert");
		PropertyConfigurator.configure("Log4j.properties");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ksrtc.in/");
		logger.info("App launched");

		driver.manage().window().maximize();
		logger.info("Browser maximized");

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/form/div[8]/a/font")).click();
		logger.info("Click search button");

		Thread.sleep(2000);
		
		String actual_msg = driver.switchTo().alert().getText();
		logger.info("Capture alert text");

		System.out.println("The alert message is : " +actual_msg);
		driver.switchTo().alert().accept();
		logger.info("Accept alert window");
		
		String expected_msg = "'From' place is required.";
		Assert.assertEquals(actual_msg, expected_msg);
		logger.info("Comparing actual & expected result");

		driver.quit();
	}

}
