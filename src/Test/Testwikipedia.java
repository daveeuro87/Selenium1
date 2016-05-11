package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testwikipedia {
	
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		WebElement link;
		link = driver.findElement(By.linkText("English"));
		link.click();
		Thread.sleep(5000);
		WebElement searchBox;
		searchBox = driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("Software");
		searchBox.submit();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
