package com.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mmp.patient.utils.TestBase;

public class HomePage extends TestBase{

	WebDriver driver ;
    By home=  By.linkText("HOME");
    By patient=  By.xpath(".//*[@id='navigation']/li[2]/a")  ;               // inkText("Patient Login");
	By officeLogin = By.linkText("Office Login");
	By aboutus=  By.linkText("About Us");
	By contactus=  By.linkText("Contact Us");
	By pLogin=By.linkText("Login");
	By pRegister= By.linkText("Register");
	By login       = By.linkText("Login");
	By doctorLogin = By.linkText("Doctor Login");

	public  HomePage ( WebDriver  driver){
		this.driver=driver;
	}

	public HomePage clickHome (){
		driver.findElement(officeLogin).click();
		return this;
	}
	public void  clickPatient (){
	WebElement patientButton=driver.findElement(patient);
	TestBase.waitforElementToBeClickable( 90 ,patientButton );	
	patientButton.click();
	}
	
	public pLoginPage clickpLogin (){//does not work ...wont go to the end
		driver.findElement(pLogin).click();
		return new pLoginPage(driver);
		
	}
	public pRegisterationPage clickpRegister (){//does not work ...wont go to the end
		driver.findElement(pRegister).click();
		return new  pRegisterationPage(driver);
	}
	public HomePage clickOfficelogin (){//does not work ...wont go to the end
		driver.findElement(officeLogin).click();
		return this;
	}
	public HomePage clickAbout (){
		driver.findElement(aboutus).click();
		return this;
	}
	
	public HomePage clickContact (){
		driver.findElement(contactus).click();
		return this;
	}

	public adminLoginPage clickLogin(){
		driver.findElement(login ).click();
		return new adminLoginPage(driver);
	}
	
	public docLoginPage clickdoctorLogin(){
		driver.findElement(doctorLogin).click();
		return new docLoginPage(driver);
	}
	
	public pRegisterationPage navigateToPatientRegisterationPage(){
		clickPatient();
		clickpRegister();
		return new pRegisterationPage(driver);
	}
	
	
	public pLoginPage navigateToPatientLoginPage(){
		clickPatient();
		clickpLogin();
		return new pLoginPage( driver);
	}
	
	public void navigateToProviderLoginpage(){
		clickOfficelogin();
		clickdoctorLogin();
	}
}
		

