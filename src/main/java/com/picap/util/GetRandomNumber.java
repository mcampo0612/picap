package com.picap.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetRandomNumber {

    public static String fromDate(String format) {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dateTime.format(now);
    }

    public static String fromDate(){
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("ddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dateTime.format(now);
    }
}
