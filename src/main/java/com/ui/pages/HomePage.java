package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.Locators;
import com.ui.utility.WebElementAction;
import com.ui.utility.constants.Browser;
import com.ui.utility.constants.Environment;
import com.ui.utility.constants.Locator;
import com.ui.utility.readers.JsonReader;


public final class  HomePage extends WebElementAction {
	private Browser browser;	
	WebDriver driver;
	public HomePage(Browser browser) {
		super(browser);
		this.browser=browser;
		//WebDriver wd = WebElementAction(browser);
		
		getUrl(JsonReader.getURL(Environment.QA),wd);
		maximizeWindow(wd);
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		//WebDriver wd = WebElementAction(browser);
		
		getUrl(JsonReader.getURL(Environment.QA),wd);
		maximizeWindow(wd);
	}


	public LoginPage signIn() { //pageFunctions 

		By getElement = Locators.locateElement(Locator.XPATH, "//a[contains(text(),'Sign in')]");
		clickOn(getElement);
		return new LoginPage(driver);
	}

	

}
