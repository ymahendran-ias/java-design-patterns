package com.ias.designpatterns.command.commands;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class All24HoursAvailableCommand implements Command {

    private final int minHoursAvailable;

    @Override
    public boolean eligibleForProcessing() {
        return minHoursAvailable == 24;
    }
}
