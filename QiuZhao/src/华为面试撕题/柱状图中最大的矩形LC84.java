package 华为面试撕题;

import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class 柱状图中最大的矩形LC84 {
    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 1, 2};
        柱状图中最大的矩形LC84 me = new 柱状图中最大的矩形LC84();
        System.out.println(me.largestRectangleArea(heights));
//        me.largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[heights.length + 1];
        System.arraycopy(heights, 0, arr, 0, heights.length);
//        arr[heights.length] = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int top = stack.pop();
                // 如果之前栈为空，宽度就乘以自己的下标:代表之前所有的都是比自己大的？如果不为空，此时就将i和stack的栈顶元素相减再减1，进行相乘
                maxArea = Math.max(maxArea, arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
//                arr[top] = arr[i];
            }
            stack.push(i);
        }
        return maxArea;
    }
}
