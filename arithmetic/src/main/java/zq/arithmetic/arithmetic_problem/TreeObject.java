package zq.arithmetic.arithmetic_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/9 14:48
 * @Version 1.0
 **/
public class TreeObject<T> {

    //对外暴漏构造方法.构造TreeObject时，初始化当前节点的值
    public TreeObject(T t){
        //新建node
        Node<T> tNode = new Node<>(t);
        currentNode = tNode;
    }

    private Node currentNode = null;//根节点没有爸爸

    //添加

    /**
     *
     * @param t
     * @return  添加后的子节点
     */
    public void addChild(T t){
        //定义要添加的节点,子节点指向父节点，不保存子节点的引用怎么遍历？
        Node<Object> objectNode = new Node<>(t);
        //当前节点保存子节点的引用
        currentNode.childs.add(objectNode);
    }

    /**
     * 多叉树的节点定义
     * @param <T>
     */
    private class Node<T>{
        //维护父节点 发现维护父节点不容易遍历。所以维护子节点
        //维护多个子节点的引用
        //节点保存的值(快乐值)
//        Node parent;
        List<Node> childs = new ArrayList<>(); //为了方便遍历，维护子节点的引用
        T t;

        //节点的构造方法
        public Node(T t){
           this.t = t;
        }
    }


}
