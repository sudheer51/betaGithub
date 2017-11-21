package dummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SingleTon {
	 
	static WebDriver driver;
	private SingleTon()
	{	 
	}
	public static WebDriver getDriverInstance()
	{
		if(driver==null)
		{
			System.out.println("Creating instance");
			 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();		  
		}
	 
		return driver;
	}
	public static void deactivateDriverInstance()
	{
		driver.quit();
		driver=null;
	}
}
