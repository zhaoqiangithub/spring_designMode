package com.zq.designdemo.proxy_cglib;


public class Enter {
    public static void main(String[] args) {
        //面向接口编程，应用场景。我们要对外开放，制定一套规范，接口就是一套规范。一般service层对外暴露接口，dao数据访问层一般不会

        //JDK的动态代理是通过接口强制转换的，生成后的代理对象可以强制转换为接口 Person
        //cjlib动态代理是通过生成一个被代理对象的子类，也就是自己写的类
        //子类引用赋值给父类
        try {
//            YunZhong instance = (YunZhong)new GPMeiPo().getInstance(new YunZhong());
            YunZhong instance = (YunZhong)new GPMeiPo().getInstance("com.zq.designdemo.proxy_cglib.YunZhong");
            instance.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
