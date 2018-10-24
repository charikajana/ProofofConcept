package com.qa.cleartrip.flights;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.qa.cleartrip.baseutils.AppConstants;
import com.qa.cleartrip.baseutils.Base;
import com.qa.cleartrip.baseutils.ExcelUtil;



public class FlightBookingPage {
	
	private static Logger logger = Logger.getLogger("FlightBookingPage");	
	@FindBy(how = How.XPATH, using = "//a[text()='Flights']")	 
	public WebElement Flights_TAB;
	
	@FindBy(how = How.ID, using = "OneWay")	 
	public WebElement OneWay;
	
	@FindBy(how = How.NAME, using = "origin")	 
	public WebElement origin;
	
	@FindBy(how = How.ID, using = "ui-id-1")	 
	public WebElement OriginDropdown;
	
	@FindBy(how = How.NAME, using = "destination")	 
	public WebElement destination;
	
	@FindBy(how = How.ID, using = "DepartDate")	 
	public WebElement DepartDate;
	
	@FindBy(how = How.XPATH, using = "//a[text()='30']")	 
	public WebElement dateofJourney;
	
	@FindBy(how = How.ID, using = "Adults")	 
	public WebElement Adults;
	
	@FindBy(how = How.ID, using = "Childrens")	 
	public WebElement Childrens;
	
	@FindBy(how = How.ID, using = "infants")	 
	public WebElement infants;
	
	@FindBy(how = How.ID, using = "SearchBtn")	 
	public WebElement SearchBtn;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='listView flights']/li[1]/table/tbody[2]/tr[2]/td[3]/button")	 
	public WebElement SelectfirstFlight;
	
	public void search_for_demosticflights(WebDriver driver){
		try{
			ExcelUtil.setExcelFile(System.getProperty("user.dir")+AppConstants.Path_TestData + AppConstants.File_TestData,"Flights");
			Flights_TAB.click();
			logger.info("Clicked on Flight Tab");
			OneWay.click();
			logger.info("Clicked on OneWay Radio Button");
			origin.sendKeys(ExcelUtil.getCellData(1,2));
			logger.info("Entered Origin is :"+ExcelUtil.getCellData(1,2));
			destination.sendKeys(ExcelUtil.getCellData(1,3));
			logger.info("Entered destination is :"+ExcelUtil.getCellData(1,3));
			DepartDate.click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			logger.info("Clicked on DepartDate");
			dateofJourney.click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			logger.info("selected Feature date");
			Select sel=new Select(Adults);
			sel.selectByVisibleText("1");
			logger.info("Selected Adults");
			Base.captureScreenShot(driver);
			SearchBtn.click();
			Base.captureScreenShot(driver);
			logger.info("clicked on SearchBtn");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			SelectfirstFlight.click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			Base.captureScreenShot(driver);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	

	
	


}
