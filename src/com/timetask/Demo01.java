package com.timetask;

import java.util.concurrent.TimeUnit;

public class Demo01 {

    static int count = 0;

    public static void main(String[] args) {
        TimeUnit unit = TimeUnit.SECONDS;
        Runnable runnable = () -> {
            try {
                while (true) {
                    unit.sleep(1);
                    System.out.println("定时任务需要执行。。。count:" + ++count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
