package com.zq.designdemo.singleton;

public class Singleton4 {

//    这种方式同样利用了classloader的机制来保证初始化instance时只有一个线程
    //为什么用内部类
    //类中的私有方法是会被反射机制破
    private static class LazyHolder {
        //final防止内部误操作。子类可能拿到LazyHolder方法，从而改变INSTANCE，所以用final防止子类修改从而产生两个实例
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4(){}

    //静态方法里面的逻辑是在调用是才分配到（方法中的逻辑需要分配内存，但不会立即分配）
    //！！ 不用静态代码块 替换 静态方法的主要原因就在这
    //静态代码块会立即为里面的逻辑分配内存，静态方法是被调用的时候才会分配。方法更加的节省内存
    public static final Singleton4 getInstance(){
        return LazyHolder.INSTANCE;
    }


    /*
    类加载到jvm过程
    1、从上往下，必须声明在前，使用在后
    2、先属性 后方法 在类中 成员变量可以写到方法后面，因为成员变量先加载
    3、先静态 后动态


     */
//    static{
//        1、不管class有没有实例化，static静态总会在classloader执行完之后，就加载完毕
//        2、静态代码块中的内容，只能访问静态和静态方法
//        3、只要是静态的方法或者属性，就直接用class名字就能 .出来。不需要实例化
//        4、JVM内存中的静态区，这一块内容是公共的
//    }


}