package com.ui.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.ui.utility.constants.Browser;

public class WebDriverUtility implements IDriverUtility {
	Logger logger = LoggerUtil.getlogger(this.getClass());
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getWebDriverInstance(Browser browser) {
		if (browser == Browser.CHROME) {
			driver.set(new ChromeDriver());
			return driver.get();
		} else if (browser == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			return driver.get();
		} else if (browser == Browser.EDGE) {
			driver.set(new EdgeDriver());
			return driver.get();
		} else if (browser == Browser.SAFARI) {
			driver.set(new SafariDriver());
			return driver.get();
		} else {
			logger.info("please enter correct browser value :" , browser);

		}
		return null;

	}

	public WebDriver getWebDriverInstance(Browser browser, boolean isHeader) {
		if (browser == Browser.CHROME) {
			if (isHeader) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new"); 
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {

				driver.set(new ChromeDriver());
			}
			return driver.get();
		} else if (browser == Browser.FIREFOX) {

			if (isHeader) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			} else {

				driver.set(new FirefoxDriver());
			}

			return driver.get();
		} else if (browser == Browser.EDGE) {

			if (isHeader) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {

				driver.set(new EdgeDriver());
			}

			return driver.get();
		}
		 else {
			logger.info("from headless ,please enter correct browser value :" , browser);

		}
		return null;

	}

	public static void getUrl(String url, WebDriver wd) {

		wd.get(url);

	}

	public static void maximizeWindow(WebDriver wd) {

		wd.manage().window().maximize();

	}

}
