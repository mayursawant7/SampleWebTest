package com.crm.qa.util;

public class ExcelUtilTest {

	public static void main(String[] args) {
		Xls_Reader reader=new Xls_Reader("C:\\Users\\sawantm\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
		String sheetName="practice";
		String data = reader.getCellData(sheetName, 0, 2); //By row no.
		System.out.println(data);
		int rowCount=reader.getRowCount(sheetName);
		System.out.println("total rows: "+rowCount);
		reader.addColumn(sheetName, "Status");
		
		if(!reader.isSheetExist("Registration")) {
			reader.addSheet("Registration");
		}
		reader.setCellData(sheetName, "Status", 2, "Pass");
		System.out.println	(reader.getCellData(sheetName, "username", 3));  //by column name
		//reader.removeColumn("Registration", 0);
		System.out.println(reader.getCellData("Registration", "phoneNo", 2));
		System.out.println(reader.getCellData("Registration", "age", 2));
		
		

	}

}
