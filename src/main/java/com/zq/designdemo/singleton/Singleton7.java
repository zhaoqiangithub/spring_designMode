package com.zq.designdemo.singleton;

import java.util.HashMap;
import java.util.Map;

public class Singleton7 {
    //使用容器 map
    //需要维护key 比较麻烦
    private static Map<String,Object> objectMap = new HashMap<String,Object>();

    private Singleton7(){}

    public static void registerService(String key,Object singleton7){
        if(!objectMap.containsKey(key)){
            objectMap.put(key,singleton7);
        }
    }

    public static Object getObject(String key){
        return objectMap.get(key);
    }
}
