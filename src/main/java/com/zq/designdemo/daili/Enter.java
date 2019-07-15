package com.zq.designdemo.daili;

public class Enter {
    public static void main(String[] args) {
        //1、这个是不用代理前，只能自己去寻找对象
        //new Zhangsan().findTrueLove();

        //2、自从有了媒婆代理
        try {
            Person person = (Person)new MeiPo().getInstance(new Zhangsan());
            person.findTrueLove();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
