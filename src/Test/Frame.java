package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Frame {
	
	@Test
	public void SwitchFrame(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.about.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String title = driver.switchTo().frame("google_ads_iframe_/479/abt.homepage/homepage_www/billboard_0").getTitle();
		System.out.println("The title is :" +title);
		driver.quit();
	}

}
