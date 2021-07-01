package utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/*
 * This Class writes the product specification in excel file
 * 
 * @author Saravanan, Arumugam
 */

public class ExcelWrite {
	
	//"wbk" is an instance for Workbook interface
	Workbook wbk =null;
	
	//"sht" is an instance for Sheet interface
	Sheet sht = null;
	
	//"row" is an instance for Row interface
	Row row = null;
	
	//"cell" is an instance for Cell interface
	Cell cell = null;
	
	//"out" is a static instance for FileOutputStream class
	FileOutputStream out = null;
	
	/*
	 * The constructor for creating instance for excel workbook 2007 version
	 */
	public ExcelWrite() {
		wbk = new XSSFWorkbook();
	}
	
	/*
	 * Creates sheet in workbook with name received as a parameter
	 * 
	 * @param data - Sheet name
	 */
	public void toCreateSheet(String data) {
		sht = wbk.createSheet(data);
	}
	
	/*
	 * Creates the row in the sheet
	 * 
	 * @param i - row index
	 */
	public void rowCreation(int i) {
		row = sht.createRow(i);
	}
	
	/*
	 * Creates cell and writes received data to that cell
	 * 
	 * @param i - cell index
	 * @param data - data to be written
	 */
	public void cellCreationAndWrite(int i, String data) {
		
		cell = row.createCell(i);
		cell.setCellValue(data);
	}
	
	public void fileCreation() throws IOException {
		out = new FileOutputStream(new File("D:/Gmail_Test_Data/SathyaProject.xlsx")); 
		wbk.write(out);
		out.close();
	}
}
