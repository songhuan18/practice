package com.sh.interview;

public class IncrementOperation {
    public static void main(String[] args) {
        int i = 1;
        // i = 1 ①把i的值压入操作数栈②i变量自增1，此时局部变量为2③把操作数栈中的值赋值给i 所以 i=1
        i = i++;
        // 同上步骤 j=1，此时i的值没被覆盖，所以i=2
        int j = i++;
        // ①把i的值压入操作数栈，此时i=2②i变量自增1(这是先加操作),所以i=3③把i=3的值压入操作数栈，对应++i④把i的值压入操作数栈，对应i++
        // i对应的值为i=4,此时操作数栈中有2，3，3 分别做运算，结果为11⑤把操作数栈中前两个弹出求乘积为9，结果再压入栈中⑥把操作栈中的值弹出
        // 求和再赋值给k
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }
}
