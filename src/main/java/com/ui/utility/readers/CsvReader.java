package com.ui.utility.readers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.Users;

public class CsvReader {

	public static Iterator<Users> readCsvFile(String fileName) {
		String[] csvLine;
		CSVReader csvReader;
		List<Users> userDetails = null;
		
		try {

			csvReader = new CSVReader(new FileReader(new File(
					System.getProperty("user.dir") + File.separator + "test-data" + File.separator + fileName+".csv")));
			csvReader.readNext();

			userDetails = new ArrayList<Users>();

			while ((csvLine = csvReader.readNext()) != null) {
				userDetails.add(new Users(csvLine[0], csvLine[1]));

			}

		} catch (IOException | CsvValidationException e) {

			e.printStackTrace();
		}
		return userDetails.iterator();

	}
}