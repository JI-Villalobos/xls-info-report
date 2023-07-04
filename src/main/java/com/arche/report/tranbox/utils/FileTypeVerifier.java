package com.arche.report.tranbox.utils;

/**
 * This class checks the file type allowed.
 * @author arche
 * @version 1.0
 * @see Format
 */
public class FileTypeVerifier {
    /**
     * Verify the extension type for the file target
     * @param path the directory where target file is located
     * @return File format of file target
     */
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
