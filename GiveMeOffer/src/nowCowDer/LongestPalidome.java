package nowCowDer;

/**
 * @author Geliang
 * @date 2021-06-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class LongestPalidome {
    public static void main(String[] args) {
        String A="abcba";
        int count=getLongestPalindrome(A,A.length());
        System.out.println(count);
    }
    public static int getLongestPalindrome(String A, int n) {
        // write code here
        if(A==null||A.length()==0) return 0;
        // dp[i][j]:是以i开始，同时以j结束的字符串存在的回文串的长度
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;//以i开始，同时以即j=i结束的赋值为1
        }
        int res=0;// 记录最终的结果
        // j一定是大于i的
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(A.charAt(i)==A.charAt(j)){
                    if(j-i<=1){
                        dp[i][j]=true;
                    }else if(i<=n-2&&j>=1&&dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j]) res=Math.max(res,j-i+1);
            }
        }
        return res;
    }
}
