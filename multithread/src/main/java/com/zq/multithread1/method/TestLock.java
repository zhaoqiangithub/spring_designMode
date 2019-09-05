package com.zq.multithread1.method;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 10:43
 * @Version 1.0
 **/
public class TestLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        class Thread1 extends Thread{
            public Thread1(String name){
                super(name);
            }

            public void run(){
                lock.lock();
                try {
                    for (int i =0;i<5;i++){
                        System.out.println("线程"+Thread.currentThread().getName()+"运行");
                        Thread.sleep(300);
                    }
                }catch (InterruptedException e){

                }finally {
                    lock.unlock();
                }
            }
        }
        new Thread1("t1").start();
        new Thread1("t2").start();

    }
}
