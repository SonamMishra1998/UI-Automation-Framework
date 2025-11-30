package com.ui.testscripts;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.ui.utility.LambdaTestUtil;
import com.ui.utility.LoggerUtil;
import com.ui.utility.WebElementAction;
import com.ui.utility.constants.Browser;
import com.ui.utility.constants.Environment;
import com.ui.utility.readers.PropertyReader;

public class TestBase {
	protected HomePage home;
	Logger logger = LoggerUtil.getlogger(this.getClass());
	private boolean isLambdatest;
	private boolean isHeadless;
	private String browser;

	@Parameters({"browser","isLambdatest","isHeadless"})
	@BeforeMethod
	public void setUp(
			@Optional("CHROME")String browser,@Optional("true")boolean isLambdatest,@Optional("true") boolean isHeadless ,ITestResult result) {
		WebDriver lambdaDriver;
		this.browser=browser;
		this.isHeadless =isHeadless;
		this.isLambdatest =isLambdatest;
		if (isLambdatest) {
			logger.info("in testbase  before test");
			PropertyReader.setProperties(Environment.QA);
			lambdaDriver = LambdaTestUtil.intializeLambdaTestSession(result.getMethod().getMethodName(), Browser.valueOf(browser.toUpperCase()).toString());
			logger.info("lambda driver created");
			home = new HomePage(lambdaDriver);
			logger.info("in homePage end");
		} else {
			logger.info("in testbase  before test");
			PropertyReader.setProperties(Environment.QA);
			home = new HomePage( Browser.valueOf(browser.toUpperCase()));

		}
	}

	public WebElementAction getInstance() {
		return home;

	}

	@AfterMethod
	public void tearDown() {
		if (isLambdatest) {

			LambdaTestUtil.quitSession();
		}

	}
}