package com.arche.report.tranbox.instances;

import com.arche.report.tranbox.utils.FileTypeVerifier;
import com.arche.report.tranbox.utils.Format;
import com.arche.report.tranbox.utils.Global;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class that represent a workbook file
 * @author arche
 * @version 1.0
 */
public class WorkbookInstance {
    /**
     * Create a workbook instance based on the target file type
     * @param filename The directory where the target file is allocated
     * @return A new XLS/XLSX Workbook instance
     * @see FileTypeVerifier
     */
    public static Workbook createInstance(String filename){
        Format format = FileTypeVerifier.verify(Global.BASE_PATH + filename);
        Workbook workbook = null;

        try {
            FileInputStream inputStream =new FileInputStream(Global.BASE_PATH + filename);
            switch (format){
                case XLS -> workbook = new HSSFWorkbook(inputStream);
                case XLSX -> workbook = new XSSFWorkbook(inputStream);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return workbook;
    }
}
