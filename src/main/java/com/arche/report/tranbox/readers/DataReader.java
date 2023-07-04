package com.arche.report.tranbox.readers;

import com.arche.report.tranbox.models.TranboxData;
import com.arche.report.tranbox.utils.Global;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;
/**
 * This class check the report raw information
 * @author arche
 * @version 1.0
 */
public class DataReader {
    /**
     * Extract data information from a report sales
     * @param sheet A sheet instance, it assumes the instance is formatted
     * @return A TranboxData model object
     * @see TranboxData
     */
    public static List<TranboxData> readData(Sheet sheet){
        List<TranboxData> data = new ArrayList<>();
        String date = "";
        String time = "";
        double node = 0.00;
        String name = "";
        String user = "";
        String product = "";
        double total = 0.00;
        double amount = 0.00;
        String reference = "";
        String id = "";
        String message = "";

        Row dataRowIndex = sheet.getRow(3);

        for (int i = dataRowIndex.getRowNum(); i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < Global.COLUMN_LIMIT; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getColumnIndex()){
                    case 0 -> date = cell.getStringCellValue();
                    case 1 -> time = cell.getStringCellValue();
                    case 3 -> node = cell.getNumericCellValue();
                    case 4 -> name = cell.getStringCellValue();
                    case 5 -> user = cell.getStringCellValue();
                    case 7 -> product = cell.getStringCellValue();
                    case 9 -> total = cell.getNumericCellValue();
                    case 11 -> amount = cell.getNumericCellValue();
                    case 12 -> reference = cell.getStringCellValue();
                    case 13 -> id = cell.getStringCellValue();
                    case 14 -> {
                        message = cell.getStringCellValue();
                    }
                }
            }
            TranboxData ppReportData = new TranboxData(
                    date, time,
                    Double.toString(node),
                    name, user,
                    product, total,
                    amount, reference,
                    id, message);
            data.add(ppReportData);
        }
        return  data;
    }
}
