package 美团正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * @author Geliang
 * @date 2021-08-08
 * @slogan 致敬大师，致敬未来的你！
 * 5
 * 1 6 3 3 8
 */
public class t3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int[] nums = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            int[] last = new int[n];
            TreeSet<Integer> set = new TreeSet<>();
            int[] dp = new int[n];
            dp[0] = 0;
            for (int i = 0; i < n; i++) {

            }
//            for (int i = 0; i < n; i++) {
//                set.add(nums[i]);
//                int maxValue = 0;
////                for (int j = 0; j < i; j++) {
////                    if (nums[j] < nums[i]) {
////                        maxValue = Math.max(maxValue, nums[j]);
////                    }
////                }
//                Integer lower = set.lower(nums[i]);
//                if (lower != null) {
//                    last[i] = lower;
//                } else {
//                    last[i] = 0;
//                }
//            }
            int sum = 0;
            for (int i = 0; i < last.length; i++) {
                sum += last[i] * (i + 1);
            }
            System.out.println(sum);
        }
    }
}
