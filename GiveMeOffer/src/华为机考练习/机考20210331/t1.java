package 华为机考练习.机考20210331;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-24
 * @slogan 致敬大师，致敬未来的你！
 * a-b 3:0
 * b-a 1:1
 *
 * a 4,b 1
 *
 * a-b 3:0
 * a-c 2:1
 * b-a 1:1
 * c-a 0:1
 * b-c 4:3
 * c-b 2:2
 *
 * a 10,b 5,c 1
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        while (true) {
            while ((s = br.readLine()) != null) {
                // 死循环怎么进行跳出
                if (s.equals("")) break;
                String[] teamScore = s.split(" ");
                if (teamScore.length == 0) break;
                String[] team = teamScore[0].split("-");
                String[] score = teamScore[1].split(":");
                if (score[0].compareTo(score[1]) < 0) {
                    map.put(team[1], map.getOrDefault(team[1], 0) + 3);
                    map.put(team[0], map.getOrDefault(team[0], 0) + 0);
                } else if (score[0].compareTo(score[1]) > 0) {
                    map.put(team[0], map.getOrDefault(team[0], 0) + 3);
                    map.put(team[1], map.getOrDefault(team[1], 0) + 0);
                } else {
                    map.put(team[1], map.getOrDefault(team[1], 0) + 1);
                    map.put(team[0], map.getOrDefault(team[0], 0) + 1);
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() != o2.getValue()) {
                        return -(o1.getValue() - o2.getValue());
                    } else {
                        return o1.getKey().compareTo(o1.getKey());
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                Map.Entry<String, Integer> mapping = list.get(i);
                sb.append(mapping.getKey() + " " + mapping.getValue());
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
