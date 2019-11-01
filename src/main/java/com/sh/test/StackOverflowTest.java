package com.sh.test;

/**
 * @author sh
 * @date 2019-09-10 21:19
 */
public class StackOverflowTest {
    private static int count;

    public static void redo() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }
}
