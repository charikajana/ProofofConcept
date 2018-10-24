package com.qa.cleartrip.flightTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.cleartrip.baseutils.AppConstants;
import com.qa.cleartrip.baseutils.Base;
import com.qa.cleartrip.flights.FlightBookingPage;


public class FlightTest extends Base{
	WebDriver driver;
	FlightBookingPage flightbookingpage;
	
	@BeforeMethod
	public void flightbeforemethod(){
		driver=createdriverinstance_and_Launchbrowser();
		driver.get(AppConstants.URL);
		flightbookingpage=PageFactory.initElements(driver, FlightBookingPage.class);
	}
	
	@Test
	public void searchforflight(){
		flightbookingpage.search_for_demosticflights(driver);
	}

}
