package com.thread.demo02;

class ThreadJoin extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"******" + i);
        }
    }
}
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin t1 = new ThreadJoin();
        synchronized (t1) {
            ThreadJoin t2 = new ThreadJoin();
            t1.start();
            t1.wait();
            t2.start();
        }

        //t1.join();
        //t2.join();
        System.out.println("主线程结束!");
    }
}
