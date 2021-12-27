package com.sh.function;

import java.util.function.Predicate;

/**
 * @author sh
 * @date 2021/11/23 8:49 上午
 */
public class PredicateTest {

    public static void main(String[] args) {
        test((msg) -> {
            return msg.equals("Hello");
        }, "Hello");
    }

    private static void test(Predicate<String> predicate, String msg) {
        boolean b = predicate.test(msg);
        System.out.println("是否相等：" + b);
    }
}
