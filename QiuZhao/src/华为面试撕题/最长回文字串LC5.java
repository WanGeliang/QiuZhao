package 华为面试撕题;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class 最长回文字串LC5 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int len = s.length();
        int left = 0;
        int right = 0;
        // 记录一个二维dp，含义是从下标i到j是否是回文字串
        // 必须要从后往前遍历，因为我们要记录的是当我判断i和j相同时，还需要判断i+1和j-1的位置是否是true
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        String res = s.substring(left, right + 1);
        return res;
    }
}
