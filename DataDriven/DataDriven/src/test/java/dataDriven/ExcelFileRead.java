package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {

	public static void main(String[] args) throws IOException {
		File excelFile = new File("D:\\Websites Programming Lanuguages List.xlsx");
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet websiteList = wb.getSheet("Website List");
		int rowsCount = websiteList.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Row rowData = websiteList.getRow(i);
			int cellsCount = rowData.getPhysicalNumberOfCells();
			for (int j = 0; j < cellsCount; j++) {
				Cell cellData = rowData.getCell(j);
				CellType cellType = cellData.getCellType();
				String cellValue = null;
				if (cellType.equals(CellType.STRING)) {
					cellValue = cellData.getStringCellValue();
				} else if (cellType.equals(CellType.NUMERIC)) {
					double doubleCellValue = cellData.getNumericCellValue();
					long longCellValue = (long) doubleCellValue;
					cellValue = String.valueOf(longCellValue);
				}
				System.out.println(cellValue);
			}
		}
wb.close();
	}
}