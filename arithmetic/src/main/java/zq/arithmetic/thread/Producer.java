package zq.arithmetic.thread;

public class Producer implements Runnable {

    private Box box;
    public Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for (int  i = 0;  i < 50;  i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.produce();
        }

    }
}
