package com.zq.multithread1.method.demo3;

import ch.qos.logback.core.util.TimeUtil;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 22:52
 * @Version 1.0
 **/

/**
 * 原子性问题
 */
public class AtomicDemo {
    private static int count = 0;

    public static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1000;i++){
            new Thread(AtomicDemo::inc).start();
        }
        TimeUnit.SECONDS.sleep(4);
        System.out.println(count);
    }


}
