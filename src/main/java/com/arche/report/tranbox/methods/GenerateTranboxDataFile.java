package com.arche.report.tranbox.methods;

import com.arche.report.tranbox.models.TranboxData;
import com.arche.report.tranbox.models.TranboxDataSheet;
import com.arche.report.tranbox.utils.Global;
import com.arche.report.tranbox.utils.InMemoryData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GenerateTranboxDataFile {
    public static void generateXLSX() throws IOException {
        String filename = Global.getDir() + LocalDate.now() + ".xls";
        TranboxDataSheet tranboxDataSheet = InMemoryData.get();
        List<TranboxData> data = tranboxDataSheet.data();
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        Row row1 = null;
        Row row2 = null;
        Row headers = null;
        Cell initialDateCell = null;
        Cell finalDateCell = null;

        row1 = sheet.createRow(1);
        row2 = sheet.createRow(2);
        headers = sheet.createRow(4);
        String[] columnNames = {"Fecha", "Hora", "Nodo", "Usuario", "Producto", "Total", "Monto", "Referencia", "Id", "Mensaje"};

        initialDateCell = row1.createCell(1);
        initialDateCell.setCellValue("Fecha inicial: " + tranboxDataSheet.reportDateInfo().initialDate());
        finalDateCell = row2.createCell(1);
        finalDateCell.setCellValue("Fecha final: " + tranboxDataSheet.reportDateInfo().finalDate());

        for (int i = 0; i < columnNames.length; i++) {
            headers.createCell(i).setCellValue(columnNames[i]);
        }

        for (int i = 0; i < data.size(); i++) {
            AtomicInteger rowNumb = new AtomicInteger(5);
            data.forEach(d -> {
                Row r = sheet.createRow(rowNumb.get());
                r.createCell(0).setCellValue(d.date());
                r.createCell(1).setCellValue(d.time());
                r.createCell(2).setCellValue(d.node());
                r.createCell(3).setCellValue(d.user());
                r.createCell(4).setCellValue(d.product());
                r.createCell(5).setCellValue(d.total());
                r.createCell(6).setCellValue(d.amount());
                r.createCell(7).setCellValue(d.reference());
                r.createCell(8).setCellValue(d.id());
                r.createCell(9).setCellValue(d.message());
                rowNumb.getAndIncrement();
            });
        }

        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Archivo generado como: " + filename);
    }
}
