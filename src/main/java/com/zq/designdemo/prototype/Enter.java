package com.zq.designdemo.prototype;

public class Enter {

    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAge(18);



        try {
            //不走构造方法 通过字节码实现
            //引用类型，直接复制，导致两个list的引用为同一个
            ConcretePrototype clone = (ConcretePrototype)concretePrototype.clone();

            System.out.println(concretePrototype.getList() == clone.getList());
            System.out.println(clone.getAge());



        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //用这种克隆 中能够直接拷贝的其实有9中  java 8大基本数据类型和String

    }
}
