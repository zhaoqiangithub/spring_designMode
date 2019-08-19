package zq.arithmetic.thread2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCooker {

    /**
     * Callable的现实生活中的模型：
     * 小明准备自己做菜，但是没有食材 也没有餐具
     * 小明在京东买了周日上午12点在京东下单买了餐具
     * 小明买完餐具后就去 超市买食材
     *
     * 如果小明做菜的整个流程是 一个主线程的话，小明去京东下单买餐具就是 整个主线程的一个子线程
     *
     * 如果用Thread 去模拟的话，我们用启动在主线程中启动子线程，由于我们又锅才能做菜（即我们拿到 锅的实例之后才能），所以我们只能用 用子线程调用join
     * 强行阻塞主线程，拿到锅之后，接着下面的 主线程的流程（即去超市买菜），由于子线程阻塞了主线程  其实用不用多线程没有啥意义了（相当于 必须等到快递才能买菜，
     * 买菜和等快递不能同时进行）。
     *
     * 可见模拟这种场景 ，Thread是存在一定的问题的
     *
     *Callable 可以完美的模拟这种场景（join是用整个线程去阻塞主线程，Callable是用 future.get()去阻塞主线程，可以理解为用返回值阻塞）
     */

    public static void main(String[] args) {
        JDApp jdApp =  new JDApp();
        FutureTask<Utensil> jdShoppingTask = new FutureTask<>(jdApp);
        //启动京东购物子线程
        new Thread(jdShoppingTask).start();

        //主线程小明去逛超市
        System.out.println("2.1、小明来到超市");
        System.out.println("2.2、小明买了鸡胸肉");
        System.out.println("2.3、小明买了西兰花");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3.1、回家");

        if (jdShoppingTask.isDone()){// isDone不会阻塞线程
            System.out.println("炒锅还没到不能做饭！！！等耐心等待快递小哥");
        }


        Utensil utensil = null;
        try {
            utensil = jdShoppingTask.get();// get会阻塞主线程，等待子线程的返回
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("4.1、"+utensil.getName()+"终于到了！可以做饭了");



    }
}
