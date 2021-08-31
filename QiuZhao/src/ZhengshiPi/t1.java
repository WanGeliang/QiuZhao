package ZhengshiPi;


import java.util.Arrays;

public class t1 {
    public static void main(String[] args) {
        int[] height = {1, 5, 3, 2, 4};
        System.out.println(TeamNums(height));
    }

    public static int TeamNums(int[] height) {
        // write code here
        if (height.length < 3) return 0;
        int[] dp1 = new int[height.length];
        int[] dp2 = new int[height.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            for (int j = height.length - 1; j > i; j--) {
                if (height[i] > height[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (dp1[i] >= 3) {
                res += Combination(dp1[i], dp1[i]-1);
            }
            if (dp2[i] >= 3) {
                res += Combination(dp2[i], 3);
            }
        }
        return res;
    }

    public static int Combination(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return Combination(n - 1, k) + Combination(n - 1, k - 1);
        }

    }
}
