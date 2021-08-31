package 华为面试撕题;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 */
public class 每日温度LC739 {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        每日温度LC739 me = new 每日温度LC739();
        System.out.println(Arrays.toString(me.dailyTemperatures(temp)));
    }

//    public static int[] dailyTemperatures(int[] T) {
//        int[] res = new int[T.length];
//        res[T.length - 1] = 0;
//        for (int i = 0; i < T.length - 1; i++) {
//            for (int j = i + 1; j < T.length; j++) {
//                if (T[i] < T[j]) {
//                    res[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        // 设置一个单调递减栈
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                // 如果当前温度，大于栈里面的元素，就进行出栈
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    int top = stack.pop();
                    // 然后将top作为元素的下标进行赋值
                    res[top] = i - top;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
