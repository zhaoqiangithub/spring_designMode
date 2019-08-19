package zq.arithmetic.linkedList;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/22 22:30
 * @Version 1.0
 **/
public class ListTest {
    public static void main(String[] args) {
        LinkedListObject<String> linkedListObject = new LinkedListObject<>();
        linkedListObject.add("a");//0
        linkedListObject.add("b");//1
        linkedListObject.add("c");//2
        linkedListObject.add("d");//3
        linkedListObject.add("e");//4

        linkedListObject.delete(2);
        linkedListObject.addAtSpecify("链表的简单实现",2);
        System.out.println(linkedListObject.get(0));
        System.out.println(linkedListObject.get(1));
        System.out.println(linkedListObject.get(2));
        System.out.println(linkedListObject.get(3));
        System.out.println(linkedListObject.get(4));
    }
}
