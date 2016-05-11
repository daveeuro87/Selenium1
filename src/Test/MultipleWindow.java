package Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindow {
	
	
	@Test
	public void SwitchWindow() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dave87\\Desktop\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://accounts.google.com/SignUp?service=mail&continue=http%3A%2F%2Fmail.google.com%2Fmail%2Fe-11-14347447bd4f91e0ed1e14e80c258f9d-954454d96ab5283ddbc87675468e886d577f6fcf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String parent_window = driver.getWindowHandle();
		System.out.println("Before switching the title is "+driver.getTitle());
		
		driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();
		
		Set<String> s1 = driver.getWindowHandles();
		
		Iterator<String> i1 = s1.iterator();
		
		while (i1.hasNext()) {
			String child_window = i1.next();
			
			if(!parent_window.equalsIgnoreCase(child_window))
			{
				driver.switchTo().window(child_window);
				Thread.sleep(10000);
				System.out.println("After switching the title is "+driver.getTitle());
				
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parent_window);
		System.out.println("Back to parent window "+driver.getTitle());
		Thread.sleep(10000);
		driver.quit();
	}

}
