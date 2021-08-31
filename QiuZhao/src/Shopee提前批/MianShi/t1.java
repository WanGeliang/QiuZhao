package Shopee提前批.MianShi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-08-02
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    /**
     * 输入一个字符串如： 12223334 ，输出最早出现的重复最多次的数，比如例题输出2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            // 定义res[0] = 次数, res[1] = 坐标的前后
            int[] res = new int[2];
            Map<Character, Map<Integer, Integer>> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (map.containsKey(c)) {
                    Map<Integer, Integer> mm = map.get(c);
                    Integer next = mm.keySet().iterator().next();
                    mm.put(next, mm.get(next) + 1);
                    map.put(c, mm);
                    continue;
                }
                Map<Integer, Integer> tempMap = new HashMap<>();
                tempMap.put(i, 1);
                map.put(c, tempMap);
            }
//            Collections.sort(map);
        }
    }
}
