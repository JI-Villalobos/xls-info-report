package com.arche.report.tranbox.readers;

import com.arche.report.tranbox.models.ReportDateInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * This class check the report information date
 * @author arche
 * @version 1.0
 */
public class DateReader {
    /**
     * Extract date information that corresponds the period of data registered on the report.
     * The cells that contain the date info in the row report file don´t change
     * @param sheet A sheet instance
     * @return The initial and final dates which the report corresponds
     * @see ReportDateInfo
     */
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
