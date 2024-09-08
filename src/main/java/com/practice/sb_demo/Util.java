package com.practice.sb_demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Util {
    public static Date strToDate(String strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//        String dateInString = "22-01-2015 10:15:55 AM";
        return formatter.parse(strDate);
    }

    public static String dateToStr(Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//        String dateInString = "22-01-2015 10:15:55 AM";
        return formatter.format(date);
    }
}
