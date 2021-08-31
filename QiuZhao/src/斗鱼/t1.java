package 斗鱼;


public class t1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s1 string字符串
     * @param s2 string字符串
     * @return string字符串
     */
    static int[][] dp;
    static int[][] path;
    static StringBuilder sb = new StringBuilder();
    static String a;

    public String LCS(String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        a = s1;
        dp = new int[len1 + 1][len2 + 1];
        path = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j] = 1;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    path[i][j] = 2;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    path[i][j] = 3;
                }
            }
        }
        if (len1 == 0 || len2 == 0) return "-1";
        lcsPath(len1, len2);
        if (sb.length() == 0) return "-1";
        return sb.toString();
    }

    public static void lcsPath(int i, int j) {
        if (i == 0 || j == 0) return;
        if (path[i][j] == 1) {
            lcsPath(i - 1, j - 1);
            sb.append(a.charAt(i - 1));
        } else if (path[i][j] == 2) {
            lcsPath(i - 1, j);
        } else {
            lcsPath(i, j - 1);
        }
        return;
    }

}