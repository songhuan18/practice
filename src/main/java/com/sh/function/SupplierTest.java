package com.sh.function;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author sh
 * @date 2021/11/23 8:42 上午
 */
public class SupplierTest {

    public static void main(String[] args) {
        fun1(() -> {
            int[] arr = {1, 2, 8, 5, 99, 100};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }

    private static void fun1(Supplier<Integer> supplier) {
        Integer max = supplier.get();
        System.out.println("max = " + max);
    }
}
