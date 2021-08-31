package 华为机考练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-24
 * @slogan 致敬大师，致敬未来的你！
 */
public class HJ23 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            Map<String, Integer> map = new TreeMap<>();
            String[] split = str.split("");
//            int count = Integer.MAX_VALUE;
            for (int i = 0; i < split.length; i++) {
                String subStr = split[i];
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
//                int num = map.get(subStr);
//                count = Math.min(count, num);
            }
            List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue()-o2.getValue();
                }
            });
            int count = list.get(0).getValue();
            Set<String> set = map.keySet();
            for (String key : set) {
                if (map.get(key) == count) {
                    str = str.replace(key, "");
                }
            }
            System.out.println(str);
        }
    }
}
