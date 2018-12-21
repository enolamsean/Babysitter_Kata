package com.seanmalone.babysitter;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.Assert.*;

public class BabySitterTest {
    private BabySitter babySitterTestObject;

    @Before
    public void setUp() throws Exception {
        babySitterTestObject = new BabySitter();
    }

    @Test
    public void validateInputStartTime() {
        assertTrue(babySitterTestObject.validateInputTime(17));
    }

    @Test
    public void errorHandlingTimeInputConversion() throws ParseException {
        assertEquals(0, babySitterTestObject.convertInputTime("6:00"));
    }

    @Test
    public void convertPMStartTimeToTwentyFourHourFormat() throws ParseException {
        assertEquals(18, babySitterTestObject.convertInputTime("6:00 pm"));
    }

    @Test
    public void convertAMEndTimeToTwentFourHourFormat() throws ParseException {
        assertEquals(27, babySitterTestObject.convertInputTime("3:00 am"));
    }

    @Test
    public void settingStartTimeVariableandValidatingStringInput() throws ParseException {
        assertEquals(17, babySitterTestObject.setStartTime("5:00 pm"));
    }
    @Test
    public void settingEndTimeVariableandValidatingStringInput() throws ParseException {
        assertEquals(27, babySitterTestObject.setEndTime("3:00 am"));
    }
      /*@After
    public void tearDown() throws Exception {
    }*/
}

