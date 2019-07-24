package com.zq.designdemo.ownwrite_proxy;

import com.zq.designdemo.proxy.MeiPo;
import com.zq.designdemo.proxy.Person;
import com.zq.designdemo.proxy.Zhangsan;

public class Enter {
    public static void main(String[] args) {
        //获取代理对象
        Person person = null;
        try {
             person = (Person) new GPMeipo().getInstance(new Zhangsan());

            System.out.println("代理对象"+person.getClass());
//            这里这个person是新的代理对象了不是原来的zhangsan 。代理对象调用findTrueLove 是在调用invoke方法
            person.findTrueLove();//由于是动态代理 代理是整个类，整个类都是生成的一个class，所以掉哪一个方法都行。


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
