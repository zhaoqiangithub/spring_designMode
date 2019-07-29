package com.zq.designdemo.factory.abstract1;

import com.zq.designdemo.factory.simple.Car;
import com.zq.designdemo.factory.simple.MayBach;

public class MayBachFactory extends AbstractFactory {
    @Override
    Car getCar() {
        return new MayBach();
    }
}
