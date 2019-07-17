package com.zq.designdemo.daili;

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
            person.findTrueLove();


        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * 原理
         * 1、拿到被代理对象的引用，然后获取他的接口
         * 2、jdk代理重新生成一个类，同时实现代理对象所实现的接口
         * 3、把被代理对象的引用也拿到
         * 4、重新动态生成一个class字节码
         * 5、然后编译
         */
    }
}

