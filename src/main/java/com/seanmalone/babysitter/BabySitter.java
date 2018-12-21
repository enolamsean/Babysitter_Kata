package com.seanmalone.babysitter;

import java.text.ParseException;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class BabySitter {
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
        int milliseconds = 1000, seconds = 60, minutes = 60, errorCorrectionValue = 5, fourAM = 4, conversionStorageTime;

        try {
            //Converting input String to Date format
            Date timeInDateFormat = time_to_date.parse(inputTime);

            /*Converting Date format input into integer
            The date format conversion consistently adds 5 additional hours to conversion,
            errorCorrectionValue is deducted to correct this error.*/
            conversionStorageTime = (((((int) timeInDateFormat.getTime()) / milliseconds) / seconds) / minutes) - errorCorrectionValue;

            /*if the time registers as after midnight it will be add to 24
            to more easily calculate total hours worked*/
            if (conversionStorageTime < fourAM) {
                conversionStorageTime += 24;
            }
        } catch (ParseException e) {
            return 0;
        }
        return conversionStorageTime;
    }

}
