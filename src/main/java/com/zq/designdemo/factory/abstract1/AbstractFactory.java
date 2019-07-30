package com.zq.designdemo.factory.abstract1;

import com.zq.designdemo.factory.simple.AstonMartin;
import com.zq.designdemo.factory.simple.Car;
import com.zq.designdemo.factory.simple.MayBach;

public abstract class AbstractFactory {

    //通过api的形式动态配置工厂！！！！
    abstract Car getAstonMartin();

    abstract Car getMayBach();



    //抽象方法自带逻辑
    //动态配置工厂！！！！
//    public Car getCar(String name){
//        if("AstonMartin".equals(name)){
//            return new AstonMartinFactory().getCar();
//        }
//        else if("MayBach".equals(name)){
//            return new MayBachFactory().getCar();
//        }else{
//            System.out.println("没有此产品");
//            return null;
//        }
//    }
}
