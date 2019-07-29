package com.zq.designdemo.factory;

public class Enter {
    public static void main(String[] args) {

        //封装生产过程 简单工厂实现统一 专业化管理
        Car astonMartin = new SimpleFactory().getCar("AstonMartin");
        Car mayBach = new SimpleFactory().getCar("MayBach");
        System.out.println(astonMartin.getName());
        System.out.println(mayBach.getName());
    }
}
