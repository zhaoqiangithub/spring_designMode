package com.zq.designdemo.singleton;

public class Singleton1 {
    //饿汉
    //特点 不管用不用，先new出一个单例
    //没有达到懒加载的效果
    private static final Singleton1 singleton = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return Singleton1.singleton;
    }
}
