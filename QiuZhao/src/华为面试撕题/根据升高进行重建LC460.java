package 华为面试撕题;

import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-31
 * @slogan 致敬大师，致敬未来的你！
 */
public class 根据升高进行重建LC460 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        根据升高进行重建LC460 me = new 根据升高进行重建LC460();
        int[][] res = me.reconstructQueue(people);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] arr : people) {
            if (arr[1] < list.size()) {
                list.add(arr[1], arr);
            } else {
                list.addLast(arr);
            }
        }
        int[][] res = new int[people.length][2];
        int index = 0;
        for (int[] arr : list) {
            res[index++] = arr;
        }
        return res;
    }

    public int[][] reconstructQueue1(int[][] people) {
        int len = people.length;
        int[][] res = new int[len][2];
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            indices.add(i);
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });

        for (int[] arr : people) {
            int index = indices.get(arr[1]);
            indices.remove(arr[1]);
            res[index] = arr;
        }
        return res;
    }
}
