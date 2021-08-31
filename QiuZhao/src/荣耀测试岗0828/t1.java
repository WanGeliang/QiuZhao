package 荣耀测试岗0828;

import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 */

public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        int[][] arr = new int[times][10];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < times; i++) {
            System.out.println(leastCount(arr[i]));
        }
    }

    // 寻找一维数组的最少的合成次数
    public static int leastCount(int[] arr) {
        int count = 0, index = 8;
        while (arr[9] < 2) {
            //从下标为8这个元素开始遍历
            index = 8;
            //从右边找到第一个大于等于2的数字
            while (index >= 0 && arr[index] < 2) {
                index--;
            }
            arr[index] -= 2;
            arr[index + 1] += 1;
            count++;
        }
        return ++count;
    }
}

