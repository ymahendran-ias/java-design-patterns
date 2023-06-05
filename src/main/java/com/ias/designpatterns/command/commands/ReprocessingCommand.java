package com.ias.designpatterns.command.commands;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReprocessingCommand implements Command {

    private final int minHoursAvailable;
    private final int minHoursRequired;
    private final boolean isReprocessingRun;

    @Override
    public boolean eligibleForProcessing() {
        return isReprocessingRun && minHoursAvailable >= minHoursRequired;
    }
}
