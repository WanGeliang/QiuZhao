package BagProblem;

import java.util.Arrays;

public class ZeroOneBag {
//    就是先把物品一个一个的放入容量不同的背包中
    public static void main(String[] args) {
        int[] weight={1,3,4};
        int[] values={15,20,30};
        int bagWeight=4;
        yiWeiArray(weight,values,bagWeight);
    }

    /**
     * 我们首先采用的是二维数组的方式进行理解的
     * @param weight
     * @param values
     * @param bagWeight
     */
    public static void erWeiArray(int[] weight,int[] values,int bagWeight){
        int[][] dp=new int[weight.length][bagWeight+1];
//        初始化，当背包容量为0时的最大容量
        for (int i = 0; i < weight.length; i++) {
            dp[i][0]=0;
        }
//        初始化，当放入物品时,倒叙遍历，防止物品重复放入背包中
        for (int i = bagWeight; i >= weight[0]; i--) {
            dp[0][i]=dp[0][i-weight[0]]+values[0];
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if(j<weight[i]) dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    /**
     * 方法2：我们采用一维数组的方式进行遍历
     * @param weight
     * @param values
     * @param baWeight
     */
    public static void yiWeiArray(int[] weight,int[] values,int baWeight){
        // 一维数组的定义是：背包容量为j时，背包所能装下的最大价值
        int[] dp=new int[baWeight+1];
        dp[0]=0;//背包容量为0时，背包的最大价值
        for (int i = 0; i < weight.length; i++) {
            // 倒序遍历，为了使背包只用遍历一次
            for (int j = baWeight; j >=weight[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+values[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
