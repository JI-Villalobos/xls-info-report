package com.arche.report.tranbox.models;

public record TranboxData(
        String date,
        String time,
        String node,
        String name,
        String user,
        String product,
        Double total,
        Double amount,
        String reference,
        String id,
        String message
) {
}
