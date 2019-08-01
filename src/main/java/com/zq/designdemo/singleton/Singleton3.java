package com.zq.designdemo.singleton;

public class Singleton3 {
    //饿汉 变种。跟饿汉差不多
    //利用静态代码块进行单例的构建
    private static Singleton3 singleton3 = null;

    static {
        singleton3 = new Singleton3();
    }

    private Singleton3(){}

    public static Singleton3 getInstance(){
        return singleton3;
    }



 }
