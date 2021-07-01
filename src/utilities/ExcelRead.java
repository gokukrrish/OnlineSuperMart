package utilities;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/*
 * This Class reads the billing information form Excel file
 * 
 * @author Saravanan, Arumugam
 */
public class ExcelRead {
	
	//"ExcelFile" is a static instance for FileInputStream class
	static FileInputStream ExcelFile = null;
	
	//"xWbk" is an instance for XSSFWorkbook class
	static XSSFWorkbook xWbk = null;
	
	//"xSht" is an instance for XSSFSheet class
	static XSSFSheet xSht = null;
	
	//"xRow" is an instance for XSSFRow class
	static XSSFRow  xRow = null;
	
	/*
	 * Retrieves billing information from excel file with actual format
	 * specified in excel file
	 * 
	 * @returns Object[][] tabArray - Consists of all the billing information  in single row
	 * 
	 * @throws Exception if unable to read file
	 */
	public static Object[][] getTableArray() throws Exception {
		String[][] tabArray = new String[1][8];
		ExcelFile = new FileInputStream("C:/Users/pc/eclipse-workspace/Sathya_Electronics/src/testData/Billing_Info.xlsx");
		xWbk = new XSSFWorkbook(ExcelFile);
		xSht = xWbk.getSheetAt(0);
		 for(int i = 0;xSht.getRow(0).getCell(i) != null; i++) 
			 tabArray[0][i] = new DataFormatter().formatCellValue(xSht.getRow(0).getCell(i)).toString();
		return tabArray;
	}
}
