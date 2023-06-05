package com.ias.designpatterns.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlainIfElseLogic {

    private final int minHoursRequired;
    private final int lastCheckHourET;
    private final int currentHourET;

    public boolean isEligibleForProcessing(int hoursAvailable, boolean isReprocess) {
        if(isReprocess) {
            if(hoursAvailable >= minHoursRequired) {
                return true;
            } else {
                return false;
            }
        } else {
            if(currentHourET >= lastCheckHourET) {
                if(hoursAvailable >= minHoursRequired) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(hoursAvailable == 24) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
