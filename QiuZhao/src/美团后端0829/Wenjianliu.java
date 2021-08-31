package 美团后端0829;

import java.util.Scanner;

public class Wenjianliu {

    static int n1, n2;
    public static int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String a = sc.next();
        int slen = s.length();
        int alen = a.length();
        n1 = s.length();
        n2 = a.length();
        sb.append(s);
        String now = sb.toString();
        int count = n1;
        char last = a.charAt(n2 - 1);
        while (longestCommonSubsequence(now, a) != n2) {
            sb.append(s);
            now = sb.toString();
            count += n1;
        }
        int sub = s.indexOf(last);
        System.out.println(count - (slen - sub - 1) - alen);
    }

}
