package com.zq.multithread1.method;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/23 17:15
 * @Version 1.0
 **/
public class TestWait {

    public static void main(String[] args) {
        class Thread1 extends Thread{

            public Thread1(String name){
                super(name);
            }
            @Override
            public void run(){
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + "线程执行");
                    System.out.println(Thread.currentThread().getName() + "唤醒");
                    notify();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        /*
        1、新增thread1线程
        2、获取thread1的锁
        3、启动thread1线程
        4、主线程执行thread1.wait() 释放thread1的锁（只有释放才可以执行thread1线程的逻辑，才可以执行线程的notify方法唤醒主线程） 主线程进入阻塞状态。等待thread1对象上的线程唤醒它
        5、thread1线程执行结束，通过notify()唤醒当前对象上的线程 也就是主线程，获取到thread1的锁继续执行
         */

        Thread1 thread1 = new Thread1("A");

        synchronized (thread1){//获取Thread1对象的锁
            System.out.println(Thread.currentThread().getName()+"启动");
            thread1.start();
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"等待，同时释放");
                thread1.wait();//注意  阻塞的是主线程。 但是只有执行完wait 才能释放thread1对象的同步锁，cpu才能调用thread1线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
        }
    }
}
