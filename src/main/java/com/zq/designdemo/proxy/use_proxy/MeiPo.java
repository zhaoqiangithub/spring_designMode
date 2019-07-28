package com.zq.designdemo.proxy.use_proxy;

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
        System.out.println("原来的代理对象："+aClass);
        //三个参数  要去代理：第一个参数：classLoader   第二个就是获取他的接口 第三个代理人
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
        //后面传this 在Proxy 中通过这个方法传入代理对象（不是被代理对象！） 在Proxy this.h赋值为这个传进去的代理对象 this
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处是代理人做筛选

        System.out.println("我是媒婆：");
        System.out.println("开始海选");
        System.out.println("也就是代理前的预处理");
        System.out.println("--------");
        method.invoke(this.person,args);
//        this.person.findTrueLove();
        System.out.println("--------");
        return null;
    }
}
