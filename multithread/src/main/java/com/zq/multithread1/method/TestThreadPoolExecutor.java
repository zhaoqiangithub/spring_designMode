package com.zq.multithread1.method;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/4 22:02
 * @Version 1.0
 **/
public class TestThreadPoolExecutor {
    /*
    ThreadPoolExecutor类
    用来存放一定的线程的集合
    它的一个Worker对应一个线程


    线程池分类
    FixedThreadPool
    SimpleThreadPool
    SchedualThreadPool
    CashedThreadPool
     */


    public static void main(String[] args) {

        class Thread1 extends Thread{
            public Thread1(String name){
                super(name);
            }
            public void run(){
                int i = 5;
                for (;;){
                    System.out.println(Thread.currentThread().getName()+" "+ i--);
                    if (i==0) break;
                }
            }
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Thread1("t1"));
        executorService.execute(new Thread1("t2"));
        executorService.shutdown();

    }

}
