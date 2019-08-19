package zq.arithmetic.thread;

public class Box {

    private static final int MAX_PRODUCT = 30;
    private static final int MIN_PRODUCT = 20;

    private int product = 0;//设置产品初始值为0


//    public int getProduct() {
//        return product;
//    }
//
//    public void setProduct(int product) {
//        this.product = product;
//    }

    /**
     * 生产者生产出来的产品交给店员（生产的动作）
     */

    public synchronized void produce()//对于此方法来说，加synchronized 人为的实现了此代码块的线程安全（synchronized使用的是当前类实例的monitor来实现防止重入 monitor是厕所模型）
    // 。此代码块用于多线程时，cpu的调度顺序不会影响代码预期结果（必须注意 synchronized使用统一一个monitor 必须堵在同一个厕所才行呀）
    {
        if(this.product >= MAX_PRODUCT)
        {
            try
            {
                wait();
                System.out.println("产品已满,请稍候再生产");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            return;
        }

        this.product++;
        System.out.println("生产者生产第" + this.product + "个产品."+"线程信息:"+Thread.currentThread().getName()+"-"+Thread.currentThread().getThreadGroup());
        notifyAll();   //通知等待区的消费者可以取出产品了
    }

    /**
     * 消费者从店员取产品（消费的动作）
     */
    public synchronized void consume()
    {
        if(this.product <= MIN_PRODUCT)
        {
            try
            {
                wait();
                System.out.println("缺货,稍候再取");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return;
        }

        System.out.println("消费者取走了第" + this.product + "个产品."+"线程信息:"+Thread.currentThread().getName()+"-"+Thread.currentThread().getThreadGroup());

        this.product--;
        notifyAll();   //通知等待去的生产者可以生产产品了
    }

}
