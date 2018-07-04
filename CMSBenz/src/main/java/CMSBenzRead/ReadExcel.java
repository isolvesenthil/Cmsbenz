package CMSBenzRead;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Row row;
	static int rowNos;
	static Cell cell;
	
	public static void loadExcel() throws Exception{
		
//		System.out.println("Loading Excel :::");
		FileInputStream File = new FileInputStream("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\src\\test\\java\\CMSBenz\\Data.xlsx");
		workbook = new XSSFWorkbook(File);
		sheet = workbook.getSheet("Sheet1");
		File.close();
		
//		rowNos = sheet.getPhysicalNumberOfRows();
//		System.out.println(rowNos);
		}
	
	public static Map<String, Map<String, String>> getDatamap() throws Exception {
		if(sheet==null) {
			loadExcel();
		}
		Map<String, Map<String,String>> superMap = new HashMap<String, Map<String,String>>();
		Map<String,String> secondMap = new HashMap<String,String>();
		
		for(int i=1 ;i<sheet.getLastRowNum()+1;i++) {
			row = sheet.getRow(i);			
			String keyCell = row.getCell(0).getStringCellValue();
		for(int j=1;j<row.getLastCellNum();j++) {
				
			cell=row.getCell(j);				
			cell.setCellType(Cell.CELL_TYPE_STRING);
			
			String Value = row.getCell(j).getStringCellValue();
			secondMap.put(keyCell, Value);
		} 
		 superMap.put("MASTERDATA",secondMap );
	}
		return superMap;	
	}
	
	public static String getValue(String key) throws Exception {
		Map<String, String> myVal = getDatamap().get("MASTERDATA");
		String retValue = myVal.get(key);
		return retValue;
		}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(getValue("login_username"));
//		System.out.println(getValue("login_pwd"));
//	}
	}
