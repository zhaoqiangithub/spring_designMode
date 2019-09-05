package com.zq.multithread1.method;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/29 14:29
 * @Version 1.0
 **/
public class TestYield {

    /*
    yield使抢到cpu的线程重新退回到 就绪状态，继续抢
    yield不会释放线程的锁

    wait()和yield(),
    wait从运行状态到阻塞状态，yield是从运行状态到就绪状态
    wait可以释放它所持有对象的同步锁，yield不会释放它所持有对象的同步锁
     */
    static class Thread1 extends Thread{
        public  void run(){
            synchronized (object){
            for (int i=0 ;i<10 ;i++) {
                System.out.println(Thread.currentThread().getName() + " :" + i);
                if(i%2 == 0){
                    Thread.yield();
                }
            }
            }
        }
    }

    private static Object object = new Object();

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t1.start();
        t2.start();

    }


}
