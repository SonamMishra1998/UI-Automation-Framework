package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.Locators;
import com.ui.utility.WebElementAction;
import com.ui.utility.constants.Browser;
import com.ui.utility.constants.Locator;

public class AccountPage extends WebElementAction {

	public AccountPage(Browser browser) {
		super(browser);
	}
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	public String verifyName() {
		By getUserName = Locators.locateElement(Locator.XPATH, "//a[@title=\"View my customer account\"]/span");

		return getTextValue(getUserName);

	}
}
