package WangYi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-08-07
 * @slogan 致敬大师，致敬未来的你！
 * 2
 * 34088119480815*663
 * 520123200501169**4
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
//      余数为0-10对应的下标，
//      身份证最后一位对应的
        String[] lastIndex = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 0);map.put("0", 1);map.put("X", 2);map.put("9", 3);map.put("8", 4);map.put("7", 5);map.put("6", 6);map.put("5", 7);map.put("4", 8);map.put("3", 9);map.put("2", 10);
        int mmCount = Integer.parseInt(br.readLine());
        int[] num = new int[mmCount];
        int resIndex = 0;
        for (int m = 0; m < mmCount; m++) {
            str = br.readLine();
            if (str.contains("*")) {
                String[] s = str.split("");
                int len = s.length;
                int sum = 0;
                int mod = -1;
                if (s[17].equals("X")) {
                    mod = map.get("X");
                } else {
                    mod = map.get(s[17]);
                }
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < len - 1; i++) {
                    if (s[i].equals("*")) {
                        list.add(i);
                    } else {
                        sum = sum + weight[i] * Integer.parseInt(s[i]);
                    }
                }
                int res = 0;
                int sizeCount = list.size();
                boolean f0 = false;
                boolean f1 = false;
                boolean f2 = false;
                for (int i = 0; i < sizeCount; i++) {
                    if (i == 0) f0 = true;
                    if (i == 1) f1 = true;
                    if (i == 2) f2 = true;
                }
                int m0 = 0, m1 = 0, m2 = 0;
                if (f0) {
                    for (int i = 0; i <= 9; i++) {
                        m0 = (weight[list.get(0)] * i);
                        if (f1) {
                            for (int j = 0; j <= 9; j++) {
                                m1 = (weight[list.get(1)] * j);
                                if (f2) {
                                    for (int k = 0; k <= 9; k++) {
                                        m2 = (weight[list.get(2)] * k);
                                        if ((m0 + m1 + m2 + sum) % 11 == mod) {
                                            res++;
                                        }
                                    }
                                }else {
                                    if ((m0 + m1 + sum) % 11 == mod) {
                                        res++;
                                    }
                                }
                            }
                        }else {
                            if ((m0 + sum) % 11 == mod) {
                                res++;
                            }
                        }
                    }
                }
                num[resIndex++] = res;
            } else {
                num[resIndex++] = 1;
            }
        }
        for (int i = 0; i < mmCount; i++) {
             System.out.println(num[i]);
        }
    }
}
