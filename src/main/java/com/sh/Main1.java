package com.sh;

public class Main1 {
    public static void main(String[] args) {
        int i = maxLen("()(((())))()()()()()((");
        System.out.println(i);
    }

    private static int maxLen(String str) {
        String s = "()";
        char[] chars = s.toCharArray();
        String start = String.valueOf(chars[0]);
        String end = String.valueOf(chars[1]);
        char[] charArray = str.toCharArray();
        int len = 0;
        int maxLen = 0;
        int left = 0;
        int flag = 0;
        int right = 0;
        for (int i = 0; i < charArray.length; i++) {
            String ch = String.valueOf(charArray[i]);
            if (i < charArray.length - 1) {
                if (start.equals(ch)) {
                    if (flag == 0 && left > 1) {
                        len = 0;
                    }
                    left++;
                    flag = 0;
                } else if (end.equals(ch)) {
                    right++;
                    if (flag == 0 || left > 0) {
                        len += 2;
                        if (len >= maxLen) {
                            maxLen = len;
                        }
                        left--;
                    }
                    flag = 1;
                } else {
                    return 0;
                }
            }
        }
        return maxLen;
    }
}
