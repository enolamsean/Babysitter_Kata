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

}
