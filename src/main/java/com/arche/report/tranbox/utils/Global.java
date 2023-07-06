package com.arche.report.tranbox.utils;

public class Global {
    public static final Integer COLUMN_LIMIT = 15;
    public static final Double BASE_COMMISSION = 10.0;

    public static String getDir() {
        String basePath = System.getProperty("user.home");
        return basePath.concat("\\Desktop\\");
    }
}
