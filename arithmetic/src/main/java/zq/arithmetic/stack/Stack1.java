package zq.arithmetic.stack;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 14:06
 * @Version 1.0
 **/
public class Stack1 {
    /**
     * 栈：后进先出 在一段删除，也在这段新增
     *
     * 实现：判读 一个字符串是否是 回文字符串 左右对称的字符串
     * @param args
     */
    public static void main(String[] args) {
         //尝试实现
        char[] arr = {'a','b','c','d','c','b','a'};

        //拿到最中间 mid 索引值
        int mid = arr.length / 2; //注意这里不用加1 也不用减1

        //将mid之前的数组入栈
        StackObject stackObject = new StackObject();
        for (int i = 0; i < mid; i++) {
            stackObject.pushIn(arr[i]);
        }

        for (int i = 0; i < mid; i++) {
            System.out.println(stackObject.takeOut());
        }
    }
}
