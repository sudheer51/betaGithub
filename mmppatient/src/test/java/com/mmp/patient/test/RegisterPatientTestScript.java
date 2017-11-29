package com.mmp.patient.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mmp.patient.exceldata.ExcelReader;
import com.mmp.patient.utils.Library;
import com.mmp.patient.utils.TestBase;
import com.mmp.patientmodule.pages.HomePage;
import com.mmp.patientmodule.pages.pRegisterationPage;

public class RegisterPatientTestScript  extends TestBase{

	WebDriver driver;
	@BeforeClass( description="set up the browser andlaunch the website")
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
	@Test(priority= 1, description ="Patient registeration with firstName ,LastName, address, city,state,ssnno,licenece,username, password and emailid")
	public void patientRegister( ){	
		try {
			ExcelReader er= new ExcelReader(System.getProperty( "user.dir"+"src\\main\\java\\com\\mmp\\patient\\exceldata\\testdatammp.xlsx"));;
			for ( int i=1;i<er.getRowCount(0); i++)
			{ 
				HomePage hPage=new HomePage(driver);
				hPage.	navigateToPatientRegisterationPage();

				pRegisterationPage rPage= new pRegisterationPage(driver);
				//pRegisterationPage rPage= hPage.registerPatient(); giving me error as this method is not on that page
				hPage=	rPage.registerPatient(er.getData(0, i,0 ),er.getData(0, i,1),er.getData(0,i,2),er.getData(0,i,3) ,er.getData(0,i,4),er.getData(0,i,5),er.getData(0,i,6),er.getData(0,i,7),er.getData(0,i,8),er.getData(0,i,9),er.getData(0,i,10),er.getData(0,i,11)
						,er.getData(0,i,12),er.getData(0,i,13),er.getData(0,i,14),
						er.getData(0,i,15),er.getData(0,i,16),er.getData(0,i,17),er.getData(0,i,18),er.getData(0,i,19));
				
				//verify registration is successful if the homebutton is present on the homepage
				
				boolean actual = rPage.verifyHomeLinkpresent();
				if(actual){
					Assert.assertTrue(true);
				}
				
				Library.takeScreenShots( driver);
			}
		} catch (Exception e) {
			Assert.fail(" Test case Failed :::"+ e.getMessage());
		}

	
}
}