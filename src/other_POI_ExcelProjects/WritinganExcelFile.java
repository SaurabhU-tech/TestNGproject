package other_POI_ExcelProjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WritinganExcelFile {
//	https://www.geeksforgeeks.org/reading-writing-data-excel-file-using-apache-poi/

	public static <cellnum> void main(String[] args) {
		try (// Writing an Excel File
				/*
				Procedure: Writing a file using POI is very simple and involve the following steps:
		
					Create a workbook
					Create a sheet in the workbook
					Create a row in the sheet
					Add cells in the sheet
					Repeat steps 3 and 4 to write more data.
					Close the output stream.
				*/
				// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook()) {
			// Creating a blank Excel sheet
			XSSFSheet sheet = workbook.createSheet("student Details");
			
			// Creating an empty TreeMap of string and Object][]
			// type
			Map<String, Object[]> data = new TreeMap<String, Object[]>();
			
    // Writing data to Object[]
			// using put() method
			data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
			data.put("2", new Object[] { 1, "Pankaj", "Kumar" });
			data.put("3", new Object[] { 2, "Prakashni", "Yadav" });
			data.put("4", new Object[] { 3, "Ayan", "Mondal" });
			data.put("5", new Object[] { 4, "Virat", "kohli" });
			
    // Iterating over data and writing it to sheet
			Set<String> keyset = data.keySet();
 
			int rownum = 0;
			for (String key : keyset) {
				 
			    // Creating a new row in the sheet
			    Row row = sheet.createRow(rownum++);
 
			    Object[] objArr = data.get(key);
 
			    int cellnum = 0;
 
			    for (Object obj : objArr) {
 
			        // This line creates a cell in the next
			        //  column of that row
			    	org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);
			        if (obj instanceof String)
			            ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((String)obj);
 
			        else if (obj instanceof Integer)
			            ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((Integer)obj);
			    }
			    try {
			    	 
			        // Writing the workbook
			        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\asus\\Desktop\\StudentData.xlsx"));
			        workbook.write(out);
    
			        // Closing file output connections
			        out.close();
			        // Console message for successful execution of
			        // program
			        System.out.println("StudentData.xlsx written successfully on disk.");
			    }
    
			    // Catch block to handle exceptions
			    catch (Exception e) {
    
			        // Display exceptions along with line number
			        // using printStackTrace() method
			        e.printStackTrace();
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
