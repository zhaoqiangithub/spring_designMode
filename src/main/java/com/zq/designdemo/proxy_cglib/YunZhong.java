package com.zq.designdemo.proxy_cglib;


/**
 * 不同于jdk动态代理，需要实现一个接口，比如person。获取到代理对象之后，通过强转为Person去调用被代理对象的方法
 * cjlib是通过继承实现的。自动生成一个类继承YunZhong，即继承被代理类。把子类的引用指向父类
 * 根本原理还是 字节码重组
 *
 * 好处：少写一个接口。Person。对于api的用户来说是无感知的
 *
 *
 */
public class YunZhong {

    public void findLove(){
        System.out.println("大长腿");
    }
}
