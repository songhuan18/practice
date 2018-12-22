package com.sh;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;

public class Test {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
//        LocalDate startDate = LocalDate.of(2014, Month.AUGUST, 18);
//        LocalDate endDate = LocalDate.of(2018, Month.OCTOBER, 16);
//
//        System.out.println(startDate.until(endDate, ChronoUnit.DAYS));

        Runnable task = () -> {
            int i = connectBlocking();
            System.out.println("hello word " + i);
        };

        new Thread(task).start();
    }

    private static int connectBlocking() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
