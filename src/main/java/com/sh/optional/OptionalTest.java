package com.sh.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());
        optional.ifPresent(op -> System.out.println(op));
        System.out.println(optional.get());
//        Optional<Object> optional1 = Optional.of(null);// error
        Optional<Object> optional2 = Optional.ofNullable(null);
        System.out.println(optional2.isPresent());
//        System.out.println(optional2.get());
        optional2.ifPresent(op -> System.out.println(op));
    }
}
