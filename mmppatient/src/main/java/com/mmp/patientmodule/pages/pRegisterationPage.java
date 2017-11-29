package com.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mmp.patient.utils.Library;
import com.mmp.patient.utils.TestBase;

public class pRegisterationPage  {
 WebDriver driver;
 
 
 
 By verifyText=By.xpath(".//span[@id='h12'][contains(text(),'PERSONAL DETAILS')]");
 By firstName= By.id("firstname");
 By lastName= By.id("lastname");
 By dOb = By.id("datepicker");
 By license=By.id("license");
 By ssnNo = By.id("ssn");
 By state= By.id("state");
 By city= By.id("city");
 By address= By.id("address");
 By zipcode= By.id("zipcode");
 By age= By.id("age");
 By height= By.id("height");
 By weight= By.id("weight");
 By pharmacy= By.id("pharmacy");
 By pharmacyAddress = By.id("pharma_adress");
 By email= By.id("email");
 By password= By.id("password");
 By username= By.id("username");
 By confirmpaswrd= By.id("confirmpassword");
 By securityQuestion = By.id("security");
 By securityAnswer= By.id("answer");
 By saveButton = By.name("register");
 By homeButton =By.linkText("HOME");
 
 public pRegisterationPage(WebDriver driver) {
	this.driver=driver;
	}

 public boolean verifyRegistrationPageText(){
	 WebElement text= driver.findElement(verifyText);
	return text.isDisplayed();
 }
 public pRegisterationPage setFirstName(String fName){
	 driver.findElement(firstName).clear();
	 driver.findElement(firstName).sendKeys(fName);
	 return this;
}
 public pRegisterationPage setLastName(String lName){
	 driver.findElement(lastName).clear();
	 driver.findElement(lastName).sendKeys(lName);
	 return this;
}
 
 public pRegisterationPage setdOb(String dofb){
	 driver.findElement(dOb).clear();
	 driver.findElement(dOb).sendKeys(dofb);
	 return this;
}
 public pRegisterationPage setLicenseNo(String lic){
	 driver.findElement(license).clear();
	 driver.findElement(license).sendKeys(lic);
	 return this;
}
 public void setSsnNo(String ssnno){
	 driver.findElement(ssnNo).clear();
	 driver.findElement(ssnNo).sendKeys(ssnno);
	
}
 public void setStateName(String pState){
	 driver.findElement(state).clear();
	 driver.findElement(state).sendKeys(pState);
	 
}
 public void setCityName(String pCity){
	 driver.findElement(city).clear();
	 driver.findElement(city).sendKeys(pCity);
	 
}
 public pRegisterationPage setAddress(String pAddress){
	 driver.findElement(address).clear();
	 driver.findElement(zipcode).sendKeys(pAddress);
	 return this;
}
 public pRegisterationPage setZipcodeno(String zip){
	 driver.findElement(zipcode).clear();
	 driver.findElement(zipcode).sendKeys(zip);
	 return this;
 }
 public void setAge(String pAge){
	 driver.findElement(age).clear();
	 driver.findElement(age).sendKeys(pAge);
 }
 public void setheight(String ht){
	 driver.findElement(height).clear();
	 driver.findElement(height).sendKeys(ht);
 }
 public void setWeight(String wt){
	 driver.findElement(weight).clear();
	 driver.findElement(weight).sendKeys(wt);
 }
 public void setEmailid(String pEmail){
	 driver.findElement(email).clear();
	 driver.findElement(email).sendKeys(pEmail);
 }
 public void setUsername(String Username){
	 driver.findElement(username).clear();
	 driver.findElement(username).sendKeys(Username);
 }
 public void setPassword(String Password ){
	 driver.findElement(password).clear();
	 driver.findElement(password).sendKeys(Password);
 }
 public void setConfirmpassword(String Confirmpassword ){
	 driver.findElement(confirmpaswrd).clear();
	 driver.findElement(confirmpaswrd).sendKeys(Confirmpassword);
 }
 public void setSecurityQuestion( String securityQ ){
	Select dropdown=new Select(driver.findElement(securityQuestion));
	dropdown.selectByVisibleText( securityQ);
 }
 public void setSecurityAnswer(String SecurityAnswer ){
	 driver.findElement(securityAnswer).clear();
	 driver.findElement(securityAnswer).sendKeys(SecurityAnswer);
 }
 public HomePage clickOnSaveButton( ){
	 WebElement saveButon =driver.findElement(saveButton);
	 TestBase.waitforElementToBeClickable(60, saveButon);
	 saveButon.click();
	 return new HomePage(driver);
 }
 //for asseration 
 public String verifyRegisterationAlert(){
	 String text= driver.switchTo().alert().getText();
	 Library.takeScreenShots(driver);
	 return text;
 }
 public HomePage registerPatient(String fName , String lName, String dofb, String lic , String ssnNo , String pState, String pCity,String pAddress,String zip , String pAge,String pharm, String pharmAdd ,String ht ,String wt,String pEmail,String Username,String Password,String Confirmpassword ,String securityQ,String SecurityAnswer ){
	 setFirstName( fName);
	 setLastName(lName);
	 setdOb(dofb);
	 setLicenseNo(lic);
	 setSsnNo(ssnNo);
	 setStateName( pState);
	 setCityName( pCity);
	 setAddress(pAddress);
	 setZipcodeno(zip);
	 setAge(pAge);
	 setPharmacy(pharm);
	 setPharmacyAddress(pharmAdd);
	 setheight(ht);
	 setWeight( wt);
	 setEmailid( pEmail);
	 setUsername(Username);
	 setPassword( Password );
	 setConfirmpassword( Confirmpassword );
	 setSecurityQuestion(  securityQ );
	 setSecurityAnswer(SecurityAnswer );
	return clickOnSaveButton( );
	// return new HomePage(driver);
 }

public void setPharmacyAddress(String pharmAdd) {
	driver.findElement(pharmacyAddress).clear();
	driver.findElement(pharmacyAddress).sendKeys(pharmAdd);
	
}

public void setPharmacy(String pharm) {
	driver.findElement(pharmacy).clear();
	driver.findElement(pharmacy).sendKeys(pharm);
	
}
 
 public boolean verifyHomeLinkpresent(){
	try {
		WebElement hButton =driver.findElement(homeButton);
		TestBase.waitforElement( 30, hButton);
		hButton.isDisplayed();
		 return true;
	} catch (Exception e) {
		return false;
	}
	 
 } 
 
}
