package testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {	
	//i have to learn log4j topic
	//https://www.geeksforgeeks.org/reading-writing-data-excel-file-using-apache-poi/

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\asus\\Desktop\\LoginData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(1);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(1).getLastCellNum();
		
		System.out.println(rows);
		System.out.println(columns);
		
		String arr[][] = new String[rows+1][columns];
		for(int r = 0; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			
			for(int c = 0; c < columns; c++) {
				XSSFCell cell = row.getCell(c);
				
//				arr[r][c] = cell.getStringCellValue();
//				System.out.print(arr[r][c]+"  ");
//				System.out.println();
				
				switch(cell.getCellType())
				{
				case STRING:
					System.out.print(cell.getStringCellValue()+"  ");
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue()+"  ");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue()+"  ");
					break;
				default:
					break;
				}
			}
			System.out.println();
		}
		// Closing file output streams
//        file.close();
	}

}
