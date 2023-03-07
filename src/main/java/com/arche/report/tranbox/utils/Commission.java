package com.arche.report.tranbox.utils;

import com.arche.report.tranbox.models.SummaryReport;

import java.util.ArrayList;
import java.util.List;

public class Commission {
    public static Double setTotalWithCommission(Double amount, Double total){
        if (total < amount)
            return total + 10.0;

        return total;
    };

    public static Double calculateCommission(Double amount, Double totalWithCommission){
        return totalWithCommission - amount;
    }

    public static Double totalCommissions(List<SummaryReport> summaryReportList){
        List<Double> commissions = new ArrayList<>();
        summaryReportList.forEach(data -> commissions.add(data.commissions()));

        return commissions.stream().reduce(0.0, Double::sum);
    }
}
