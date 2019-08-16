package com.sh;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;

/**
 * 修改String中的值，并且不通过赋值或者不创建多一个对象
 */

public class TestString {
    public static void main(String[] args) throws Exception {
//        String str = "hello";
//        String a = str;
//        System.out.println(str == str);
//        System.out.println(str.equals(a));
//        System.out.println(str);
//        System.out.println("=====================================");
//        Field field = str.getClass().getDeclaredField("value");
//        field.setAccessible(true);
//        Field modifiers = Field.class.getDeclaredField("modifiers");
//        modifiers.setAccessible(true);
//        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//        field.set(str, new char[]{'1','2','3'});
//        System.out.println(str);
//        System.out.println(str == str);
//
//
//        String sqlScript = "<script>select * from %s where %s = %s </script>";
//        String sql = String.format(sqlScript, "user", "id", 1);
//        System.out.println(sql);

        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
        Integer a = new Integer(42);
        Integer b = new Integer(42);
        System.out.println(a == b);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println("192.168.10.211".hashCode());
        System.out.println("256.256.256.256".hashCode());
    }
}
