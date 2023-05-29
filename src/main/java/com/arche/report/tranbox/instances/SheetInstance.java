package com.arche.report.tranbox.instances;

import com.arche.report.tranbox.utils.Global;
import com.arche.report.tranbox.utils.SheetFormat;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SheetInstance {
    public static Sheet createInstance(String filename){
        Workbook workbook = WorkbookInstance.createInstance(filename);
        Sheet sheet = workbook.getSheetAt(0);

        return SheetFormat.removeMergedRegions(sheet);
    }
}
