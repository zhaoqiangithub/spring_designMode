package com.zq.multithread1.method.demo;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 20:23
 * @Version 1.0
 **/
public class Request {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
