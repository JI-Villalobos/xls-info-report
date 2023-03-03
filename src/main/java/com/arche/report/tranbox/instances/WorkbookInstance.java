package com.arche.report.tranbox.instances;

import com.arche.report.tranbox.utils.FileTypeVerifier;
import com.arche.report.tranbox.utils.Format;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkbookInstance {
    public static Workbook createInstance(String path){
        Format format = FileTypeVerifier.verify(path);
        Workbook workbook = null;

        try {
            FileInputStream inputStream =new FileInputStream(path);
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
