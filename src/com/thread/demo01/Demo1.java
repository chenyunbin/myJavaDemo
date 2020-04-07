package com.thread.demo01;

import java.util.Random;

/**
 * 自旋锁，顾名思义就是自旋等待，也就是说是空转CPU，在等待一个线程执行完毕之后，才会执行。
 */
public class Demo1 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程执行...");

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程执行...");

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程执行...");

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程执行...");

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
        }).start();

        while (Thread.activeCount() != 2) {
            //空转cpu
//            System.out.println(Thread.activeCount()+"！");
        }
        System.out.println("所有线程执行完毕啦，收工！");
    }
}
