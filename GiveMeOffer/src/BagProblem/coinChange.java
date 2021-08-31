package BagProblem;

import java.util.Arrays;

public class coinChange {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=5;
        change(coins,amount);
    }
    public static void change(int[] coins,int amount){
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            // 当把背包放入里面的时候，相当于是一个排列数
            for (int j = coins[i]; j <= amount; j++) {
                dp[j]+=dp[j-coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
    }
}
