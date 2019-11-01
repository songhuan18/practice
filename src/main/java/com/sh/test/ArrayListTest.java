package com.sh.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author sh
 * @date 2019-09-05 15:22
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello word");
        Object[] objects = list.toArray();
        System.out.println(objects.getClass().getSimpleName());
        objects[0] = new Object(); // 执行报错
    }
}
