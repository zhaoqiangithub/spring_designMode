package com.zq.multithread1.method;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/1 19:23
 * @Version 1.0
 **/
public class TestSleep {
    /*
    wait和sleep
    wait可以释放对象的同步锁
    sleep不可以释放当前对象的同步锁
     */

    private static Object object = new Object();
    static class Thread1 extends Thread{

        public Thread1(String name){
            super(name);
        }

        public void run(){
            synchronized (object){

                try {
                    System.out.println(Thread1.currentThread().getName()+"执行");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("t1");
        Thread1 thread2 = new Thread1("t2");
        thread1.start();
        thread2.start();
    }
}
