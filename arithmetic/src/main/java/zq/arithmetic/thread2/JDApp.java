package zq.arithmetic.thread2;

import java.util.concurrent.Callable;

/**
 * @ClassName JDApp
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/20 0:48
 * @Version 1.0
 **/
public class JDApp implements Callable<Utensil> {
    @Override
    public Utensil call() throws Exception {
        System.out.println("1.1、购买餐具：京东下单");
        Thread.sleep(2000);
        System.out.println("1.2、购买餐具：京东备货");
        System.out.println("1.3、购买餐具：京东发货");
        Thread.sleep(10000);
        System.out.println("1.4、购买餐具：京东送达小明手中");

        Utensil utensil = new Utensil();
        utensil.setName("炒锅");
        return utensil;
    }
}
