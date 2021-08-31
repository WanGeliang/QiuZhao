package Shopee提前批;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-07-19
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) {
        t2 me = new t2();
        char c = '2';
        System.out.println(c - '0' + 1);
        int[] res = me.GetEndPoint("3W2D");
        System.out.println(Arrays.toString(res));
    }

    public int[] GetEndPoint(String order) {
        // write code here
//        "2w2d"[2,2]; ws,da
//        if(order==null||order.length()==0) return new int[]{};
//        order.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('S', 0);
        map.put('W', 0);
        map.put('D', 0);
        int row = 0, col = 0;

        char[] c = order.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == 'W'||c[i] == 'w' && i > 0 && (c[i - 1] >= '0' && c[i - 1] <= '9')) {
                map.put('W', map.get('W') + (c[i - 1] - '0'));
            } else if (c[i] == 'W') {
                map.put('W', map.get('W') + 1);
            }
            if (c[i] == 'S'||c[i] == 's' && i > 0 && (c[i - 1] >= '0' && c[i - 1] <= '9')) {
                map.put('S', map.get('S') + (c[i - 1] - '0'));
            } else if (c[i] == 'S') {
                map.put('S', map.get('S') + 1);
            }
            if (c[i] == 'D'||c[i] == 'd' && i > 0 && (c[i - 1] >= '0' && c[i - 1] <= '9')) {
                map.put('D', map.get('D') + (c[i - 1] - '0'));
            } else if (c[i] == 'D') {
                map.put('D', map.get('D') + 1);
            }
            if (c[i] == 'A' ||c[i] == 'a'&& i > 0 && (c[i - 1] >= '0' && c[i - 1] <= '9')) {
                map.put('A', map.get('A') + (c[i - 1] - '0'));
            } else if (c[i] == 'A') {
                map.put('A', map.get('A') + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 'W') col += entry.getValue();
            if (entry.getKey() == 'S') col -= entry.getValue();
            if (entry.getKey() == 'D') row += entry.getValue();
            if (entry.getKey() == 'A') row -= entry.getValue();
        }
        return new int[]{row, col};
    }


}
