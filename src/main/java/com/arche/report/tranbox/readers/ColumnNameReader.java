package com.arche.report.tranbox.readers;

import com.arche.report.tranbox.models.Header;
import com.arche.report.tranbox.utils.Global;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * This class check the headers/columns from a sheet instance
 * @author arche
 * @version 1.0
 */
public class ColumnNameReader {
    /**
     * Extract the name of every column
     * @param sheet A sheet instance
     * @return A list o headers representing color names
     * @see Header
     */
    public static List<Header> readRowHeader(Sheet sheet){
        List<Header> headers = new ArrayList<>();
        String header = "";

        Row columnName = sheet.getRow(2);

        for (int i = 0; i < Global.COLUMN_LIMIT; i++) {
            Cell cell = columnName.getCell(i);
            if (cell.getCellType() != CellType.BLANK) {
                header = cell.getStringCellValue();
                Header rowHeader = new Header(header);
                headers.add(rowHeader);
            }
        }

        return headers;
    }
}
