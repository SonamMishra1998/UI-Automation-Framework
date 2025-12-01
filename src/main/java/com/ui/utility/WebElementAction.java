package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.utility.constants.Browser;

public abstract class WebElementAction extends WebDriverUtility {
	WebDriverUtility driverUtil;
	
	
	
public WebDriver wd;
protected WebElementAction(Browser browser)

{
	logger.info("from browser constructor");
	driverUtil = new WebDriverUtility();
	wd=driverUtil.getWebDriverInstance(browser,true);

	
}
protected WebElementAction(WebDriver driver)

{logger.info("from driver constructor");
	
	wd =driver;

	
}

	
protected  void clickOn(By webelement) {
		
		wd.findElement(webelement).click();
		
	}
protected  void sendValue(By webelement, String value) {
		
		wd.findElement(webelement).sendKeys(value);
		
	
	}

protected String getTextValue(By webelement) {
	
	return wd.findElement(webelement).getText();
}
public String takeScreenShot(String name) {

	
	
	TakesScreenshot screenshot = (TakesScreenshot) wd;

	File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
	String timestamp = format.format(date);
	String path =  ".//screenshots//" + name + "." + timestamp + ".png";
	File screenshotFile = new File(path);
	try {
		FileUtils.copyFile(screenshotData, screenshotFile);
	} catch (IOException e) {
		e.printStackTrace();
	}

	return path;
}

}
	
//protected void waitForElement()
//WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//}
