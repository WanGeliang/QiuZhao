package 贝壳侧开;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-13
 * @slogan 致敬大师，致敬未来的你！
10
Nice
to
meet
you
I
can
help
you
thank
you
 */
//
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                String s = br.readLine().toLowerCase();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
            PriorityQueue<String[]> queue = new PriorityQueue<>(n,((o1, o2) -> o1[1] != o2[1] ? o2[1].compareTo(o1[1]) : o1[0].compareTo(o2[0])));
//            PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
//                @Override
//                public int compare(String[] o1, String[] o2) {
//                    if (o1[1] != o2[1]) {
//                        return o2[1].compareTo(o1[1]);
//                    } else {
//                        return o2[0].compareTo(o1[0]);
//                    }
////                    return 0;
//                }
//            });

            for (String key : map.keySet()) {
                String[] strTemp = {key, String.valueOf(map.get(key))};
                queue.add(strTemp);
            }

            String[] poll = queue.poll();
            System.out.println(poll[0] + " " + poll[1]);

        }
    }

}
