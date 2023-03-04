package com.arche.report.commands;

import com.arche.report.tranbox.methods.PrintSummaryReport;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ReportCommands {
    private boolean generated;

    @ShellMethod(value = "Generate the summary report.", key = "extract")
    public void generate(@ShellOption(value = { "-p" }) String path){
        PrintSummaryReport.printSummary(path);
    }

    @ShellMethod(value="Exports a cleaned xlsx file from the original file.", key = "exp")
    public void export(){
        //a complex process
    }

    public Availability exportAvailability(){
        return generated
                ? Availability.available()
                : Availability.unavailable("the summary report must be generated before export the cleaned file.");
    }
}
