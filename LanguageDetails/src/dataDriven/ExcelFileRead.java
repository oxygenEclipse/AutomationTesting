package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {

	public static void excelPrintAllRows(String fileName, String sheetName) throws IOException {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet(sheetName);
		int rowsCount = websiteList.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Row rowData = websiteList.getRow(i);
			int cellsCount = rowData.getPhysicalNumberOfCells();
			for (int j = 0; j < cellsCount; j++) {
				Cell cellData = rowData.getCell(j);
				String cellValue = null;
				cellValue = getCellValue(cellData);
				System.out.print(cellValue + "\t\t");
			}
			System.out.println("");
		}
		wb.close();
	}

	public static String excelPrintACell(String fileName, String sheetName, int rowNum, int cellNum)
			throws IOException {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet(sheetName);
		Row rowData = websiteList.getRow(rowNum);
		Cell cellData = rowData.getCell(cellNum);
		String cellValue = null;
		cellValue = getCellValue(cellData);
		wb.close();
		return cellValue;
	}

	public static List<String> excelPrintARow(String fileName, String sheetName, int rowNum) throws IOException {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet(sheetName);
		Row rowData = websiteList.getRow(rowNum);
		int cellsCount = rowData.getPhysicalNumberOfCells();
		List<String> rowCellValues = new ArrayList<String>();
		for (int j = 0; j < cellsCount; j++) {
			Cell cellData = rowData.getCell(j);
			rowCellValues.add(getCellValue(cellData));
		}
		wb.close();
		return rowCellValues;
	}

	public static List<String> excelPrintAColumn(String fileName, String sheetName, int columnNum) throws IOException {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet(sheetName);
		List<String> columnValues = new ArrayList<String>();
		int rowsCount = websiteList.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Row rowData = websiteList.getRow(i);
			Cell cellData = rowData.getCell(columnNum);
			columnValues.add(getCellValue(cellData));
		}
		wb.close();
		return columnValues;
	}

	public static List<String> excelPrintAColumn(String fileName, String sheetName, String columnName)
			throws IOException {
		int columnNum = 0;
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet(sheetName);
		int rowsCount = websiteList.getPhysicalNumberOfRows();
		String cellValue = null;
		for (int i = 0; i < rowsCount; i++) {
			Row rowData = websiteList.getRow(i);
			int cellsCount = rowData.getPhysicalNumberOfCells();
			for (int j = 0; j < cellsCount; j++) {
				Cell cellData = rowData.getCell(j);
				cellValue = getCellValue(cellData);
				if (cellValue.equalsIgnoreCase(columnName))
					columnNum = j;
			}
		}
		List<String> columnValues = excelPrintAColumn(fileName, sheetName, columnNum);
		wb.close();
		return columnValues;
	}

	public static List<String> excelPrintARow(String fileName, String sheetName, String rowName) throws IOException {
		int rowNum = 0;
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet(sheetName);
		int rowsCount = websiteList.getPhysicalNumberOfRows();
		String cellValue = null;
		for (int i = 0; i < rowsCount; i++) {
			Row rowData = websiteList.getRow(i);
			int cellsCount = rowData.getPhysicalNumberOfCells();
			for (int j = 0; j < cellsCount; j++) {
				Cell cellData = rowData.getCell(j);
				cellValue = getCellValue(cellData);
				if (cellValue.equalsIgnoreCase(rowName))
					rowNum = i;
			}
		}
		List<String> rowCellValues = excelPrintARow(fileName, sheetName, rowNum);
		wb.close();
		return rowCellValues;
	}

	public static String getCellValue(Cell cellData) {
		String cellDataValue = null;
		CellType cellType = cellData.getCellType();
		if (cellType.equals(CellType.STRING)) {
			cellDataValue = cellData.getStringCellValue();
		} else if (cellType.equals(CellType.NUMERIC)) {
			double doubleCellValue = cellData.getNumericCellValue();
			long longCellValue = (long) doubleCellValue;
			cellDataValue = String.valueOf(longCellValue);
		}

		return cellDataValue;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Case : 1 " + "Print All Rows" + "\n");
		excelPrintAllRows("D:\\User Details.xlsx", "Sheet1"); // pass the file name
		System.out.println("\nCase : 2 " + "Print A Cell" + "\n");
		String excelPrintACellValue = excelPrintACell("D:\\User Details.xlsx", "Sheet1", 1, 5); // Pass the row and cell
																								// value
		System.out.println(excelPrintACellValue);
		System.out.println("\nCase : 3 " + "Print A Row passing Row Number" + "\n");
		List<String> excelPrintARow = excelPrintARow("D:\\User Details.xlsx", "Sheet1", 4);
		for (int i = 0; i < excelPrintARow.size(); i++) {
			System.out.print(excelPrintARow.get(i) + "\t\t");
		}
		System.out.println("\nCase : 4 " + "Print A Column passing Column Number" + "\n");
		List<String> excelPrintAColumn = excelPrintAColumn("D:\\User Details.xlsx", "Sheet1", 1);
		for (int i = 0; i < excelPrintAColumn.size(); i++) {
			System.out.println(excelPrintAColumn.get(i));
		}
		System.out.println("\nCase : 5 " + "Print A Column passing Column Name" + "\n");
		List<String> excelPrintAColumnName = excelPrintAColumn("D:\\User Details.xlsx", "Sheet1", "FirstName");
		for (int i = 0; i < excelPrintAColumnName.size(); i++) {
			System.out.println(excelPrintAColumnName.get(i));
		}
		System.out.println("\nCase : 6 " + "Print A Row passing Row Name" + "\n");
		List<String> excelPrintARowNames = excelPrintARow("D:\\User Details.xlsx", "Sheet1", "User1");
		for (int i = 0; i < excelPrintARowNames.size(); i++) {
			System.out.print(excelPrintARowNames.get(i) + "\t\t");
		}
	}
}