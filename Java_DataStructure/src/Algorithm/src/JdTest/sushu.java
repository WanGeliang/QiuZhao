package Algorithm.src.JdTest;

/**
 * @author 万葛亮
 * @Date 2020 08 27 20:19
 * @GIRL friend 江珊
 */
import java.util.*;
public class sushu {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] arr = new int[n][2*n-1];
            for(int i=0;i<n;i++){
                for(int j=n-i-1;j<n+i;j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n][2*n-1];
            for(int j=0;j<2*n-1;j++){
                dp[n-1][j] = arr[n-1][j];
            }
            int res = 0;  //不用变量res，直接取dp[0][n-1]就行
            for(int i=n-2;i>=0;i--){
                for(int j=n-i-1;j<n+i;j++){
                    dp[i][j] = Math.max(dp[i + 1][j - 1], Math.max(dp[i + 1][j], dp[i + 1][j + 1])) + arr[i][j];
                    res = dp[i][j];
                }
            }
            System.out.println(res);
        }

}
