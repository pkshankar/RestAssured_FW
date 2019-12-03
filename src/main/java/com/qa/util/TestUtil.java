package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

	public static String[][] readDataExcel(String fileName, String sheetName) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			int lastRowNum = sh.getLastRowNum();
			data = new String[lastRowNum][sh.getRow(0).getLastCellNum()];
			for (int rwCnt = 0; rwCnt < lastRowNum; rwCnt++) {
				for (int clCnt = 0; clCnt < sh.getRow(rwCnt).getLastCellNum(); clCnt++) {

					data[rwCnt][clCnt] = sh.getRow(rwCnt + 1).getCell(clCnt).getStringCellValue();

				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

}
