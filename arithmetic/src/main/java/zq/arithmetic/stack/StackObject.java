package zq.arithmetic.stack;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 14:15
 * @Version 1.0
 **/
public class StackObject {
    private int top = 0;//栈顶
    private char[] arr = new char[100];


    public StackObject() {
    }


    public void pushIn(char value){
        this.arr[top] = value;
        top++;
    }

    public char takeOut(){
        return arr[--top];
    }

}
