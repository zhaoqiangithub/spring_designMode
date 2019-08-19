package zq.arithmetic.queue;

/**
 * @Description TODO
 * @@Author qiang_obs
 * @Date 2019/4/21 13:39
 * @Version 1.0
 **/
public class QuereObject {
    private int[] arrMain ;
    private int head;
    private int tail;

    public QuereObject(int[] arrMain, int head, int tail) {
        this.arrMain = arrMain;
        this.head = head;
        this.tail = tail;
    }

    public QuereObject() {
    }

   public void addHead(){
        this.head++;
    }

    public void addTail(){
        this.tail++;
    }

    public int getQueueValueByInd(int ind){
        return this.arrMain[ind];
    }
    public void setQueueValueByInd(int ind,int value){
        this.arrMain[ind] = value;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

}
