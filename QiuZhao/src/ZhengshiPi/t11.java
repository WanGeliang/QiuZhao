package ZhengshiPi;

/**
 * @author Geliang
 * @date 2021-08-07
 * @slogan 致敬大师，致敬未来的你！
 */
public class t11 {
    public int TeamNums(int[] height) {
        // write code here
        int len = height.length;
        int res = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if ((height[i] < height[j] && height[j] < height[k]) || (height[i] > height[j] && height[j] > height[k]))
                        res++;
                }
            }
        }
        return res;
    }
}
