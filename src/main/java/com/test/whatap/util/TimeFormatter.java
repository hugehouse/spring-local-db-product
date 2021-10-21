package com.test.whatap.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    private static final DateTimeFormatter uploadTimeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");

    public static String formTime(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }
    public static String formUploadTime(LocalTime localTime) {
        return localTime.format(uploadTimeFormatter);
    }
}
