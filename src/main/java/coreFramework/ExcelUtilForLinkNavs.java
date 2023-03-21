package coreFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilForLinkNavs {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static File file;
	public static FileInputStream fin;
	
	public static XSSFWorkbook workbook1;
	public static XSSFSheet sheet1;
	public static XSSFRow row1;
	public static XSSFCell cell1;
	public static File file1;
	public static FileInputStream fin1;
	public static FileOutputStream fout;
	

public static void setExcel(String path,String Sheet1){
	String SheetName=null;
	try {
		System.out.println("path of inside setexcel: "+path);
		
	file1 = new File(path);
	if (!file1.exists()) {
		int index = path.lastIndexOf("/");
		String fileName = path.substring(index + 1);
		System.out.println(fileName);
		String absoluteFileName[]=fileName.split("_");
		SheetName=absoluteFileName[0];
			File file3 = new File(System.getProperty("user.dir") + Constants.EXCELFILEPATH+absoluteFileName[0]+".xlsx");
			try {
				FileUtils.copyFile(file3, file1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }

		fin1 = new FileInputStream(file1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		workbook1 =new XSSFWorkbook(fin1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	sheet1=workbook1.getSheet(Sheet1);
	
}


public static int getNumberOfRows(){
	return sheet.getLastRowNum();
}

public static String getCellValue(int cellnum){
	cell = row.getCell(cellnum);
	return cell.getStringCellValue();
}


public static int getNumberOfRows1(){
	return sheet1.getLastRowNum();
}

public static String getCellValue1(int cellnum){
	cell1 = row1.getCell(cellnum);
	return cell1.getStringCellValue();
}

}


