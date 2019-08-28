package com.zq.multithread1.method;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/27 17:30
 * @Version 1.0
 **/
public class TestWait2 {

    private static Object object = new Object();

    static class Thread1 extends Thread{
        public void run(){
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "");
                try {
                    System.out.println(Thread.currentThread().getName() + "线程等待");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();
        Thread1 thread3 = new Thread1();
        System.out.println(Thread.currentThread().getName() + "线程启动");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            System.out.println("线程睡眠");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (object){
            System.out.println("唤醒object上的所有线程");
            object.notifyAll();
        }

    }







}
