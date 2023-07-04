package com.arche.report.tranbox.modifiers;

import com.arche.report.tranbox.models.CleanedData;
import com.arche.report.tranbox.models.SummaryReport;
import com.arche.report.tranbox.models.TranboxData;
import com.arche.report.tranbox.utils.Commission;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class modifies the TranboxData model adding commissions column
 * @author arche
 * @version 1.0
 */
public class Modifier {
    /**
     * This method modifies the base TranboxData object with a commission field.
     * Generates cleaned data with resumed sales report
     * @param dataList A TranboxData collection
     * @return CleanedData model object
     * @see CleanedData
     * @see TranboxData
     */
    public static List<CleanedData> addCommissionColumn(List<TranboxData> dataList){
        List<CleanedData> cleanedDataList = new ArrayList<>();
        dataList.forEach(data -> {
            Double plusCommission = Commission.setTotalWithCommission(data.amount(), data.total());
            Double commission = Commission.calculateCommission(data.amount(), plusCommission);

            CleanedData cleanedData = new CleanedData(
                    data.date(),
                    data.time(),
                    data.total(),
                    data.amount(),
                    plusCommission,
                    commission
            );
            cleanedDataList.add(cleanedData);
        });
        return  cleanedDataList;
    }

    private static Set<String> getDates(List<CleanedData> cleanedData){
        Set<String> dates = new HashSet<>();
        cleanedData.forEach(data -> dates.add(data.date()));

        return dates;
    }

    private static SummaryReport summarizeTotal(List<Double> totals, List<Double> commissions, String date){
        Double granTotal = totals.stream().reduce(0.0, Double::sum);
        Double commTotal = commissions.stream().reduce(0.0, Double::sum);

        return new SummaryReport(date, granTotal, commTotal);
    }

    /**
     * Summarize from a CleanedData the information that the end user will visualize
     * @param cleanedData A List of CleanedData
     * @return SummaryReport model list
     * @see CleanedData
     * @see SummaryReport
     */
    public static List<SummaryReport> summarize(List<CleanedData> cleanedData){
        Set<String> dates = getDates(cleanedData);
        List<SummaryReport> summaryReportList = new ArrayList<>();

        dates.forEach(d -> {
            List<Double> totals = new ArrayList<>();
            List<Double> commissions = new ArrayList<>();
            cleanedData.forEach(data -> {
                if (data.date().equals(d)){
                    totals.add(data.withCommission());
                    commissions.add(data.commission());
                }
            });
            SummaryReport summaryReport = summarizeTotal(totals, commissions, d);
            summaryReportList.add(summaryReport);
        });

        return summaryReportList;
    }

}
