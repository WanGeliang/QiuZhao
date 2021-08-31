package BagProblem;
//分割等和子集问题
public class leetcode_416 {
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(subset_sum(nums));
    }
    public static boolean subset_sum(int[] nums){
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return  false;
        int target=sum/2;
        int[] dp=new int[10001];
        dp[0]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >=nums[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }

}


