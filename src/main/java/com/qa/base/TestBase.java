package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

import com.qa.location.FileLocation;

public class TestBase {

	public Properties prop;

	public void initialization() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(FileLocation.CONFIG_FILE_LOCATION);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
