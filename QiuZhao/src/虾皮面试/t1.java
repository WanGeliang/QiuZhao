package 虾皮面试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split("->");
            int[] arr=new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i]=Integer.parseInt(s[i]);
            }
            ListNode head = new ListNode(arr[0]);
            ListNode cur=head;
            for (int i = 1; i < arr.length; i++) {
                cur.next=new ListNode(arr[i]);
                cur=cur.next;
            }
            System.out.println(detectCycle(head));
        }
    }
    public static int detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return -1;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        int count=-1;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            count++;
        }
        return count;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}