package com.ui.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.dataProviders.LoginDataProvider;
import com.ui.pojos.Users;

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase {
//	@Test(description = "This test Method is used to verify the valid user able to login into the application", groups = {
//			"smoke", "sanity", "regression" },dataProviderClass=LoginDataProvider.class,dataProvider="login")
//
//	
//	public void login(Users user) {
//	
//	assertEquals(home.signIn().login(user.getUsername(), user.getPassword()).verifyName(),"Sonam mishra");
//
//	
//}
	@Test(description = "This test Method is used to verify the valid user able to login into the application", groups = {
			"smoke", "sanity",
			"regression" }, dataProviderClass = LoginDataProvider.class, dataProvider = "loginCSVDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)

	public void loginwithCsvData(Users user) {
		logger.info("start in login test");
		assertEquals(home.signIn().login(user.getUsername(), user.getPassword()).verifyName(), "Sonam mishra");
		logger.info("end in login test");
	}

}
