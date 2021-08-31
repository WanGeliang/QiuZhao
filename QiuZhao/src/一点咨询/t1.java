package 一点咨询;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-07-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("0200"));
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> sub = new ArrayList<>();
        sub.add("10:00");
        sub.add("12:00");
        list.add(new ArrayList<>(sub));
        sub.clear();
        sub.add("03:00");
        sub.add("11:30");
        list.add(new ArrayList<>(sub));
        sub.clear();
        sub.add("11:30");
        sub.add("14:00");
        list.add(new ArrayList<>(sub));
        System.out.println(countMaxActivity(list));
//        String s="11:00";
//        System.out.println(Integer.parseInt(s.replace(":","")));
    }

    public static int countMaxActivity(ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        int[][] num = new int[timeSchedule.size()][2];
        // 转化成数字
        for (int i = 0; i < timeSchedule.size(); i++) {
            String[] s = timeSchedule.get(i).toArray(new String[2]);
            System.out.println(Arrays.toString(s));
            for (int j = 0; j < 2; j++) {
                num[i][j] = Integer.parseInt(s[j].replace(":", ""));
            }
        }
        Arrays.sort(num, ((o1, o2) -> o1[0] - o2[0]));
        int index = -1;
        int[][] res = new int[num.length][2];
        for (int[] arr : num) {
            if (index == -1 || arr[0] >= res[index][1]) {
                res[++index] = arr;
            } else {
                res[index][1] = Math.max(res[index][1], arr[1]);
            }
        }
//        int[][] temp = Arrays.copyOf(res, index + 1);
//      减去合并之后的数
        return num.length - index - 1;
    }
}
