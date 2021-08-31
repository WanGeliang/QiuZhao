package 华为面试撕题;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class 森林中的兔子LC781 {
    public static void main(String[] args) {
        int[] answers = {1, 1, 2};
        森林中的兔子LC781 ne = new 森林中的兔子LC781();
//        ne.numRabbits(answers);
        System.out.println(ne.numRabbits(answers));
    }

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int res = 0;
        Set<Integer> rabbitSet = map.keySet();
        for (int key : rabbitSet) {
            int group = map.get(key) / (key + 1);
            int mod = map.get(key) % (key + 1);
            if (mod == 0) {
                res = res + (group * (key + 1));
            } else {
                res = res + (group * (key + 1)) + key + 1;
            }
        }
        return res;
    }
}
