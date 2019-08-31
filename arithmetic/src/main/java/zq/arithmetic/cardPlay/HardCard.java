package zq.arithmetic.cardPlay;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 19:33
 * @Version 1.0
 **/
public class HardCard {//队列 先进后出
    private int[] arr = new int[100];
    public int head;
    public int tail;

    public HardCard(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
//        Set<String> stringSet = new HashSet<>();
//        stringSet.add("345");
//        stringSet.add("345");
//        stringSet.add("34b5");
//        stringSet.add("345");
//        stringSet.add("345");
//        System.out.println(stringSet.size());

        Map<String,String> map = new HashMap<>();
        map.put("11","3");
        map.put("11","4");

        String s = map.get("11");
        System.out.println(s);
    }
}
