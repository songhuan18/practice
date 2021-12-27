package com.sh.function;

import java.util.function.Function;

/**
 * @author sh
 * @date 2021/12/25 4:41 下午
 */
public class FunctionTest {

    public static void main(String[] args) {
        function((a) -> {
            System.out.printf(a);
            return a.toUpperCase();
        }, "abc");
    }

    public static String function(Function<String, String> function, String str) {
        return function.apply(str);
    }
}
