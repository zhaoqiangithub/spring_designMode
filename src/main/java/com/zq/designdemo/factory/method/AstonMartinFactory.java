package com.zq.designdemo.factory.method;

import com.zq.designdemo.factory.simple.AstonMartin;
import com.zq.designdemo.factory.simple.Car;

public class AstonMartinFactory implements Factory {
    @Override
    public Car getCar() {
        return new AstonMartin();
    }
}
