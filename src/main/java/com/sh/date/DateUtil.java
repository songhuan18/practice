package com.sh.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
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

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 获取本月最后一天
     * @return 本月最后一天
     */
    public static LocalDate getMonthOfLastDay() {
//        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     *  获取本月帝天
     * @return 本月第一天
     */
    public static LocalDate getMonthOfFirstDay() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 两个日期相隔时间（秒）
     * @param t1 开始时间
     * @param t2 结束时间
     * @return
     */
    public static long betweenDuration(LocalDateTime t1, LocalDateTime t2) {
        return Duration.between(t1, t2).getSeconds();
    }

    /**
     * 计算两个日期相隔天数
     * @param t1  开始日期
     * @param t2 结束日期
     * @return
     */
    public static int betweenDays(LocalDate t1, LocalDate t2) {
        return Period.between(t1, t2).getDays();
    }

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(betweenDuration(now, now1));
        int[] arr = new int[]{1, 2, 3, 4, 5};
    }
}
