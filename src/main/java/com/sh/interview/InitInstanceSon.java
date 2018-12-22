package com.sh.interview;

public class InitInstanceSon extends InitInstanceFather {

    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }

    InitInstanceSon() {
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }

    public int test() {
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        InitInstanceSon son1 = new InitInstanceSon();
        System.out.println();
        InitInstanceSon son2 = new InitInstanceSon();
        // 结果：(5)(1)(10)(6)(9)(3)(2)(9)(8)(7)
        //      (9)(3)(2)(9)(8)(7)
        /**
         * 类初始化过程：
         * ①一个类要创建实例需要先加载并初始化该类，注意：main方法所在的类需要先加载和初始化
         * ②一个子类要初始化需要先初始化父类
         * 执行过程：
         * ①父类中的静态方法先执行，按照代码顺序执行，然后是执行子类中的静态方法
         * ②父类中的常量和代码再执行，按照顺序执行。
         * ③执行构造器
         * 注意：如果子类重写了父类的方法，那么父类中调用的其实是子类中的方法。多态
         */
    }
}
