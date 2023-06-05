package com.ias.designpatterns.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandPatternLogicTest {

    @Test
    public void testReprocessFlow() {
        int minHoursRequired = 21;
        int lastCheckHourET = 8;
        int currentHourET = 9;

        //Assert that reprocess run not triggered when enough hours not available
        CommandPattern notEnoughHoursAvailable = new CommandPattern(1, minHoursRequired, lastCheckHourET, currentHourET, true);
        Assertions.assertFalse(notEnoughHoursAvailable.isEligibleForProcessing());

        //Assert that reprocess run triggered when enough hours are available
        CommandPattern enoughHoursAvailable = new CommandPattern(22, minHoursRequired, lastCheckHourET, currentHourET, true);
        Assertions.assertTrue(enoughHoursAvailable.isEligibleForProcessing());
    }

    @Test
    public void testRegularFlowBeforeLastCheckHour() {
        int minHoursRequired = 21;
        int lastCheckHourET = 8;
        int currentHourET = 6;

        //Assert that regular run not triggered unless 24hours worth of data are available
        CommandPattern OneHourAvailable = new CommandPattern(1, minHoursRequired, lastCheckHourET, currentHourET, false);
        Assertions.assertFalse(OneHourAvailable.isEligibleForProcessing());

        //Assert that regular run not triggered unless 24hours worth of data are available
        CommandPattern notEnoughHoursAvailable = new CommandPattern(22, minHoursRequired, lastCheckHourET, currentHourET, false);
        Assertions.assertFalse(notEnoughHoursAvailable.isEligibleForProcessing());

        //Assert that regular run triggered when 24hours worth of data are available
        CommandPattern allHoursAvailable = new CommandPattern(24, minHoursRequired, lastCheckHourET, currentHourET, false);
        Assertions.assertTrue(allHoursAvailable.isEligibleForProcessing());
    }

    @Test
    public void testRegularFlowAtOrAfterLastCheckHour() {
        int minHoursRequired = 21;
        int lastCheckHourET = 8;
        int currentHourET = 8;

        //Assert that regular run not triggered unless 24hours worth of data are available
        CommandPattern OneHourAvailable = new CommandPattern(1, minHoursRequired, lastCheckHourET, currentHourET, false);
        Assertions.assertFalse(OneHourAvailable.isEligibleForProcessing());

        //Assert that regular run triggered when enough hours are available
        CommandPattern enoughHoursAvailable = new CommandPattern(22, minHoursRequired, lastCheckHourET, currentHourET, false);
        Assertions.assertTrue(enoughHoursAvailable.isEligibleForProcessing());

        //Assert that regular run triggered when enough hours are available
        CommandPattern allHoursAvailable = new CommandPattern(24, minHoursRequired, lastCheckHourET, currentHourET, false);
        Assertions.assertTrue(allHoursAvailable.isEligibleForProcessing());
    }
}
