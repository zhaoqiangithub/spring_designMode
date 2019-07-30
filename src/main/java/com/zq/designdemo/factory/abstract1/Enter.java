package com.zq.designdemo.factory.abstract1;

import com.zq.designdemo.factory.simple.Car;

public class Enter {
    public static void main(String[] args) {
//        DefaultFactory d = new DefaultFactory();
//        //默认是astonMartin
//        System.out.println(d.getCar().getName());
//
//        System.out.println(d.getCar("MayBach").getName());
        //通过api的方式提供车的实例。对用户而言更安全，对代码维护者而言 更容易扩展，如果需要新加车辆工厂只需要动态维护抽象工厂的api就可以了
        CarFactory carFactory = new CarFactory();
        Car astonMartin = carFactory.getAstonMartin();
        Car mayBach = carFactory.getMayBach();

        System.out.println(astonMartin.getName());
        System.out.println(mayBach.getName());

        //对于用户只关注结果 不关注过程
        //对于工厂 可以把固定的流程和工艺封装起来，做的更专一更专业，双方都有好处

        //工厂模式的特点
        /*
        把复杂的逻辑处理隐藏掉，只关注执行结果
         */



        //Spring中的工厂模式
        //Bean
        //BeanFactory()生成bean
        //bean的种类很多
        //单例bean 被代理的bean 最原始的bean（原型bean）  list类型的bean  作用域不同的bean（范围不一样）
        //这么多bean 一个方法也能搞定 getBean

        //但是不好的是 逻辑都写到一起，非常紊乱，不利于以后api的升级
        //解耦（松耦合开发 低耦合高内聚） 调用者简单，开发者维护方便

        //44分
    }
}
