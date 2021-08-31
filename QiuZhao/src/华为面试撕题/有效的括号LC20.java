package 华为面试撕题;

import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class 有效的括号LC20 {
    public static void main(String[] args) {
        有效的括号LC20 me = new 有效的括号LC20();
        String s = "]";
        System.out.println(me.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
                // 这里一定要注意：此时如果出现的是反括号，如果此时stack中为空或者c不等于stack里面的pop值也是要返回false
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
