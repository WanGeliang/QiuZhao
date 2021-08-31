package datasource_linkedlist.src.linkedlist;

/**
 * @author 万葛亮
 * @Date 2020 07 02 16:13
 * @GIRL friend 江珊
 */
public class Josephu {
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }

}

class CircleSingleLinkedList{
    //根据传入的数量构建单项环形链表
    Boy first=null;
    public void addBoy(int num){

        //先判断num的值是否满足形成队列
        if(num<1){
            System.out.println("不能创建环形链表");
            return;
        }
        Boy curBoy=null;
        for (int i = 1; i <=num ; i++) {

            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }

    }

    // 遍历当前的环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {// 说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // curBoy后移
        }
    }

    /**
     *
     * @param startNo 开始的位置
     * @param countNum 间隔数字
     * @param nums 总共的人数
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if(first==null||startNo>nums||startNo<1){
            System.out.println("输入的数据不合法");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        for (int i = 0; i < nums; i++) {
            if(first==helper.getNext()){
                break;
            }
            helper=helper.getNext();
        }
        //再让first 和 helper 循环到指定的次数
        for (int i = 0; i < startNo - 1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        //进行出圈操作
        while (true){
            if(first==helper){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                helper=helper.getNext();
                first=first.getNext();
            }
            System.out.printf("此时出圈的人号数为%d \n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后出圈的人的号数为 %d \n",helper.getNo());
    }
}
//创建一个节点
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}