package 提前批.HuaWei.test7021;

import java.util.*;

/**
 * @author Geliang
 * @date 2021-07-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        int N, K;
        String[] s = str.split(" ");
        // N表示生产车间的贵重仪器数量
        N = Integer.parseInt(s[0]);
        // K表示需要使用仪器的生产测试的设备数量
        K = Integer.parseInt(s[1]);
//        System.out.println(K);
        int[][] arr = new int[K][2];
        // 位置为0的是时间，位置为1的是优先级
        for (int i = 0; i < K; i++) {
            str = sc.nextLine();
            s = str.split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        // 这里按照优先级升序，时间降序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] > o2[1]) {
                    return 1;
                } else {
                    if (o1[0] > o2[0]) {
                        return -1;
                    }
                    return 1;
                }
            }
        });
        // 设置一个小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(K, ((o1, o2) -> o1 - o2));
        // 往小根堆里初始化全为0
        for (int i = 0; i < K; i++) {
            queue.add(0);
        }
        // 遍历数组，每次从小根堆里面取出最小的数据
        for (int i = 0; i < K; i++) {
            int q = queue.poll();
            int t = arr[i][0] + q;
            queue.add(t);
        }
        // 在小根堆里最大的数据就是我们要找的数
        for (int i = 0; i < queue.size(); i++) {
           queue.poll();
        }
        System.out.println(queue.peek());
    }
}
