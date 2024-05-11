package com.tutorialsNinja.TestData;

import lombok.Data;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jxls.common.CellData;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelCode {
    public static FileInputStream ip;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    @DataProvider(name= "TNLogin")
    public Object[][] getExcelLoginData() throws Exception {
        Object[][] data = ExcelCode.readFromExcelSheetTNLogin("LoginTN");
        return data;
    }

    public static Object[][] readFromExcelSheetTNLogin(String sheetName) throws Exception {
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
        workbook = new XSSFWorkbook(ip);
        sheet = workbook.getSheet(sheetName);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];
        for (int i = 0 ; i<rows ; i++) {
            XSSFRow row = sheet.getRow(i+1);
            for(int j = 0; j<cols ; j++ ) {
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                    break;

                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;

                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                }
            }
        }
    return data;
    }

    @DataProvider(name = "TNRegister")
    public Object[][] getTNExcelRegisterData() throws Exception {
        Object[][] data = ExcelCode.readFromExcelSheetTNRegister("RegisterTN");
        return data;
    }

    public static Object[][] readFromExcelSheetTNRegister(String sheetName) throws Exception {
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
        workbook = new XSSFWorkbook(ip);
        sheet = workbook.getSheet(sheetName);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows][cols];
        for (int i = 0 ; i<rows ; i++) {
            XSSFRow row = sheet.getRow(i+1);
            for (int j = 0 ; j<cols ; j++) {
                XSSFCell cell = row.getCell(j);
                CellType celltype = cell.getCellType();

                switch (celltype) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;

                }
            }
        }
        return data;
    }
}
