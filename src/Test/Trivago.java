package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Trivago {
	
	@Test
	public void TrivagoSearch() throws InterruptedException{
	
	WebDriver driver = new FirefoxDriver();
	
	//Navigate to the website(French version)
	driver.get("http://www.trivago.fr");
	//Maximize the window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	String parent_window = driver.getWindowHandle();
	System.out.println("Before switching the title is "+driver.getTitle());
	
	//Search for the German city “Hamburg”
	driver.findElement(By.id("js_querystring")).sendKeys("Hamburg");
	driver.findElement(By.xpath(".//*[@id='js-dealform-suggest']/ul/li[1]")).click();
	driver.findElement(By.xpath(".//*[@id='js_dealform_querycenter']/div[3]/div[1]/span[2]")).click();
	Thread.sleep(5000);
	
	//Locate the second hotel from the result list
	WebElement hotel = driver.findElement(By.xpath("(//ul[@id='js_itemlist']/li)[2]"));
	System.out.println("The Second Hotel Name is :" +hotel.getText());
	String temp1 = hotel.getText();
	String parent_website = temp1.substring(0,8);
	System.out.println("The first 8 substrng is : " +parent_website);
	
	Thread.sleep(5000);

	//Click on the available offer of the second hotel
	List<WebElement> li = driver.findElements(By.xpath("//ul[@id='js_itemlist']//li[@title='Voir toutes les offres disponibles']"));	
	li.get(1).click();
	
	//Choose the third deal
	List<WebElement> offer = driver.findElements(By.xpath("//div[@class='deal_wrp js_deal_wrp js_co_deal']"));
	offer.get(2).click();
	
	Set<String> s1 = driver.getWindowHandles();
	Iterator<String> i1 = s1.iterator();
	
	//Switch to the partner website window and verify the titles
	while (i1.hasNext()) {
		String child_window = i1.next();
		
		if(!parent_window.equalsIgnoreCase(child_window))
		{
			driver.switchTo().window(child_window);
			Thread.sleep(10000);
			System.out.println("After switching the title is "+driver.getTitle());
			String temp2 = driver.getTitle();
			String partner_website = temp2.substring(0,8);
			System.out.println("The first 8 substrng is : " +partner_website);

			
			//Verifying the hotel name of the second hotel in result list is available on the partners website
			Assert.assertEquals(parent_website, partner_website);
			//Closing the partner website window
			driver.close();
		}
		
	}
	//Switch to Parent window
	driver.switchTo().window(parent_window);
	Thread.sleep(10000);
	//Quit the driver
	driver.quit();
}
}
