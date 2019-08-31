package zq.arithmetic.thread;

public class MyThread implements Runnable{

    Object object = "11";
    @Override
    public synchronized void run() {

            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        for (int i =0 ;i<10;i++) {
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
