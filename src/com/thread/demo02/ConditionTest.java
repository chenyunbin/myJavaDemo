package com.thread.demo02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private int conditionValue = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest=new ConditionTest();
        TimeUnit unit = TimeUnit.SECONDS;
        //线程3
        new Thread(
                () -> conditionTest.test3()
        ).start();
        unit.sleep(2);
        //线程2
        new Thread(
                () -> conditionTest.test2()
        ).start();

        unit.sleep(2);
        //线程1
        conditionTest.test1();

    }



    public  void test1(){
        lock.lock();
        try{
            while(conditionValue != 1){
                System.out.println("test1 在等待");
                condition1.await();
            }
            System.out.println("test1 在执行");
            conditionValue = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public  void test2(){
        lock.lock();
        try{
            while(conditionValue != 2){

                System.out.println("test2 在等待");
                condition2.await();

            }
            System.out.println("test2 在执行");
            conditionValue = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public  void test3(){
        lock.lock();
        try{
            while(conditionValue != 3){

                System.out.println("test3 在等待");
                condition3.await();
            }
            System.out.println("test3 在执行");
            conditionValue = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
