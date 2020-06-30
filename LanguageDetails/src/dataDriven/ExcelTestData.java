package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData {

	public static void main(String[] args) throws IOException {
		String[][] tabArray = null;

		// get the workbook file. Provide the path of excel file
		File excelFile = new File("D:\\Banu\\testData.xlsx");
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		// get the sheet name
		Sheet sheet = wb.getSheet("Data");
		int rowsCount, cellsCount;
		Row tableHeader = sheet.getRow(0);
		String tableName1 = tableHeader.getCell(0).getStringCellValue();
		int arrayColumnCount = tableHeader.getLastCellNum();
		int arrayRowCount = sheet.getLastRowNum();
		tabArray = new String[arrayRowCount][arrayColumnCount];
		if (tableName1.contains("testData")) {
			rowsCount = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowsCount; i++) {
				Row rowData = sheet.getRow(i);
				cellsCount = rowData.getPhysicalNumberOfCells();
				for (int j = 1; j < cellsCount; j++) {
					Cell cellData = rowData.getCell(j);
					tabArray[i - 1][j - 1] = cellData.getStringCellValue();
				}
			}
		}
		wb.close();
		for (int i = 0; i < arrayRowCount; i++) {
			for (int j = 0; j < arrayColumnCount - 1; j++) {
				System.out.println(tabArray[i][j]);
			}
		}
	}
}
