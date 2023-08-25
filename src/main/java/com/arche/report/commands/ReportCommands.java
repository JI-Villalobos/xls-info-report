package com.arche.report.commands;

import com.arche.report.tranbox.methods.GenerateTranboxDataFile;
import com.arche.report.tranbox.methods.PrintSummaryReport;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.FileNotFoundException;
import java.io.IOException;

@ShellComponent
public class ReportCommands {
    private boolean generated;

    @ShellMethod(value = "Generate the summary report.", key = "extract")
    public void generate(@ShellOption(value = { "-p" }) String filename){
        PrintSummaryReport.printSummary(filename);
        generated = true;
    }

    @ShellMethod(value="Exports a cleaned xlsx file from the original file.", key = "exp")
    public void export() throws IOException {
        GenerateTranboxDataFile.generateXLSX();
    }

    public Availability exportAvailability(){
        return generated
                ? Availability.available()
                : Availability.unavailable("the summary report must be generated before export the cleaned file.");
    }
}
