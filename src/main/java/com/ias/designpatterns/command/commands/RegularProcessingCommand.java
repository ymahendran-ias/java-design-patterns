package com.ias.designpatterns.command.commands;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegularProcessingCommand implements Command {

    private final int minHoursAvailable;
    private final int minHoursRequired;
    private final int lastCheckHourET;
    private final int currentHourET;

    @Override
    public boolean eligibleForProcessing() {
        if(currentHourET >= lastCheckHourET) {
            return minHoursAvailable >= minHoursRequired;
        }
        return false;
    }
}
