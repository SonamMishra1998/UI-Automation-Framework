package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ui.utility.readers.PropertyReader;

public class RetryAnalyzer implements IRetryAnalyzer{

	private static final int RETRY_COUNT= Integer.parseInt(PropertyReader.getProperties().getProperty("MAX_AlLOWED_RETRY"));
	int count=1;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<=RETRY_COUNT)
		{
			count++;
			
			return true;
		}
		return false;
	}

}
