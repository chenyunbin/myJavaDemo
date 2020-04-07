package com.thread.demo01;

/**
 * 重入锁
 */
public class Demo {
    public synchronized void a() {
        System.out.println("a方法被执行");
        b();
    }

    public synchronized void b() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b方法被执行");
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.b();
            }
        }).start();
    }
}
