package demo.project;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	private static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			inIt();
			
		
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			inIt();
		}
		
	
		
	}
	
	public void inIt() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void closeBrowser()
	{	
	
		if(driver!= null) 
		{
			driver.close();
		}
	}
	
}
