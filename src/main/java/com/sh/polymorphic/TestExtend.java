package com.sh.polymorphic;

/**
 * @author sh
 * @date 2020-01-30 16:52
 */
public class TestExtend {
    public static void main(String[] args) {
        Children c = new Children();
        c.print();
        System.out.println("==============");
        Parent p = new Parent();
        p.print();
    }
}

class Parent {
    public void print() {
        System.out.println("这是父类打印的");
        testOverride();
    }

    public void testOverride() {
        System.out.println("这是父类重写的");
    }
}

class Children extends Parent {
    @Override
    public void testOverride() {
        System.out.println("这是子类重写的");
    }
}
