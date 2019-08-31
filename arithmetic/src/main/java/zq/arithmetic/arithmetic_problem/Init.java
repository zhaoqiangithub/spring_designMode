package zq.arithmetic.arithmetic_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/9 15:27
 * @Version 1.0
 **/
public class Init {
    public static void main(String[] args) {
        //定义值为map形式
        //键为员工编号  值为欢乐值

        //根节点 的值
        Map<Integer,Integer> root = new HashMap<>();
        root.put(1,5);
        TreeObject treeObject =  new TreeObject(root);//此时，构造出的root 节点没有父节点

        Map<Integer,Integer> employee2 = new HashMap<>();
        employee2.put(2,1);

        Map<Integer,Integer> employee3 = new HashMap<>();
        employee3.put(3,1);

        treeObject.addChild(employee2);
        treeObject.addChild(employee3);
        //------------------至此 树赋值完毕
        System.out.println();
        //根据游戏规则找出最大的快乐值











    }
}
