package Vivo提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-06-17
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int maxContains = Integer.parseInt(str);
            // 用W[i]表示第i个集装箱的重量
            str = br.readLine();
            String[] W_String = str.split(",");
            int N = W_String.length;
            int[] W = new int[N];
            for(int i = 0; i < N; i++){
                W[i] = Integer.parseInt(W_String[i]);
            }

            str = br.readLine();
            String[] V_String = str.split(",");
            int[] V = new int[N];
            for(int i = 0; i < N; i++){
                V[i] = Integer.parseInt(V_String[i]);
            }

            int dp[][] = new int[N + 1][maxContains + 1];
            // dp[i][j]表示前i(第i个货物的下标为i - 1)个（包括i，0 <= i <= N）集装箱，最大容量为j(0 <= j <= maxContains)的货轮可以最多可以放多少
            for(int i = 1; i <= N; i++){
                // j = 0时始终为0，所以不用放进去计算
                for(int j = 1; j <= maxContains; j++){
                    // 如果第i个货物的重量超出了最大限度，那么就和没有这个货物一样
                    if(j < W[i - 1]){
                        dp[i][j] = dp[i - 1][j];
                    }
                    // 如果第i个货物的重量<=最大限度，那么就可以操作一下
                    else {
                        // 1.不放进去，和没有一样
                        int value1 = dp[i - 1][j];
                        // 2.放进去，相当于容量减少，价值增多，如果放进去多，就要把后面的都改掉？
                        int value2 = dp[i - 1][j - W[i - 1]] + V[i - 1];
                        if(value1 < value2){
                            dp[i][j] = value2;
                        } else {
                            dp[i][j] = value1;
                        }
//                        System.out.println("i = " + i + ", j = " + j + " ," +dp[i][j]);
                    }

                }
            }
            System.out.println(dp[N][maxContains]);
        }
    }
}