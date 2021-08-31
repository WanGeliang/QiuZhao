package hello单车;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str=br.readLine())!=null){
                String[] s = str.split(" ");
                int row=Integer.parseInt(s[0]);
                int col=Integer.parseInt(s[1]);
                int[][] arr=new int[row][col];
                for (int i = 0; i < row; i++) {
                    s = br.readLine().split(" ");
                    for (int j = 0; j < s.length; j++) {
                        arr[i][j]=Integer.parseInt(s[j]);
                    }
                }
                int[][] dp=new int[row][col];
                dp[0][0]=arr[0][0];
                for (int i = 1; i < row; i++) {
                    dp[i][0]=dp[i-1][0]+arr[i][0];
                }
                for (int i = 1; i < col; i++) {
                    dp[0][i]=dp[0][i-1]+arr[0][i];
                }
                for (int i = 1; i < row; i++) {
                    for (int j = 1; j < col; j++) {
                        dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+arr[i][j];
                    }
                }
                System.out.println(dp[row-1][col-1]);
            }
    }
}
