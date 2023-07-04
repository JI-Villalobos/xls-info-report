package com.arche.report.tranbox.utils;

import com.arche.report.tranbox.models.SummaryReport;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the utilities to calculate sale's commission
 * @author arche
 * @version 1.0
 */
public class Commission {
    /**
     * Determine if the total earns by sale already includes commissions
     * @param amount A raw sales commission report contains a column named amount with the base cost of the service
     * @param total A raw sales commission report contains a column named total with the final cost of the service
     * @return The real total of a sale with commissions
     */
    public static Double setTotalWithCommission(Double amount, Double total){
        if (total < amount)
            return total + Global.BASE_COMMISSION;

        return total;
    };

    /**
     * Estimated a real commission by sale
     * @param amount A raw sales commission report contains a column named amount with the base cost of the service
     * @param totalWithCommission A total amount of the sale including commissions
     * @see #setTotalWithCommission(Double, Double) 
     * @return The commission by sale
     */
    public static Double calculateCommission(Double amount, Double totalWithCommission){
        return totalWithCommission - amount;
    }

    public static Double totalCommissions(List<SummaryReport> summaryReportList){
        List<Double> commissions = new ArrayList<>();
        summaryReportList.forEach(data -> commissions.add(data.commissions()));

        return commissions.stream().reduce(0.0, Double::sum);
    }
}
