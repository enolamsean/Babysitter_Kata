package com.seanmalone.babysitter;

import java.text.ParseException;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class BabySitter {
    private final int fivePM = 17, ninePM = 21, tenPM = 22, elevenPM = 23, midnight = 24, fourAM = 28;
    private final boolean validTime = true;
    private int startTime = 0, endTime = 0, pay = 0;
    private String family;

    public static void main(String[] args) {
    }

    public boolean validateInputTime(int timeToValidate) {
        if ((timeToValidate >= fivePM) && (timeToValidate <= fourAM)) {
            return validTime;
        } else {
            return !validTime;
        }
    }

    public boolean validateEndInputTime(int startTime, int endTime) {
        if (validateInputTime(endTime) && (startTime < endTime)) {
            return validTime;
        }
        return !validTime;
    }


    public int convertInputTime(String inputTime) throws ParseException {
        DateFormat time_to_date = new SimpleDateFormat("hh:mm aa");
        int milliseconds = 1000, seconds = 60, minutes = 60, errorCorrectionValue = 5, fourAMBeforeConversion = 4, conversionStorageTime;

        try {
            //Converting input String to Date format
            Date timeInDateFormat = time_to_date.parse(inputTime);

            //Converting Date format input into integer
            //The date format conversion consistently adds 5 additional hours to conversion,
            //errorCorrectionValue is deducted to correct this error.
            conversionStorageTime = (((((int) timeInDateFormat.getTime()) / milliseconds) / seconds) / minutes) - errorCorrectionValue;

            //if the time registers as after midnight it will be add to 24
            //to more easily calculate total hours worked
            if (conversionStorageTime < fourAMBeforeConversion) {
                conversionStorageTime += 24;
            }
        } catch (ParseException e) {
            return 0;
        }
        return conversionStorageTime;
    }

    public int setStartTime(String scannerStartTime) throws ParseException {
        //if the validateInputTime function returns true it will assign
        //the returned value to the endTime variable
        if ((validateInputTime(convertInputTime(scannerStartTime)))) {
            startTime = convertInputTime(scannerStartTime);
        }
        return startTime;
    }

    public int setEndTime(String scannerEndTime) throws ParseException {

        //if the validateInputTime function returns true it will assign
        //the returned value to the endTime variable
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

    public int familyACalulation(int startTime, int endTime) {
        int familyAHourlyRateAfterFivePM = 15, familyAHourlyRateAfterElevenPM = 20;

        //Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night
        //This If handles if startTime is before 11pm and the endTime is after 11pm
        if (startTime < elevenPM && endTime >= elevenPM) {
            return (((elevenPM - startTime) * familyAHourlyRateAfterFivePM) + ((endTime - elevenPM) * familyAHourlyRateAfterElevenPM));

            //This If handles if startTime is after 11pm and the endTime is after 11pm
        } else if (startTime >= elevenPM && endTime > elevenPM) {
            return ((endTime - startTime) * familyAHourlyRateAfterElevenPM);

            //This If handles if startTime and endTime are before 11pm
        } else if (startTime < elevenPM && endTime <= elevenPM) {
            return ((endTime - startTime) * familyAHourlyRateAfterFivePM);
        }
        return 0;
    }

    public int familyBCalculation(int startTime, int endTime) {

        //Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night
        int familyBHourlyRateAfterFivePM = 12, familyBHourlyRateAfterTenPM = 8, familyBHourlyRateAfterMidnight = 16;

        //if the startTime is prior to 10 and the endTime is set after 10
        if (startTime < tenPM && endTime >= tenPM) {

            //In the situation that endTime is after midnight
            if (endTime > midnight) {
                return (((tenPM - startTime) * familyBHourlyRateAfterFivePM) + (familyBHourlyRateAfterTenPM * (midnight - tenPM)) + ((endTime - midnight) * familyBHourlyRateAfterMidnight));
            }
            return (((tenPM - startTime) * familyBHourlyRateAfterFivePM) + ((midnight - endTime) * familyBHourlyRateAfterTenPM));

            //This If handles if startTime and endTime are after 10pm
        } else if (startTime >= tenPM && endTime > tenPM) {

            //In the situation that endTime is after midnight
            if (startTime < midnight && endTime < midnight) {
                return (endTime - startTime) * familyBHourlyRateAfterTenPM;
            }
            return (((midnight - startTime) * familyBHourlyRateAfterTenPM) + ((endTime - midnight) * familyBHourlyRateAfterMidnight));

            //if startTime and endTime are after midnight
        } else if (startTime >= midnight && endTime > midnight) {
            return (endTime - startTime) * familyBHourlyRateAfterMidnight;
        }
        return 0;
    }

    public int familyCCalculation(int startTime, int endTime) {
        int familyCHourlyRateAfterFivePM = 21, familyCHourlyRateAfterNinePM = 15;

        //if startTime is before 9pm and endtTime is after 9pm
        if (startTime < ninePM && endTime > ninePM) {
            return (((ninePM - startTime) * familyCHourlyRateAfterFivePM) + ((endTime - ninePM) * familyCHourlyRateAfterNinePM));

            //if startTime and endTime are after 9pm
        } else if (startTime >= ninePM && endTime > ninePM) {
            return ((endTime - startTime) * familyCHourlyRateAfterNinePM);

            //if startTime and endTime are before 9pm
        } else if (startTime < ninePM && endTime <= ninePM) {
            return ((endTime - startTime) * familyCHourlyRateAfterFivePM);
        }
        return 0;
    }

}
