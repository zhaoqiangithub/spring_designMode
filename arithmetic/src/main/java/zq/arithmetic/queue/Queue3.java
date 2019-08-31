package zq.arithmetic.queue;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 13:38
 * @Version 1.0
 **/
public class Queue3 {
    /**
     * 利用队列的基本结构实现
     * @param args
     */
    public static void main(String[] args) {
        //加密后的qq号码
        int[] arr = {0,6,3,1,7,5,8,9,2,4};//队首多加了一个0 索引head可以从1开始

        //将arr长度扩容到100（也不知道有什么好的方法 只能这么无脑来）
        int[] arrNew = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }

        //给队列赋值
        QuereObject quereObject = new QuereObject(arrNew,1,arr.length);

        for (;quereObject.getHead() < quereObject.getTail();){
            //删除队首
            System.out.println(quereObject.getQueueValueByInd(quereObject.getHead()));
            quereObject.addHead();

            //将队首值放到队尾
            quereObject.setQueueValueByInd(quereObject.getTail(),quereObject.getQueueValueByInd(quereObject.getHead()));
            quereObject.addTail();
            //再将队首值移除
            quereObject.addHead();
        }
    }
}
