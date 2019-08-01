package com.zq.designdemo.singleton;

public class Singleton6 {
    //双重校验锁
    private volatile static Singleton6 singleton6;

    private Singleton6(){}

    public static Singleton6 getInstance(){
        if(singleton6 == null){
            synchronized (Singleton6.class){
                if(singleton6 == null){
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}
