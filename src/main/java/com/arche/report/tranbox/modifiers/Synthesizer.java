package com.arche.report.tranbox.modifiers;

import com.arche.report.tranbox.models.CleanedData;
import com.arche.report.tranbox.models.SummaryReport;
import com.arche.report.tranbox.models.TranboxData;

import java.util.List;
import java.util.function.Function;

/**
 * Class that define functions to synthesize data
 * @author arche
 * @version 1.0
 */
public class Synthesizer {
    Function<List<TranboxData>, List<CleanedData>> modifyColumns = Modifier::addCommissionColumn;
    Function<List<CleanedData>, List<SummaryReport>> summarizeData = Modifier::summarize;
    Function<List<TranboxData>, List<SummaryReport>> synthesize = modifyColumns.andThen(summarizeData);

    /**
     * This method synthesize the main process to generate final summary report, starts collecting a
     * list of TranboxData, then modifying columns and finally synthesize the summarized report
     * @param data A list of TranboxData
     * @return The final list of SummaryReport
     * @see TranboxData
     * @see CleanedData
     * @see SummaryReport
     */
    public List<SummaryReport> results(List<TranboxData> data){
        return synthesize.apply(data);
    }
}
