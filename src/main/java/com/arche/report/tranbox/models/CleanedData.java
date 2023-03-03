package com.arche.report.tranbox.models;

public record CleanedData(String date,
                          String time,
                          Double total,
                          Double amount,
                          Double withCommission,
                          Double commission) {
}
