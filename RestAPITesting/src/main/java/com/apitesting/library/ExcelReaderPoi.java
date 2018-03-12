package com.apitesting.library;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("rawtypes")
public class ExcelReaderPoi {
	public int index = 0;

	public interface RowHandler {
		boolean handleRow(Map rowMap);
	}

	public Workbook getWorkbook(String fileName) {
		Workbook newWorkbook = null;
		try {

			File file = new File(fileName);
			String fileName1 = file.getName();
			FileInputStream inputStream = new FileInputStream(file);
			String fileExtensionName = fileName1.substring(fileName1.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				newWorkbook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				newWorkbook = new HSSFWorkbook(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newWorkbook;

	}

	public void read(String fileName, String sheetName, RowHandler rowHandler) {
		List<String> headerValues = new ArrayList<String>();
		List<String> rowValues = null;
		try {
			FileInputStream file = new FileInputStream(new File(fileName));

			Workbook workbook = getWorkbook(fileName);
			Sheet sheet = workbook.getSheet(sheetName);

			Row rw = sheet.getRow(0);
			for (org.apache.poi.ss.usermodel.Row temp : sheet) {
				rowValues = new ArrayList<String>();

				for (int i = 0; i < rw.getLastCellNum(); i++) {
					if (temp.getRowNum() == 0) {
						String headerData;
						if (temp.getCell(i) != null) {
							headerData = temp.getCell(i).getStringCellValue();
						} else {
							headerData = null;
						}
						headerValues.add(headerData);
					} else {
						String rowData;
						if (temp.getCell(i) != null) {
							rowData = temp.getCell(i).getStringCellValue();
						} else {
							rowData = null;
						}
						rowValues.add(rowData);
					}
				}
				if (temp.getRowNum() == 0) {
					continue;
				}

				Map<String, String> rowMap = new HashMap<String, String>();
				for (int ixval = 0; ixval < rw.getLastCellNum(); ixval++) {
					if (ixval >= rowValues.size()) {
						break;
					}
					rowMap.put(headerValues.get(ixval), rowValues.get(ixval));
				}
				if (rowHandler.handleRow(rowMap))
					break;
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class RowObjectBuilder implements RowHandler {
		private Object[][] objs;

		public RowObjectBuilder(Object[][] objs) {
			this.objs = objs;
		}

		public boolean handleRow(Map row) {
			objs[index][0] = row;
			index++;
			return false;
		}
	}

	public Object[][] readFilenSheet(String fileName, String sheetName) throws Exception {
		Object[][] objArrays = new HashMap[500][1];
		Object[][] returnableArrays = null;
		int rowsCount = 0;
		read(fileName, sheetName, new RowObjectBuilder(objArrays));
		for (int rows = 0; rows < 500; rows++) {
			if (objArrays[rows][0] != null) {
				rowsCount++;
			}
		}
		returnableArrays = new HashMap[rowsCount][1];
		for (int rows = 0; rows < rowsCount; rows++) {
			returnableArrays[rows][0] = objArrays[rows][0];
		}
		return returnableArrays;
	}
}
