package com.mmp.patient.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mmp.patient.config.DataProperties;

public class TestBase {

	public static WebDriver driver;


	public static WebDriver invokeBrowser(){
		DataProperties obj=new DataProperties(driver);
		if (obj.getBrowser().equals( "CH")){

			System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
			driver = new ChromeDriver();
		}

		else if (obj.getBrowser().equals( "FF")){

			System.setProperty("webdriver.gecko.driver","geckodriver.exe" );
			driver = new FirefoxDriver();
		}
		else if (obj.getBrowser().equals( "IE")){

			System.setProperty("webdriver.IEDriverServer.driver","IEDriver.exe" );
			driver= new InternetExplorerDriver();
		}

		return driver;
	}
	public   void getUrl(){
		DataProperties obj= new DataProperties(driver);
		driver.get( obj.getUrl());
		//driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

	}

	public  static void waitforElement(int timeOutInSeconds ,WebElement element ){
		WebDriverWait  wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  static void waitforElementToBeClickable( int timeOutInSeconds ,WebElement element ){
		WebDriverWait  wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void closeBrowser(){
		driver.quit();
	}
}
	

