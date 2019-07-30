package com.zq.designdemo.factory.abstract1;

import com.zq.designdemo.factory.simple.AstonMartin;
import com.zq.designdemo.factory.simple.Car;
import com.zq.designdemo.factory.simple.MayBach;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/7/30 9:22
 * @Version 1.0
 **/
public class CarFactory extends AbstractFactory {

    @Override
    Car getAstonMartin() {
        //如果此处new 的是AstonMartionFactory 那就是混合工厂模式，抽象工厂加工厂方法 下同
        return new AstonMartin();
    }

    @Override
    Car getMayBach() {
        return new MayBach();
    }

}
