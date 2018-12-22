package com.sh.singleton;

import java.util.concurrent.*;

public class TestSingleton3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton3> callable = () -> Singleton3.getINSTANCE();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Future<Singleton3> submit = exec.submit(callable);
        Future<Singleton3> submit1 = exec.submit(callable);
        Singleton3 s1 = submit.get();
        Singleton3 s2 = submit1.get();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        exec.shutdown();
    }
}
