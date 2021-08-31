package datasource_sort.src.com.ListNodeSort;


import java.util.List;

/**
 * @author Geliang
 * @date 2021-06-26
 * @slogan 致敬大师，致敬未来的你！
 */
public class ListNodeQuickSort {
    public static void main(String[] args) {
        // 单链表的排序
        ListNode head=new ListNode(4);
        head.next=new ListNode(5);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(6);
        head.next.next.next.next=new ListNode(1);
        // 没有排序前
        System.out.println(head);
        // 开始排序
        // 首先使用归并排序
//        ListNode temp=head;
//        temp.next=null;
//        ListNode res=helpMerge(head);
        // 使用快速排序
//        ListNode res=quickSort(head,null);
        ListNode res=oddEvenList(head);
        System.out.println(res);


    }

    /**
     * 奇偶链表
     * @param head
     * @return
     */
    public static ListNode oddEvenList (ListNode head){
        if(head==null||head.next==null||head.next.next==null) return head;

        ListNode odd=head;

        ListNode even=head.next;

        //这里指向偶数节点的头节点
        ListNode evenHead=head.next;
        while(even!=null&&even.next!=null){
//            System.out.println("head:"+head);
//            System.out.println("head.next:"+head.next);
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        // 只需要要把奇数节点的尾节点指向偶数节点的头节点
        odd.next=evenHead;
        // 最后直接返回头节点
        return head;
    }
    public static ListNode helpMerge(ListNode head){
        if(head==null||head.next==null) return head;
        // 先寻找中间节点
        ListNode slow=head;
        ListNode fast=head;
        // 慢指针走1步，快指针走2步
        while (slow.next!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // 遍历完之后，slow节点就是前一断的尾节点
//        最后慢指针就是中间节点
        ListNode right=helpMerge(slow.next);
        slow.next=null;
        ListNode left=helpMerge(head);
        return mergeSort(left,right);
    }

    /**
     * 单链表的归并排序
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeSort(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        // 创建一个新的链表，进行归并排序后，返回一个升序的链表
        ListNode dumpNode=new ListNode(-1);
        ListNode cur=dumpNode;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return dumpNode.next;
    }

    /**
     * 单链表的快速排序
     * @param head :head头节点相当于
     * @param end :这里的end节点是取不到的
     * @return
     */
    public static ListNode quickSort(ListNode head,ListNode end){
        // 同数组的排序方式一样
        // 判断left节点和right节点是否满足继续判断的条件
        // 这里就是判断head和end节点
        // 这句话相当于head==null,以及head.next==null
        if(head==end||head.next==end){
            return head;
        }
        // 我们将链表分为两部分进行排序
        // 将链表从head节点进行分开，前一部分进行,头插法
        ListNode pre=head;
        // 对后一部分进行尾插法
        ListNode tail=head;

        ListNode cur=head.next;
        // 这里cur是不等于end的
        while (cur!=end){
            // 记录下一个需要遍历的值
            ListNode next=cur.next;
            if(cur.val < head.val){
                cur.next=pre;
                pre=cur;
            }
            if(cur.val >= head.val){
                tail.next=cur;
                tail=cur;
            }
            cur=next;
        }
        // 把后面的进行断掉
        tail.next=end;
        // 定义一个node，最终返回这个node
        ListNode node=quickSort(pre,head);
        head.next=quickSort(head.next,end);
        return node;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}