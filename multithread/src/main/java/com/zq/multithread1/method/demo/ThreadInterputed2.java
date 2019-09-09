package com.zq.multithread1.method.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 22:21
 * @Version 1.0
 **/
public class ThreadInterputed2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted){
                    System.out.println("before："+interrupted);
                    Thread.interrupted();
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }


            }
        },"线程1");
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
    }


}
