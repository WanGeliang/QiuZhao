package 华为面试撕题;

import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 */
public class 反转每对括号间的字串LC1190 {
    public static void main(String[] args) {
        String s="(abcd)";
        String s1="(u(love)i)";
        String s2="(ed(et(oc))el)";
        reverseParentheses(s);
        reverseParentheses(s1);
        reverseParentheses(s2);
    }

    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ')') {
                String temp = sb.reverse().toString();
                sb = new StringBuilder(stack.pop()).append(temp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
