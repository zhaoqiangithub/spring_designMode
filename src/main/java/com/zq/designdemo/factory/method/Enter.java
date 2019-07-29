package com.zq.designdemo.factory.method;

public class Enter {
    public static void main(String[] args) {
        //工厂方法模式
        //各个产品的生产商都有自己的各自的工厂
        //生产工艺不一样
        Factory factory = new MayBachFactory();
        System.out.println(factory.getCar().getName());

        /*
        对用户来说
        只关注产品的的生产商 对用户来说 需要关注生产商，这个其实增加代码的复杂度
        抽象工厂可以解决这个问题
         */
        AstonMartinFactory astonMartinFactory = new AstonMartinFactory();
        System.out.println(astonMartinFactory.getCar().getName());
    }
}
