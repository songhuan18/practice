package com.sh;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
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
//        System.out.println(a == str);
//        System.out.println(a.hashCode() + "  " + str.hashCode());
//
//
//        String sqlScript = "<script>select * from %s where %s = %s </script>";
//        String sql = String.format(sqlScript, "user", "id", 1);
//        System.out.println(sql);

//        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
//        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
//        Integer a = new Integer(42);
//        Integer b = new Integer(42);
//        System.out.println(a == b);
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println("192.168.10.211".hashCode());
//        System.out.println("256.256.256.256".hashCode());


//        String str = "hello";
//        System.out.println(str.substring(0,1).toUpperCase() + str.substring(1));


//        try {
//            int i = 1 / 0;
//        } catch (Exception e) {
//            System.out.println("catch");
//            throw new RuntimeException("runtime exception");
//        } finally {
//            System.out.println("finally");
//        }
//
//        System.out.println(new BigDecimal(String.valueOf(37.49)).add(new BigDecimal(String.valueOf(12.31))).doubleValue());


        final String str = "计算机软件";
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
