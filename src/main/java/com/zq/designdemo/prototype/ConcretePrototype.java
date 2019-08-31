package com.zq.designdemo.prototype;

import java.util.ArrayList;

public class ConcretePrototype extends Prototype{

    private int age;

    private ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
