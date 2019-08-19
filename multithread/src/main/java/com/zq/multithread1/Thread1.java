package com.zq.multithread1;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/8 17:13
 * @Version 1.0
 **/
public class Thread1 extends  Thread {

    private String name;

    private Thread1(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        Thread thread1 = new Thread1("A");
        Thread thread2 = new Thread1("B");
        thread1.start();
        thread2.start();
    }
}
