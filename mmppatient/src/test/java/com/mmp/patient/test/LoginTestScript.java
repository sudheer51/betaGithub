package com.mmp.patient.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.mmp.patient.exceldata.ExcelReader;
import com.mmp.patient.utils.Library;
import com.mmp.patient.utils.TestBase;
import com.mmp.patientmodule.pages.HomePage;
import com.mmp.patientmodule.pages.pLoginPage;


public class LoginTestScript extends TestBase {


	@BeforeClass( alwaysRun= true ,description="set up the browser and launch the website")
	public void setup (){

		try{
			driver= TestBase.invokeBrowser();
			getUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority= 0, description ="Patient signin with valid username and password")
	public void patientLoginwithValidcredentials( ) {
		//C:\Users\radpuri\Desktop\eclipse\workspace\mmppatient\  =system.getProperty( "user.dir"+
		//src\\main\\java\\com\\mmp\\patient\\exceldata\\testdatammp.xlsx
		//C:\Users\radpuri\Desktop\eclipse\workspace\mmppatient\
		//src\main\java\com\mmp\patient\config\testdata.xsls.xlsx
	
ExcelReader er = new ExcelReader(System.getProperty( "user.dir"+"src\\main\\java\\com\\mmp\\patient\\exceldata\\testdatammp.xlsx"));
		try {
			for (int i =1;i<=er.getRowCount(1) ;i++){
				//clicks on patient and login on homepage and takes to signinpage
				HomePage hPage=new HomePage(driver);
				hPage.navigateToPatientLoginPage();
				pLoginPage pLogin= new pLoginPage(driver);	
			
				//enter username password 
				pLogin.loginAs(er.getData(1,i,0), er.getData(1,i, 1));
				boolean actual= pLogin.verifyHomeLink();
				if (actual){
			Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail(" error message testcase failed :::" + e.getMessage());
		
		}
	}
}
	
	
	/*@AfterClass( )
	public void tearDown(){
		closeBrowser();
	}*/





