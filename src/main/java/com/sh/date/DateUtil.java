package com.sh.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前时间零点，如：00:00
     * @return
     */
    public static LocalTime getZoneTime() {
        return LocalTime.of(0, 0);
    }

    /**
     * 获取当前日期前几天的日期
     * @param day
     * @return
     */
    public static LocalDate getCurrentBeforeDay(Long day) {
        return LocalDate.now().plusDays(0 - day);
    }

    /**
     * 获取当前日期后几天的数据
     * @param day
     * @return
     */
    public static LocalDate getCurrentAfterDay(Long day) {
        return LocalDate.now().plusDays(day);
    }

    /**
     * 将时间字符串转换为Date格式
     * @param date
     * @return
     */
    private static Date stringToDate(String date) {
        return Date.from(LocalDate.parse(date).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String dateToString(Date date, String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return date.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime().format(dtf);
    }

    private static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void main(String[] args) {
        System.out.println(convertToLocalDateViaInstant(new Date()));
    }
}
