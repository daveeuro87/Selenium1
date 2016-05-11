package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Orbitz {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.orbitz.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("search.type.air")).click();
		driver.findElement(By.name("ar.rt.leaveSlice.orig.key")).sendKeys("CDG");
		driver.findElement(By.name("ar.rt.leaveSlice.dest.key")).sendKeys("MAD");
		driver.findElement(By.name("ar.rt.leaveSlice.date")).sendKeys("02/22/16");
		driver.findElement(By.name("ar.rt.returnSlice.date")).sendKeys("03/10/16");
		driver.findElement(By.name("search")).click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		/*String price =driver.findElement(By.xpath(".//*[@id='matrix']/div[1]/div/div/span")).getText();
		System.out.println("The lowest price is:" +price);
		driver.close();*/
	}

}
