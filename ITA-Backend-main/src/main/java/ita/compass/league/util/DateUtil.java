package ita.compass.league.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy h:mm a");

    public static LocalDateTime dateFromString(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    public static String stringFromDate(LocalDateTime date) {
        return date.format(formatter);
    }

}
