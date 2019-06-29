package com.sh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask).start();
        System.out.println("*****result: " + futureTask.get());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}