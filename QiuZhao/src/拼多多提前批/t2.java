package 拼多多提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int time = Integer.parseInt(str);
            for (int j = 0; j < time; j++) {
                String[] s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                if (start >= end) {
                    int flag = start - end;
                    if (flag % 2 == 0) System.out.println(flag / 2);
                    else System.out.println(flag / 2 + 1);
                    continue;
                }
                int[] dp = new int[end + 1];
                for (int i = 0; i <= start; i++) {
                    if ((start - i) % 2 == 0) dp[i] = (start - i) / 2;
                    else dp[i] = (start - i) / 2 + 1;
                }
                for (int i = start + 1; i < end + 1; i++) {
                    int flag = 0;
                    int down = 1 + dp[i - 1];
                    if (i % 2 == 0) flag = dp[i / 2] + 1;
                    else flag = 2 + dp[(i + 1) / 2];
                    dp[i] = Math.min(down, flag);
                }
                System.out.println(dp[end]);
            }
        }
    }
}
