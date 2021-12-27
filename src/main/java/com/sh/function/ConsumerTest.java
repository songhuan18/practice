package com.sh.function;

import java.util.function.Consumer;

/**
 * @author sh
 * @date 2021/12/25 4:41 下午
 */
public class ConsumerTest {

    public static void main(String[] args) {
        consumerTest((msg) -> {
            System.out.printf(msg);
        }, "你好");
    }

    private static void consumerTest(Consumer<String> consumer, String t) {
        consumer.accept(t);
    }
}
