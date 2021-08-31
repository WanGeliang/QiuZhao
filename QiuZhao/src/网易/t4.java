package 网易;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-21
 * @slogan 致敬大师，致敬未来的你！
 * [[1,1,1,1,0],[0,1,0,1,0],[1,1,2,1,1],[0,2,0,0,1]]
 */
public class t4 {

    public static void main(String[] args) {

    }

    public int minSailCost(int[][] input) {
        int row = input.length;
        int col = input[0].length;
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (input[i][j] == 0) {
                    cost[i][j] = 2;
                } else if (input[i][j] == 1) {
                    cost[i][j] = 1;
                } else {
                    cost[i][j] = 999;
                }
            }
        }
        int[][] dp = new int[row][col];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + cost[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
            }
        }
        if (dp[row - 1][col - 1] > 1000) {
            return -1;
        } else return dp[row - 1][col - 1];
    }
}
