package 猿辅导正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-07-31
 * @slogan 致敬大师，致敬未来的你！
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(nums);
            int count = 0;
            int left = -1, right = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != Integer.parseInt(s[i])) {
                    count++;
                    if (count == 1) {
                        left = i + 1;
                    }
                    if (count == 2) {
                        right = i + 1;
                    }
                }
                if (count == 2) break;
            }
            System.out.println(left + " " + right);
        }
    }
}
