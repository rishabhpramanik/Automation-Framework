package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary{
	//This class will be use to read the data from Excel sheet
	public String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx";

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelLibrary() {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ExcelLibrary(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCellData(String sheetName,String colName,int rowNum){
		//If no data present in the sheet return blank string
		try{
			if(rowNum <=0)
				return "";

			//Getting the index of required sheet
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";

			//Getting the sheet index
			sheet = workbook.getSheetAt(index);

			//Pointing at the first row
			row = sheet.getRow(0);

			//Iterating from the first row to the last row containing data
			for(int i = 0; i < row.getLastCellNum(); i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}

			//If the column is not present then return blank string
			if(col_Num==-1)
				return "";

			//Getting the required sheet using the index
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row == null)
				return "";
			cell = row.getCell(col_Num);

			if(cell == null)
				return "";

			if(cell.getCellType().name().equals("STRING"))
				return cell.getStringCellValue();
			else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){
				//If the cell value is numeric or formula
				//Convert it into String
				String cellText  = String.valueOf(cell.getNumericCellValue());
				
				//If the cell data is a date, then format the value and then convert it into String
				if (DateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;
				}
				return cellText;
			}else if(cell.getCellType().name().equals("BLANK"))
				//Return blank String if cell is blank
				return ""; 
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			//Print message if row or column doesnot exist
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}

	//Returns the row count in a sheet
	public int getRowCount(String sheetName){
		//Get the sheet index
		int index = workbook.getSheetIndex(sheetName);
		
		//If the sheet does not exist then index = -1 and no rows will be there
		if(index==-1)
			return 0;
		else{
			//If sheet is found then number of rows with data is returned
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
	}

	// Returns the data from a cell usign column number and row number
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if(index==-1)
				return "";


			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";

			if(cell.getCellType().name().equals("STRING"))
				return cell.getStringCellValue();
			else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){

				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH)+1 + "/" +
							cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cellText;
				}
				return cellText;
			}else if(cell.getCellType().name().equals("BLANK"))
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}

	// returns number of columns in a sheet	
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if(row==null)
			return -1;

		return row.getLastCellNum();

	}

	// find whether sheets exists	
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}
		else
			return true;
	}
}
