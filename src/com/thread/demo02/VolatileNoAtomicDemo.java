package com.thread.demo02;

import java.util.concurrent.atomic.AtomicInteger;

class VolatileNoAtomic extends Thread {
    private static volatile AtomicInteger COUNT = new AtomicInteger(10000);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            COUNT.decrementAndGet();
        }
        System.out.println(getName() + "******" +COUNT.get());
    }
}
public class VolatileNoAtomicDemo {
    public static void main(String[] args) {

        // 初始化10个线程
        VolatileNoAtomic[] volatileNoAtomic = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            // 创建
            volatileNoAtomic[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < volatileNoAtomic.length; i++) {
            volatileNoAtomic[i].start();
        }

    }

}
