package com.zq.designdemo.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Enter {

    public static void main(String[] args) {
        //策略模式举例
        //jdk里面 对比集合小大的工具类


        List<Long> longList = new ArrayList<>();
        //第一个参数传 集合，第二个参数传 排序规则.这种排序规则就是一种策略
        Collections.sort(longList, new Comparator<Long>() {
//            compare 返回只有三个  -1 0 1
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;

                }
                return 0;
            }
        });




    }
}
