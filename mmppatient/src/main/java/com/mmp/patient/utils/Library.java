package com.mmp.patient.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Library {

	static WebDriver driver;
	

	public static void takeScreenShots(WebDriver driver  ){

		TakesScreenshot  sh= (	TakesScreenshot)driver;
		//temp location for the screenshot
		File source	=sh.getScreenshotAs(OutputType.FILE);

		//will copy from source and patse it at the dest i.e screenshots folder
		//creates a calender
		Calendar cal= Calendar.getInstance();
		try {
			FileUtils.copyFile(source, new File("./screenShots/"+cal.getTimeInMillis()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("screenshot taken "+ e.getMessage());
		}
		//File destFile=new File("opemmrs"+cal.getTimeInMillis()+".jpg");
		//	FileUtils.copyFile(fs, destFile);
	}

}

