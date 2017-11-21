package org.iit.openmrs.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Library 
{
	static WebDriver driver;
	public static WebElement   findElement(WebDriver driver, By locator,long timeinsecs)
	{
	     Wait wait = new FluentWait(driver).withTimeout(timeinsecs, TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS).
	    		 ignoring(NoSuchElementException.class);
	     WebElement e=(WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	     return e;
	     
	}

	public static WebDriver selectBrowser(String browser)
	{
//		switch(browser)
//		{
//
//		case (browser.equalsIgnoreCase("IE")):
//			break;
//		case (browser.equalsIgnoreCase("CH")):
//			break;
//		default:
//
//
//
//		}
		if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();		  
		}
		else if(browser.equalsIgnoreCase("CH"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();		  
		}
		return driver;

	}

	public static void geturl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	public static void captureScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot tsh=(TakesScreenshot)driver;
		//Strore in temp location
		File fs=tsh.getScreenshotAs(OutputType.FILE);
		//Copy the file from one location to another
		Calendar cal= Calendar.getInstance();

		File destFile=new File("opemmrs"+cal.getTimeInMillis()+".jpg");
		FileUtils.copyFile(fs, destFile);


	}
}
