package zq.arithmetic.thread;

public class Consumer implements Runnable {

    private Box box;

    public Consumer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.consume();
        }

    }
}
