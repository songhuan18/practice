package com.sh;

import java.util.Scanner;

/**
 * @author sh
 * @date 2020-02-20 19:08
 */
public class Test1 {
    public static void main(String[] args) {
        int a = 555444;
        System.out.println(a % 1000);
    }

    private Integer find(Integer num) {

        if (num.toString().length() != 6) {
            throw new RuntimeException("请正确输入数字");
        }
        Integer s = num / 1000;
        Integer e = num % 1000;
        char[] aChars = s.toString().toCharArray();
        char[] bChars = e.toString().toCharArray();
        int sum = (int) aChars[0] + (int) aChars[1] + (int) aChars[2];
        int a = (int) aChars[0] - (int) bChars[0];
        int b = (int) aChars[1] - (int) bChars[1];
        int c = (int) aChars[2] - (int) bChars[2];
        int result = a + b + c;
        if (result == 0) {
            return num;
        }
        if (result > 0) {

        }
        if (result < 0) {

        }
        return null;
    }
}
