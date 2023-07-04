package com.arche.report.tranbox.modifiers;

import com.arche.report.tranbox.models.TranboxData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class that define filters to sanitize data
 * @author arche
 * @version 1.0
 */
public class Filter {
    Function<List<TranboxData>, List<TranboxData>> deleteRowsWithZeros = x ->
            x.stream().filter(y -> y.total() > 1.00).collect(Collectors.toList());

    Function<List<TranboxData>, List<TranboxData>> deleteRowsWithErrors = x ->
            x.stream().filter(y -> y.message().equals("00")).collect(Collectors.toList());

    Function<List<TranboxData>, List<TranboxData>> clean = deleteRowsWithZeros.compose(deleteRowsWithErrors);

    /**
     * This method apply a filter composition to sanitize data
     * @param data A list of raw TranboxData
     * @return A cleaned List of TranboxData
     * @see TranboxData
     */
    public List<TranboxData> cleanData(List<TranboxData> data){
        return clean.apply(data);
    }
}
