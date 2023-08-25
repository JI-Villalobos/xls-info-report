package com.arche.report.tranbox.models;

import java.util.List;

public record TranboxDataSheet(ReportDateInfo reportDateInfo, List<TranboxData> data) {
}
