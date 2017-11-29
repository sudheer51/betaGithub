package com.mmp.patient.exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int totalrow;
	int totalcoloumn;
	

	public  ExcelReader( String excelPath){
		//C:\\Users\\radpuri\\Documents\\MMptestadata\\testdatammp.xlsx
		//C:\Users\radpuri\Desktop\eclipse\workspace\mmppatient\
		//src\main\java\com\mmp\patient\exceldata\testdatammp.xlsx

		try {
			File f= new File(excelPath);
			FileInputStream fis = new FileInputStream(f);
			wb = new XSSFWorkbook( fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}	          

	@SuppressWarnings("deprecation")
	public  String getData (int sheetno , int row , int column)	{
		// give the sheet index
		sheet=	wb.getSheetAt(sheetno);
		//to get the particular column 
		cell = sheet .getRow(row).getCell(column);
		//if the cell value is string return string
		if (cell.getCellType()==Cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
			//if the cell value is numeric or formula convert and return string value
		} else if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()== Cell.CELL_TYPE_FORMULA)
		{
			String cellValue = String.valueOf(cell.getNumericCellValue());
			//if the numeric value is in date format then
			if (HSSFDateUtil.isCellDateFormatted(cell))
			{
				SimpleDateFormat dt =new SimpleDateFormat("mm/dd/yy");
				//Date date =cell.getDateCellValue();  
				//	cellValue  = dt.format(date);      OR
				return  String.valueOf(dt.format(cell.getDateCellValue()));
			} 
			else if (cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
				return String.valueOf(cell.getBooleanCellValue());
				//for blank value
			}
			else if (cell.getCellType()==Cell.CELL_TYPE_BLANK){
				return " " ;	

			}
		}
		/*String data = cell.getStringCellValue()    /??????
		 * return data;
		 */
		return null;

	}

	public int getRowCount( int sheetno){
		sheet=	wb.getSheetAt(sheetno);
		totalrow = sheet.getLastRowNum();	
		return totalrow;
	}

	public int getColoumnCount(int sheetno){
		sheet=	wb.getSheetAt(sheetno);
		totalcoloumn = sheet.getRow(0).getLastCellNum();
		return totalcoloumn;
	}
}
