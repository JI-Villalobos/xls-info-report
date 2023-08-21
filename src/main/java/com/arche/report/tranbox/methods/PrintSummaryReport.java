package com.arche.report.tranbox.methods;

import com.arche.report.tranbox.instances.SheetInstance;
import com.arche.report.tranbox.models.ReportDateInfo;
import com.arche.report.tranbox.models.SummaryReport;
import com.arche.report.tranbox.models.TranboxData;
import com.arche.report.tranbox.modifiers.Filter;
import com.arche.report.tranbox.modifiers.Synthesizer;
import com.arche.report.tranbox.readers.DataReader;
import com.arche.report.tranbox.readers.DateReader;
import com.arche.report.tranbox.utils.Commission;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * This Class represent the whole process to generate the final report of sales
 * @author arche
 * @version 1.0
 */
public class PrintSummaryReport {
    /**
     * Print the generated report
     * @param filename Directory path of the target file
     */
    public static void printSummary(String filename){
        Sheet sheet = SheetInstance.createInstance(filename);
        ReportDateInfo dateInfo = DateReader.readDate(sheet);
        System.out.println("This report correspond to: " + dateInfo.initialDate() + " to: " + dateInfo.finalDate());

        List<TranboxData> dataList = DataReader.readData(sheet);

        Filter filter = new Filter();
        Synthesizer synthesizer = new Synthesizer();

        List<TranboxData> cleanedData = filter.cleanData(dataList);
        List<SummaryReport> summaryReportList = synthesizer.results(cleanedData);

        System.out.println("Summary of earnings per day including commissions");
        System.out.println("--------------------------------------------------");
        System.out.println("   DATE    |   TOTAL  | COMMISSIONS ");
        summaryReportList.forEach(sr -> {
            System.out.println(sr.date() + " | " + sr.granTotal() + " | " + sr.commissions());
        });
        System.out.println("--------------------------------------------------");
        System.out.println("Total commissions: "  + Commission.totalCommissions(summaryReportList));
        System.out.println("--------------------------------------------------");
        System.out.println("Total amount: " + Commission.finalAmount(summaryReportList));
    }
}
