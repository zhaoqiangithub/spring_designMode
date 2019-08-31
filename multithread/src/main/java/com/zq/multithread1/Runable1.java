package com.zq.multithread1;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/8 17:29
 * @Version 1.0
 **/
public class Runable1 implements Runnable {
    private String name;

    private Runable1(String name){
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runable1("A")).start();
        new Thread(new Runable1("B")).start();
    }
}
