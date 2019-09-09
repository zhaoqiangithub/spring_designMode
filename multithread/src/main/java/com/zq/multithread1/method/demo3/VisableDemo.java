package com.zq.multithread1.method.demo3;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 22:45
 * @Version 1.0
 **/
/*
可见性问题
 */
public class VisableDemo {
    private static  boolean  flag = false;//不加volitile 不可见
    //lock是应用层面的
    //加volitile，在代码编译成汇编语言后，变量会被lock修饰

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i=0;
            while (!flag){
                i++;
            }

        }, "thread-1");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        flag = true;

    }
}
