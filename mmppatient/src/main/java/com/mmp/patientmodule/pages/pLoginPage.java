package com.mmp.patientmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mmp.patient.config.DataProperties;
import com.mmp.patient.utils.TestBase;

public class pLoginPage  {

	WebDriver driver;

	By username= By.id("username");
	By password=By.id("password");
	By forgotpaswordLink= By.xpath(".//*[@id='login']//p[4]/a");
	By signInButton =By.name("submit");
	By registerButton = By.linkText("REGISTER");
	//By verifyloginPageText =By.xpath(".//*[@id='h12'][contains(text(),'Patient Login')]");
	By homeButton =By.linkText("HOME");
	
	public pLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void setUsername(String Username){
		//DataProperties obj=new DataProperties(driver);
		//DataProperties.getusername();
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(Username);
	}
	public void setPassword( String Password){
		//DataProperties obj=new DataProperties(driver);
		//DataProperties.getpassword( );
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(Password);
	}
		
	public ForgetPasswordPage clickonForgotUsernamepasswordLink( ){
		driver.findElement(forgotpaswordLink).click();
		return new ForgetPasswordPage(driver);
	}
	public void clickOnsigninbutton(){
		driver.findElement(signInButton).click();
	}
	public pRegisterationPage clickOnregisterbutton(){
		driver.findElement(registerButton).click();
		return new pRegisterationPage(driver);
	}
	/*public boolean verifyLoginPageText(){
		try {
			WebElement text= driver.findElement(verifyloginPageText);
			TestBase.waitforElement(30,text);
			 text.isDisplayed();
			 return true;
		} catch (Exception e) {
			return false;
		}
	}*/

	public PatientPortalPage loginAs(String Username,String Password){
		setUsername(Username);
		setPassword( Password );
		clickOnsigninbutton();
     return new PatientPortalPage(driver);
	}
	public String invadminLoginText() {
			Alert alert=driver.switchTo().alert();
			String alertMessage= driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			alert.accept();
			return alertMessage;
		}
	
	public boolean verifyHomeLink( ){
	
	try {
		WebElement homeLink=	driver.findElement(homeButton);
		TestBase.waitforElement(30,homeLink );
		homeLink.isDisplayed();
		return true;
	} catch (Exception e) {
		return false;
	}
	
	}
	
	}

