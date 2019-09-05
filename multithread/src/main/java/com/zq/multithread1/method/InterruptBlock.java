package com.zq.multithread1.method;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/4 15:18
 * @Version 1.0
 **/
public class InterruptBlock {

    /**
     * @param args
     */
    public static void main(String[] args) {



        class MyThread extends Thread{

            private volatile boolean flag = true;

            public void stopTask(){
                flag = false;
            }

            public MyThread(String name){
                super(name);
            }

            @Override
            public void run() {
                synchronized(this){

                    try {
                        int i=0;
                        while(flag){
                            Thread.sleep(10000);
                            i++;
                            System.out.println(Thread.currentThread().getName()+ " ("+this.getState()+") loop "+i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread().getName()+ " ("+this.getState()+") catch InterruptedExecption");
                    }
                }
            }
        }


        try {

            //新建
            MyThread t1 = new MyThread("t1");
            System.out.println(t1.getName()+" ("+t1.getState()+" ) is new.");

            //System.out.println("luo1:"+t1.isInterrupted());
            //启动
            t1.start();
            System.out.println(t1.getName()+" ("+t1.getState()+" ) is started.");
            //System.out.println("luo2:"+t1.isInterrupted());
            //主线程休眠300ms，然后主线程给t1发“中断”指令
            Thread.sleep(300);
            //t1.interrupt();
            t1.stopTask();
            //System.out.println("luo3:"+t1.isInterrupted());
            System.out.println(t1.getName()+" ("+t1.getState()+" ) is interrupted.");

            //主线程休眠300ms，然后查看t1的状态
            Thread.sleep(300);
            System.out.println(t1.getName()+" ("+t1.getState()+" ) is interrupted now .");


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
