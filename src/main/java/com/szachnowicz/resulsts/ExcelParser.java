package com.szachnowicz.resulsts;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {
    private static List<Result> timeResults = new ArrayList<>();




    public void createFile(String sheetName, List<Result> resultList) {
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet(sheetName);
        // Create a Font for styling header cells

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        int rowNum = 0;
        // Create a Row
        Row headerRow = sheet.createRow(rowNum);


        for (Result result : resultList) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(result.getOperationTested());
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue("Ilosc opreacji");
            row.createCell(1).setCellValue("Czas [ms]");


            for (int i = 0; i < result.timeList.size(); i++) {
                row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(result.instanceList.get(i));
                row.createCell(1).setCellValue(result.timeList.get(i));

            }



            /// adding extra space
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(" ");
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(" ");

        }


        for (int i = 0; i < 2; i++) {
            sheet.autoSizeColumn(i);
        }
        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(sheetName + ".xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERRROR");

        }


    }


}
