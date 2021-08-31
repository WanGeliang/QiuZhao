package 提前批.HuaWei.test7021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Geliang
 * @date 2021-07-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str=sc.nextLine();
        String[] s1 = str.split(" ");
        int N = Integer.parseInt(s1[0]);
        int K = Integer.parseInt(s1[1]);
//      以最短时间运行
        int[][] time = new int[K][2];
        Point[] points = new Point[K * 2];

        for (int i = 0; i < K; i++) {
            str = sc.nextLine();
//            System.out.println(str);
            String[] s = str.split(" ");
            int startTime = Integer.parseInt(s[0]);
            int startPoint = Integer.parseInt(s[1]);
            int endPoint = Integer.parseInt(s[2]);
            // 起始点和终止相同，不处理
            if (startPoint == endPoint) continue;
            // 开始处理数据
            // 开始时间
            time[i][0] = startTime;
            // 计算结束时间，题目中要求最短时间，需要比较两点走过最少的站点个数
            // 记录为n,前面一个是顺时针，后面一个是逆时针行走
            int n = Math.min(Math.abs(endPoint - startPoint), Math.abs(startPoint + N - endPoint));
            time[i][1] = n * 5 + startTime;
        }

        for (int i = 0; i < time.length; i++) {
            System.out.println(Arrays.toString(time[i]));
        }
        for (int i = 0; i < K; i++) {
            points[i * 2] = new Point(time[i][0], 0);
            points[i * 2 + 1] = new Point(time[i][1], 1);
        }

        Arrays.sort(points);
        //查看以下分数
        System.out.println(Arrays.toString(points));
        // 至少有一个车在线
        int max = 1, count = 0;

        // 比较type值，进行更新
        for (int i = 0; i < points.length; i++) {
            if (points[i].type == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        // 最后打印出结果值
        System.out.println(max);
    }

}

class Point implements Comparable<Point> {

    int value;
    int type;

    Point(int v, int t) {
        this.value = v;
        this.type = t;
    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        if (this.value < o.value) {
            return -1;
        } else if (this.value > o.value) {
            return 1;
        } else {
            // 当type当两者相等时，需要把type为1的数放在前面，相当于降序
            // 相当于把有边界的相同的情况放在前面
            if (this.type > o.type) {
                return -1;
            }
            return 1;
        }
    }
}