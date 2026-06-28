package com.framework.utilities;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVUtil {

	public static List<String[]> getData(String path) throws Exception {

		CSVReader reader = new CSVReader(new FileReader(path));

		return reader.readAll();
	}
}