package com.thread.demo02;

public class MyThread extends Thread {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        myThread1.join();
        System.out.println(count);
        MyThread myThread2 = new MyThread();
        myThread2.start();
        myThread2.join();
        System.out.println(count);
        MyThread myThread3 = new MyThread();
        myThread3.start();
        myThread3.join();
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            MyThread.count = MyThread.count + 1;
            System.out.println(MyThread.currentThread().getName());
        }

    }
}






//System.out.println(count);
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println(count);
//myThread.join();
//        System.out.println(count);
//    MyThread myThread1 = new MyThread();
//        myThread1.start();
//                myThread1.join();
//                System.out.println(count);
//
//                MyThread myThread2 = new MyThread();
//                myThread2.start();
//                MyThread myThread3 = new MyThread();
//                myThread3.start();
//
//                //        myThread2.join();
//                //        myThread3.join();
//                Thread.sleep(100);
//                System.out.println(count);
