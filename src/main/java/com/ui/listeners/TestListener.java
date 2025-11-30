package com.ui.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.utility.ExtentReportUtil;
import com.ui.utility.LoggerUtil;
import com.ui.utility.WebDriverUtility;
import com.ui.utility.WebElementAction;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtil.getlogger(this.getClass());

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(result.getMethod().getGroups());
		ExtentReportUtil.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "----->" + "PASSED");
		ExtentReportUtil.getTest().log(Status.PASS, result.getMethod().getMethodName() + "----->" + "PASSED");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + "----->" + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtil.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "----->" + "FAILED");
		ExtentReportUtil.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		logger.info("Capturing the Screenshot!!!");
		Object  testClass=result.getInstance();
		WebElementAction webDriver=((com.ui.testscripts.TestBase)testClass).getInstance();
String path=webDriver.takeScreenShot(result.getMethod().getMethodName());
	
	ExtentReportUtil.getTest().addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + "------>" + "SKIPPED");
		ExtentReportUtil.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "----->" + "SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite started !!!!!");
		ExtentReportUtil.setUpSparkReport("test-report.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite ended !!!!!");
		ExtentReportUtil.flushReport();
	}

}
