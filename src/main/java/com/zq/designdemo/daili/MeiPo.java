package com.zq.designdemo.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理需要实现这个接口
public class MeiPo implements InvocationHandler {

    private Person person;

    //获取被代理人的个人资料
    public Object getInstance(Person object) throws Exception{
        this.person = object;
        Class<? extends Person> aClass = object.getClass();
        //三个参数  要去代理：第一个参数：classLoader   第二个就是获取他的接口 第三个代理人
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆："+this.person.getName());
        System.out.println("开始海选");
        System.out.println("如果合适就结婚");
        System.out.println("--------");
        this.person.findTrueLove();
        System.out.println("--------");
        return null;
    }
}
