package datasource_linkedlist.src.linkedlist;

public class test {
    public static void main(String[] args) {
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        cur.next=new ListNode(1);
        cur.next.next=new ListNode(2);
//        cur.next.val=1;
//        cur.next.next.val=2;
        System.out.println(res.next.val);
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
