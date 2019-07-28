package com.zq.designdemo.proxy.use_proxy;

//张三要相亲
public class Zhangsan implements Person {

//    private String sex ="女";
//    private String name ="张三";

    @Override
    public void findTrueLove() {
//        System.out.println("我叫"+this.name);
        System.out.println("高富帅");
        System.out.println("体重180");
    }


//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
