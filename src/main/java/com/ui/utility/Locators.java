package com.ui.utility;

import org.openqa.selenium.By;

import com.ui.utility.constants.Locator;

public class Locators implements IDriverUtility{
	
	private Locators() {}
	
	public  static By locateElement(Locator loc,String path) {

	switch (loc)
	{
	case ID:
		
		return By.id(path);
		
		
	case NAME:
		
		return By.name(path);
		
	case TAGNAME:
		return By.tagName(path);
		
	case CLASSNAME:
		return By.className(path);
	case LINKTEXT:
		return By.linkText(path);
	case PARTIALLINKTEXT:
		return By.partialLinkText(path);
	case XPATH:
		return By.xpath(path);
	case CSS_SELECTOR:
		return By.cssSelector(path);
	default:
		System.out.println("Send wrong locator:"+loc);
		return null;
			
	}
	
	
}
}
