package 海康测开;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-26
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int startX = Integer.parseInt(s[2]);
            int startY = Integer.parseInt(s[3]);
            int[][] dp = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                Arrays.fill(dp, 0);
//            }
            for (int i = startY; i < n; i++) {
                dp[startX][i] = 1;
            }
            for (int i = startX; i < m; i++) {
                dp[i][startY] = 1;
            }
            for (int i = startX + 1; i < m; i++) {
                for (int j = startY + 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
            System.out.println(dp[m - 1][n - 1]);
        }
    }
}
