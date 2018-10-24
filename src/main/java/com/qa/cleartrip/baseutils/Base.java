package com.qa.cleartrip.baseutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.cleartrip.browserfactory.BrowserFactory;

public class Base {
	WebDriver driver;

public WebDriver createdriverinstance_and_Launchbrowser(){
		try{
			driver=BrowserFactory.getbrowser(AppConstants.BROWSER);
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;		
	}
public static void captureScreenShot(WebDriver ldriver){
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/ScreenShots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}


}
