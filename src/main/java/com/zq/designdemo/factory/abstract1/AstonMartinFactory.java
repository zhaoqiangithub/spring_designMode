package com.zq.designdemo.factory.abstract1;

import com.zq.designdemo.factory.simple.AstonMartin;
import com.zq.designdemo.factory.simple.Car;

public class AstonMartinFactory extends AbstractFactory {
    @Override
    Car getCar() {
        return new AstonMartin();
    }
}
