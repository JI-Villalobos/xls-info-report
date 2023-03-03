package com.arche.report.tranbox.utils;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class SheetFormat {
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

        return sheet;
    }
}
