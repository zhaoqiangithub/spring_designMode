package com.zq.designdemo.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Enter {
    public static void main(String[] args) {
        //1、这个是不用代理前，只能自己去寻找对象
        //new Zhangsan().findTrueLove();

        //2、自从有了媒婆代理
        try {
            //获取代理对象
            Person person = (Person)new MeiPo().getInstance(new Zhangsan());
            System.out.println("代理对象"+person.getClass());
            //这里这个person是新的代理对象了不是原来的zhangsan 。代理对象调用findTrueLove 是在调用invoke方法
            person.findTrueLove();//由于是动态代理 代理是整个类，整个类都是生成的一个class，所以掉哪一个方法都行。

            /**
             * 原理
             * 1、拿到被代理对象的引用，然后获取他的接口
             * 2、jdk代理重新生成一个类，同时实现代理对象所实现的接口
             * 3、把被代理对象的引用也拿到
             * 4、重新动态生成一个class字节码
             * 5、然后编译
             */

            //通过方法查看原理
            //从内存中获得$Proxy_own这个代理类  生成字节码文件，代理类的类名 $Proxy_own
            byte[] data = ProxyGenerator.generateProxyClass("$Proxy_own", new Class[]{person.getClass()});
            //获取代理对象 $Proxy_owns，写到文件中
            FileOutputStream os = new FileOutputStream("$Proxy_own.class");
            os.write(data);
            os.close();

            //$Proxy_own.class 里面的this.h 是InvocationHandler
         } catch (Exception e) {
            e.printStackTrace();
        }








    }
}

