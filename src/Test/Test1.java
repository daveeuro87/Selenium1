package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
	
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtSource")).sendKeys("Delhi");
		driver.findElement(By.id("txtDestination")).sendKeys("Mumbai");
		driver.findElement(By.id("txtOnwardCalendar")).click();
		driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr[6]/td[3]")).click();
		driver.findElement(By.id("txtReturnCalendar")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='rbcal_txtReturnCalendar']/table[2]/tbody/tr[5]/td[2]")).click();
		driver.findElement(By.id("searchBtn")).click();
		
		Thread.sleep(10000);
		driver.close();
	}

}
