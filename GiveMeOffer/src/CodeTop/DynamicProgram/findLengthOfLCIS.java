package CodeTop.DynamicProgram;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-06-09
 * @slogan 致敬大师，致敬未来的你！
 */
// 最长连续子序列
public class findLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums={1,2,3,5,4};
        System.out.println(getMax(nums));
    }

    public static int getMax(int[] nums){
        int res=0;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1]>nums[i]) dp[i+1]=dp[i]+1;
            res=Math.max(res,dp[i+1]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
