package com.zq.designdemo.singleton;

public class Singleton2 {

    //懒汉
    //需要的时候，再加载实例

    private static Singleton2 singleton2;

    private Singleton2(){}

    //线程不安全
    public static Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    //线程安全
    //线程安全是指，逻辑所在线程被cpu调用时，代码的执行顺序不影响预期的结果
    //如果不通过synchronized使得这段逻辑变成同步代码块，为这段逻辑加锁的话，正好两个不同线程的相同逻辑同时被cpu调用，并执行的话，singleton2都为空，并new出两个Singleton2()实例，全局上，也就不是单例
    //不过效率低
    public static synchronized Singleton2 getInstance1(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
