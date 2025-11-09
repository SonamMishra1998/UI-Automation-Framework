package com.ui.testscripts;

import static com.ui.utility.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.dataProviders.LoginDataProvider;
import com.ui.pages.HomePage;
import com.ui.pojos.Users;
import com.ui.utility.LoggerUtil;
import com.ui.utility.constants.Environment;
import com.ui.utility.readers.PropertyReader;
@Listeners({com.ui.listeners.TestListener.class})
public class loginTest {
	HomePage home;
	Logger logger=LoggerUtil.getlogger(this.getClass());

	@BeforeTest
	public void setUp() {
		PropertyReader.setProperties(Environment.QA );

		home = new HomePage(CHROME);
	}

//	@Test(description = "This test Method is used to verify the valid user able to login into the application", groups = {
//			"smoke", "sanity", "regression" },dataProviderClass=LoginDataProvider.class,dataProvider="login")
//
//	
//	public void login(Users user) {
//	
//	assertEquals(home.signIn().login(user.getUsername(), user.getPassword()).verifyName(),"Sonam mishra");
//
//	
//	}
	@Test(description = "This test Method is used to verify the valid user able to login into the application", groups = {
			"smoke", "sanity",
			"regression" }, dataProviderClass = LoginDataProvider.class, dataProvider = "loginCSVDataProvider",retryAnalyzer=com.ui.listeners.RetryAnalyzer.class)

	public void loginwithCsvData(Users user) {
	//	logger.info("start in login test");

		home = new HomePage(CHROME);
		assertEquals(home.signIn().login(user.getUsername(), user.getPassword()).verifyName(), "Sonam mishra");
	//	logger.info("end in login test");
	}

}
