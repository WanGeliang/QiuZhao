package CommonTest;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Geliang
 * @date 2021-07-11
 * @slogan 致敬大师，致敬未来的你！
 */
public class DuanDianExam20210711 {
    public static void main(String[] args) {
        int i = Integer.valueOf("11").intValue();
        int test = Integer.parseInt("11");
        System.out.println(i==test);
        Queue<ListNode> queue=new PriorityQueue<>((l1,l2)->l1.val-l2.val);

    }
}
class ListNode{
    int val;
}
