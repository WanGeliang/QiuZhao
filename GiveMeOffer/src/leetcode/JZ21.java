package leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-08-09
 * @slogan 致敬大师，致敬未来的你！
 */
public class JZ21 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(exchange(nums)));
//        exchange(nums);
        Map<Integer,Integer> map;
//        map.remove()
//        map.keySet().iterator().next()
    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while ((left <= right) && nums[left] % 2 == 1) {
                left++;
            }
            while ((left <= right) && nums[right] % 2 == 0) {
                right--;
            }
            // 这里要进行中断，如果left>right此时就要进行break了，不然此时还会交换一次
            if (left > right) break;
            // 自己和自己交换也行
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
