package zq.arithmetic.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 12:45
 * @Version 1.0
 **/
public class Queue1 {
    /**
     * 队列： 先进先出 在一段删除，另一端新增
     * @param args
     */
    public static void main(String[] args) {
        //加密后的qq号码
        int[] arr = {6,3,1,7,5,8,9,2,4};


    }

    /**
     * 需要 将数组整体往前位移  很耗费时间
     * @param arr
     * @return
     */
    private  List<Integer>  decode(int[] arr){
//        int[] decodeArr = new int[100];
        //将结果数组存到decodeArr里面
        List<Integer> decodeArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1){
                break;
            }
            if(i%2==0){
                decodeArr.add(arr[i]);
                deleteFront(arr);
            }else{
                addFrontToTail(arr);
            }

        }

        return decodeArr;
    }

    private void addFrontToTail(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i>0){
                newArr[i-1] = arr[i];
            }
            else{
                //将值放到 -1 之前的那个索引处
            }
        }
    }

    private void deleteFront(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = -1;


    }
}
