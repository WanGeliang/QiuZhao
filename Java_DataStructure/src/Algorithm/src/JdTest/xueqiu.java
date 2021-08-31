package Algorithm.src.JdTest;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 万葛亮
 * @Date 2020 08 27 20:57
 * @GIRL friend 江珊
 */
import java.util.*;
public class xueqiu {


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(2); q.addLast(3); q.addLast(5);
            int cnt = 0;
            while(!q.isEmpty()) {
                int val = q.pollFirst();
                cnt++;
                if(cnt == n) {
                    System.out.println(val);
                    break;
                }
                q.addLast(val * 10 + 2);
                q.addLast(val * 10 + 3);
                q.addLast(val * 10 + 5);
            }
        }

}
