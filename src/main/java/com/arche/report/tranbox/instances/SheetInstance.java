package com.arche.report.tranbox.instances;

import com.arche.report.tranbox.utils.Global;
import com.arche.report.tranbox.utils.SheetFormat;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Class that represent a workbook sheet
 * @author arche
 * @version 1.0
 */
public class SheetInstance {
    /**
     * Instantiate a formatted sheet from a workbook instance
     * @param filename The directory where the target file is allocated
     * @return A new sheet instance
     * @see WorkbookInstance
     */
    public static Sheet createInstance(String filename){
        Workbook workbook = WorkbookInstance.createInstance(filename);
        Sheet sheet = workbook.getSheetAt(0);

        return SheetFormat.format(sheet);
    }
}
