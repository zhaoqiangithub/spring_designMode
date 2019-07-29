package com.zq.designdemo.factory;

/*
对于这个代码来说  太强大了
为什么
这个工厂啥汽车都能生产不符合现实呀
编码是一种艺术 艺术来源于生活需要回归于生活
 */
public class SimpleFactory {


    /*
    实现统一化管理
    如果没有工厂模式，小作坊，没有执行标准
    卫生监督局的工作将大大减轻
     */
    public Car getCar(String name){
        if("AstonMartin".equals(name)){
            return new AstonMartin();
        }
        else if("MayBach".equals(name)){
            return new MayBach();
        }else{
            System.out.println("没有此产品");
            return null;
        }
    }
}
