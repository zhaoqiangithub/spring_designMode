package com.zq.multithread1.method.demo;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 22:33
 * @Version 1.0
 **/
public class ThreadInterrupt3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "线程1");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("before:"+thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("before:"+thread.isInterrupted());



    }
}
