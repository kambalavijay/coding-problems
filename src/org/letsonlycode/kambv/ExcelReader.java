package org.letsonlycode.kambv;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {
	
    public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\kambv\\Desktop\\book2.xlsx";

    public static void main(String[] args) throws Exception {
    	
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        
    	Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH)));
        
    	System.out.println(WorkbookFactory.create(new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH))).getClass());
    	
        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        
        /*
           ==================================================================
           Iterating over all the rows and columns in a Sheet (Multiple ways)
           ==================================================================
        */

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\nIterating over Rows and Columns using Iterator\n");
        
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        
    }
}