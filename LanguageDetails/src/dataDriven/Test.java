package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	public static Map<String, String> getUser(String fileName, String sheetName, int userNum) throws Exception {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet sh = wb.getSheet(sheetName);
		Map<String, String> userData = new HashMap<String, String>();
		String cellValue = null;
		int rowsCount = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Cell cell = sh.getRow(i).getCell(userNum);
			if (cell == null) {
				cell = sh.getRow(i).createCell(userNum);
			}
			System.out.println("(" + i + "," + userNum + ")" + "  =  " + cell.getCellType());
			if (cell.getCellType().equals(CellType.STRING)) {
				cellValue = cell.getStringCellValue();
			} else if (cell.getCellType().equals(CellType.NUMERIC)) {
				if (DateUtil.isCellDateFormatted(cell)) {
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					cellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					double doubleCellValue = cell.getNumericCellValue();
					long longCellValue = (long) doubleCellValue;
					cellValue = String.valueOf(longCellValue);
				}
			}
			FileOutputStream fout = new FileOutputStream(excelFile);
			wb.write(fout);
			userData.put(sh.getRow(i).getCell(0).getStringCellValue(), cellValue);
			cellValue = "";
		}
		wb.close();
		return userData;
	}

	public static Map<String, String> updateUser(String fileName, String sheetName, int userNum,
			Map<String, String> updateUser) throws Exception {
		File excelFile = new File(fileName);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet sh = wb.getSheet(sheetName);
		int rowsCount = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Cell cell = sh.getRow(i).getCell(userNum);
			if (sh.getRow(i).getCell(0).getStringCellValue().equals("Order Reference Id")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Order Reference Id"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("Amount")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Amount"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("Account Owner")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Account Owner"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("Bank Name")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Bank Name"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("User Created")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("User Created"));
			}
		}
		FileOutputStream fout = new FileOutputStream(excelFile);
		wb.write(fout);
		wb.close();
		return updateUser;
	}

	public static void main(String[] args) throws Exception {
		Map<String, String> user = getUser("D:\\Automation Practice User Order Details.xlsx", "TestUser", 1);
		String[] dateParts = user.get("Date Of Birth").split("/");
		if (dateParts[1].startsWith("0"))
			dateParts[1] = dateParts[1].substring(1);
		System.out.println(dateParts[0]);
		System.out.println(dateParts[1]);
		System.out.println(dateParts[2]);
		String splitText = "- Do not forget to insert your order reference ";
		String OrderReferenceText = "- Do not forget to insert your order reference DHFGGMWZB in the subject of your bank wire.";
		System.out.println(
				splitText.length() + " " + OrderReferenceText.length() + " " + OrderReferenceText.substring(47, 56));

		user.replace("Amount", "$18.15");
		user.replace("Account Owner", "Abc");
		user.replace("Bank Name","RTP");
		user.replace("Order Reference Id", OrderReferenceText.substring(47, 56));
		Map<String, String> updateUser = updateUser("D:\\Automation Practice User Order Details.xlsx", "TestUser", 1, user);
		System.out.println(updateUser);
	}
	
	

}
