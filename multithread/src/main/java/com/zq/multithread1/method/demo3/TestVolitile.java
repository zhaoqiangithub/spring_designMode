package com.zq.multithread1.method.demo3;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/6 10:14
 * @Version 1.0
 **/
public class TestVolitile {

    private static volatile TestVolitile testVolitile = null;

    //volitile怎么保证可见性：
    //生产汇编指令的差异
    //加入volitile 汇编有lock修饰
    //不加 没有这这条指令
    //汇编是编译器层面生成的
    //lock可以解决可见性问题，其实就是加了一个内存屏障


    //volitile怎么实现指令重排序
    //怎么解决重排序的问题：优化屏障和内存屏障
    //cpu层面：什么是内存屏障
    //所有的问题都是 cpu的高速缓存 多核心造成的，如果cpu在获取数据的时候，不在高速缓存里面，那么就去内存里面找，并加载到高粗缓存里面。多个缓存的时候通过缓存一致性保证


    /*
    指令重排序有cpu层面和编译器层面重排序
    在多核心多线程问题会暴露出来

    演示：
    单线程下：但是，不管怎么排序，会保证语义，结果不会变
    多线程下：

     */

//    public static TestVolitile getInstance(){
//        if(null == testVolitile){
//            testVolitile = new TestVolitile();
//        }
//        return testVolitile;
//    }
//
//    public static void main(String[] args) {
//        TestVolitile.getInstance();
//    }

    private static int x=0,y=0;
    private static int a=0,b=0;

    //两个静态变量在线程之间共享
    public static void main(String[] args) throws InterruptedException {
        //也有可能 0 0  x=b b=1 y=a a=1，这是优化带来的重排序问题，
        //也有double_check  dcl问题
        Thread t1 = new Thread(() -> {
            a = 1;
            x = b;

        }, "thread-0");
        Thread t2 = new Thread(() -> {
            b = 1;
            y = a;
        }, "thread-1");
        t1.start();
        t2.start();
        t1.join();//callable feature 差不多，等待线程执行完，否则一直阻塞
        t2.join();
//        TimeUnit.SECONDS.sleep(1);//睡眠和join效果一样，为了阻塞主线程的执行，主线程可以看到t1和t2执行完改变的值
        System.out.println("x="+x+" y="+y);




    }


}
