package 华为面试撕题;

/**
 * @author Geliang
 * @date 2021-08-31
 * @slogan 致敬大师，致敬未来的你！
 */
public class 跳跃游戏2LC45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        跳跃游戏2LC45 me = new 跳跃游戏2LC45();
        System.out.println(me.jump(nums));
    }

    /**
     * 刚开始我们定义一个当前能到达最远的位置maxStep和一个当前能到达的路径curStep
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0;
        int curIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (curIndex == i) {
                // 当前步数能达到curIndex时，此时我们就更新count
                count++;
                // 更新curIndex能到达的位置
                curIndex = maxIndex;
                if (curIndex >= nums.length - 1) break;
            }
        }
        return count;
    }
}
