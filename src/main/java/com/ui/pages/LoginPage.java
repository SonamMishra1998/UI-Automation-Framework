package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.Locators;
import com.ui.utility.WebElementAction;
import com.ui.utility.constants.Browser;
import com.ui.utility.constants.Locator;

public class LoginPage extends WebElementAction {
	private Browser browser;
	private WebDriver driver;
	public LoginPage(Browser browser) {
		super(browser);
		this.browser=browser;
	
	}
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	
	}

	
	public AccountPage login(String emailAddress,String  password)
	{
		System.out.println("email"+emailAddress);
		//System.out.println("email"+emailAddress);
		
		By getElementEmail = Locators.locateElement(Locator.ID, "email");
		sendValue(getElementEmail, emailAddress);
		By getElementpasswd = Locators.locateElement(Locator.ID, "passwd");
		sendValue(getElementpasswd, password);
		By getElementSubmit = Locators.locateElement(Locator.ID, "SubmitLogin");
		clickOn(getElementSubmit);
		return new AccountPage(driver);
	}
	
	
	



	
}
