package com.zq.multithread1.method;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 20:17
 * @Version 1.0
 **/
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "返回";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new CallableDemo());

        try {
            Thread.sleep(3000);
            String s = submit.get();//通过get进行阻塞
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
