package com.sh.function;

public class ConverterTest {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from -> Integer.valueOf(from));
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }
}
