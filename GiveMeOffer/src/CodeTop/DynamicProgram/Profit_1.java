package CodeTop.DynamicProgram;

/**
 * @author Geliang
 * @date 2021-06-07
 * @slogan 致敬大师，致敬未来的你！
 */
// 买卖股票的最佳时机
public class Profit_1 {
    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};
        System.out.println(getMax(nums));
    }
    public static int getMax(int[] nums){
        /**
         * 只能买一次，卖一次
         * dp[0]手里没有股票
         * dp[1]手里有股票
         */
        if(nums.length==1) return nums[0];
        int[] dp=new int[3];
        dp[0]=0;//手里没有股票
        dp[1]=-nums[0];//买了一次
        dp[2]=Integer.MIN_VALUE;//买了一次卖了一次，刚开始这里设定为负数
        for (int i = 1; i < nums.length; i++) {
            int temp1=Math.max(dp[1],dp[0]-nums[i]);
            int temp2=Math.max(dp[2],dp[1]+nums[i]);
            dp[1]=temp1;
            dp[2]=temp2;
        }
        return dp[2];
    }

}
