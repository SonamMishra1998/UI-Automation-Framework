package com.ui.testscripts;
import static com.ui.utility.readers.PropertyReader.*;
import org.testng.annotations.*;
import com.ui.pages.HomePage;
import com.ui.utility.constants.Environment;

import static com.ui.utility.constants.Browser.*;
public class HomeTest {

	@BeforeMethod
	public void setUp()
	{
		setProperties(Environment.QA);
	}
	
	@Test
public void loginTest() {
		HomePage home=new HomePage(CHROME);
		home.signIn();

	}

}
