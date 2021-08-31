package 爱奇艺提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-01
 * @slogan 致敬大师，致敬未来的你！
 */
public class t33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
//            if (str=="[]") System.out.println("[]");
            String s = str.replace("[", "");
            s = s.replace("]", "");
            String[] sp = s.split(",");
            int[] rains = new int[sp.length];
            int[] ans = new int[sp.length];
            for (int i = 0; i < rains.length; i++) {
                rains[i] = Integer.parseInt(sp[i]);
            }

            int[] next = new int[rains.length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = rains.length - 1; i >= 0; i--) {
                int temp = rains[i];
                if (temp > 0) {
                    if (map.containsKey(temp)) {
                        next[i] = map.get(temp);
                    }
                    map.put(temp, i);
                }
            }
            Map<Integer, Integer> m2 = new HashMap<>();
            Queue<Integer> queue = new PriorityQueue<>();
            boolean flag = false;
            for (int i = 0; i < rains.length; i++) {
                int temp = rains[i];
                if (temp != 0) {
                    if (m2.containsKey(temp) == false || m2.get(temp) == 0) {
                        m2.put(temp, 1);
                        ans[i] = -1;
                        if (next[i] != 0) {
                            queue.add(next[i]);
                        }
                    } else {
                        System.out.println(new int[]{});
                        flag = true;
                    }
                } else {
                    if (queue.isEmpty()) {
                        ans[i] = 1;
                    } else {
                        int top = queue.peek();
                        queue.poll();
                        ans[i] = rains[top];
                        m2.put(rains[top], 0);
                    }
                }
            }
            if (!flag) System.out.println(Arrays.toString(ans));
        }
    }
}
