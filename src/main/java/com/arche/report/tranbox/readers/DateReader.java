package com.arche.report.tranbox.readers;

import com.arche.report.tranbox.models.ReportDateInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class DateReader {
    public static ReportDateInfo readDate(Sheet sheet){
        String initialDate = "";
        String finalDate = "";


        Row rowWithInitialDate = sheet.getRow(0);
        Row rowWithFinalDate = sheet.getRow(1);
        Cell initial = rowWithInitialDate.getCell(8);
        Cell end = rowWithFinalDate.getCell(8);

        initialDate = initial.getDateCellValue().toString();
        finalDate = end.getDateCellValue().toString();

        return new ReportDateInfo(initialDate, finalDate);
    }
}
