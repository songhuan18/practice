package com.sh;

import lombok.Data;

/**
 * Author sh
 * Date 2019-08-02 22:25
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//        int[] a = {1, 2};
//        int[] clone = a.clone();
//        System.out.println(a.hashCode());
//        System.out.println(clone.hashCode());
        Person person = new Person();
        person.setName("zs");
        Person clone = (Person) person.clone();
        System.out.println(person.hashCode());
        System.out.println(clone.hashCode());
    }
}

@Data
class Person implements Cloneable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


