package com.ias.designpatterns.command;

import com.ias.designpatterns.command.commands.All24HoursAvailableCommand;
import com.ias.designpatterns.command.commands.Command;
import com.ias.designpatterns.command.commands.RegularProcessingCommand;
import com.ias.designpatterns.command.commands.ReprocessingCommand;
import java.util.List;

public class CommandPattern {
    private final List<Command> commands;

    public CommandPattern(int hoursAvailable, int hoursRequired, int lastCheckHourET, int currentHourET, boolean isReprocessingRun) {
        this.commands = List.of(
            new All24HoursAvailableCommand(hoursAvailable),
            new ReprocessingCommand(hoursAvailable, hoursRequired, isReprocessingRun),
            new RegularProcessingCommand(hoursAvailable, hoursRequired, lastCheckHourET, currentHourET)
        );
    }

    public boolean isEligibleForProcessing() {
        return commands.stream().anyMatch(Command::eligibleForProcessing);
    }
}
