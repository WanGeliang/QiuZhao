package 华为面试撕题;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 */

public class 最大正方形LC221 {
    public static void main(String[] args) {
        String[][] matrix = {{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}};
        最大正方形LC221 me = new 最大正方形LC221();
        System.out.println(me.maximalSquare(matrix));
    }

    public int maximalSquare(String[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        // 因为我们要定义需要从i和j开始计算起，要计算相邻三个方向的元素
        // 以下标i和j为顶点的正方形能构成的边
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == "1") {
                    // dp[i][j]是以下标 i 和 j 的正方形，要求相邻三个边长中最短的作为
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
