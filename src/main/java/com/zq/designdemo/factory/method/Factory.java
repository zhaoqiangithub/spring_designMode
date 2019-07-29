package com.zq.designdemo.factory.method;

import com.zq.designdemo.factory.simple.Car;

//定义所有工厂的执行标准
public interface Factory {

    //符合汽车标准
    Car getCar();
}
