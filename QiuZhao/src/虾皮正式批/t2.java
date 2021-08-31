package 虾皮正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            int target=Integer.parseInt(str);
            int[] nums={1,2,3,3,3,3,4};
            int[] res=searchRange(nums,target);
            System.out.println(Arrays.toString(res).replace("[","").replace("]",""));
        }
    }
    public static int[] searchRange(int[] nums, int target) {
        int find = binarySearch(nums, target);
        if (find == -1) {
            return new int[]{-1, -1};
        }
        int left = find - 1;
        int right = find + 1;
        while (left >= 0 && nums[left] == target) left--;
        while (right < nums.length && nums[right] == target) right++;
        return new int[]{left + 1, right - 1};
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
