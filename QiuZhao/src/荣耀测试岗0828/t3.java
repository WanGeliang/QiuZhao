package 荣耀测试岗0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 * 5
 * Apple 1 80
 * Apple 2 62
 * Apple 4 73
 * Orange 4 65
 * Orange 1 90
 * Apple 3 91
 * Orange 3 88
 * Orange 5 90
 */
public class t3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            List<Power> list = new ArrayList<>();
            Queue<String> queue = new PriorityQueue<>();
            while (!(str = br.readLine()).equals("")) {
                String[] s = str.split(" ");
                Power power = new Power(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                if (!queue.contains(power.name)) {
                    queue.add(power.name);
                }
                list.add(power);
            }

            Collections.sort(list, new Comparator<Power>() {
                @Override
                public int compare(Power o1, Power o2) {
                    if (o1.name != o2.name) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        if (o1.weight != o2.weight) {
                            return o1.weight - o2.weight;
                        } else {
                            return o1.no - o2.no;
                        }
                    }
                }
            });
            for (int i = 0; i < list.size(); i++) {
                Power power = list.get(i);
                System.out.println(power.name + " " + power.no + " " + power.weight);
            }
        }
    }
}

class Power {
    int no;
    int weight;
    String name;

    public Power(String name, int no, int weight) {
        this.name = name;
        this.no = no;
        this.weight = weight;
    }
}
