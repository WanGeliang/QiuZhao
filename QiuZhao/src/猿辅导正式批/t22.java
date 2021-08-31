package 猿辅导正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-07-31
 * @slogan 致敬大师，致敬未来的你！
 */
public class t22 {
//    可以通过
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '[') stack.push(-1);
                else if (c == ']') {
                    int temp = 1;
                    while (stack.peek() != -1) {
                        temp += stack.pop();
                    }
                    stack.pop();
                    stack.push(temp);
                } else {
                    int top = stack.peek();
                    stack.pop();
                    stack.push(top * (c - '0'));
                }
            }
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            System.out.println(sum);
        }
    }
}
