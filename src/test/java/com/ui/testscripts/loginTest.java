package com.ui.testscripts;

import static com.ui.utility.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.dataProviders.LoginDataProvider;
import com.ui.pages.HomePage;
import com.ui.pojos.Users;

public class loginTest {
	HomePage home;

	@BeforeTest
	public void setUp() {
		// setProperties(Environment.QA );

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
		System.out.println("start in login test");
		home = new HomePage(CHROME);
		assertEquals(home.signIn().login(user.getUsername(), user.getPassword()).verifyName(), "Sonam mishra");

	}

}
