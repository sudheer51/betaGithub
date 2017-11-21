package org.iit.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private final WebDriver driver;
	By loginMsg = By.xpath(".//*[@id='home-container']/h4[contains(text(),'Logged in as Super User () at Inpatient Ward.')]");
	
	public HomePage(WebDriver driver) 
	{
		this.driver= driver;
	}
    public boolean fetchLoginMsg()
    {
    	  
        WebElement verifyText=driver.findElement(loginMsg);
        return verifyText.isDisplayed();
    }
}
