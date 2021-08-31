package CommonTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-07-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class IntervalTest {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    if (o1[1] > o2[1]) {
                        return -1;
                    }
                    return 1;
                }
            }
        });
        int[] newInterval = {2, 3};
        int[][] temp = new int[intervals.length + 1][2];
//        int[][] temp
        for (int i = 0; i < temp.length; i++) {
            Arrays.fill(temp[i], 0);
        }
        temp = Arrays.copyOf(intervals, intervals.length);
        for (int[] arr : temp) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(temp.length);
        temp[temp.length - 1][0] = newInterval[0];
        temp[temp.length - 1][1] = newInterval[1];
        for (int[] arr : temp) {
            System.out.println(Arrays.toString(arr));
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        Integer a = map.entrySet().iterator().next().getKey();
    }
}
