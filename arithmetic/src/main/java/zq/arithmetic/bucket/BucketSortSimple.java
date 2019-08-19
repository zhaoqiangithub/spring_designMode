package zq.arithmetic.bucket;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/20 22:49
 * @Version 1.0
 **/
public class BucketSortSimple {
    /**
     * 用桶做排序(简化版)  已知要被排序的目标数组的各个元素的值的范围在0-10之间  共11个值
     * @param args
     */
    public static void main(String[] args) {
        //定义桶 桶每个索引存的是 跟索引相等的值的数量！！ 所要排序的目标数组值 必须在预期之内！！
        //桶的时间复杂度 m+2n   复杂度忽略较小的常数 所以是 O(m+n)
        int[] bucket = new int[11];   //长度m
        int[] sourceArr = {2,8,5,5,2,4,7,0,5};   //长度n
        //循环了9次 n次
        for (int i = 0; i < sourceArr.length; i++) {
            bucket[sourceArr[i]]++;
        }

//        System.out.println("zhaoqiandfdsafsdg".hashCode());
//        System.out.println(2<<30);
        //遍历桶(从小打大)  循环11次  桶的个数  m+n次
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i]!=0){
                int times = bucket[i];
                for (int j=1;j<=times;j++){
                    System.out.println(i);
                }
            }
        }


        //遍历桶(从大打小)
//        for (int i = bucket.length-1; i >= 0; i--) {
//            if(bucket[i]!=0){
//                int times = bucket[i];
//                for (int j=1;j<=times;j++){
//                    System.out.println(i);
//                }
//            }
//        }
    }
}
