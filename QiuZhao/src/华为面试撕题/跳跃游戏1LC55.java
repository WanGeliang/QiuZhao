package 华为面试撕题;

/**
 * @author Geliang
 * @date 2021-08-31
 * @slogan 致敬大师，致敬未来的你！
 */
public class 跳跃游戏1LC55 {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
        跳跃游戏1LC55 me = new 跳跃游戏1LC55();
        System.out.println(me.canJump(nums));
//        me.canJump(nums);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums[0] <= 0) return false;
        int curIndex = 0;
        int maxStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int step = curIndex + nums[i];
            maxStep = Math.max(step, maxStep);
            if (curIndex == maxStep && maxStep < nums.length - 1) return false;
            if (maxStep >= nums.length - 1) return true;
            curIndex++;
        }
        return false;
    }

    /**
     * 只需要更新
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i <= maxStep; i++) {
            maxStep = Math.max(maxStep, i + nums[i]);
            if (maxStep >= nums.length - 1) return true;
        }
        return false;
    }
}
