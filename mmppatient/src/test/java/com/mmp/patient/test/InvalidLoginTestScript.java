package com.mmp.patient.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mmp.patient.exceldata.ExcelReader;
import com.mmp.patient.utils.Library;
import com.mmp.patient.utils.TestBase;
import com.mmp.patientmodule.pages.HomePage;
import com.mmp.patientmodule.pages.pLoginPage;

public class InvalidLoginTestScript extends TestBase {

	WebDriver driver;
	@BeforeClass( description="set up the browser andlaunch the website")
	public void setup (String browser ,String url){

		try{
			driver= TestBase.invokeBrowser();
			getUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//C:\Users\radpuri\Desktop\eclipse\workspace\mmppatient\  =system.getProperty( "user.dir"+
			//src\\main\\java\\com\\mmp\\patient\\exceldata\\testdatammp.xlsx
	
	@Test(priority= 4, description ="Patient signin with invalid username and password")
	public void patientLoginwithinvalidcredentials (  ){
		ExcelReader er= new ExcelReader(System.getProperty( "user.dir"+"src\\main\\java\\com\\mmp\\patient\\exceldata\\testdatammp.xlsx"));
		for( int i =1; i<er.getRowCount(0);i++){
			
		  HomePage hPage=new HomePage(driver);
		  hPage.navigateToPatientLoginPage();
		  pLoginPage pLogin= new pLoginPage(driver);
		 pLogin.loginAs( er.getData(0, i, 0) , er.getData(0, i, 1));
		Assert.assertEquals(pLogin.invadminLoginText(),"Wrong username and password. ");
	Library.takeScreenShots( driver);
	}
	}
	}


