package zq.arithmetic.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Box box = new Box();
        Producer producer = new Producer(box);
        Consumer consumer = new Consumer(box);

        Thread thread1 = new Thread(producer);
        thread1.setName("producerThead");

        Thread thread2 = new Thread(consumer);
        thread2.setName("consumerThead");

        thread1.start();
        thread2.start();
    }
}
