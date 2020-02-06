package com.sh.thread;

import java.util.Hashtable;

/**
 * @author sh
 * @date 2020-01-30 14:35
 */
public class TestHashtable {
    private static Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                hashtable.put(i, i);
            }
            new Thread(() -> {
                for (int i = 0; i < hashtable.size(); i++) {
                    hashtable.remove(i);
                }
            }).start();

            new Thread(() -> {
                for (int i = 0; i < hashtable.size(); i++) {
                    System.out.println(hashtable.get(i));
                }
            }).start();
            while (Thread.activeCount() > 20);
        }

    }
}
