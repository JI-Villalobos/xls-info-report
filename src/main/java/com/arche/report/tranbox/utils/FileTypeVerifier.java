package com.arche.report.tranbox.utils;

public class FileTypeVerifier {
    public static Format verify(String path){
        if (path.toLowerCase().endsWith("xlsx")){
            return Format.XLSX;
        }else if (path.toLowerCase().endsWith("xls")){
            return Format.XLS;
        } else {
            throw new RuntimeException(Messages.FILE_NOT_ACCEPTED);
        }
    }
}
