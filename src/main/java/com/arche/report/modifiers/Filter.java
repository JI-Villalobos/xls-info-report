package com.arche.report.modifiers;

import com.arche.report.tranbox.models.TranboxData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filter {
    Function<List<TranboxData>, List<TranboxData>> deleteRowsWithZeros = x ->
            x.stream().filter(y -> y.total() > 1.00).collect(Collectors.toList());

    Function<List<TranboxData>, List<TranboxData>> deleteRowsWithErrors = x ->
            x.stream().filter(y -> y.message().equals("00")).collect(Collectors.toList());

    Function<List<TranboxData>, List<TranboxData>> clean = deleteRowsWithZeros.compose(deleteRowsWithErrors);

    public List<TranboxData> cleanData(List<TranboxData> data){
        return clean.apply(data);
    }
}
