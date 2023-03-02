package com.arche.report.commands;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ReportCommands {
    private boolean generated;

    @ShellMethod(value = "Generate the summary report.", key = "gen")
    public void generate(String path){
        //the big stuff goes here
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
