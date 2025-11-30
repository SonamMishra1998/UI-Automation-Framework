package com.ui.utility.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.ui.pojos.Config;
import com.ui.utility.constants.Environment;

public class JsonReader {

	private static com.ui.pojos.Environment instance;

	

	private static void setUP(Environment env) {
		Gson gson = new Gson();
		String filePath = System.getProperty("user.dir") + File.separator + "config" + File.separator + "config.json";

		try {
			Config config = gson.fromJson(new FileReader(filePath), Config.class);

			instance = config.getEnvironment().get(env.name());

		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String getURL(Environment env) {
		setUP(env);
		return instance.getURL();
		

	}


}
