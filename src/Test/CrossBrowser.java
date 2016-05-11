package Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	WebDriver driver;
	
    @Test
    @Parameters("browser")
	public void VerifyPagetitle(String browserName) 
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
             driver = new FirefoxDriver();
	}
		else if (browserName.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dave87\\Desktop\\Selenium\\chromedriver.exe");
			 driver = new  ChromeDriver();
		}
        else if (browserName.equalsIgnoreCase("IE")) {
        	 System.setProperty("webdriver.ie.driver", "C:\\Users\\Dave87\\Desktop\\Selenium\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}
		
	driver.get("https://www.redbus.in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	System.out.println(driver.getTitle());
	driver.close();
	
   }
}
