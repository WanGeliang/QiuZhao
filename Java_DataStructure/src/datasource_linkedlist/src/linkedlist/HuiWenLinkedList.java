package datasource_linkedlist.src.linkedlist;

public class HuiWenLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-129);
        node1.next=new ListNode(-129);
        ListNode node2=new ListNode(1);
        node2.next=new ListNode(2);
        node2.next.next=new ListNode(2);
        node2.next.next.next=new ListNode(1);
//        System.out.println(isPalindrome(node1));
        isPalindrome(node1);

    }

    public static boolean isPalindrome(ListNode listNode){
        StringBuffer sb = new StringBuffer();
        while (listNode!=null){
            sb.append(listNode.val);
            listNode=listNode.next;
        }
        String s = sb.toString();
        int i=0,j=s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }

}
