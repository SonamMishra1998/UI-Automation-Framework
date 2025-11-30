package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.ui.pojos.LoginTestData;
import com.ui.pojos.Users;
import com.ui.utility.readers.CsvReader;

import org.testng.annotations.DataProvider;
public class LoginDataProvider {
	
     @DataProvider(name="login")
     
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		String filePath = System.getProperty("user.dir") + File.separator + "test-data" + File.separator
				+ "loginData.json";

		LoginTestData data = null;
		try {
			data = gson.fromJson(new FileReader(filePath), LoginTestData.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {

			e.printStackTrace();
		}

		List<Object[]> loginData = new ArrayList<Object[]>();
		for (Users user : data.getData()) {

			loginData.add(new Object[] { user });
		}

		return loginData.iterator();

	}
	@DataProvider(name="loginCSVDataProvider")
	
	public Iterator<Users> loginCsvDataProvider( )
	{
	return	CsvReader.readCsvFile("loginData");
		
	}
	
	
	
}