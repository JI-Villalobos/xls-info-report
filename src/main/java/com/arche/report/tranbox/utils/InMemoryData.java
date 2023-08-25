package com.arche.report.tranbox.utils;

import com.arche.report.tranbox.models.TranboxDataSheet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class InMemoryData {
    private static TranboxDataSheet info;

    public static void add(TranboxDataSheet tranboxDataSheet){
       info = tranboxDataSheet;
    }

    public static TranboxDataSheet get(){
        return info;
    }
}
