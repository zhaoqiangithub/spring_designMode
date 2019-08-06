package com.zq.designdemo.proxy_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GPMeiPo implements MethodInterceptor {


    //疑问？
    //好像并没有被代理对象的引用
    //这个引用是由cjlib new出来的 所以public Object getInstance(YunZhong object) throws Exception {
    //改为 Class clazz
    //public Object getInstance(YunZhong object) throws Exception {
    public Object getInstance(String object) throws Exception {
        //通过反射机制给他实例化

        //动态生成class
        Enhancer enhancer = new Enhancer();
        //把父类设置为谁 这一步是告诉cjlib 需要继承哪一个类
//        enhancer.setSuperclass(object.getClass());
        enhancer.setSuperclass(Class.forName(object));
        //回调 intercept
        enhancer.setCallback(this);

        //1、生成源代码
//        2、编译
//        3、家在到jvm中，生成代理对象、
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //这个object 是 cjlib给我们new出来的 是子类的引用，new出来以后的对西那个是被代理对象的子类（继承我们的被代理对象 YunZhong）
        //OOP规定 new子类之前，是默认调用我们的super（）方法
        //new子类的同时，必须先new出来父类，这就相当于间接的持有父类的引用
        //子类重写父类的所有方法
        //我们改变子类对象的某些属性，是可以间接的操作父类的
        System.out.println("我是媒婆：");
        System.out.println("开始海选");
        System.out.println("也就是代理前的预处理");
        System.out.println("--------");
//        methodProxy.invoke(object,args);
        //这里不是invoke 否则会一直循环  为什么 因为object是子类的引用，在主方法中，子类调用方法instance.findLove();  其实就是调用intercept方法，但是方法中又invoke调用自己，导致死循环。应该调用父类中的invokeSuper（）方法
        methodProxy.invokeSuper(object,args);
        System.out.println("--------");

        return null;
    }
}
