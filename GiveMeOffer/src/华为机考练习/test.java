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
public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(",");
            Map<String, Integer> map = new TreeMap<>();
            for (int i = 0; i < s.length; i++) {
                int count = 0;
                String subStr = s[i];
                for (int j = 0; j < subStr.length(); j++) {
                    char c = subStr.charAt(j);
                    if (c == 'a') count++;
                }
                map.put(subStr, count);
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int l1 = o1.getKey().length();
                    int l2 = o2.getKey().length();
                    if (o1.getValue() == o2.getValue()) {
                        if (l1 == l2) {
                            return o2.getKey().compareTo(o1.getKey());
                        } else {
                            return l2 - l1;
                        }
                    } else {
                        return o2.getValue() - o1.getValue();
                    }
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                Map.Entry<String, Integer> entry = list.get(i);
                sb.append(entry.getKey());
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
