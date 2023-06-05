package com.ias.designpatterns.command;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlainIfElseLogicTest {


    @Test
    public void testReprocessFlow() {
        int minHoursRequired = 21;
        int lastCheckHourET = 8;
        int currentHourET = 9;

        PlainIfElseLogic logic = new PlainIfElseLogic(minHoursRequired, lastCheckHourET, currentHourET);

        //Assert that reprocess run not triggered when enough hours not available
        Assertions.assertFalse(logic.isEligibleForProcessing(1, true));

        //Assert that reprocess run triggered when enough hours are available
        Assertions.assertTrue(logic.isEligibleForProcessing(22, true));
    }

    @Test
    public void testRegularFlowBeforeLastCheckHour() {
        int minHoursRequired = 21;
        int lastCheckHourET = 8;
        int currentHourET = 6;

        PlainIfElseLogic logic = new PlainIfElseLogic(minHoursRequired, lastCheckHourET, currentHourET);

        //Assert that regular run not triggered unless 24hours worth of data are available
        Assertions.assertFalse(logic.isEligibleForProcessing(1, false));

        //Assert that regular run not triggered unless 24hours worth of data are available
        Assertions.assertFalse(logic.isEligibleForProcessing(22, false));

        //Assert that regular run triggered when 24hours worth of data are available
        Assertions.assertTrue(logic.isEligibleForProcessing(24, false));
    }

    @Test
    public void testRegularFlowAtOrAfterLastCheckHour() {
        int minHoursRequired = 21;
        int lastCheckHourET = 8;
        int currentHourET = 8;

        PlainIfElseLogic logic = new PlainIfElseLogic(minHoursRequired, lastCheckHourET, currentHourET);

        //Assert that regular run not triggered unless 24hours worth of data are available
        Assertions.assertFalse(logic.isEligibleForProcessing(1, false));

        //Assert that regular run triggered when enough hours are available
        Assertions.assertTrue(logic.isEligibleForProcessing(22, false));

        //Assert that regular run triggered when enough hours are available
        Assertions.assertTrue(logic.isEligibleForProcessing(24, false));
    }
}
