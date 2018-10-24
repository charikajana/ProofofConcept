package com.qa.cleartrip.browserfactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.cleartrip.loadproperties.LoadProperties;


public class BrowserFactory {
	public static WebDriver driver;
	public static String browserVersion = "";

	/**
	 * This method will open browser according to user argument passed
	 * 
	 * @param browser
	 * @return it will return the driver
	 */
	private static Logger logger = Logger.getLogger("BrowserFactory");

	public static WebDriver getbrowser(String browser) {
		switch (LoadProperties.getdesiredProperty(browser).toUpperCase()) {
		case "FIREFOX":
			driver = firefoxBrowser();
			break;
		case "CHROME":
			driver = chromebrowser();
			break;
		case "IE":
			driver = iEbrowser();
			break;
		default:
			driver = firefoxBrowser();
			break;

		}
		return driver;

	}

	public static WebDriver iEbrowser() {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability("ignoreProtectedModeSettings", true);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Initiated IE driver and registered with event listener..");
		return driver;
	}

	public static WebDriver chromebrowser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
		logger.info("Init chrome driver is completed..");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Initiated Chrome driver and registered with event listener..");
		return driver;
	}

	public static WebDriver firefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Initiated Firefox driver and registered with event listener..");
		return driver;
	}


}