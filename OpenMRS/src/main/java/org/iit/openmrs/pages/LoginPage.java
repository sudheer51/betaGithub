package org.iit.openmrs.pages;

import java.io.IOException;

import org.iit.openmrs.utils.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private final WebDriver driver;//null
	int i ;//0
	public LoginPage(WebDriver driver) 
	{
		this.driver= driver;
	}
	By uname = By.id("username");
	By pword = By.id("password");
	By patientWard = By.id("Inpatient Ward");
	By login = By.id("loginButton");
	 
     
	
	public HomePage login(String username,String password) throws IOException
	{
		 
		//Enter username , password,select Inpatient ward and click on Login
		driver.findElement(uname).clear();
		driver.findElement(uname).sendKeys(username);
		Library.captureScreenshot(driver);
		
		driver.findElement(pword).clear();
		driver.findElement(pword).sendKeys(password);
		Library.captureScreenshot(driver);
		
		driver.findElement(patientWard).click();
		Library.captureScreenshot(driver);
		
        driver.findElement(login ).click();
        Library.captureScreenshot(driver);
        
        //Create an object
        HomePage hPage = new HomePage(driver);
        
        return hPage;
       
   
	}

}
