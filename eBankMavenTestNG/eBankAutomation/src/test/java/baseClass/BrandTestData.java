package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BrandTestData {

	public static String[] getBrandName(String fileName) throws IOException {
		String brandName[] = null;
		File file = new File(fileName);
		FileInputStream fin = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet s = wb.getSheetAt(0);
		int brandCount = 0;
		int rowsCount = s.getPhysicalNumberOfRows();
		brandName = new String[rowsCount - 1];
		for (int i = 1; i < rowsCount; i++, brandCount++) {
			Row row = s.getRow(i);
			brandName[brandCount] = row.getCell(0).getStringCellValue();
			System.out.println("Brand Name From Excel : " + brandName[brandCount]);
		}
		wb.close();
		return (brandName);
	}

	public static void updateBrandDetails(String fileName, String brandName, String prodName, String prodCost,
			String totalAmt) throws IOException {
		boolean update = false;
		File file = new File(fileName);
		FileInputStream fin = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet s = wb.getSheetAt(0);
		int rowsCount = s.getPhysicalNumberOfRows();
		Row r = s.getRow(0);
		int cellsCount = r.getPhysicalNumberOfCells();
		for (int i = 1; i < rowsCount; i++) {
			Row row = s.getRow(i);
			update = false;
			for (int j = 0; j < cellsCount; j++) {
				Cell cell = row.getCell(j);
				if (cell == null)
					cell = row.createCell(j);
				if (cell.getStringCellValue().equals(brandName) && j == 0)
					update = true;
				if (update && j == 1)
					cell.setCellValue(prodName);
				else if (update && j == 2)
					cell.setCellValue(prodCost);
				else if (update && j == 3)
					cell.setCellValue(totalAmt);
			}
			
		}
		FileOutputStream fout= new FileOutputStream(file);
		wb.write(fout);
		wb.close();
	}
}
