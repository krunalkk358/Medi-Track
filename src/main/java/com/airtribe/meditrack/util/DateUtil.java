package com.airtribe.meditrack.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime parseDate(String date) {

        return LocalDateTime.parse(date, formatter);

    }

    public static String formatDate(LocalDateTime date) {

        return date.format(formatter);

    }

}