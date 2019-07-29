package com.zq.designdemo.factory.abstract1;

import com.zq.designdemo.factory.simple.AstonMartin;
import com.zq.designdemo.factory.simple.Car;

public class DefaultFactory extends AbstractFactory {

    private AstonMartinFactory defaultFactory = new AstonMartinFactory();

    @Override
    Car getCar() {
        return defaultFactory.getCar();
    }
}
