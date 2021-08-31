package CodeTop.DynamicProgram;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-06-07
 * @slogan 致敬大师，致敬未来的你！
 */
//连续子数组的最大值
public class maxSubArray {
    public static void main(String[] args) {
//        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int[] nums={-1,-2};
        System.out.println(getMax(nums));
    }
    public static int getMax(int[] nums){
        // dp[i]的定义，从位置（0,i）下标的最大值
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=nums[0];
        // 这里要把我们res，置为nums[0],不然会报错
        int res=dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 地推公式：当前值与前一个连续最大的值相加进行比较
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
