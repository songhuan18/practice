package com.sh.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 * @date 2020-01-05 21:18
 */
public class ThreadLocalTest {

    private static final int THREAD_LOOP_SIZE = 500;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 10000;

    private static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            // 不使用线程池，不会导致内存泄露
//            new Thread(() -> {
//                threadLocal.set(new ThreadLocalTest().addBigList());
//                Thread t = Thread.currentThread();
//                System.out.println(t.getName());
//            }).start();
            // 以下使用线程池，如果不手动remove，会导致内存泄漏，最后出现OOM
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalTest().addBigList());
                Thread t = Thread.currentThread();
                System.out.println(t.getName());
                threadLocal.remove(); //不取消注释的话就可能出现OOM
            });
//            Thread.sleep(1000L);
        }
//        executorService.shutdown();

    }

    private List<User> addBigList() {
        List<User> params = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
        for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
            params.add(new User("xuliugen", "password" + i, "男", i));
        }
        return params;
    }
}

class User {
    private String userName;
    private String password;
    private String sex;
    private int age;

    public User(String userName, String password, String sex, int age) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }
}
