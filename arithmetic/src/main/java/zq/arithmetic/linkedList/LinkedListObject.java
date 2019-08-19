package zq.arithmetic.linkedList;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/22 9:31
 * @Version 1.0
 **/
public class LinkedListObject<T> {
    /**
     * 必须注意 获取索引为i的节点时 必须通过next遍历法
     * 指定位置删除 指定位置新增 获取指定位置节点的值 都需要首先遍历获取到当前节点 才能进行下面的操作
     *
     * 单向链表节点有两个属性  节点的值，下一个节点的地址
     */
    private Node<T> head = new Node<>(null);//定义头节点，很重要，链表的基底
    private int size = 0;//定义链表的长度。作用：


    /**
     * 链表新增  获取到最后一个节点，节点的next等于 新增节点
     * @param t
     */
    public void add(T t){//找到最后的那个元素  新增 长度加1
        Node temp = head;
        for (;temp.next !=null;){
            temp = temp.next;
        }
        temp.next = new Node<>(t);
        size++;
    }


    /**
     * 获取链表元素值  获取到索引为i 的节点（head索引为-1），获取节点的t
     * @param i
     */
    public T get(int i){
        if(i<0 || i>size-1){
            throw new ArrayIndexOutOfBoundsException("获取位置不合法!");
        }else {
            //定义初始索引
            int initial = -1;//从1开始 保证传入i是0的时候 不会返回head  这个索引是-1
            Node temp = head;//定义暂存节点
            for (;temp!=null;){
                if(initial == i){
                    return (T)temp.t;
                }
                temp = temp.next;
                initial++;
            }
            return null;
        }
    }

    /**
     * 删除特定索引的元素   获取到索引为i的前一个节点，让此节点的next 等于i的下一个节点  长度减1
     * @param i
     */
    public void delete(int i){
        if(i<0 || i>size-1){
            throw new ArrayIndexOutOfBoundsException("获取位置不合法!");
        }else{
            Node temp = head;
            int initial = -1;
            for(;temp!=null;){
                if(initial == (i-1)){//开始删除
                    temp.next = temp.next.next;
                    size--;//链表长度减1
                }
                temp = temp.next;//获取i出 节点中。。
                initial++;
            }
        }
    }

    /**
     * 在i出新增节点  获取索引为i 的节点的前一个节点 让新加的节点指向 i的前一个节点的next，
     *             让前一个节点的next 指向新加的节点（注意顺序 很简单）
     * @param t
     * @param i
     */
    public void addAtSpecify(T t,int i){
        if(i<0 || i>size-1){
            throw new ArrayIndexOutOfBoundsException("获取位置不合法!");
        }else {
            int initial = -1;
            Node temp = head;
            for (;temp!=null;){
                if(initial == i-1){//开始在i处新增  -1就可以拿到i 之前的节点
                    Node newNode = new Node<T>(t);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    size++;
                }
                temp = temp.next;
                initial++;
            }
        }
    }


    private class Node<T>{
        Node next;
        T t;

        public Node(T t) {
            this.t = t;
        }
    }
}
