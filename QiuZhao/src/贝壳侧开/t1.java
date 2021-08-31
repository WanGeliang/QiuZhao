package 贝壳侧开;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

/**
 * @author Geliang
 * @date 2021-08-13
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
//        while ((str = br.readLine()) != null) {
//
//        }
        int[] count = getCount(4, 6);
        System.out.println(Arrays.toString(count));
    }

    public static int[] getCount(int n, int m) {
        int[] res = new int[n];
        if (m <= n) {
            Arrays.fill(res, 0, m, 1);
            return res;
        } else {
            Arrays.fill(res, 1);
            // 还剩这么多肥料
            int k = m - n;
            int leftToRight = 0;
            int rightToLeft = 0;
            int leftLen = -1;
            int rightLen = -1;
            int count = k / (n - 1);
            if ((count > 0)&&(count) % 2 == 0) {
                leftToRight = count / 2;
                rightToLeft = count / 2;
            } else if (count > 0) {
                leftToRight = count / 2 + 1;
                rightToLeft = count / 2;
                if (count % 2 == 1) {
                    rightLen = k % (n - 1);
                } else {
                    leftLen = k % (n - 1);
                }
            } else if (count == 0) {
                rightLen = k % (n - 1);
            }
            // 左到右边
            for (int l = 1; l < n; l++) {
                res[l] += rightToLeft;
            }
            // 右边
            for (int r = n - 2; r >= 0; r--) {
                res[r] += leftToRight;
            }
            if (rightLen != -1) {
                for (int l = 1; l < 1 + rightLen; l++) {
                    res[l] += 1;
                }
            }
            if (leftLen != -1) {
                for (int r = n - 2; r >= n - 2 - leftLen; r--) {
                    res[r] += 1;
                }
            }
            return res;
        }
    }
}
