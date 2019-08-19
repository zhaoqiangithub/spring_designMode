package zq.arithmetic.bucket;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/20 22:15
 * @Version 1.0
 **/
public class QiangObsSort {
    /**
     * 对五个数进行排序
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,8,5,2};
        int[] sorted = new int[5];

        //从小到大
        for (int i = 0; i < arr.length; i++) {
            //将arr的当前位和 sort的前一位对比，如果小了， sort交换。否则不交换
            if(i == 0){
                sorted[0] = arr[0];
            }else {
                if(sorted[i-1] > arr[1]){
                    sorted[i] = sorted[i-1];
                    sorted[i-1] = arr[1];
                }else {
                    sorted[i] = arr[i];
                }
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            System.out.println("sort:"+i+" "+sorted[i]);

        }

    }

}
