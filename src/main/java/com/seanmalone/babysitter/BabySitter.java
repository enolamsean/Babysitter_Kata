package com.seanmalone.babysitter;

import java.text.ParseException;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class BabySitter {
    private final int fivePM = 17, ninePM = 21, tenPM = 22, elevenPM = 23, midnight = 24;
    private int startTime = 0, endTime = 0;
    private String family;

    public static void main(String[] args) {
    }

    public boolean validateInputTime(int timeToValidate) {
        int fourAMNextDay = 28, fivePMFirstDay = 17;
        boolean validTime = true;
        if ((timeToValidate >= fivePMFirstDay) && (timeToValidate <= fourAMNextDay)) {
            return validTime;
        } else {
            return !validTime;
        }
    }

    public int convertInputTime(String inputTime) throws ParseException {
        DateFormat time_to_date = new SimpleDateFormat("hh:mm aa");
        int milliseconds = 1000, seconds = 60, minutes = 60, errorCorrectionValue = 5, fourAMBeforeConversion = 4, conversionStorageTime;

        try {
            //Converting input String to Date format
            Date timeInDateFormat = time_to_date.parse(inputTime);

            /*Converting Date format input into integer
            The date format conversion consistently adds 5 additional hours to conversion,
            errorCorrectionValue is deducted to correct this error.*/
            conversionStorageTime = (((((int) timeInDateFormat.getTime()) / milliseconds) / seconds) / minutes) - errorCorrectionValue;

            /*if the time registers as after midnight it will be add to 24
            to more easily calculate total hours worked*/
            if (conversionStorageTime < fourAMBeforeConversion) {
                conversionStorageTime += 24;
            }
        } catch (ParseException e) {
            return 0;
        }
        return conversionStorageTime;
    }

    public int setStartTime(String scannerStartTime) throws ParseException {
       /*  if the validateInputTime function returns true it will assign
        the returned value to the endTime variable*/
        if ((validateInputTime(convertInputTime(scannerStartTime)))) {
            startTime = convertInputTime(scannerStartTime);
        }
        return startTime;
    }

    public int setEndTime(String scannerEndTime) throws ParseException {

        /*if the validateInputTime function returns true it will assign
        the returned value to the endTime variable*/
        if ((validateInputTime(convertInputTime(scannerEndTime)))) {
            endTime = convertInputTime(scannerEndTime);
        }
        return endTime;
    }

    public boolean validateFamily(String validateFamily) {
        boolean validFamily = true;
        if (validateFamily.equalsIgnoreCase("A") ||
                validateFamily.equalsIgnoreCase("B") ||
                validateFamily.equalsIgnoreCase("C")) {
            return validFamily;
        }
        return !validFamily;
    }

    public String setFamily(String familyInput) {
        if (validateFamily(familyInput)) {
            family = familyInput;
            return family;
        } else {
            return errorMessage();
        }
    }

    public String errorMessage() {
        return "Error";
    }
}
