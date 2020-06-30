package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileWrite {
	
	public static void updateCell(String fileName, String sheetName) throws IOException {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(12);
		if (row == null) {
			System.out.println("Row created");
			row = sh.createRow(12);
		}
		Cell cell = row.getCell(9);
		if (cell == null) {
			System.out.println("Cell Created");
			cell = row.createCell(9);
		}
		cell.setCellValue("Hello");
		FileOutputStream fout = new FileOutputStream(excelFile);
		wb.write(fout);
		wb.close();
	}


	public static void main(String[] args) throws Exception {
		updateCell("D:\\Websites Programming Lanuguages List.xlsx", "Website List"); // pass the file name
	}

}
