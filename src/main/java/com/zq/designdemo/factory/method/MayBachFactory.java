package com.zq.designdemo.factory.method;

import com.zq.designdemo.factory.simple.Car;
import com.zq.designdemo.factory.simple.MayBach;

public class MayBachFactory implements Factory {
    @Override
    public Car getCar() {
        return new MayBach();
    }
}
