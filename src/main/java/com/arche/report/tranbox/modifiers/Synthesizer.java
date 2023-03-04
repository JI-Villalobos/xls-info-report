package com.arche.report.tranbox.modifiers;

import com.arche.report.tranbox.models.CleanedData;
import com.arche.report.tranbox.models.SummaryReport;
import com.arche.report.tranbox.models.TranboxData;

import java.util.List;
import java.util.function.Function;

public class Synthesizer {
    Function<List<TranboxData>, List<CleanedData>> modifyColumns = Modifier::addCommissionColumn;
    Function<List<CleanedData>, List<SummaryReport>> summarizeData = Modifier::summarize;
    Function<List<TranboxData>, List<SummaryReport>> synthesize = modifyColumns.andThen(summarizeData);

    public List<SummaryReport> results(List<TranboxData> data){
        return synthesize.apply(data);
    }
}
