package com.ui.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ui.utility.constants.Browser;

public class LambdaTestUtil {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver intializeLambdaTestSession(String testname, String browser) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName",browser );
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "mishrasonam907");
		ltOptions.put("accessKey", "LT_3p3xLEEhJ9joQuXV3Bs5eTUR3jAG8oPa0PsPQBiCIX8hqXY");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testname);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitiesLocal.set(capabilities);
		WebDriver driver=null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		driverLocal.set(driver);
		
		return driverLocal.get();
	}
	
	
	public static void quitSession() {
		if(driverLocal.get()!=null)
		{
			driverLocal.get().quit();
		}
		
	}
	

}
