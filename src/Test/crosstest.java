package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crosstest {
	
	WebDriver driver;
	@Test
	@Parameters("browser")
	public void verifytitle(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dave87\\Desktop\\Selenium\\chromedriver.exe" );
			driver = new ChromeDriver();
		}
		
		driver.get("http://www.wwe.fr/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.close();
	}
	
	
	
	
	

}
