package com.seanmalone.babysitter;


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
    public void errorHandlingProperTimeInputFormatAndConversion() throws ParseException {
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

    @Test
    public void validatingFamilyIfAShouldReturnTrue() {
        assertTrue(babySitterTestObject.validateFamily("a"));
    }

    @Test
    public void validatingFamilyIfBShouldReturnTrue() {
        assertTrue(babySitterTestObject.validateFamily("b"));
    }

    @Test
    public void validatingFamilyIfCShouldReturnTrue() {
        assertTrue(babySitterTestObject.validateFamily("C"));
    }

    @Test
    public void validatingFamilyIfNotAorBorCShouldReturnFalse() {
        assertFalse(babySitterTestObject.validateFamily("d"));
    }

    @Test
    public void assigningFamilyVariableIsSetAfterValidation() {
        assertEquals("A", babySitterTestObject.setFamily("A"));
    }

    @Test
    public void ifValidateFamilyReturnsFalseShouldReceiveErrorMessage() {
        assertEquals("Error", babySitterTestObject.setFamily("d"));
    }

    @Test
    public void familyACalculation5PMTo10PMShouldReturn75() {
        assertEquals(75, babySitterTestObject.familyACalulation(17, 22));
    }

    @Test
    public void familyACalculationStartTime5PMAndEndTime12AMShouldReturn110() {
        assertEquals(110, babySitterTestObject.familyACalulation(17, 24));
    }

    @Test
    public void familyACalculationStartTime11PMAndEndTime2AMShouldReturn60() {
        assertEquals(60, babySitterTestObject.familyACalulation(23, 26));
    }

    @Test

    public void familyBCalculationStartTime5PMAndEndTime2AMShouldReturn108() {
        assertEquals(108, babySitterTestObject.familyBCalculation(17, 26));
    }

    @Test
    public void familyBCalculationStartTime5PMAndEndTime11PMShouldReturn68() {
        assertEquals(68, babySitterTestObject.familyBCalculation(17, 23));
    }

    @Test
    public void familyBCalculationStartTime10PMAndEndTime11PMShouldReturn8() {
        assertEquals(8, babySitterTestObject.familyBCalculation(22, 23));
    }

    @Test
    public void familyBCalculationStartTime10PMAndEndTime3AMShouldReturn64() {
        assertEquals(64, babySitterTestObject.familyBCalculation(22, 27));
    }

    @Test
    public void familyBCalculationStartTime12AMAndEndTime3AMShouldReturn48() {
        assertEquals(48, babySitterTestObject.familyBCalculation(24, 27));
    }

    @Test
    public void familyCCalulationStartTime5PMEndTime2AMShouldReturn159() {
        assertEquals(159, babySitterTestObject.familyCCalculation(17, 26));
    }

    @Test
    public void familyCCalulationStartTime9PMEndTime3AMShouldReturn90() {
        assertEquals(90, babySitterTestObject.familyCCalculation(21, 27));
    }

    @Test
    public void familyCCalulationStartTime5PMEndTime9PMShouldReturn84() {
        assertEquals(84, babySitterTestObject.familyCCalculation(17, 21));
    }

    @Test
    public void ifEndTimeIsBeforeStartTimeShouldReturnFalse() {
    assertFalse(babySitterTestObject.validateEndInputTime(21, 17));
    }

}

