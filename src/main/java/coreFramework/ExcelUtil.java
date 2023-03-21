package coreFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import applicationSpecific.AUT;

/**
 * This class consists of all the methods required to interact with the test data excel file
 * 
 * @author Kamil
 * @version 1.0
 */
public class ExcelUtil {

	public static String strFile= null ;
	
	public static String filename = System.getProperty("user.dir") + Constants.FILENAME;
	public static String testDataWorkSheetName = "TESTDATA";
	public  String path;
	public  static FileInputStream fis = null;
	public  static FileOutputStream fileOut = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row   =null;
	public static XSSFCell cell = null;
	
	/**
	 * This method is used to connect to excel. This is a constructor.
	 * 
	 * @param path Test data file location
	 * @author Kamil
	 */
	public ExcelUtil(String path) {

		this.path=path;
		try {
			fis = new FileInputStream(path);
			
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	/**
	 * This method is used to get row count
	 * 
	 * @param sheetName Sheet name in the excel
	 * @return returns the row count in a sheet
	 * @author Kamil
	 */
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}

	}
	
	
	/**
	 * This method is used to get cell data
	 * 
	 * @param sheetName Sheet name in the excel
	 * @param colName Column name
	 * @param rowNum Row number
	 * @return returns the data from a cell
	 * @author Kamil
	 */
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";

			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);

			if(cell==null)
				return "";
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){

				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;
				}
				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return ""; 
			else 
				return String.valueOf(cell.getBooleanCellValue());

		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	
	
	/**
	 * This method is used to get cell data
	 * 
	 * @param sheetName Sheet name in the excel
	 * @param colNum Column number
	 * @param rowNum Row number
	 * @return returns the data from a cell
	 * @author Kamil
	 */
	// returns the data from a cell
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

			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){

				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH)+1 + "/" +
							cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cellText;
				}
				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	
	/**
	 * This method is used to set string value in excel's cell
	 * 
	 * @param sheetName Sheet name in the excel
	 * @param colName Column name
	 * @param rowNum Row number
	 * @param data Value to set should be a string
	 * @return returns true if data is set successfully else false
	 * @author Kamil 
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);

			if(rowNum<=0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;

			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);

			cell = row.getCell(colNum);	
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();	
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method is used to set url value in excel's cell
	 * 
	 * @param sheetName Sheet name in the excel
	 * @param colName Column name
	 * @param rowNum Row number
	 * @param data Value to set should be a url
	 * @return returns true if data is set successfully else false
	 * @author Kamil
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
		try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);

			if(rowNum<=0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum=i;
			}

			if(colNum==-1)
				return false;
			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);

			cell = row.getCell(colNum);	
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);
			XSSFCreationHelper createHelper = (XSSFCreationHelper) workbook.getCreationHelper();
			CellStyle hlink_style = workbook.createCellStyle();
			XSSFFont hlink_font = workbook.createFont();
			hlink_font.setUnderline(XSSFFont.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlink_style);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();	
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}


	/**
	 * This method is used add work sheet
	 * 
	 * @param sheetName Sheet name in the excel
	 * @return returns true if sheet is successfully created else false
	 * @author Kamil
	 */
	public boolean addSheet(String  sheetname){		

		FileOutputStream fileOut;
		try {
			workbook.createSheet(sheetname);	
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method is used remove work sheet
	 * 
	 * @param sheetName Sheet name in the excel
	 * @return returns true if sheet is successfully removed else false
	 * @author Kamil
	 */
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;

		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addColumn(String sheetName,String colName){
		try{				
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;

			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			sheet=workbook.getSheetAt(index);

			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			if(row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellStyle(style);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();		    

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		return true;


	}
	
	
	// removes a column and all the contents
	public boolean removeColumn(String sheetName, int colNum) {
		try{
			if(!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			@SuppressWarnings("unused")
			XSSFCreationHelper createHelper = (XSSFCreationHelper) workbook.getCreationHelper();
			style.setFillPattern(HSSFCellStyle.NO_FILL);



			for(int i =0;i<getRowCount(sheetName);i++){
				row=sheet.getRow(i);	
				if(row!=null){
					cell=row.getCell(colNum);
					if(cell!=null){
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;

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
	
		public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){
		url=url.replace('\\', '/');
		if(!isSheetExist(sheetName))
			return false;

		sheet = workbook.getSheet(sheetName);

		for(int i=2;i<=getRowCount(sheetName);i++){
			if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){
				//System.out.println("**caught "+(i+index));
				setCellData(sheetName, screenShotColName, i+index, message,url);
				break;
			}
		}


		return true; 
	}


	public int getCellRowNum(String sheetName,String colName,String cellValue){

		for(int i=2;i<=getRowCount(sheetName);i++){
			if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
				return i;
			}
		}
		return -1;

	}
	
	
	/**
	 * This method is used get data from the test data excel
	 * 
	 * @param rowTestCaseName Test Case name in the test data
	 * @param columnName Column name in the test data
	 * @return returns the value corresponding to the test case and the column name
	 * @author Kamil
	 */
	public static String getDataFromExcel(String rowTestCaseName, String columnName){
		ExcelUtil dataTable = null;
		int rowFlag = 0;
		int colnFlag = 0;
		try {
			dataTable = null;
			dataTable = new ExcelUtil(filename+strFile);
			rowFlag = 0;
			colnFlag = 0;
			int rowCount = dataTable.getRowCount(testDataWorkSheetName);
			int columnCount = dataTable.getColumnCount(testDataWorkSheetName);

			for (int row=1; row <= rowCount; row++) {
				String testNameInExcelRow = dataTable.getCellData(testDataWorkSheetName, 0, row);
				if(testNameInExcelRow.equals(rowTestCaseName)){
					rowFlag = row;
					break;
				}
			}
			
			for(int col=0; col <= columnCount; col++) {
				String testNameInExcelColn = dataTable.getCellData(testDataWorkSheetName, col, 1);
				if(testNameInExcelColn.equals(columnName)){
					colnFlag = col;
					break;
				}
			}
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Error in finding test data in excel file");
			e.printStackTrace();
		}
		
		return dataTable.getCellData(testDataWorkSheetName,colnFlag, rowFlag);
		
	}

	
	public static void updateResultToExcel(int rownum,int column,String path,String status)
	{
		ExcelUtilForLinkNavs.row1 = ExcelUtilForLinkNavs.sheet1.getRow(rownum);
		ExcelUtilForLinkNavs.cell1 = ExcelUtilForLinkNavs.row1.createCell(column);
		ExcelUtilForLinkNavs.cell1.setCellValue(status);
		try {
			ExcelUtilForLinkNavs.fout = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExcelUtilForLinkNavs.workbook1.write(ExcelUtilForLinkNavs.fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setRowAndColumn(int rownum,int column)
	{
		ExcelUtilForLinkNavs.row1 = ExcelUtilForLinkNavs.sheet1.getRow(rownum);
		ExcelUtilForLinkNavs.cell1 = ExcelUtilForLinkNavs.row1.createCell(column);
	}
	public static void updateResultToExcel(String path,String status)
	{
		ExcelUtilForLinkNavs.cell1.setCellValue(status);
		try {
			ExcelUtilForLinkNavs.fout = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExcelUtilForLinkNavs.workbook1.write(ExcelUtilForLinkNavs.fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
