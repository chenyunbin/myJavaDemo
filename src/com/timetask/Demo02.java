package com.timetask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 使用TimerTask类实现定时任务
 * @author yunbin
 */
public class Demo02 {

    static int count = 0;

    public static void main(String[] args) {
        TimeUnit unit = TimeUnit.SECONDS;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                count++;
                System.out.println("定时任务需要执行。。。count:" + ++count);
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long period = 1000;
        timer.scheduleAtFixedRate(task,delay,period);
    }
}
