package com.sh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的使用
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // 创建被代理类的对象
        RealSubject realSubject = new RealSubject();
        // 创建一个实现了InvocationHandler接口类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        // 调用bind()方法，动态返回一个同样实现了real所在类实现的接口的代理类的对象。
        Object obj = handler.bind(realSubject);
        Subject sub = (Subject) obj;
        sub.action();
    }
}

interface Subject {
    void action();
}

class RealSubject implements Subject {

    @Override
    public void action() {
        System.out.println("我是被代理类");
    }
}

class MyInvocationHandler implements InvocationHandler {

    // 实现了接口的被代理类的声明
    private Object obj;

    // 给被代理对象实例化
    // 返回一个代理类的对象
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行了吗");
        Object returnVal = method.invoke(obj, args);
        return returnVal;
    }
}