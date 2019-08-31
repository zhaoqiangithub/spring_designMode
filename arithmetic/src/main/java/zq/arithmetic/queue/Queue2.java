package zq.arithmetic.queue;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 13:16
 * @Version 1.0
 **/
public class Queue2 {
    /**
     *
     * 队列的基本结构抽象
     * 一个数组，两个变量 head和tail
     * queue{
     *     int arr[100]; //队列的主体
     *     int head; //队首
     *     int tail; //队尾
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
        //由于Queue中的  整体位移的思路  太过于慢 所以一下有个改良版
        //加密后的qq号码
        int[] arr = {0,6,3,1,7,5,8,9,2,4};//队首多加了一个0 索引head可以从1开始
        //定义arr 队列的队首和队尾的索引
        //通过改变索引值 来达到删除和增加的效果
        int head = 1;
        int tail = arr.length;// 此时值为10   队列的队尾的下一个元素的索引 避免队列只有一个元素时，队首和队尾的索引重合

        //将arr长度扩容到100（也不知道有什么好的方法 只能这么无脑来）
        int[] arrNew = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        arr = arrNew;


        //开始
        while (head<tail){//队列中没有元素的时候 就是head =  tail的时候
            //不要想着去接 删掉的值，可以直接打印嘛
            System.out.println(arr[head]);
            head++; //删掉第一位

            arr[tail] = arr[head];
            tail++;//将队首的值放到队尾
            //再将队首的值移除
            head++;
        }
    }
}
