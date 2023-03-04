package com.arche.report.tranbox.utils;

public class Commission {
    public static Double setTotalWithCommission(Double amount, Double total){
        if (total < amount)
            return total + 10.0;

        return total;
    };

    public static Double calculateCommission(Double amount, Double totalWithCommission){
        return totalWithCommission - amount;
    }
}
