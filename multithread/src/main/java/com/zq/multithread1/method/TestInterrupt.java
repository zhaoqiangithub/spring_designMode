package com.zq.multithread1.method;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/2 10:41
 * @Version 1.0
 **/
public class TestInterrupt {

    /*
    join
    一个线程在其他线程调用join方法，其他线程将会被阻塞，先执行该线程。线程执行完毕，再执行其他线程


    interrupt改变线程的标志位，使得线程终止
    但是
    用interrupt()进行中断时，注意两点：
    1、如果在别的线程中断当前线程的话，会有安全检查，可能会抛出SecurityException
    2、本线程调用Interrupt进行中断：如果线程调用wait、sleep、join，阻塞线程的话,调用interrupt，将中断标识置为true，但由于阻塞，又将中断标识置为false，并抛出InterruptedExecption。
    3、本线程调用Interrupt进行中断：如果线程被阻塞在Selector选择器中，线程会直接把中断状态改为true，进行中断

    那应该正确的使用interrupt()进行中断?
    1、如果线程处于阻塞状态，通过interrupt()进行中断时会抛出InterruptedEcception()，在循环外面进行异常捕获，可以终止线程
    2、如果线程处于运行状态有两种方法中断线程：  1>通过中断标记中断，线程调用interrupt()将线程的中断标记置为true，通过isInterrupted()判断，终止进入循环，终止线程
                                                 2>通过标志位中断。加入全局变量标志位，调用方法修改标志位，从而阻断循环，终止线程
                                                 3>这个状态位不能够实时中断，中断位可以实时中断。也就是说 中断位可以不等循环结束前，就进行中断位判断并中断线程

     Thread.interrpted()方法 是对中断标识更改的线程进行复位


     */

    /**
     *
     */
    static class Thread1 extends Thread {
        private static volatile boolean flag = false;

        public synchronized void run() {
            try {
                while (!flag) {
//                    Thread.sleep(100);
                    wait(10000);//wait sleep阻塞时，通过interrupt改变终端位会抛出异常。在循环外面捕获异常即可中断阻塞线程！！
                    System.out.println("线程" + Thread.currentThread().getName() + "执行"+this.getState());

                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("阻塞中断异常"+Thread.currentThread()+ " "+this.getState());
            }
        }

        public static void main(String[] args) {
            //线程处于运行状态，线程终止测试
            Thread1 thread1 = new Thread1();
            thread1.start();
            System.out.println("线程启动");
            System.out.println(thread1.isInterrupted());
            System.out.println(thread1.isDaemon());

            try {
                sleep(300);
//                thread1.interrupt();//中断线程thread1
                flag = true;
                System.out.println(thread1.isInterrupted());

                sleep(300);
                System.out.println(thread1.getState());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程结束");
        }
    }


}
