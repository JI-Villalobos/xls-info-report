package com.arche.report.tranbox.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the right format how the readers summarizes the sheet.
 * currently, the only requirement is remove any merged region
 * @author arche
 * @version 1.0
 */
public class SheetFormat {
    /**
     * Remove any merged region from a specific sheet instance
     * @param sheet an instance of Sheet
     * @return A new sheet instance without merged regions
     * @see com.arche.report.tranbox.instances.SheetInstance
     */
    public static Sheet removeMergedRegions(Sheet sheet) {
        System.out.println("Searching for merged regions....");
        System.out.println("Founded " + sheet.getNumMergedRegions() + " merged regions");
        System.out.println("Removing merged Regions....");
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            indexes.add(i);
        }
        sheet.removeMergedRegions(indexes);
        System.out.println("Remaining merged regions: " + sheet.getNumMergedRegions());
        sheet.setAutoFilter(new CellRangeAddress(2, 2, 0, 15));

        return sheet;
    }
}
