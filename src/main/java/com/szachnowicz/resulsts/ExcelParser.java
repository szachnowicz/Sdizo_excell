package com.szachnowicz.resulsts;

import com.szachnowicz.Array.Array;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFScatterChartData;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        int counter = 0;
        for (Result second : resultList) {

            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);

            cell.setCellValue(second.getOperationTested());
            if (counter > 0) {
                Result first = resultList.get(counter - 1);
                row.createCell(4).setCellValue("Ilość opreacji");
                row.createCell(5).setCellValue(first.getOperationTested());
                row.createCell(6).setCellValue(second.getOperationTested());
            }

            row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue("Ilość opreacji");
            row.createCell(1).setCellValue("Czas [ns]");


            for (int i = 0; i < second.timeList.size(); i++) {


                if (counter > 0) {

                    Result first = resultList.get(counter - 1);

                    row.createCell(4).setCellValue(second.instanceList.get(i));
                    row.createCell(5).setCellValue(first.timeList.get(i));
                    row.createCell(6).setCellValue(second.timeList.get(i));

                }
                row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(second.instanceList.get(i));
                row.createCell(1).setCellValue(second.timeList.get(i));

            }


            /// adding extra space
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(" ");
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(" ");

            counter++;
        }


        for (int i = 0; i < 6; i++) {
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








